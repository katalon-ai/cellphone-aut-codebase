import {
	CATEGORY_PATH,
	PRODUCT_WITHOUT_VARIANTS,
	PRODUCT_WITHOUT_VARIANTS_PATH,
	expect,
	expectTrueTestSnippet,
	gotoStorefront,
	test,
} from './support/storefront';

test.describe('regression guardrails', () => {
	for (const path of ['/', CATEGORY_PATH, PRODUCT_WITHOUT_VARIANTS_PATH, '/checkout/info']) {
		test(`renders the configured TrueTest snippet on ${path}`, async ({page}) => {
			await gotoStorefront(page, path);
			await expectTrueTestSnippet(page);
		});
	}

	test('does not show a client-side application error on important routes', async ({page}) => {
		for (const path of ['/', '/about', CATEGORY_PATH, PRODUCT_WITHOUT_VARIANTS_PATH, '/cart', '/checkout/info']) {
			await gotoStorefront(page, path);
			await expect(page.locator('body')).not.toContainText('Application error');
		}
	});

	test('supports direct links and refreshes on important storefront routes', async ({page}) => {
		await gotoStorefront(page, CATEGORY_PATH);
		await expect(page.getByRole('heading', {name: /^Phone$/i})).toBeVisible();
		await page.reload({waitUntil: 'domcontentloaded'});
		await expect(page.getByRole('heading', {name: /^Phone$/i})).toBeVisible();
		await expect(page.locator('.products__item').first()).toBeVisible();

		await gotoStorefront(page, PRODUCT_WITHOUT_VARIANTS_PATH);
		await expect(page.getByRole('heading', {name: PRODUCT_WITHOUT_VARIANTS})).toBeVisible();
		await page.reload({waitUntil: 'domcontentloaded'});
		await expect(page.getByRole('heading', {name: PRODUCT_WITHOUT_VARIANTS})).toBeVisible();
		await expect(page.getByText(/In stock/i)).toBeVisible();

		await gotoStorefront(page, '/cart');
		await expect(page.getByRole('heading', {name: 'Shopping cart'})).toBeVisible();
		await expect(page.locator('body')).toContainText(/Your shopping cart is empty\.|Order Total:/);

		await gotoStorefront(page, '/checkout/info');
		await expect(page).toHaveURL(/\/checkout\/info/);
		await expect(page.locator('body')).not.toContainText('Application error');
	});
});
