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

"Step 6: Click on link byPrice"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_category_phone_samsung/link_byPrice'))

"Step 7: Click on link samsungGalaxyS23Ultra"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_category_phone_samsung/link_samsungGalaxyS23Ultra'))

"Step 8: Click on link apple -> Navigate to page '/category/phone-apple'"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_category_phone_samsung/link_apple'))

"Step 9: Enter input value in input priceMin"

TrueTestScripts.setText(findTestObject('AI-Generated/Staging/Page_category_phone_apple/input_priceMin'), input_priceMin_1)

"Step 10: Enter input value in input priceMax"

TrueTestScripts.setText(findTestObject('AI-Generated/Staging/Page_category_phone_apple/input_priceMax'), input_priceMax_1)

"Step 11: Click on input inStock"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_category_phone_apple/input_inStock'))

"Step 12: Click on button search"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_category_phone_apple/button_search'))

"Step 13: Click on link byTitle"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_category_phone_apple/link_byTitle'))

"Step 14: Select storage options and adjust quantity for Apple iPhones."

selectAppleIphoneOptionsAndAdjustQuantity.execute(button_quantityAdjustment_ButtonTitle, button_quantityAdjustment_ButtonTitle_1, button_quantityAdjustment_css_value, button_quantityAdjustment_css_value_1, label_storageColorOptions_LabelInternalText, label_storageColorOptions_LabelInternalText_1, label_storageColorOptions_css_value, label_storageColorOptions_css_value_1, link_appleIphones_InternalRoleLinkName, link_appleIphones_css_value)

"Step 15: Take full page screenshot as checkpoint"

WebUI.takeFullPageScreenshotAsCheckpoint('TC4-Search for Samsung and Apple Phones with Price Filters_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}