import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import truetest.Staging.common.enterCheckoutDetailsAndCompleteOrder
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

"Step 2: Click on button quantityAdjust (increase2)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/button_quantityAdjust"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/button_quantityAdjust', ['button_quantityAdjust_ButtonTitle_1': button_quantityAdjust_ButtonTitle, 'button_quantityAdjust_css_value_1': button_quantityAdjust_css_value]))

"Step 3: Click on button buy2"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/button_quantityAdjust"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/button_quantityAdjust', ['button_quantityAdjust_ButtonTitle_1': button_quantityAdjust_ButtonTitle_1, 'button_quantityAdjust_css_value_1': button_quantityAdjust_css_value_1]))

"Step 4: Click on label storageOption (pink)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/label_storageOption"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/label_storageOption', ['label_storageOption_LabelInternalText_1': label_storageOption_LabelInternalText, 'label_storageOption_css_value_1': label_storageOption_css_value]))

"Step 5: Click on label storageOption (storageFiveHundredTwelveGb2)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/label_storageOption"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/label_storageOption', ['label_storageOption_LabelInternalText_1': label_storageOption_LabelInternalText_1, 'label_storageOption_css_value_1': label_storageOption_css_value_1]))

"Step 6: Click on button quantityAdjust (increase)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/button_quantityAdjust"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/button_quantityAdjust', ['button_quantityAdjust_ButtonTitle_1': button_quantityAdjust_ButtonTitle_2, 'button_quantityAdjust_css_value_1': button_quantityAdjust_css_value_2]))

"Step 7: Click on button buy"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/button_quantityAdjust"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/button_quantityAdjust', ['button_quantityAdjust_ButtonTitle_1': button_quantityAdjust_ButtonTitle_3, 'button_quantityAdjust_css_value_1': button_quantityAdjust_css_value_3]))

"Step 8: Enter checkout and shipping details, then complete the order."

enterCheckoutDetailsAndCompleteOrder.execute(input_addressLineOne, input_city, input_email, input_firstName, input_lastName, input_phone, input_state, input_zipCode)

"Step 9: Take full page screenshot as checkpoint"

WebUI.takeFullPageScreenshotAsCheckpoint('TC7-Add a product to the cart and complete checkout (2)_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}