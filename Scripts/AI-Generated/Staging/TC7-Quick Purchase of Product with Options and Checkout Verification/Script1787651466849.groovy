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

"Step 1: Navigate to https://cellphoneshop-truetest-auto-staging.netlify.app/product/apple-airpods-pro-2 with params (category)"

TrueTestScripts.navigate("/product/${product_id}", ["category": product_category])

"Step 2: Click on button buy2"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_product/button_buy2'))

"Step 3: Click on label storageColorOptions (colorPink)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/label_storageColorOptions"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/label_storageColorOptions', ['label_storageColorOptions_LabelInternalText_1': label_storageColorOptions_LabelInternalText, 'label_storageColorOptions_css_value_1': label_storageColorOptions_css_value]))

"Step 4: Click on label storageColorOptions ( 256Gb2)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/label_storageColorOptions"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/label_storageColorOptions', ['label_storageColorOptions_LabelInternalText_1': label_storageColorOptions_LabelInternalText_1, 'label_storageColorOptions_css_value_1': label_storageColorOptions_css_value_1]))

"Step 5: Click on button buy"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_product/button_buy_1'))

"Step 6: Fill in shipping details and complete the checkout process"

completeCheckoutProcessWithShippingDetails.execute(input_address, input_city, input_email, input_firstName, input_lastName, input_phone, input_state, input_zipCode)

"Step 7: Take full page screenshot as checkpoint"

WebUI.takeFullPageScreenshotAsCheckpoint('TC7-Quick Purchase of Product with Options and Checkout Verification_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}