import {
	CATEGORY_LISTING_PRODUCT,
	CATEGORY_PATH,
	VARIANT_COLOR,
	VARIANT_PRODUCT,
	VARIANT_PRODUCT_PATH,
	VARIANT_STORAGE,
	expect,
	expectCheckoutSummaryContains,
	gotoStorefront,
	openCartFromHeader,
	proceedToCheckout,
	test,
	waitForCartReady,
} from './support/storefront';

test.describe('checkout entry paths', () => {
	test.beforeEach(async ({context}) => {
		await context.clearCookies();
	});

	test('enters checkout after adding an in-stock product from category listing', async ({page}) => {
		await gotoStorefront(page, CATEGORY_PATH);
		await waitForCartReady(page);

		const productCard = page.locator('.products__item').filter({hasText: CATEGORY_LISTING_PRODUCT}).first();
		await expect(productCard).toBeVisible();
		await expect(productCard).toContainText('$ 39.00');
		await productCard.getByRole('button', {name: /add to cart/i}).click();
		await expect(page.locator('header .cart-header__qty')).toHaveText(/[1-9]\d*/);

		await openCartFromHeader(page);
		await expect(page.locator('.cart-item')).toContainText(CATEGORY_LISTING_PRODUCT);
		await expect(page.locator('.cart-item')).toContainText('$ 39.00');
		await proceedToCheckout(page);
		await expectCheckoutSummaryContains(page, CATEGORY_LISTING_PRODUCT);
		await expectCheckoutSummaryContains(page, '$ 39.00 x 1 pcs');
	});

	test('requires variant selection and carries selected variant into checkout', async ({page}) => {
		await gotoStorefront(page, VARIANT_PRODUCT_PATH);
		await waitForCartReady(page);

		await page.getByRole('button', {name: /buy/i}).click();
		await expect(page.getByText('Please, choose a variant.')).toBeVisible();

		await page.locator('.variant-picker__characteristic label.btn').filter({hasText: VARIANT_STORAGE}).click();
		await page.locator('.variant-picker__characteristic label.btn').filter({hasText: VARIANT_COLOR}).click();

		await expect(page.getByText(/In stock/i)).toBeVisible();
		await expect(page.locator('.price-and-buy__price')).toContainText('$ 1,999.00');
		await page.getByRole('button', {name: /buy/i}).click();
		await expect(page.locator('header .cart-header__qty')).toHaveText(/[1-9]\d*/);

		await openCartFromHeader(page);
		await expect(page.locator('.cart-item')).toContainText(VARIANT_PRODUCT);
		await expect(page.locator('.cart-item')).toContainText(VARIANT_STORAGE);
		await expect(page.locator('.cart-item')).toContainText(VARIANT_COLOR);

		await proceedToCheckout(page);
		await expectCheckoutSummaryContains(page, VARIANT_PRODUCT);
		await expectCheckoutSummaryContains(page, VARIANT_STORAGE);
		await expectCheckoutSummaryContains(page, VARIANT_COLOR);
		await expectCheckoutSummaryContains(page, '$ 1,999.00 x 1 pcs');
	});
});
