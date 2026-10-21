import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import truetest.Staging.common.enterShippingDetailsAndCompleteOrder
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

"Step 2: Click on button buy -> Navigate to page '/cart'"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_product/button_buy'))

"Step 3: Click on button increaseDecrease (increase)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_cart/button_increaseDecrease"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_cart/button_increaseDecrease', ['button_increaseDecrease_ButtonTitle_1': button_increaseDecrease_ButtonTitle, 'button_increaseDecrease_css_value_1': button_increaseDecrease_css_value]))

"Step 4: Click on button increaseDecrease (decrease)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_cart/button_increaseDecrease"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_cart/button_increaseDecrease', ['button_increaseDecrease_ButtonTitle_1': button_increaseDecrease_ButtonTitle_1, 'button_increaseDecrease_css_value_1': button_increaseDecrease_css_value_1]))

"Step 5: Enter checkout details and complete the order."

enterShippingDetailsAndCompleteOrder.execute(input_address, input_city, input_email, input_firstName, input_lastName, input_phone, input_state, input_zipCode)

"Step 6: Take full page screenshot as checkpoint"

WebUI.takeFullPageScreenshotAsCheckpoint('TC6-Review cart quantity and continue to order page_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}