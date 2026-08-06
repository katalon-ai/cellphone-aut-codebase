import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import truetest.Staging.custom.TrueTestScripts


'Initialize test session: Open browser and set view port'

@com.kms.katalon.core.annotation.SetUp
def setup() {
	WebUI.openBrowser('')
	WebUI.setViewPortSize(1280, 720)
	//WebUI.maximizeWindow()
}

"Step 1: Navigate to https://cellphoneshop-truetest-auto-staging.netlify.app/product/apple-airpods-pro-2 with params (category)"

TrueTestScripts.navigate("/product/${product_id}", ["category": product_category])

"Step 2: Click on button quantityAdjustment (increase2)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/button_quantityAdjustment"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/button_quantityAdjustment', ['button_quantityAdjustment_ButtonTitle_1': button_quantityAdjustment_ButtonTitle, 'button_quantityAdjustment_css_value_1': button_quantityAdjustment_css_value]))

"Step 3: Click on button buy -> Navigate to page '/cart'"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_product/button_buy'))

"Step 4: Click on button quantityAdjustment (increase)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_cart/button_quantityAdjustment"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_cart/button_quantityAdjustment', ['button_quantityAdjustment_ButtonTitle_2': button_quantityAdjustment_ButtonTitle_1, 'button_quantityAdjustment_css_value_2': button_quantityAdjustment_css_value_1]))

"Step 5: Click on button quantityAdjustment (decrease)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_cart/button_quantityAdjustment"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_cart/button_quantityAdjustment', ['button_quantityAdjustment_ButtonTitle_2': button_quantityAdjustment_ButtonTitle_2, 'button_quantityAdjustment_css_value_2': button_quantityAdjustment_css_value_2]))

"Step 6: Click on button proceedToCheckout -> Navigate to page '/checkout/info'"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_cart/button_proceedToCheckout'))

"Step 7: Double-click on input email"

WebUI.doubleClick(findTestObject('AI-Generated/Staging/Page_checkout_info/input_email'))

"Step 8: Click on input email"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_checkout_info/input_email'))

"Step 9: Enter input value in input email"

TrueTestScripts.setText(findTestObject('AI-Generated/Staging/Page_checkout_info/input_email'), input_email)

"Step 10: Click on button continueToShipping -> Navigate to page '/checkout/shipping-address'"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_checkout_info/button_continueToShipping'))

"Step 11: Double-click on input firstName"

WebUI.doubleClick(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_firstName'))

"Step 12: Click on input firstName"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_firstName'))

"Step 13: Enter input value in input firstName"

TrueTestScripts.setText(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_firstName'), input_firstName)

"Step 14: Double-click on input lastName"

WebUI.doubleClick(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_lastName'))

"Step 15: Click on input lastName"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_lastName'))

"Step 16: Enter input value in input lastName"

TrueTestScripts.setText(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_lastName'), input_lastName)

"Step 17: Double-click on input address"

WebUI.doubleClick(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_address'))

"Step 18: Click on input address"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_address'))

"Step 19: Enter input value in input address"

TrueTestScripts.setText(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_address'), input_address)

"Step 20: Double-click on input zipCode"

WebUI.doubleClick(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_zipCode'))

"Step 21: Click on input zipCode"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_zipCode'))

"Step 22: Enter input value in input zipCode"

TrueTestScripts.setText(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_zipCode'), input_zipCode)

"Step 23: Double-click on input city"

WebUI.doubleClick(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_city'))

"Step 24: Click on input city"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_city'))

"Step 25: Enter input value in input city"

TrueTestScripts.setText(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_city'), input_city)

"Step 26: Double-click on input state"

WebUI.doubleClick(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_state'))

"Step 27: Click on input state"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_state'))

"Step 28: Enter input value in input state"

TrueTestScripts.setText(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_state'), input_state)

"Step 29: Double-click on input phone"

WebUI.doubleClick(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_phone'))

"Step 30: Click on input phone"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_phone'))

"Step 31: Enter input value in input phone"

TrueTestScripts.setText(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_phone'), input_phone)

"Step 32: Click on button continueToPayment -> Navigate to page '/checkout/payment'"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/button_continueToPayment'))

"Step 33: Click on button completeOrder -> Navigate to page '/thank-you/*'"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_checkout_payment/button_completeOrder'))

"Step 34: Take full page screenshot as checkpoint"

WebUI.takeFullPageScreenshotAsCheckpoint('TC6-Complete Checkout Process with Multiple Quantity Adjustments_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}