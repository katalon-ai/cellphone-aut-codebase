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

"Step 1: Navigate to https://cellphoneshop-truetest-auto-staging.netlify.app/product/apple-iphone-16"

TrueTestScripts.navigate("/product/${product_id}")

"Step 2: Click on label storageColorOptions (white)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/label_storageColorOptions"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/label_storageColorOptions', ['label_storageColorOptions_LabelInternalText_1': label_storageColorOptions_LabelInternalText, 'label_storageColorOptions_css_value_1': label_storageColorOptions_css_value]))

"Step 3: Click on label storageColorOptions (storage256Gb2)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/label_storageColorOptions"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/label_storageColorOptions', ['label_storageColorOptions_LabelInternalText_1': label_storageColorOptions_LabelInternalText_1, 'label_storageColorOptions_css_value_1': label_storageColorOptions_css_value_1]))

"Step 4: Click on button quantityAdjustment (increase)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/button_quantityAdjustment"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/button_quantityAdjustment', ['button_quantityAdjustment_ButtonTitle_1': button_quantityAdjustment_ButtonTitle, 'button_quantityAdjustment_css_value_1': button_quantityAdjustment_css_value]))

"Step 5: Click on button buy2"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/button_quantityAdjustment"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/button_quantityAdjustment', ['button_quantityAdjustment_ButtonTitle_1': button_quantityAdjustment_ButtonTitle_1, 'button_quantityAdjustment_css_value_1': button_quantityAdjustment_css_value_1]))

"Step 6: Click on button quantityAdjustment (increase2)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/button_quantityAdjustment"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/button_quantityAdjustment', ['button_quantityAdjustment_ButtonTitle_1': button_quantityAdjustment_ButtonTitle_2, 'button_quantityAdjustment_css_value_1': button_quantityAdjustment_css_value_2]))

"Step 7: Click on button buy"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/button_quantityAdjustment"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/button_quantityAdjustment', ['button_quantityAdjustment_ButtonTitle_1': button_quantityAdjustment_ButtonTitle_3, 'button_quantityAdjustment_css_value_1': button_quantityAdjustment_css_value_3]))

"Step 8: Fill in shipping details and complete the checkout process"

completeCheckoutProcessWithShippingDetails.execute(input_address, input_city, input_email, input_firstName, input_lastName, input_phone, input_state, input_zipCode)

"Step 9: Take full page screenshot as checkpoint"

WebUI.takeFullPageScreenshotAsCheckpoint('Select Storage and Color Options for Product Purchase_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}