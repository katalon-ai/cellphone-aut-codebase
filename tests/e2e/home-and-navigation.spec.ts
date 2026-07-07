import {
	CATEGORY_PATH,
	PRODUCT_WITHOUT_VARIANTS,
	expect,
	expectHeaderAndFooter,
	expectTrueTestSnippet,
	expectProductGrid,
	gotoStorefront,
	test,
} from './support/storefront';

test.describe('home and navigation', () => {
	test('renders the storefront home page with real catalog data', async ({page}) => {
		await gotoStorefront(page, '/');

		await expect(page).toHaveTitle(/Cellphone Shop/);
		await expectHeaderAndFooter(page);
		await expect(page.getByRole('heading', {name: /Boundless store/i})).toBeVisible();
		await expectProductGrid(page);
		await expectTrueTestSnippet(page);
	});

	test('navigates through top-level content pages', async ({page}) => {
		await gotoStorefront(page, '/');

		await page.getByRole('link', {name: /^About$/i}).click();
		await expect(page).toHaveURL(/\/about$/);
		await expect(page.getByRole('heading', {name: 'About'})).toBeVisible();
		await expect(page.getByText(/latest and best phones/i)).toBeVisible();

		await page.getByRole('link', {name: /K Cellphone Shop/i}).click();
		await expect(page).toHaveURL(/\/$/);
		await expect(page.getByText(PRODUCT_WITHOUT_VARIANTS).first()).toBeVisible();
	});

	test('opens category navigation and product category pages', async ({page}) => {
		await gotoStorefront(page, '/');

		const phoneLink = page.getByRole('link', {name: /^Phone/i}).first();
		await phoneLink.hover();
		await expect(page.getByRole('link', {name: /^Apple$/i}).first()).toBeVisible();
		await expect(page.getByRole('link', {name: /^Samsung$/i}).first()).toBeVisible();

		await gotoStorefront(page, CATEGORY_PATH);
		await expect(page.getByRole('heading', {name: /^Phone$/i})).toBeVisible();
		await expect(page.getByText('Sort by:')).toBeVisible();
		await expectProductGrid(page, {containsKnownProduct: false});
		await expectTrueTestSnippet(page);
	});
});
