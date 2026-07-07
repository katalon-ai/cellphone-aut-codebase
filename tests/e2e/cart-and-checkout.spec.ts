import {
	CHECKOUT_EMAIL,
	PRODUCT_WITHOUT_VARIANTS,
	addKnownProductFromHome,
	addKnownProductFromDetail,
	expect,
	expectCheckoutSummaryContains,
	expectTrueTestSnippet,
	gotoStorefront,
	openCartFromHeader,
	openCartFromQuickAction,
	proceedToCheckout,
	test,
} from './support/storefront';

test.describe('cart and checkout', () => {
	test.beforeEach(async ({context}) => {
		await context.clearCookies();
	});

	test('adds a product to cart, updates quantity, and removes it', async ({page}) => {
		await addKnownProductFromHome(page);
		await gotoStorefront(page, '/cart');

		await expect(page.getByRole('heading', {name: 'Shopping cart'})).toBeVisible();
		const row = page.locator('.cart-item').filter({hasText: PRODUCT_WITHOUT_VARIANTS}).first();
		await expect(row).toBeVisible();

		await row.getByTitle('Increased').click();
		await expect(row.locator('input[type="number"]')).toHaveValue('2');
		await expect(page.locator('.cart-items__total-row')).toContainText('2');

		page.once('dialog', dialog => dialog.accept());
		await row.getByRole('button', {name: /Remove/i}).click();
		await expect(page.getByText('Your shopping cart is empty.')).toBeVisible();
		await expectTrueTestSnippet(page);
	});

	test('loads checkout from a populated cart without placing an order', async ({page}) => {
		await addKnownProductFromHome(page);
		await gotoStorefront(page, '/cart');

		await proceedToCheckout(page);
		await expectCheckoutSummaryContains(page, PRODUCT_WITHOUT_VARIANTS);
		await expectTrueTestSnippet(page);
	});

	test('validates checkout contact email before shipping', async ({page}) => {
		await addKnownProductFromHome(page);
		await gotoStorefront(page, '/cart');
		await proceedToCheckout(page);

		const email = page.getByRole('textbox', {name: /Email/i});
		const continueButton = page.getByRole('button', {name: /Continue to shipping/i});

		await continueButton.click();
		await expect(page).toHaveURL(/\/checkout\/info/);

		await email.fill('qa');
		await continueButton.click();
		await expect(page).toHaveURL(/\/checkout\/info/);

		await email.fill(CHECKOUT_EMAIL);
		await expect(email).toHaveValue(CHECKOUT_EMAIL);
		await expectCheckoutSummaryContains(page, PRODUCT_WITHOUT_VARIANTS);
	});

	test('enters checkout from homepage add-to-cart quick action', async ({page}) => {
		await addKnownProductFromHome(page);
		await openCartFromQuickAction(page);
		await expect(page.locator('.cart-item')).toContainText(PRODUCT_WITHOUT_VARIANTS);
		await proceedToCheckout(page);
		await expectCheckoutSummaryContains(page, PRODUCT_WITHOUT_VARIANTS);
	});

	test('enters checkout from product detail add-to-cart quick action', async ({page}) => {
		await addKnownProductFromDetail(page);
		await openCartFromQuickAction(page);
		await expect(page.locator('.cart-item')).toContainText(PRODUCT_WITHOUT_VARIANTS);
		await proceedToCheckout(page);
		await expectCheckoutSummaryContains(page, PRODUCT_WITHOUT_VARIANTS);
	});

	test('enters checkout through the persistent header cart icon', async ({page}) => {
		await addKnownProductFromHome(page);
		await openCartFromHeader(page);
		await expect(page.locator('.cart-item')).toContainText(PRODUCT_WITHOUT_VARIANTS);
		await proceedToCheckout(page);
		await expectCheckoutSummaryContains(page, PRODUCT_WITHOUT_VARIANTS);
	});
});
