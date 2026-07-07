import {
	CATEGORY_PATH,
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
});
