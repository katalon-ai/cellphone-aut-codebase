# E2E Test Suite

This Playwright suite automates the manual E2E cases in `../manual/e2e-test-cases.md` against either staging or production.

## Targets

```sh
yarn test:e2e:install
yarn test:e2e:staging
yarn test:e2e:production
yarn test:e2e:chrome:staging
yarn test:e2e:chrome:production
TARGET_ENV=staging yarn test:e2e
TARGET_ENV=production yarn test:e2e
BROWSER_CHANNEL=chrome TARGET_ENV=production yarn test:e2e
BASE_URL=https://example.netlify.app yarn test:e2e
ALLOW_PRODUCTION_TEST_ORDER=true TARGET_ENV=production yarn test:e2e tests/e2e/complete-checkout.spec.ts
```

Default target is `staging`.
The complete checkout spec submits a real test order on staging. Production order submission is skipped unless `ALLOW_PRODUCTION_TEST_ORDER=true` is set.
Generic product-selection flows choose a random simple in-stock product from the active product grid on each run, then assert against the selected product captured at runtime. Variant-specific flows still use known variants so required option handling stays explicit.

## TrueTest Session Attributes

Every Playwright browser page installs a TrueTest session attribute once the TrueTest SDK is available:

```js
TrueTest.setSessionAttributes({
	source: 'playwright',
});
```

Use `source = 'playwright'` in TrueTest user session filters to isolate automated Playwright sessions from other traffic.

## Coverage

- Home page rendering, shared header/footer, and real catalog data
- Top navigation, about page, category menu, and category listing
- Product detail page, quantity controls, and add-to-cart behavior
- Cart item display, quantity update, removal, and empty-cart state
- Checkout shell loading from a populated cart without placing an order
- Checkout entry paths from homepage quick action, product detail quick action, header cart, category listing, and variant product selection
- Complete checkout with `ai@test.com`, `US Shipping`, `Cash on delivery`, and thank-you page verification
- Multi-category checkout containing a random Accessories product and a Phone variant product in the same order
- Price query search for accessories in the `$20.00` to `$30.00` range. Production is asserted against the exact 2-product filtered result; staging currently keeps the query in the URL but returns the full accessories listing, so staging is treated as a route/data smoke check.
- Regression checks for client-side application errors
- Direct-link and refresh resilience for category, product, cart, and checkout routes
- Regression checks that the configured TrueTest/Katalon snippet is injected
- Harness check that Playwright sessions call `TrueTest.setSessionAttributes({source: 'playwright'})`

Most checkout-entry tests stop before order submission. `complete-checkout.spec.ts` submits staging test orders by default and skips production order submission unless explicitly enabled.
