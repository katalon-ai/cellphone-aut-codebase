import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import truetest.Staging.common.selectAppleIphoneOptionsAndAdjustQuantity
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

"Step 4: Click on link apple"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_category_phone/link_apple'))

"Step 5: Select storage options and adjust quantity for Apple iPhones."

selectAppleIphoneOptionsAndAdjustQuantity.execute(button_quantityAdjustment_ButtonTitle, button_quantityAdjustment_ButtonTitle_1, button_quantityAdjustment_css_value, button_quantityAdjustment_css_value_1, label_storageColorOptions_LabelInternalText, label_storageColorOptions_LabelInternalText_1, label_storageColorOptions_css_value, label_storageColorOptions_css_value_1, link_appleIphones_InternalRoleLinkName, link_appleIphones_css_value)

"Step 6: Take full page screenshot as checkpoint"

WebUI.takeFullPageScreenshotAsCheckpoint('TC1-Navigate to About Page and Explore Apple iPhone Options_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}