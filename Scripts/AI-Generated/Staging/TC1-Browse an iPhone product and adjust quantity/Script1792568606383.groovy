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

"Step 1: Navigate to https://cellphoneshop-truetest-auto-staging.netlify.app"

TrueTestScripts.navigate("/")

"Step 2: Click on link about -> Navigate to page '/about'"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_home/link_about'))

"Step 3: Click on link phone -> Navigate to page '/category/phone'"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_about/link_phone'))

"Step 4: Click on link apple -> Navigate to page '/category/phone-apple'"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_category_phone/link_apple'))

"Step 5: Click on link iphone16e -> Navigate to page '/product/*'"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_category_phone_apple/link_iphone16e'))

"Step 6: Click on label object (white)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/label_object"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/label_object', ['label_object_LabelInternalText_1': label_object_LabelInternalText, 'label_object_css_value_1': label_object_css_value]))

"Step 7: Click on label object ( 128Gb)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/label_object"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/label_object', ['label_object_LabelInternalText_1': label_object_LabelInternalText_1, 'label_object_css_value_1': label_object_css_value_1]))

"Step 8: Click on button increaseDecrease (increaseIcon)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/button_increaseDecrease"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/button_increaseDecrease', ['button_increaseDecrease_ButtonTitle_1': button_increaseDecrease_ButtonTitle, 'button_increaseDecrease_css_value_1': button_increaseDecrease_css_value]))

"Step 9: Click on button increaseDecrease (decreaseIcon) -> Navigate to page ''"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/button_increaseDecrease"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/button_increaseDecrease', ['button_increaseDecrease_ButtonTitle_1': button_increaseDecrease_ButtonTitle_1, 'button_increaseDecrease_css_value_1': button_increaseDecrease_css_value_1]))

"Step 10: Take full page screenshot as checkpoint"

WebUI.takeFullPageScreenshotAsCheckpoint('TC1-Browse an iPhone product and adjust quantity_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}