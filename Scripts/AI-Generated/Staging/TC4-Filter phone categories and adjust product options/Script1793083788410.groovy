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

"Step 2: Enter input value in input priceFrom"

TrueTestScripts.setText(findTestObject('AI-Generated/Staging/Page_category_phone_samsung/input_priceFrom'), input_priceFrom)

"Step 3: Enter input value in input priceTo"

TrueTestScripts.setText(findTestObject('AI-Generated/Staging/Page_category_phone_samsung/input_priceTo'), input_priceTo)

"Step 4: Click on input inStock"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_category_phone_samsung/input_inStock'))

"Step 5: Click on button search"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_category_phone_samsung/button_search'))

"Step 6: Click on link sortByPrice -> Navigate to page '/product/*'"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_category_phone_samsung/link_sortByPrice'))

"Step 7: Click on label storageOption (storageOneTb)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/label_storageOption"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/label_storageOption', ['label_storageOption_LabelInternalText_1': label_storageOption_LabelInternalText, 'label_storageOption_css_value_1': label_storageOption_css_value]))

"Step 8: Click on label storageOption (selectCream)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/label_storageOption"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/label_storageOption', ['label_storageOption_LabelInternalText_1': label_storageOption_LabelInternalText_1, 'label_storageOption_css_value_1': label_storageOption_css_value_1]))

"Step 9: Click on button productQuantity (increaseIcon)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/button_productQuantity"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/button_productQuantity', ['button_productQuantity_ButtonTitle_1': button_productQuantity_ButtonTitle, 'button_productQuantity_css_value_1': button_productQuantity_css_value]))

"Step 10: Click on button productQuantity (decreaseIcon) -> Navigate to page '/category/phone-apple'"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/button_productQuantity"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/button_productQuantity', ['button_productQuantity_ButtonTitle_1': button_productQuantity_ButtonTitle_1, 'button_productQuantity_css_value_1': button_productQuantity_css_value_1]))

"Step 11: Enter input value in input priceFrom"

TrueTestScripts.setText(findTestObject('AI-Generated/Staging/Page_category_phone_apple/input_priceFrom'), input_priceFrom_1)

"Step 12: Enter input value in input priceTo"

TrueTestScripts.setText(findTestObject('AI-Generated/Staging/Page_category_phone_apple/input_priceTo'), input_priceTo_1)

"Step 13: Click on input inStock"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_category_phone_apple/input_inStock'))

"Step 14: Click on button search"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_category_phone_apple/button_search'))

"Step 15: Click on link sortByTitle -> Navigate to page '/product/*'"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_category_phone_apple/link_sortByTitle'))

"Step 16: Click on label storageOption (pink)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/label_storageOption"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/label_storageOption', ['label_storageOption_LabelInternalText_1': label_storageOption_LabelInternalText_2, 'label_storageOption_css_value_1': label_storageOption_css_value_2]))

"Step 17: Click on label storageOption (storageFiveHundredTwelveGb)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/label_storageOption"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/label_storageOption', ['label_storageOption_LabelInternalText_1': label_storageOption_LabelInternalText_3, 'label_storageOption_css_value_1': label_storageOption_css_value_3]))

"Step 18: Click on button productQuantity (increaseIcon)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/button_productQuantity"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/button_productQuantity', ['button_productQuantity_ButtonTitle_1': button_productQuantity_ButtonTitle_2, 'button_productQuantity_css_value_1': button_productQuantity_css_value_2]))

"Step 19: Click on button productQuantity (decreaseIcon) -> Navigate to page ''"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/button_productQuantity"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/button_productQuantity', ['button_productQuantity_ButtonTitle_1': button_productQuantity_ButtonTitle_3, 'button_productQuantity_css_value_1': button_productQuantity_css_value_3]))

"Step 20: Take full page screenshot as checkpoint"

WebUI.takeFullPageScreenshotAsCheckpoint('TC4-Filter phone categories and adjust product options_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}