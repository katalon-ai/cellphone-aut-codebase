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

"Step 6: Click on div dynamicObject (colorBlack)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/div_dynamicObject"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/div_dynamicObject', ['div_dynamicObject_LabelInternalText_1': div_dynamicObject_LabelInternalText, 'div_dynamicObject_css_value_1': div_dynamicObject_css_value]))

"Step 7: Click on div dynamicObject (storage256Gb)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/div_dynamicObject"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/div_dynamicObject', ['div_dynamicObject_LabelInternalText_1': div_dynamicObject_LabelInternalText_1, 'div_dynamicObject_css_value_1': div_dynamicObject_css_value_1]))

"Step 8: Click on div dynamicObject (increaseIcon)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/div_dynamicObject_1"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/div_dynamicObject_1', ['div_dynamicObject_ButtonTitle_1': div_dynamicObject_ButtonTitle, 'div_dynamicObject_css_value_2': div_dynamicObject_css_value_2]))

"Step 9: Click on div dynamicObject (decreaseIcon) -> Navigate to page ''"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/div_dynamicObject_1"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/div_dynamicObject_1', ['div_dynamicObject_ButtonTitle_1': div_dynamicObject_ButtonTitle_1, 'div_dynamicObject_css_value_2': div_dynamicObject_css_value_3]))

"Step 10: Take full page screenshot as checkpoint"

WebUI.takeFullPageScreenshotAsCheckpoint('TestCase-001_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}