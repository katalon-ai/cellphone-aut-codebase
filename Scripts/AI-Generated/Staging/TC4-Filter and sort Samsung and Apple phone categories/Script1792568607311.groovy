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

"Step 7: Click on label object ( 1Tb)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/label_object"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/label_object', ['label_object_LabelInternalText_1': label_object_LabelInternalText, 'label_object_css_value_1': label_object_css_value]))

"Step 8: Click on label object (phantomBlack2)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/label_object"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/label_object', ['label_object_LabelInternalText_1': label_object_LabelInternalText_1, 'label_object_css_value_1': label_object_css_value_1]))

"Step 9: Click on button increaseDecrease (increaseIcon)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/button_increaseDecrease"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/button_increaseDecrease', ['button_increaseDecrease_ButtonTitle_1': button_increaseDecrease_ButtonTitle, 'button_increaseDecrease_css_value_1': button_increaseDecrease_css_value]))

"Step 10: Click on button increaseDecrease (decreaseIcon) -> Navigate to page '/category/phone-apple'"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/button_increaseDecrease"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/button_increaseDecrease', ['button_increaseDecrease_ButtonTitle_1': button_increaseDecrease_ButtonTitle_1, 'button_increaseDecrease_css_value_1': button_increaseDecrease_css_value_1]))

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

"Step 16: Click on label object (ultramarine)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/label_object"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/label_object', ['label_object_LabelInternalText_1': label_object_LabelInternalText_2, 'label_object_css_value_1': label_object_css_value_2]))

"Step 17: Click on label object ( 128Gb2)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/label_object"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/label_object', ['label_object_LabelInternalText_1': label_object_LabelInternalText_3, 'label_object_css_value_1': label_object_css_value_3]))

"Step 18: Click on button increaseDecrease (increaseIcon)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/button_increaseDecrease"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/button_increaseDecrease', ['button_increaseDecrease_ButtonTitle_1': button_increaseDecrease_ButtonTitle_2, 'button_increaseDecrease_css_value_1': button_increaseDecrease_css_value_2]))

"Step 19: Click on button increaseDecrease (decreaseIcon) -> Navigate to page ''"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/button_increaseDecrease"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/button_increaseDecrease', ['button_increaseDecrease_ButtonTitle_1': button_increaseDecrease_ButtonTitle_3, 'button_increaseDecrease_css_value_1': button_increaseDecrease_css_value_3]))

"Step 20: Take full page screenshot as checkpoint"

WebUI.takeFullPageScreenshotAsCheckpoint('TC4-Filter and sort Samsung and Apple phone categories_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}