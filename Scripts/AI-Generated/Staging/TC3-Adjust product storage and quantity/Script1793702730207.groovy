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

"Step 1: Navigate to https://cellphoneshop-truetest-auto-staging.netlify.app/product/samsung-galaxys23-ultra"

TrueTestScripts.navigate("/product/${product_id}")

"Step 2: Click on label storageOption (storage256Gb)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/label_storageOption"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/label_storageOption', ['label_storageOption_LabelInternalText_1': label_storageOption_LabelInternalText, 'label_storageOption_css_value_1': label_storageOption_css_value]))

"Step 3: Click on label storageOption (phantomBlack)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/label_storageOption"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/label_storageOption', ['label_storageOption_LabelInternalText_1': label_storageOption_LabelInternalText_1, 'label_storageOption_css_value_1': label_storageOption_css_value_1]))

"Step 4: Click on button increase (increase) -> Navigate to page ''"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/button_increase"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/button_increase', ['button_increase_ButtonTitle_1': button_increase_ButtonTitle, 'button_increase_css_value_1': button_increase_css_value]))

"Step 5: Take full page screenshot as checkpoint"

WebUI.takeFullPageScreenshotAsCheckpoint('TC3-Adjust product storage and quantity_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}