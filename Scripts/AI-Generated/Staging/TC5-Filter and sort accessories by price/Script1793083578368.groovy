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

"Step 1: Navigate to https://cellphoneshop-truetest-auto-staging.netlify.app/category/accessories"

TrueTestScripts.navigate("/category/accessories")

"Step 2: Enter input value in input priceFrom"

TrueTestScripts.setText(findTestObject('AI-Generated/Staging/Page_category_accessories/input_priceFrom'), input_priceFrom)

"Step 3: Enter input value in input priceTo"

TrueTestScripts.setText(findTestObject('AI-Generated/Staging/Page_category_accessories/input_priceTo'), input_priceTo)

"Step 4: Click on input inStock"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_category_accessories/input_inStock'))

"Step 5: Click on button search"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_category_accessories/button_search'))

"Step 6: Click on link sortByPrice -> Navigate to page '/product/*'"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_category_accessories/link_sortByPrice'))

"Step 7: Take full page screenshot as checkpoint"

WebUI.takeFullPageScreenshotAsCheckpoint('TC5-Filter and sort accessories by price_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}