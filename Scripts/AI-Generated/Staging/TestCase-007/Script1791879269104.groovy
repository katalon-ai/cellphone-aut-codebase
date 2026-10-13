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

"Step 1: Navigate to https://cellphoneshop-truetest-auto-staging.netlify.app/product/apple-airpods-pro-2 with params (category)"

TrueTestScripts.navigate("/product/${product_id}", ["category": product_category])

"Step 2: Click on div dynamicObject (increaseIcon2)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/div_dynamicObject_1"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/div_dynamicObject_1', ['div_dynamicObject_ButtonTitle_1': div_dynamicObject_ButtonTitle, 'div_dynamicObject_css_value_2': div_dynamicObject_css_value]))

"Step 3: Click on div dynamicObject (decreaseIcon2)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/div_dynamicObject_1"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/div_dynamicObject_1', ['div_dynamicObject_ButtonTitle_1': div_dynamicObject_ButtonTitle_1, 'div_dynamicObject_css_value_2': div_dynamicObject_css_value_1]))

"Step 4: Click on button buy2 -> Navigate to page ''"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/div_dynamicObject_1"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/div_dynamicObject_1', ['div_dynamicObject_ButtonTitle_1': div_dynamicObject_ButtonTitle_2, 'div_dynamicObject_css_value_2': div_dynamicObject_css_value_2]))

"Step 5: Take full page screenshot as checkpoint"

WebUI.takeFullPageScreenshotAsCheckpoint('TestCase-007_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}