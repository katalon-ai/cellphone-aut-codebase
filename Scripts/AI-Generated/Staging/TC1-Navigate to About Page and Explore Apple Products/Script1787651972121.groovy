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

"Step 6: Click on label storageColorOptions (colorBlack)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/label_storageColorOptions"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/label_storageColorOptions', ['label_storageColorOptions_LabelInternalText_1': label_storageColorOptions_LabelInternalText, 'label_storageColorOptions_css_value_1': label_storageColorOptions_css_value]))

"Step 7: Click on label storageColorOptions ( 256Gb)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/label_storageColorOptions"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/label_storageColorOptions', ['label_storageColorOptions_LabelInternalText_1': label_storageColorOptions_LabelInternalText_1, 'label_storageColorOptions_css_value_1': label_storageColorOptions_css_value_1]))

"Step 8: Click on button quantityControl (increase)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/button_quantityControl"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/button_quantityControl', ['button_quantityControl_ButtonTitle_1': button_quantityControl_ButtonTitle, 'button_quantityControl_css_value_1': button_quantityControl_css_value]))

"Step 9: Click on button quantityControl (decreaseIcon) -> Navigate to page ''"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/button_quantityControl"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/button_quantityControl', ['button_quantityControl_ButtonTitle_1': button_quantityControl_ButtonTitle_1, 'button_quantityControl_css_value_1': button_quantityControl_css_value_1]))

"Step 10: Take full page screenshot as checkpoint"

WebUI.takeFullPageScreenshotAsCheckpoint('TC1-Navigate to About Page and Explore Apple Products_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}