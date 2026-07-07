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
```

Default target is `staging`.

## Coverage

- Home page rendering, shared header/footer, and real catalog data
- Top navigation, about page, category menu, and category listing
- Product detail page, quantity controls, and add-to-cart behavior
- Cart item display, quantity update, removal, and empty-cart state
- Checkout shell loading from a populated cart without placing an order
- Checkout entry paths from homepage quick action, product detail quick action, header cart, category listing, and variant product selection
- Price query search for accessories in the `$20.00` to `$30.00` range. Production is asserted against the exact 2-product filtered result; staging currently keeps the query in the URL but returns the full accessories listing, so staging is treated as a route/data smoke check.
- Regression checks for client-side application errors
- Regression checks that the configured TrueTest/Katalon snippet is injected

The checkout test stops before order submission. Cart tests create only a temporary browser cart for the current session.
