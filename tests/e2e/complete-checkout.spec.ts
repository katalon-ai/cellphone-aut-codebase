import {
	ACCESSORIES_CATEGORY_PATH,
	CHECKOUT_EMAIL,
	CHECKOUT_SHIPPING_ADDRESS,
	VARIANT_COLOR,
	VARIANT_PRODUCT,
	VARIANT_PRODUCT_PATH,
	VARIANT_STORAGE,
	addKnownProductFromHome,
	addRandomProductFromCategory,
	expect,
	expectCheckoutSummaryContains,
	gotoStorefront,
	proceedToCheckout,
	test,
	waitForCartQuantity,
	waitForCartReady,
} from './support/storefront';

test.describe('complete checkout', () => {
	test.beforeEach(async ({context}) => {
		await context.clearCookies();
	});

	test('submits a test order end to end', async ({page}, testInfo) => {
		skipProductionOrderUnlessAllowed(testInfo);

		const product = await addKnownProductFromHome(page);
		const productPrice = getCurrentPrice(product.priceText);
		const total = formatCheckoutTotal(productPrice + shippingPrice);
		await waitForCartQuantity(page, 1);
		await gotoStorefront(page, '/cart');
		await expect(page.locator('.cart-item')).toContainText(product.title);

		await completeCheckoutAndVerify(page, {
			summaryTexts: [
				product.title,
				'Shipping: $ 4.90',
				`Total: ${total}`,
			],
			confirmationTexts: [
				product.title,
				total,
			],
		});
	});

	test('submits a multi-category test order end to end', async ({page}, testInfo) => {
		skipProductionOrderUnlessAllowed(testInfo);

		const accessoryProduct = await addRandomProductFromCategory(page, ACCESSORIES_CATEGORY_PATH);
		const accessoryPrice = getCurrentPrice(accessoryProduct.priceText);
		const subtotal = accessoryPrice + variantProductPrice;
		const checkoutTotal = subtotal + shippingPrice;
		await waitForCartQuantity(page, 1);

		await gotoStorefront(page, VARIANT_PRODUCT_PATH);
		await waitForCartReady(page);
		await waitForCartQuantity(page, 1);
		await page.locator('.variant-picker__characteristic label.btn').filter({hasText: VARIANT_STORAGE}).click();
		await page.locator('.variant-picker__characteristic label.btn').filter({hasText: VARIANT_COLOR}).click();
		await expect(page.locator('.price-and-buy__price')).toContainText('$ 1,999.00');
		await expect(page.getByText(/In stock/i)).toBeVisible();
		await page.getByRole('button', {name: /buy/i}).click();
		await waitForCartQuantity(page, 2);

		await gotoStorefront(page, '/cart');
		const accessoryRow = page.locator('.cart-item').filter({hasText: accessoryProduct.title});
		const phoneRow = page.locator('.cart-item').filter({hasText: `${VARIANT_STORAGE} - ${VARIANT_COLOR}`});
		await expect(page.locator('.cart-item')).toHaveCount(2);
		await expect(accessoryRow).toContainText(accessoryProduct.title);
		await expect(phoneRow).toContainText(VARIANT_PRODUCT);
		await expect(phoneRow).toContainText(`${VARIANT_STORAGE} - ${VARIANT_COLOR}`);
		await expect(page.locator('.cart-items__total-row')).toContainText('2');
		await expect(page.locator('.cart-items__total-row')).toContainText(formatCartTotal(subtotal));

		await completeCheckoutAndVerify(page, {
			summaryTexts: [
				accessoryProduct.title,
				VARIANT_PRODUCT,
				`${VARIANT_STORAGE} - ${VARIANT_COLOR}`,
				`Subtotal: ${formatCheckoutTotal(subtotal)}`,
				'Shipping: $ 4.90',
				`Total: ${formatCheckoutTotal(checkoutTotal)}`,
			],
			confirmationTexts: [
				accessoryProduct.title,
				VARIANT_PRODUCT,
				`${VARIANT_STORAGE} - ${VARIANT_COLOR}`,
				formatCheckoutTotal(checkoutTotal),
			],
		});
	});
});

const shippingPrice = 4.90;
const variantProductPrice = 1999.00;

function skipProductionOrderUnlessAllowed(testInfo: {project: {name: string}}) {
	const isProduction = testInfo.project.name.includes('production');
	test.skip(
		isProduction && process.env.ALLOW_PRODUCTION_TEST_ORDER !== 'true',
		'Set ALLOW_PRODUCTION_TEST_ORDER=true to submit a production test order.'
	);
}

async function completeCheckoutAndVerify(
	page: Parameters<typeof proceedToCheckout>[0],
	options: {
		summaryTexts: string[];
		confirmationTexts: string[];
	}
) {
	await proceedToCheckout(page);

	await page.getByRole('textbox', {name: /Email/i}).fill(CHECKOUT_EMAIL);
	await page.getByRole('button', {name: /Continue to shipping/i}).click();
	await expect(page).toHaveURL(/\/checkout\/shipping-address/);

	await page.locator('input[name="shipping_address.first_name"]').fill(CHECKOUT_SHIPPING_ADDRESS.firstName);
	await page.locator('input[name="shipping_address.last_name"]').fill(CHECKOUT_SHIPPING_ADDRESS.lastName);
	await page.locator('input[name="shipping_address.address_line_1"]').fill(CHECKOUT_SHIPPING_ADDRESS.address);
	await page.locator('input[name="shipping_address.zip"]').fill(CHECKOUT_SHIPPING_ADDRESS.zip);
	await page.locator('input[name="shipping_address.city"]').fill(CHECKOUT_SHIPPING_ADDRESS.city);
	await page.locator('input[name="shipping_address.state"]').fill(CHECKOUT_SHIPPING_ADDRESS.state);
	await page.locator('input[name="shipping_address.phone"]').fill(CHECKOUT_SHIPPING_ADDRESS.phone);

	await expect(page.getByRole('button', {name: /Continue to payment/i})).toBeEnabled();
	await page.getByRole('button', {name: /Continue to payment/i}).click();
	await expect(page).toHaveURL(/\/checkout\/payment/);
	await expect(page.getByText(/Cash on delivery/i)).toBeVisible();
	await expect(page.getByRole('button', {name: /Complete order/i})).toBeEnabled();

	for (const text of options.summaryTexts) {
		await expectCheckoutSummaryContains(page, text);
	}

	await page.getByRole('button', {name: /Complete order/i}).click();
	await expect(page).toHaveURL(/\/thank-you\/[0-9a-f-]+/i, {timeout: 60000});

	await expect(page.getByRole('heading', {name: /Thank you for your order!/i})).toBeVisible();
	await expect(page.getByText(/Order ID:/i)).toBeVisible();
	await expect(page.getByText(/Order status: New/i)).toBeVisible();
	await expect(page.getByText(/Cash on delivery/i)).toBeVisible();
	await expect(page.getByText(CHECKOUT_SHIPPING_ADDRESS.firstName + ' ' + CHECKOUT_SHIPPING_ADDRESS.lastName)).toBeVisible();
	await expect(page.locator('.bdl-order-items__address-lane', {hasText: CHECKOUT_SHIPPING_ADDRESS.address})).toBeVisible();
	await expect(page.locator('.bdl-order-items__address-lane', {
		hasText: new RegExp(`${CHECKOUT_SHIPPING_ADDRESS.city}, ${CHECKOUT_SHIPPING_ADDRESS.state}.*${CHECKOUT_SHIPPING_ADDRESS.zip}`),
	})).toBeVisible();
	await expect(page.locator('.bdl-order-items__address-lane', {hasText: CHECKOUT_SHIPPING_ADDRESS.phone})).toBeVisible();
	await expect(page.locator('body')).toContainText('Total:');

	for (const text of options.confirmationTexts) {
		await expect(page.locator('body')).toContainText(text);
	}
}

function getCurrentPrice(priceText: string): number {
	const prices = Array.from(priceText.matchAll(/\$\s*([\d,]+\.\d{2})/g));
	expect(prices.length, `Expected to parse at least one price from "${priceText}"`).toBeGreaterThan(0);
	return Number(prices[prices.length - 1][1].replace(/,/g, ''));
}

function formatCheckoutTotal(value: number): string {
	return `$ ${value.toLocaleString('en-US', {minimumFractionDigits: 2, maximumFractionDigits: 2})}`;
}

function formatCartTotal(value: number): string {
	return value.toFixed(2);
}
