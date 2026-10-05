import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import truetest.Staging.common.completeCheckoutProcessWithShippingDetails
import truetest.Staging.custom.TrueTestScripts


'Initialize test session: Open browser and set view port'

@com.kms.katalon.core.annotation.SetUp
def setup() {
	WebUI.openBrowser('')
	WebUI.setViewPortSize(1280, 720)
	//WebUI.maximizeWindow()
}

"Step 1: Navigate to https://cellphoneshop-truetest-auto-staging.netlify.app/product/iphone-15-clear-case-with-magsafe"

TrueTestScripts.navigate("/product/${product_id}")

"Step 2: Click on button buy2"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/button_quantityControl"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/button_quantityControl', ['button_quantityControl_ButtonTitle_1': button_quantityControl_ButtonTitle, 'button_quantityControl_css_value_1': button_quantityControl_css_value]))

"Step 3: Click on label productAttributes (ultramarine)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/label_productAttributes"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/label_productAttributes', ['label_productAttributes_LabelInternalText_1': label_productAttributes_LabelInternalText, 'label_productAttributes_css_value_1': label_productAttributes_css_value]))

"Step 4: Click on label productAttributes ( 128Gb)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/label_productAttributes"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/label_productAttributes', ['label_productAttributes_LabelInternalText_1': label_productAttributes_LabelInternalText_1, 'label_productAttributes_css_value_1': label_productAttributes_css_value_1]))

"Step 5: Click on button buy"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/button_quantityControl"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/button_quantityControl', ['button_quantityControl_ButtonTitle_1': button_quantityControl_ButtonTitle_1, 'button_quantityControl_css_value_1': button_quantityControl_css_value_1]))

"Step 6: Fill in shipping details and complete the checkout process"

completeCheckoutProcessWithShippingDetails.execute(input_address, input_city, input_email, input_firstName, input_lastName, input_phone, input_state, input_zipCode)

"Step 7: Take full page screenshot as checkpoint"

WebUI.takeFullPageScreenshotAsCheckpoint('TC7-Buy Product with Attributes and Complete Checkout_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}