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

"Step 1: Navigate to https://cellphoneshop-truetest-auto-staging.netlify.app/product/iphone-15-clear-case-with-magsafe"

TrueTestScripts.navigate("/product/${product_id}")

"Step 2: Click on button quantityAdjustment (increase2)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/button_quantityAdjustment"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/button_quantityAdjustment', ['button_quantityAdjustment_ButtonTitle_1': button_quantityAdjustment_ButtonTitle, 'button_quantityAdjustment_css_value_1': button_quantityAdjustment_css_value]))

"Step 3: Click on button quantityAdjustment (decrease2)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/button_quantityAdjustment"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/button_quantityAdjustment', ['button_quantityAdjustment_ButtonTitle_1': button_quantityAdjustment_ButtonTitle_1, 'button_quantityAdjustment_css_value_1': button_quantityAdjustment_css_value_1]))

"Step 4: Click on button quantityAdjustment (increase2)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/button_quantityAdjustment"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/button_quantityAdjustment', ['button_quantityAdjustment_ButtonTitle_1': button_quantityAdjustment_ButtonTitle_2, 'button_quantityAdjustment_css_value_1': button_quantityAdjustment_css_value_2]))

"Step 5: Click on button buy -> Navigate to page ''"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_product/button_buy'))

"Step 6: Take full page screenshot as checkpoint"

WebUI.takeFullPageScreenshotAsCheckpoint('TC7-Adjust Product Quantity and Return to Home Page_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}