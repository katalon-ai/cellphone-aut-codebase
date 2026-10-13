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

"Step 1: Navigate to https://cellphoneshop-truetest-auto-staging.netlify.app/category/phone-samsung"

TrueTestScripts.navigate("/category/phone-samsung")

"Step 2: Enter input value in input priceMin"

TrueTestScripts.setText(findTestObject('AI-Generated/Staging/Page_category_phone_samsung/input_priceMin'), input_priceMin)

"Step 3: Enter input value in input priceMax"

TrueTestScripts.setText(findTestObject('AI-Generated/Staging/Page_category_phone_samsung/input_priceMax'), input_priceMax)

"Step 4: Click on input inStock"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_category_phone_samsung/input_inStock'))

"Step 5: Click on button search"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_category_phone_samsung/button_search'))

"Step 6: Click on link sortByPrice -> Navigate to page '/product/*'"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_category_phone_samsung/link_sortByPrice'))

"Step 7: Click on div dynamicObject ( 512Gb)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/div_dynamicObject"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/div_dynamicObject', ['div_dynamicObject_LabelInternalText_1': div_dynamicObject_LabelInternalText, 'div_dynamicObject_css_value_1': div_dynamicObject_css_value]))

"Step 8: Click on div dynamicObject (green)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/div_dynamicObject"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/div_dynamicObject', ['div_dynamicObject_LabelInternalText_1': div_dynamicObject_LabelInternalText_1, 'div_dynamicObject_css_value_1': div_dynamicObject_css_value_1]))

"Step 9: Click on div dynamicObject (increaseIcon)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/div_dynamicObject_1"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/div_dynamicObject_1', ['div_dynamicObject_ButtonTitle_1': div_dynamicObject_ButtonTitle, 'div_dynamicObject_css_value_2': div_dynamicObject_css_value_4]))

"Step 10: Click on div dynamicObject (decreaseIcon) -> Navigate to page '/category/phone-apple'"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/div_dynamicObject_1"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/div_dynamicObject_1', ['div_dynamicObject_ButtonTitle_1': div_dynamicObject_ButtonTitle_1, 'div_dynamicObject_css_value_2': div_dynamicObject_css_value_5]))

"Step 11: Enter input value in input priceMin"

TrueTestScripts.setText(findTestObject('AI-Generated/Staging/Page_category_phone_apple/input_priceMin'), input_priceMin_1)

"Step 12: Enter input value in input priceMax"

TrueTestScripts.setText(findTestObject('AI-Generated/Staging/Page_category_phone_apple/input_priceMax'), input_priceMax_1)

"Step 13: Click on input inStock"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_category_phone_apple/input_inStock'))

"Step 14: Click on button search"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_category_phone_apple/button_search'))

"Step 15: Click on link sortByTitle -> Navigate to page '/product/*'"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_category_phone_apple/link_sortByTitle'))

"Step 16: Click on div dynamicObject (pink)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/div_dynamicObject"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/div_dynamicObject', ['div_dynamicObject_LabelInternalText_1': div_dynamicObject_LabelInternalText_2, 'div_dynamicObject_css_value_1': div_dynamicObject_css_value_2]))

"Step 17: Click on div dynamicObject ( 512Gb2)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/div_dynamicObject"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/div_dynamicObject', ['div_dynamicObject_LabelInternalText_1': div_dynamicObject_LabelInternalText_3, 'div_dynamicObject_css_value_1': div_dynamicObject_css_value_3]))

"Step 18: Click on div dynamicObject (increaseIcon)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/div_dynamicObject_1"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/div_dynamicObject_1', ['div_dynamicObject_ButtonTitle_1': div_dynamicObject_ButtonTitle_2, 'div_dynamicObject_css_value_2': div_dynamicObject_css_value_6]))

"Step 19: Click on div dynamicObject (decreaseIcon) -> Navigate to page ''"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/div_dynamicObject_1"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/div_dynamicObject_1', ['div_dynamicObject_ButtonTitle_1': div_dynamicObject_ButtonTitle_3, 'div_dynamicObject_css_value_2': div_dynamicObject_css_value_7]))

"Step 20: Take full page screenshot as checkpoint"

WebUI.takeFullPageScreenshotAsCheckpoint('TestCase-004_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}