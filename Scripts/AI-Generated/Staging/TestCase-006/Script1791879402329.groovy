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

"Step 1: Navigate to https://cellphoneshop-truetest-auto-staging.netlify.app/product/apple-iphone-16"

TrueTestScripts.navigate("/product/${product_id}")

"Step 2: Click on div dynamicObject (pink)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/div_dynamicObject"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/div_dynamicObject', ['div_dynamicObject_LabelInternalText_1': div_dynamicObject_LabelInternalText, 'div_dynamicObject_css_value_1': div_dynamicObject_css_value]))

"Step 3: Click on div dynamicObject ( 512Gb2)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/div_dynamicObject"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/div_dynamicObject', ['div_dynamicObject_LabelInternalText_1': div_dynamicObject_LabelInternalText_1, 'div_dynamicObject_css_value_1': div_dynamicObject_css_value_1]))

"Step 4: Click on div dynamicObject (increaseIcon)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/div_dynamicObject_1"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/div_dynamicObject_1', ['div_dynamicObject_ButtonTitle_1': div_dynamicObject_ButtonTitle, 'div_dynamicObject_css_value_2': div_dynamicObject_css_value_2]))

"Step 5: Click on button buy -> Navigate to page '/cart'"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/div_dynamicObject_1"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/div_dynamicObject_1', ['div_dynamicObject_ButtonTitle_1': div_dynamicObject_ButtonTitle_1, 'div_dynamicObject_css_value_2': div_dynamicObject_css_value_3]))

"Step 6: Click on div dynamicObject (increase)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_cart/div_dynamicObject"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_cart/div_dynamicObject', ['div_dynamicObject_ButtonTitle_2': div_dynamicObject_ButtonTitle_2, 'div_dynamicObject_css_value_3': div_dynamicObject_css_value_4]))

"Step 7: Click on div dynamicObject (decrease)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_cart/div_dynamicObject"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_cart/div_dynamicObject', ['div_dynamicObject_ButtonTitle_2': div_dynamicObject_ButtonTitle_3, 'div_dynamicObject_css_value_3': div_dynamicObject_css_value_5]))

"Step 8: Click on button proceedToCheckout -> Navigate to page '/checkout/info'"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_cart/button_proceedToCheckout'))

"Step 9: Click on input email"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_checkout_info/input_email'))

"Step 10: Enter input value in input email"

TrueTestScripts.setText(findTestObject('AI-Generated/Staging/Page_checkout_info/input_email'), input_email)

"Step 11: Click on button continueToShipping -> Navigate to page '/checkout/shipping-address'"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_checkout_info/button_continueToShipping'))

"Step 12: Click on input firstName"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_firstName'))

"Step 13: Enter input value in input firstName"

TrueTestScripts.setText(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_firstName'), input_firstName)

"Step 14: Click on input lastName"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_lastName'))

"Step 15: Enter input value in input lastName"

TrueTestScripts.setText(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_lastName'), input_lastName)

"Step 16: Click on input address"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_address'))

"Step 17: Enter input value in input address"

TrueTestScripts.setText(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_address'), input_address)

"Step 18: Click on input zipCode"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_zipCode'))

"Step 19: Enter input value in input zipCode"

TrueTestScripts.setText(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_zipCode'), input_zipCode)

"Step 20: Click on input city"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_city'))

"Step 21: Enter input value in input city"

TrueTestScripts.setText(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_city'), input_city)

"Step 22: Click on input state"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_state'))

"Step 23: Enter input value in input state"

TrueTestScripts.setText(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_state'), input_state)

"Step 24: Click on input phone"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_phone'))

"Step 25: Enter input value in input phone"

TrueTestScripts.setText(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_phone'), input_phone)

"Step 26: Click on button continueToPayment -> Navigate to page '/checkout/payment'"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/button_continueToPayment'))

"Step 27: Click on button completeOrder -> Navigate to page '/thank-you/*'"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_checkout_payment/button_completeOrder'))

"Step 28: Take full page screenshot as checkpoint"

WebUI.takeFullPageScreenshotAsCheckpoint('TestCase-006_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}