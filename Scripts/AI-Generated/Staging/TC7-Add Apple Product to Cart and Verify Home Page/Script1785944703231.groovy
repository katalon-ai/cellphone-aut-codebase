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

"Step 2: Click on label storageColorOptions (colorWhite)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/label_storageColorOptions"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/label_storageColorOptions', ['label_storageColorOptions_LabelInternalText_1': label_storageColorOptions_LabelInternalText, 'label_storageColorOptions_css_value_1': label_storageColorOptions_css_value]))

"Step 3: Click on label storageColorOptions (storage512Gb)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/label_storageColorOptions"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/label_storageColorOptions', ['label_storageColorOptions_LabelInternalText_1': label_storageColorOptions_LabelInternalText_1, 'label_storageColorOptions_css_value_1': label_storageColorOptions_css_value_1]))

"Step 4: Click on button buy -> Navigate to page '/cart'"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_product/button_buy'))

"Step 5: Click on button cartQuantityAdjustment (increase)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_cart/button_cartQuantityAdjustment"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_cart/button_cartQuantityAdjustment', ['button_cartQuantityAdjustment_ButtonTitle_1': button_cartQuantityAdjustment_ButtonTitle, 'button_cartQuantityAdjustment_css_value_1': button_cartQuantityAdjustment_css_value]))

"Step 6: Click on button cartQuantityAdjustment (decrease) -> Navigate to page ''"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_cart/button_cartQuantityAdjustment"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_cart/button_cartQuantityAdjustment', ['button_cartQuantityAdjustment_ButtonTitle_1': button_cartQuantityAdjustment_ButtonTitle_1, 'button_cartQuantityAdjustment_css_value_1': button_cartQuantityAdjustment_css_value_1]))

"Step 7: Take full page screenshot as checkpoint"

WebUI.takeFullPageScreenshotAsCheckpoint('TC7-Add Apple Product to Cart and Verify Home Page_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}