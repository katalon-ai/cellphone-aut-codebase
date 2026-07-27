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

"Step 6: Click on link sortByTitle"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_category_phone_samsung/link_sortByTitle'))

"Step 7: Click on button clear -> Navigate to page ''"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_category_phone_samsung/button_clear'))

"Step 8: Take full page screenshot as checkpoint"

WebUI.takeFullPageScreenshotAsCheckpoint('TC2-Search for Samsung Phones within Price Range_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}