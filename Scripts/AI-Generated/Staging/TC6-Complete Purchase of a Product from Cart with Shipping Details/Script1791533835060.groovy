import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import truetest.Staging.common.completeOrderWithShippingDetails
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

"Step 2: Click on button buy -> Navigate to page '/cart'"

TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_product/button_buy'))

"Step 3: Click on button cartQuantityControl (increase)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_cart/button_cartQuantityControl"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_cart/button_cartQuantityControl', ['button_cartQuantityControl_ButtonTitle_1': button_cartQuantityControl_ButtonTitle, 'button_cartQuantityControl_css_value_1': button_cartQuantityControl_css_value]))

"Step 4: Click on button cartQuantityControl (decrease)"

// Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_cart/button_cartQuantityControl"
TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_cart/button_cartQuantityControl', ['button_cartQuantityControl_ButtonTitle_1': button_cartQuantityControl_ButtonTitle_1, 'button_cartQuantityControl_css_value_1': button_cartQuantityControl_css_value_1]))

"Step 5: Fill in shipping details and complete the order process"

completeOrderWithShippingDetails.execute(input_address, input_city, input_email, input_firstName, input_lastName, input_phone, input_state, input_zipCode)

"Step 6: Take full page screenshot as checkpoint"

WebUI.takeFullPageScreenshotAsCheckpoint('TC6-Complete Purchase of a Product from Cart with Shipping Details_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}