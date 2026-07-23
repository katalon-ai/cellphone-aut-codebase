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

"Step 1: Navigate to https://cellphoneshop-truetest-auto-staging.netlify.app/category/accessories-apple"

TrueTestScripts.navigate("/category/accessories-apple")

"Step 2: Enter input value in input priceMin"

TrueTestScripts.setText(findTestObject('AI-Generated/Staging/Page_category_accessories_apple/input_priceMin'), input_priceMin)

"Step 3: Enter input value in input priceMax"

TrueTestScripts.setText(findTestObject('AI-Generated/Staging/Page_category_accessories_apple/input_priceMax'), input_priceMax)

"Step 4: Click on input inStock"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_category_accessories_apple/input_inStock'))

"Step 5: Click on button search"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_category_accessories_apple/button_search'))

"Step 6: Click on link byTitle"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_category_accessories_apple/link_byTitle'))

"Step 7: Click on button clear -> Navigate to page ''"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_category_accessories_apple/button_clear'))

"Step 8: Take full page screenshot as checkpoint"

WebUI.takeFullPageScreenshotAsCheckpoint('TC2-Search for Apple Accessories within Price Range and Return Home_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}