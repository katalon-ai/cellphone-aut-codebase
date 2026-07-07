# Manual E2E Test Cases

These manual test cases cover the primary customer journeys for the Cellphone Shop storefront. Run them against either staging or production before relying on the automated Playwright suite.

## Test Targets

| Environment | URL |
| --- | --- |
| Staging | https://cellphoneshop-truetest-auto-staging.netlify.app |
| Production | https://cellphoneshop-truetest-auto.netlify.app |

## General Preconditions

- Use a clean browser session or private window unless the case explicitly depends on an existing cart.
- JavaScript and cookies are enabled.
- The storefront is reachable and the homepage returns HTTP 200.
- Product data is available, including `Apple iPhone 15 Pro Silicone Case with MagSafe`.
- Production validation is read-only. Do not submit a final order in production.
- Automated Playwright cases choose a random simple in-stock product from the active product grid where the scenario does not require a specific product or variant.

## Test Data

| Data | Value |
| --- | --- |
| Known simple product | Apple iPhone 15 Pro Silicone Case with MagSafe |
| Known simple product path | `/product/apple-iphone-15-pro-silicone-case-with-magsafe` |
| Known simple product price | `$ 25.00` |
| Main category | Phone |
| Main category path | `/category/phone` |
| Price search range | `$20.00` to `$30.00` |
| Price search path | `/category/accessories?price_min=20&price_max=30` |
| Variant product | Samsung Galaxy S23 Ultra |
| Variant product path | `/product/samsung-galaxy-s23-ultra` |
| Variant test selection | Storage `512 GB`, Color `Phantom Black` |
| Checkout test email | `ai@test.com` |

## Production Chrome Execution Notes

Last executed with Chrome against production on July 6, 2026.

Observed production data:

- Homepage first products: `Apple iPhone 15 Pro Silicone Case with MagSafe` `$ 25.00`, `iPhone 15 Silicone Case with Magsafe` `$ 39.00`, `iPhone 15 Clear Case with MagSafe` `$ 99.00` / `$ 39.00`, `Samsung Galaxy S23 Ultra` `From:$ 333.00`.
- `Phone` category child links: `Apple`, `Samsung`, `Google Pixel`.
- `/category/phone` displayed 12 products. First product was `iPhone 15 Clear Case with MagSafe` at `$ 99.00` / `$ 39.00`.
- Sorting by title used `/category/phone?sort=title`; sorting by price used `/category/phone?sort=price`.
- Checkout contact step URL was `/checkout/info`.
- Checkout summary for the simple product showed `Apple iPhone 15 Pro Silicone Case with MagSafe $ 25.00 x 1 pcs $ 25.00 Total: $ 25.00`.
- Variant checkout summary showed `Samsung Galaxy S23 Ultra, 512 GB - Phantom Black $ 1,999.00 x 1 pcs $ 1,999.00 Total: $ 1,999.00`.
- No category page rendered a visible price filter panel in production. Price search was validated by direct query URL instead.
- `/category/accessories?price_min=20&price_max=30` returned 2 products: `Apple iPhone 15 Pro Silicone Case with MagSafe` `$ 25.00` and `240W USB-C Charge Cable (2 m)` `$ 29.00` / `$ 28.00`.
- Staging preserved the same price query URL but returned the full 12-product Accessories listing during automation.
- Complete order submission was not executed on production.

## E2E-001 Home Page And Storefront Shell

**Objective:** Confirm the storefront loads with shared navigation, product data, and no client-side application error.

**Steps:**

1. Open the target environment homepage.
2. Verify the browser title contains `Cellphone Shop`.
3. Verify the header shows `K Cellphone Shop`.
4. Verify top navigation includes `Phone`, `Accessories`, and `About`.
5. Verify the cart indicator is visible and starts at `0` in a clean session.
6. Verify the page heading `Boundless store` is visible.
7. Verify at least one product card is displayed.
8. Verify `Apple iPhone 15 Pro Silicone Case with MagSafe` appears on the page.
9. Verify its displayed price is `$ 25.00`.
10. Verify additional homepage products include `iPhone 15 Silicone Case with Magsafe`, `iPhone 15 Clear Case with MagSafe`, and `Samsung Galaxy S23 Ultra`.
11. Verify the footer includes `Contact Us`, `+1 (800) 123-45-67`, and `1 John Doe, Cupertino, CA 95014`.
12. Verify no `Application error` message appears.

**Expected Result:** Homepage renders successfully with catalog data, navigation, cart indicator, footer, and no client-side exception.

## E2E-002 Content Navigation

**Objective:** Confirm global navigation routes between content and catalog pages.

**Steps:**

1. Open the homepage.
2. Click `About`.
3. Verify the URL ends with `/about`.
4. Verify the page heading is `About`.
5. Verify the About content includes `Welcome to our online phone store! We're here to offer you the latest and best phones.`
6. Click `K Cellphone Shop`.
7. Verify the URL returns to the homepage.
8. Verify the product grid is visible again.

**Expected Result:** Header navigation works without full-page errors or lost storefront layout.

## E2E-003 Category Navigation And Listing

**Objective:** Confirm shoppers can browse categories from the main menu.

**Steps:**

1. Open the homepage.
2. Hover over `Phone` in the top category navigation.
3. Verify child category links such as `Apple` and `Samsung` become visible.
4. Verify the full observed child list is `Apple`, `Samsung`, and `Google Pixel`.
5. Open `/category/phone` or click the `Phone` category.
6. Verify the category page heading is `Phone`.
7. Verify sorting controls are visible.
8. Verify 12 product cards are listed in production.
9. Verify the first listed product is `iPhone 15 Clear Case with MagSafe` at `$ 99.00` / `$ 39.00`.
10. Open the first visible product from the category listing.
11. Verify the product detail page loads.

**Expected Result:** Category navigation exposes child categories, category listing loads, and a product can be opened from the category page.

## E2E-004 Category Sorting

**Objective:** Confirm category sorting updates the listing without breaking product results.

**Steps:**

1. Open `/category/phone`.
2. Verify 12 product cards are visible in production.
3. Click `By title`.
4. Verify the URL includes `/category/phone?sort=title`.
5. Verify product cards are still visible.
6. Click `By price`.
7. Verify the URL includes `/category/phone?sort=price`.
8. Verify product cards are still visible.

**Expected Result:** Sorting changes the category URL/state and keeps the product listing usable.

## E2E-005 Product Detail And Quantity Selection

**Objective:** Confirm a shopper can view a simple product, adjust quantity, and add it to cart.

**Steps:**

1. Open `/product/apple-iphone-15-pro-silicone-case-with-magsafe`.
2. Verify the product heading is `Apple iPhone 15 Pro Silicone Case with MagSafe`.
3. Verify the product price is `$ 25.00`.
4. Verify stock status is `In stock`.
5. Click the quantity increase control once.
6. Verify the quantity input changes to `2`.
7. Click `Buy`.
8. Verify the header cart quantity changes to `2`.
9. Verify the product-added confirmation is visible with a `Place an order` action.

**Expected Result:** Product details render correctly, quantity can be changed, and the selected quantity is added to cart.

## E2E-006 Add Product From Listing To Cart

**Objective:** Confirm a shopper can add a product to cart from the product grid.

**Steps:**

1. Start in a clean browser session.
2. Open the homepage.
3. Locate the product card for `Apple iPhone 15 Pro Silicone Case with MagSafe`.
4. Click the product card `Add to cart` button.
5. Verify the header cart quantity changes from `0` to `1`.
6. Verify the product-added confirmation appears.
7. Click `Place an order` or open `/cart`.
8. Verify the cart page opens.
9. Verify the cart row lists `Apple iPhone 15 Pro Silicone Case with MagSafe` at `$ 25.00`.

**Expected Result:** Product can be added from listing, cart count updates, and cart page contains the selected product.

## E2E-007 Cart Quantity Update And Removal

**Objective:** Confirm cart item quantity and removal controls work.

**Precondition:** The cart contains `Apple iPhone 15 Pro Silicone Case with MagSafe`.

**Steps:**

1. Open `/cart`.
2. Verify the page heading is `Shopping cart`.
3. Verify the known product appears in the cart item list.
4. Click the cart row quantity increase control.
5. Verify the row quantity input changes to `2`.
6. Verify the order total quantity changes to `2`.
7. Click `Remove`.
8. Accept the confirmation dialog.
9. Verify the cart shows `Your shopping cart is empty.`

**Expected Result:** Cart quantity updates correctly, totals refresh, and item removal returns the cart to empty state.

## E2E-008 Checkout Shell From Populated Cart

**Objective:** Confirm a shopper can enter checkout from cart and see the first checkout step. This case does not place an order.

**Precondition:** The cart contains `Apple iPhone 15 Pro Silicone Case with MagSafe`.

**Steps:**

1. Open `/cart`.
2. Click `Proceed to checkout`.
3. Verify the URL contains `/checkout`.
4. Verify the checkout heading `Contact information` is visible.
5. Verify the `Email` field is visible.
6. Verify the `Continue to shipping` button is visible.
7. Verify the order summary includes `Apple iPhone 15 Pro Silicone Case with MagSafe`.
8. Verify the order summary shows `$ 25.00 x 1 pcs $ 25.00`.
9. Verify the order total is `Total: $ 25.00`.
10. Do not continue to final order submission in production.

**Expected Result:** Checkout loads from a populated cart and shows contact information plus order summary without a client-side error.

## E2E-009 Checkout From Homepage Quick Action

**Objective:** Confirm a shopper can add a product from the homepage and enter checkout by using the product-added `Place an order` quick action.

**Steps:**

1. Start in a clean browser session.
2. Open the homepage.
3. Locate the product card for `Apple iPhone 15 Pro Silicone Case with MagSafe`.
4. Click the product card `Add to cart` button.
5. Verify the product-added confirmation appears.
6. Click `Place an order` in the confirmation.
7. Verify the cart page opens.
8. Verify the cart contains `Apple iPhone 15 Pro Silicone Case with MagSafe`.
9. Click `Proceed to checkout`.
10. Verify the URL contains `/checkout`.
11. Verify the checkout contact step is visible.
12. Verify the order summary shows `Apple iPhone 15 Pro Silicone Case with MagSafe $ 25.00 x 1 pcs $ 25.00 Total: $ 25.00`.

**Expected Result:** Homepage add-to-cart quick action leads to cart and then checkout with the selected product retained.

## E2E-010 Checkout From Product Detail Quick Action

**Objective:** Confirm a shopper can add a product from the product detail page and enter checkout by using the product-added `Place an order` quick action.

**Steps:**

1. Start in a clean browser session.
2. Open `/product/apple-iphone-15-pro-silicone-case-with-magsafe`.
3. Verify the product detail page loads.
4. Click `Buy`.
5. Verify the product-added confirmation appears.
6. Click `Place an order` in the confirmation.
7. Verify the cart page opens.
8. Verify the cart contains `Apple iPhone 15 Pro Silicone Case with MagSafe`.
9. Click `Proceed to checkout`.
10. Verify the checkout contact step is visible.
11. Verify the order summary shows `Apple iPhone 15 Pro Silicone Case with MagSafe $ 25.00 x 1 pcs $ 25.00 Total: $ 25.00`.

**Expected Result:** Product detail add-to-cart quick action leads to cart and then checkout with the selected product retained.

## E2E-011 Checkout Through Header Cart Icon

**Objective:** Confirm a shopper can use the persistent header cart icon to reach cart and continue to checkout.

**Steps:**

1. Start in a clean browser session.
2. Add `Apple iPhone 15 Pro Silicone Case with MagSafe` to cart from the homepage or product detail page.
3. Verify the header cart quantity is greater than `0`.
4. Click the header cart icon or cart total.
5. Verify `/cart` opens.
6. Verify the cart contains `Apple iPhone 15 Pro Silicone Case with MagSafe`.
7. Click `Proceed to checkout`.
8. Verify the checkout contact step is visible.
9. Verify the order summary shows `Apple iPhone 15 Pro Silicone Case with MagSafe $ 25.00 x 1 pcs $ 25.00 Total: $ 25.00`.

**Expected Result:** Header cart navigation preserves cart contents and allows the shopper to enter checkout.

## E2E-012 Checkout From Category Listing

**Objective:** Confirm a shopper can add a product from a category listing and continue to checkout.

**Steps:**

1. Start in a clean browser session.
2. Open `/category/phone`.
3. Verify product cards are visible.
4. Add the first observed in-stock product, `iPhone 15 Clear Case with MagSafe`, to cart.
5. Verify the header cart quantity changes from `0` to `1`.
6. Open `/cart` using either the `Place an order` quick action or the header cart icon.
7. Verify the selected product appears in the cart at `$ 39.00`.
8. Click `Proceed to checkout`.
9. Verify the checkout contact step is visible.
10. Verify the order summary shows `iPhone 15 Clear Case with MagSafe $ 39.00 x 1 pcs $ 39.00 Total: $ 39.00`.

**Expected Result:** Category listing add-to-cart path leads to checkout with the selected product retained.

## E2E-013 Checkout With Variant Product

**Objective:** Confirm a shopper can select required product options before entering checkout.

**Precondition:** At least one in-stock product with variants is available, such as an iPhone model with color/storage options.

**Steps:**

1. Start in a clean browser session.
2. Open `/product/samsung-galaxy-s23-ultra`.
3. Click `Buy` without selecting required options.
4. Verify a validation message appears, such as `Please, choose a variant.`
5. Select Storage `512 GB`.
6. Select Color `Phantom Black`.
7. Verify stock status is `In stock`.
8. Verify the selected variant price is `$ 1,999.00` with old price `$ 2,500.00`.
9. Click `Buy`.
10. Verify the product-added confirmation appears.
11. Open `/cart`.
12. Verify the cart shows `Samsung Galaxy S23 Ultra` and variant details `512 GB - Phantom Black`.
13. Click `Proceed to checkout`.
14. Verify the checkout order summary shows `Samsung Galaxy S23 Ultra, 512 GB - Phantom Black $ 1,999.00 x 1 pcs $ 1,999.00 Total: $ 1,999.00`.

**Expected Result:** Variant selection is required before cart addition, and the selected variant is preserved through cart and checkout.

## E2E-014 Checkout Contact Validation

**Objective:** Confirm the checkout form requires valid contact information before advancing.

**Precondition:** The cart contains at least one product and checkout is open at the contact information step.

**Steps:**

1. Leave the `Email` field blank.
2. Click `Continue to shipping`.
3. Verify the user remains on `/checkout/info` at the contact information step.
4. Enter an invalid email such as `qa`.
5. Click `Continue to shipping`.
6. Verify the user remains on `/checkout/info` at the contact information step.
7. Enter `ai@test.com`.
8. Do not continue to final order submission in production.

**Expected Result:** Checkout prevents progress with missing or invalid email and accepts a syntactically valid email for the contact step.

## E2E-015 Deep Link And Refresh Resilience

**Objective:** Confirm important routes can be loaded directly and refreshed.

**Steps:**

1. Open `/category/phone` directly in a new tab.
2. Refresh the page and verify the category page still loads.
3. Open `/product/apple-iphone-15-pro-silicone-case-with-magsafe` directly.
4. Refresh the page and verify the product page still loads.
5. Open `/cart` directly.
6. Verify either cart items or the empty cart state is displayed.
7. Open `/checkout/info` directly.
8. Verify the checkout shell loads or returns a controlled empty-cart/checkout state without `Application error`.
9. Note that direct `/checkout/info` in an empty cart session may render only the checkout path until a cart is populated.

**Expected Result:** Direct route loads and refreshes do not produce 404s or client-side application errors.

## E2E-016 Search Products By Price Query

**Objective:** Confirm category products can be searched by a price range query. Production currently does not render visible price filter controls, so this case validates the supported URL query behavior.

**Steps:**

1. Open `/category/accessories?price_min=20&price_max=30`.
2. Verify the category page loads successfully.
3. Verify the URL includes `price_min=20` and `price_max=30`.
4. Verify exactly 2 product cards are displayed in production.
5. Verify the first result is `Apple iPhone 15 Pro Silicone Case with MagSafe` at `$ 25.00`.
6. Verify the second result is `240W USB-C Charge Cable (2 m)` with current price `$ 28.00`.
7. Open `/category/phone?price_min=20&price_max=30`.
8. Verify the category loads successfully and shows a controlled empty-result state because no `Phone` products matched this range during production execution.

**Expected Result:** Price query parameters update category results based on the entered range and preserve a usable product listing or controlled empty state.

## E2E-017 Complete Checkout Flow

Execute this case on staging by default. Production execution is allowed only when test order submission is explicitly approved.
This case was not executed on production during Chrome validation.

**Objective:** Confirm checkout can complete an order end to end using the test email `ai@test.com`.

**Steps:**

1. Start in a clean browser session on staging.
2. Add a random simple in-stock product to cart.
3. Open `/cart`.
4. Verify the cart contains the selected product and the order total is visible.
5. Click `Proceed to checkout`.
6. Verify the checkout contact step opens.
7. Enter `ai@test.com` in the `Email` field.
8. Keep `Email me with news and offers` selected unless the test objective says otherwise.
9. Click `Continue to shipping`.
10. Fill all required shipping fields with the test shipping data: first name `AI`, last name `Tester`, address `1 John Doe`, ZIP `95014`, city `Cupertino`, state `CA`, phone `+18001234567`.
11. Continue to the delivery method step.
12. Use the default `US Shipping` delivery method.
13. Continue to the payment method step.
14. Use the default `Cash on delivery` payment method.
15. Review the order summary and verify the selected product, quantity, and total are correct.
16. Click `Complete order`.
17. Verify the thank-you page loads.
18. Record the order ID or confirmation identifier.
19. Verify the confirmation page shows the order summary and the email `ai@test.com` if the page exposes contact details.
20. Verify `/thank-you/<order-id>` loads if the environment supports direct order lookup.

**Expected Result:** A test order can be submitted with `ai@test.com`, and the order confirmation is displayed with the correct selected product, shipping address, payment method, order ID, status, and total.

## E2E-018 Multi-Category Multi-Product Checkout Flow

Execute this case on staging by default. Production execution is allowed only when test order submission is explicitly approved.

**Objective:** Confirm checkout can complete an order containing products from different categories.

**Steps:**

1. Start in a clean browser session on staging.
2. Add a random simple in-stock Accessories product to cart.
3. Verify the header cart quantity is `1`.
4. Open `/product/samsung-galaxy-s23-ultra`.
5. Wait until the existing cart quantity `1` is visible on the product detail page.
6. Select Storage `512 GB`.
7. Select Color `Phantom Black`.
8. Verify the selected Samsung variant is in stock and priced at `$ 1,999.00`.
9. Click `Buy`.
10. Verify the header cart quantity changes to `2`.
11. Open `/cart`.
12. Verify the cart contains both the selected Accessories product and `Samsung Galaxy S23 Ultra, 512 GB - Phantom Black`.
13. Verify the cart order total quantity is `2` and subtotal equals the selected Accessories product price plus `$ 1,999.00`.
14. Click `Proceed to checkout`.
15. Enter `ai@test.com` in the `Email` field.
16. Continue to shipping.
17. Fill shipping fields with the test shipping data: first name `AI`, last name `Tester`, address `1 John Doe`, ZIP `95014`, city `Cupertino`, state `CA`, phone `+18001234567`.
18. Continue to payment.
19. Verify the payment summary includes both products, the computed subtotal, `US Shipping` `$ 4.90`, and the computed total.
20. Use the default `Cash on delivery` payment method.
21. Click `Complete order`.
22. Verify the thank-you page loads with order ID, status `New`, both products, shipping address, payment method, and the computed total.

**Expected Result:** A test order with products from both Accessories and Phone categories can be submitted successfully, and the confirmation page preserves all selected products, variant details, totals, address, and payment method.

## Automation Mapping

| Manual Case | Playwright Coverage |
| --- | --- |
| E2E-001 | `home-and-navigation.spec.ts` |
| E2E-002 | `home-and-navigation.spec.ts` |
| E2E-003 | `home-and-navigation.spec.ts`, `catalog-and-product.spec.ts` |
| E2E-004 | `catalog-and-product.spec.ts` |
| E2E-005 | `catalog-and-product.spec.ts` |
| E2E-006 | `cart-and-checkout.spec.ts` |
| E2E-007 | `cart-and-checkout.spec.ts` |
| E2E-008 | `cart-and-checkout.spec.ts` |
| E2E-009 | `cart-and-checkout.spec.ts` |
| E2E-010 | `cart-and-checkout.spec.ts` |
| E2E-011 | `cart-and-checkout.spec.ts` |
| E2E-012 | `checkout-paths.spec.ts` |
| E2E-013 | `checkout-paths.spec.ts` |
| E2E-014 | `cart-and-checkout.spec.ts` |
| E2E-015 | `regression.spec.ts` |
| E2E-016 | `price-search.spec.ts` |
| E2E-017 | `complete-checkout.spec.ts` |
| E2E-018 | `complete-checkout.spec.ts` |
