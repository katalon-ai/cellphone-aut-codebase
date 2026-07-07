import {
	PRODUCT_WITHOUT_VARIANTS,
	PRODUCT_WITHOUT_VARIANTS_PATH,
	expect,
	expectTrueTestSnippet,
	gotoStorefront,
	test,
	waitForCartReady,
} from './support/storefront';

test.describe('catalog and product detail', () => {
	test('shows category controls and supports sorting without losing products', async ({page}) => {
		await gotoStorefront(page, '/category/phone');

		await expect(page.getByRole('heading', {name: /^Phone$/i})).toBeVisible();
		const initialProductCount = await page.locator('.products__item').count();
		expect(initialProductCount).toBeGreaterThan(0);

		await page.getByRole('link', {name: /^By title$/i}).click();
		await expect(page).toHaveURL(/sort=title|sort=-title/);
		await expect(page.locator('.products__item').first()).toBeVisible();
		expect(await page.locator('.products__item').count()).toBeGreaterThan(0);
	});

	test('opens a product detail page and adds quantity to the cart', async ({page}) => {
		await gotoStorefront(page, PRODUCT_WITHOUT_VARIANTS_PATH);

		await expect(page.getByRole('heading', {name: PRODUCT_WITHOUT_VARIANTS})).toBeVisible();
		await expect(page.getByText(/In stock/i)).toBeVisible();
		await expect(page.locator('.price-and-buy__price')).toBeVisible();
		await waitForCartReady(page);

		await page.getByTitle('Increased').click();
		await expect(page.locator('.price-and-buy__qty input')).toHaveValue('2');
		await page.getByRole('button', {name: /buy/i}).click();

		await expect(page.locator('header .cart-header__qty')).toHaveText('2');
		await expect(page.getByRole('link', {name: /Place an order/i})).toBeVisible();
		await expectTrueTestSnippet(page);
	});
});
