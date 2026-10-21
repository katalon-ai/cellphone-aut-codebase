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

"Step 2: Click on label object (storage256Gb)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/label_object"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/label_object', ['label_object_LabelInternalText_1': label_object_LabelInternalText, 'label_object_css_value_1': label_object_css_value]))

"Step 3: Click on label object (phantomBlack)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/label_object"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/label_object', ['label_object_LabelInternalText_1': label_object_LabelInternalText_1, 'label_object_css_value_1': label_object_css_value_1]))

"Step 4: Click on button increaseDecrease (increaseIcon) -> Navigate to page ''"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/button_increaseDecrease"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/button_increaseDecrease', ['button_increaseDecrease_ButtonTitle_1': button_increaseDecrease_ButtonTitle, 'button_increaseDecrease_css_value_1': button_increaseDecrease_css_value]))

"Step 5: Take full page screenshot as checkpoint"

WebUI.takeFullPageScreenshotAsCheckpoint('TC3-Interact with a product and adjust quantity_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}