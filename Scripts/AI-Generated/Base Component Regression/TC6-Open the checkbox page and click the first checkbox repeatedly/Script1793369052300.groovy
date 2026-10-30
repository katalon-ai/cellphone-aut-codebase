import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import truetest.Base_Component_Regression.custom.TrueTestScripts


'Initialize test session: Open browser and set view port'

@com.kms.katalon.core.annotation.SetUp
def setup() {
	WebUI.openBrowser('')
	WebUI.setViewPortSize(1280, 720)
	//WebUI.maximizeWindow()
}

"Step 1: Navigate to https://base-component.aut.katalon.com with params (clientCode, env)"

TrueTestScripts.navigate("/", ["clientCode": var_clientCode, "env": var_env])

"Step 2: Click on link checkboxes -> Navigate to page '/checkboxes'"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_home/link_checkboxes'))

"Step 3: Click on input checkboxOne"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_checkboxes/input_checkboxOne'))

"Step 4: Click on input checkboxOne"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_checkboxes/input_checkboxOne'))

"Step 5: Click on input checkboxOne"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_checkboxes/input_checkboxOne'))

"Step 6: Click on input checkboxOne"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_checkboxes/input_checkboxOne'))

"Step 7: Click on input checkboxOne"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_checkboxes/input_checkboxOne'))

"Step 8: Click on input checkboxOne"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_checkboxes/input_checkboxOne'))

"Step 9: Click on input checkboxOne"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_checkboxes/input_checkboxOne'))

"Step 10: Click on input checkboxOne"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_checkboxes/input_checkboxOne'))

"Step 11: Click on input checkboxOne"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_checkboxes/input_checkboxOne'))

"Step 12: Click on input checkboxOne"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_checkboxes/input_checkboxOne'))

"Step 13: Click on input checkboxOne"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_checkboxes/input_checkboxOne'))

"Step 14: Click on input checkboxOne"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_checkboxes/input_checkboxOne'))

"Step 15: Click on input checkboxOne"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_checkboxes/input_checkboxOne'))

"Step 16: Click on input checkboxOne"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_checkboxes/input_checkboxOne'))

"Step 17: Click on input checkboxOne"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_checkboxes/input_checkboxOne'))

"Step 18: Click on input checkboxOne"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_checkboxes/input_checkboxOne'))

"Step 19: Click on input checkboxOne"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_checkboxes/input_checkboxOne'))

"Step 20: Click on input checkboxOne"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_checkboxes/input_checkboxOne'))

"Step 21: Click on input checkboxOne"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_checkboxes/input_checkboxOne'))

"Step 22: Click on input checkboxOne"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_checkboxes/input_checkboxOne'))

"Step 23: Click on input checkboxOne"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_checkboxes/input_checkboxOne'))

"Step 24: Click on input checkboxOne"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_checkboxes/input_checkboxOne'))

"Step 25: Click on input checkboxOne"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_checkboxes/input_checkboxOne'))

"Step 26: Click on input checkboxOne"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_checkboxes/input_checkboxOne'))

"Step 27: Click on input checkboxOne"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_checkboxes/input_checkboxOne'))

"Step 28: Click on input checkboxOne"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_checkboxes/input_checkboxOne'))

"Step 29: Click on input checkboxOne"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_checkboxes/input_checkboxOne'))

"Step 30: Click on input checkboxOne"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_checkboxes/input_checkboxOne'))

"Step 31: Click on input checkboxOne"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_checkboxes/input_checkboxOne'))

"Step 32: Click on input checkboxOne"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_checkboxes/input_checkboxOne'))

"Step 33: Click on input checkboxOne"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_checkboxes/input_checkboxOne'))

"Step 34: Click on input checkboxOne"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_checkboxes/input_checkboxOne'))

"Step 35: Click on input checkboxOne"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_checkboxes/input_checkboxOne'))

"Step 36: Click on input checkboxOne"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_checkboxes/input_checkboxOne'))

"Step 37: Click on input checkboxOne"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_checkboxes/input_checkboxOne'))

"Step 38: Click on input checkboxOne -> Navigate to page ''"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_checkboxes/input_checkboxOne'))

"Step 39: Take full page screenshot as checkpoint"

WebUI.takeFullPageScreenshotAsCheckpoint('TC6-Open the checkbox page and click the first checkbox repeatedly_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}