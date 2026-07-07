import {expect, test as base, type Locator, type Page, type TestInfo} from '@playwright/test';

export const PRODUCT_WITHOUT_VARIANTS = 'Apple iPhone 15 Pro Silicone Case with MagSafe';
export const PRODUCT_WITHOUT_VARIANTS_PATH = '/product/apple-iphone-15-pro-silicone-case-with-magsafe';
export const CATEGORY_PATH = '/category/phone';
export const ACCESSORIES_CATEGORY_PATH = '/category/accessories';
export const ACCESSORIES_PRICE_QUERY_PATH = '/category/accessories?price_min=20&price_max=30';
export const CATEGORY_LISTING_PRODUCT = 'iPhone 15 Clear Case with MagSafe';
export const VARIANT_PRODUCT = 'Samsung Galaxy S23 Ultra';
export const VARIANT_PRODUCT_PATH = '/product/samsung-galaxy-s23-ultra';
export const VARIANT_STORAGE = '512 GB';
export const VARIANT_COLOR = 'Phantom Black';
export const CHECKOUT_EMAIL = 'ai@test.com';
export const CHECKOUT_SHIPPING_ADDRESS = {
	firstName: 'AI',
	lastName: 'Tester',
	address: '1 John Doe',
	zip: '95014',
	city: 'Cupertino',
	state: 'CA',
	phone: '+18001234567',
};
export const TRUETEST_CLIENT_CODE = 'KA-1941846-067';
export const TRUETEST_AGENT_SRC = 'https://static.staging.katalon.com/libs/traffic-agent/v1/traffic-agent.min.js';
export const TRUETEST_PLAYWRIGHT_SOURCE = 'playwright';

export type SelectedProduct = {
	title: string;
	priceText: string;
};

export const test = base.extend<{page: Page}>({
	page: async ({page}, use, testInfo: TestInfo) => {
		const pageErrors: string[] = [];
		page.on('pageerror', error => pageErrors.push(error.message));
		await installTrueTestPlaywrightSource(page);

		await use(page);

		if (pageErrors.length) {
			await testInfo.attach('page-errors', {
				body: pageErrors.join('\n'),
				contentType: 'text/plain',
			});
		}
		expect(pageErrors).toEqual([]);
	},
});

export {expect};

async function installTrueTestPlaywrightSource(page: Page) {
	await page.addInitScript((source) => {
		type TrueTestWindow = typeof window & {
			TrueTest?: {
				setSessionAttributes?: (attributes: Record<string, string>) => void;
			};
			__trueTestPlaywrightSource?: string;
		};

		const setPlaywrightSource = () => {
			const win = window as TrueTestWindow;
			if (typeof win.TrueTest?.setSessionAttributes === 'function') {
				win.TrueTest.setSessionAttributes({source});
				win.__trueTestPlaywrightSource = source;
				return true;
			}
			return false;
		};

		if (setPlaywrightSource()) {
			return;
		}

		let attempts = 0;
		const timer = window.setInterval(() => {
			attempts += 1;
			if (setPlaywrightSource() || attempts >= 120) {
				window.clearInterval(timer);
			}
		}, 250);
	}, TRUETEST_PLAYWRIGHT_SOURCE);
}

export async function gotoStorefront(page: Page, path = '/') {
	let response = await page.goto(path, {waitUntil: 'domcontentloaded'});
	if (response && response.status() >= 400) {
		await page.waitForTimeout(500);
		response = await page.goto(path, {waitUntil: 'domcontentloaded'});
	}
	expect(response?.status(), `Expected ${path} to return a successful HTTP status`).toBeLessThan(400);
	await expect(page.locator('body')).not.toContainText('Application error');
	return response;
}

export async function expectTrueTestSnippet(page: Page) {
	const html = await page.content();
	expect(html).toContain(TRUETEST_AGENT_SRC);
	expect(html).toContain(TRUETEST_CLIENT_CODE);
	expect(html).not.toContain('KA-1940145-025');
	expect(html).not.toContain('traffic-agent.min.js?t=2');
	expect(html).not.toContain('truetest-sdk');
}

export async function expectHeaderAndFooter(page: Page) {
	const horizontalMenu = page.locator('.horizontal-menu');
	await expect(page.getByRole('link', {name: /K Cellphone Shop/i})).toBeVisible();
	await expect(horizontalMenu.getByRole('link', {name: /^Phone/i})).toBeVisible();
	await expect(horizontalMenu.getByRole('link', {name: /^Accessories/i})).toBeVisible();
	await expect(page.getByRole('link', {name: /^About$/i})).toBeVisible();
	await expect(page.locator('header .cart-header__qty')).toBeVisible();
	await expect(page.getByText('Contact Us')).toBeVisible();
}

export async function waitForCartReady(page: Page) {
	await expect.poll(async () => {
		const cookies = await page.context().cookies();
		return cookies.find(cookie => cookie.name === 'boundless_cart_id')?.value || '';
	}, {
		message: 'Expected storefront cart cookie to be initialized',
		timeout: 20000,
	}).not.toBe('');
}

export async function waitForCartQuantity(page: Page, quantity: number) {
	await expect(page.locator('header .cart-header__qty')).toHaveText(String(quantity), {timeout: 20000});
}

export async function addRandomProductFromHome(page: Page) {
	await gotoStorefront(page, '/');
	await waitForCartReady(page);
	return addRandomProductFromCurrentGrid(page);
}

export async function addRandomProductFromCategory(page: Page, categoryPath: string) {
	await gotoStorefront(page, categoryPath);
	await waitForCartReady(page);
	return addRandomProductFromCurrentGrid(page);
}

export async function addRandomProductFromCurrentGrid(page: Page): Promise<SelectedProduct> {
	const products = page.locator('.products__item.in-stock');
	const candidateIndexes = await getRandomProductCandidateIndexes(products);
	const startingQuantity = await getHeaderCartQuantity(page);

	for (const index of shuffle(candidateIndexes)) {
		await dismissBlockingModal(page);
		const productCard = products.nth(index);
		const selectedProduct = await getProductCardDetails(productCard);
		try {
			await productCard.getByRole('button', {name: /add to cart/i}).click({timeout: 5000});
		} catch {
			await dismissBlockingModal(page);
			continue;
		}
		const wasAdded = await waitForHeaderCartQuantityGreaterThan(page, startingQuantity, 8000);
		if (wasAdded) {
			return selectedProduct;
		}
		await dismissBlockingModal(page);
	}

	throw new Error('Could not add any random product candidate to the cart.');
}

export async function addKnownProductFromHome(page: Page) {
	return addRandomProductFromHome(page);
}

export async function addKnownProductFromDetail(page: Page) {
	await gotoStorefront(page, PRODUCT_WITHOUT_VARIANTS_PATH);
	await waitForCartReady(page);
	await page.getByRole('button', {name: /buy/i}).click();
	await expect(page.locator('header .cart-header__qty')).toHaveText(/[1-9]\d*/);
	await expect(page.getByRole('link', {name: /Place an order/i})).toBeVisible();
}

export async function openCartFromQuickAction(page: Page) {
	await page.getByRole('link', {name: /Place an order/i}).click();
	await expect(page).toHaveURL(/\/cart$/);
	await expect(page.getByRole('heading', {name: 'Shopping cart'})).toBeVisible();
}

export async function openCartFromHeader(page: Page) {
	await page.locator('header .cart-header').click();
	await expect(page).toHaveURL(/\/cart$/);
	await expect(page.getByRole('heading', {name: 'Shopping cart'})).toBeVisible();
}

export async function proceedToCheckout(page: Page) {
	await page.getByRole('button', {name: /Proceed to checkout/i}).click();
	await expect(page).toHaveURL(/\/checkout/);
	await expect(page.getByRole('heading', {name: /Contact information/i})).toBeVisible({timeout: 30000});
	await expect(page.getByRole('textbox', {name: /Email/i})).toBeVisible();
	await expect(page.getByRole('button', {name: /Continue to shipping/i})).toBeVisible();
	await expect(page.getByRole('heading', {name: /Total:/i})).toBeVisible();
}

export async function expectCheckoutSummaryContains(page: Page, text: string | RegExp) {
	await expect(page.locator('main')).toContainText(text);
}

export async function expectProductGrid(page: Page, options: {containsKnownProduct?: boolean} = {}) {
	const {containsKnownProduct = true} = options;
	const products = page.locator('.products__item');
	await expect(products.first()).toBeVisible();
	expect(await products.count()).toBeGreaterThan(0);
	if (containsKnownProduct) {
		await expect(page.getByText(PRODUCT_WITHOUT_VARIANTS).first()).toBeVisible();
	}
}

async function getRandomProductCandidateIndexes(products: Locator): Promise<number[]> {
	await expect(products.first()).toBeVisible();
	const candidates: number[] = [];

	for (let index = 0; index < await products.count(); index += 1) {
		const productCard = products.nth(index);
		if (
			await productCard.getByRole('button', {name: /add to cart/i}).count()
			&& !(await productCard.locator('.products__price').innerText()).includes('From:')
		) {
			candidates.push(index);
		}
	}

	expect(candidates.length, 'Expected at least one simple in-stock product card with Add to cart').toBeGreaterThan(0);
	return candidates;
}

async function getProductCardDetails(productCard: Locator): Promise<SelectedProduct> {
	const title = (await productCard.locator('.products__title').innerText()).trim();
	const priceText = (await productCard.locator('.products__price').innerText()).replace(/\s+/g, ' ').trim();

	return {title, priceText};
}

async function getHeaderCartQuantity(page: Page): Promise<number> {
	const quantity = await page.locator('header .cart-header__qty').first().innerText();
	return Number(quantity.trim());
}

async function waitForHeaderCartQuantityGreaterThan(page: Page, quantity: number, timeout: number): Promise<boolean> {
	try {
		await page.waitForFunction((expectedQuantity) => {
			const currentQuantity = Number(document.querySelector('header .cart-header__qty')?.textContent?.trim() || '0');
			return currentQuantity > expectedQuantity;
		}, quantity, {timeout});
		return true;
	} catch {
		return false;
	}
}

function shuffle<T>(items: T[]): T[] {
	const shuffled = [...items];
	for (let index = shuffled.length - 1; index > 0; index -= 1) {
		const swapIndex = Math.floor(Math.random() * (index + 1));
		[shuffled[index], shuffled[swapIndex]] = [shuffled[swapIndex], shuffled[index]];
	}
	return shuffled;
}

async function dismissBlockingModal(page: Page) {
	const modal = page.locator('.modal.show, [role="dialog"][aria-modal="true"]').first();
	if (!await modal.count()) {
		return;
	}

	await page.keyboard.press('Escape');
	await page.waitForTimeout(250);
	if (await modal.isVisible().catch(() => false)) {
		const closeButton = modal.locator('.btn-close, button[aria-label="Close"]').first();
		if (await closeButton.count()) {
			await closeButton.click({timeout: 2000}).catch(() => undefined);
		}
	}
	await expect(modal).toBeHidden({timeout: 5000}).catch(() => undefined);
}
