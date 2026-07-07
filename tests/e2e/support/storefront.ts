import {expect, test as base, type Page, type TestInfo} from '@playwright/test';

export const PRODUCT_WITHOUT_VARIANTS = 'Apple iPhone 15 Pro Silicone Case with MagSafe';
export const PRODUCT_WITHOUT_VARIANTS_PATH = '/product/apple-iphone-15-pro-silicone-case-with-magsafe';
export const CATEGORY_PATH = '/category/phone';
export const ACCESSORIES_PRICE_QUERY_PATH = '/category/accessories?price_min=20&price_max=30';
export const CATEGORY_LISTING_PRODUCT = 'iPhone 15 Clear Case with MagSafe';
export const VARIANT_PRODUCT = 'Samsung Galaxy S23 Ultra';
export const VARIANT_PRODUCT_PATH = '/product/samsung-galaxy-s23-ultra';
export const VARIANT_STORAGE = '512 GB';
export const VARIANT_COLOR = 'Phantom Black';
export const CHECKOUT_EMAIL = 'ai@test.com';
export const TRUETEST_CLIENT_CODE = 'KA-1941846-067';
export const TRUETEST_AGENT_SRC = 'https://static.staging.katalon.com/libs/traffic-agent/v1/traffic-agent.min.js';

export const test = base.extend<{page: Page}>({
	page: async ({page}, use, testInfo: TestInfo) => {
		const pageErrors: string[] = [];
		page.on('pageerror', error => pageErrors.push(error.message));

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

export async function addKnownProductFromHome(page: Page) {
	await gotoStorefront(page, '/');
	await waitForCartReady(page);
	const productCard = page.locator('.products__item').filter({hasText: PRODUCT_WITHOUT_VARIANTS}).first();
	await expect(productCard).toBeVisible();
	await productCard.getByRole('button', {name: /add to cart/i}).click();
	await expect(page.locator('header .cart-header__qty')).toHaveText(/[1-9]\d*/);
	return productCard;
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
