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

"Step 2: Click on link about -> Navigate to page '/about'"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_home/link_about'))

// @TT_ASSERTION
// Verify AS01 About Heading is present
WebUI.verifyElementPresent(findTestObject('AI-Generated/Base Component Regression/Page_home/AS01 About Heading'), 20)
// END TT_ASSERTION

"Step 3: Click on link forms -> Navigate to page '/forms'"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_about/link_forms'))

"Step 4: Click on link tables -> Navigate to page '/tables'"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_forms/link_tables'))

"Step 5: Click on link dynamicElements -> Navigate to page '/dynamic-elements'"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_tables/link_dynamicElements'))

"Step 6: Click on link about -> Navigate to page '/about'"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_dynamic_elements/link_about'))

"Step 7: Click on link forms -> Navigate to page '/forms'"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_about/link_forms'))

"Step 8: Click on link tables -> Navigate to page '/tables'"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_forms/link_tables'))

"Step 9: Click on link dynamicElements -> Navigate to page '/dynamic-elements'"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_tables/link_dynamicElements'))

"Step 10: Click on link about -> Navigate to page '/about'"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_dynamic_elements/link_about'))

"Step 11: Click on link forms -> Navigate to page '/forms'"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_about/link_forms'))

"Step 12: Click on link tables -> Navigate to page '/tables'"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_forms/link_tables'))

"Step 13: Click on link dynamicElements -> Navigate to page '/dynamic-elements'"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_tables/link_dynamicElements'))

"Step 14: Click on link about -> Navigate to page '/about'"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_dynamic_elements/link_about'))

"Step 15: Click on link forms -> Navigate to page '/forms'"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_about/link_forms'))

"Step 16: Click on link tables -> Navigate to page '/tables'"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_forms/link_tables'))

"Step 17: Click on link dynamicElements -> Navigate to page '/dynamic-elements'"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_tables/link_dynamicElements'))

"Step 18: Click on link about -> Navigate to page '/about'"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_dynamic_elements/link_about'))

"Step 19: Click on link forms -> Navigate to page '/forms'"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_about/link_forms'))

"Step 20: Click on link tables -> Navigate to page '/tables'"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_forms/link_tables'))

"Step 21: Click on link dynamicElements -> Navigate to page '/dynamic-elements'"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_tables/link_dynamicElements'))

"Step 22: Click on link about -> Navigate to page '/about'"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_dynamic_elements/link_about'))

"Step 23: Click on link forms -> Navigate to page '/forms'"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_about/link_forms'))

"Step 24: Click on link tables -> Navigate to page '/tables'"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_forms/link_tables'))

"Step 25: Click on link dynamicElements -> Navigate to page '/dynamic-elements'"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_tables/link_dynamicElements'))

"Step 26: Click on link about -> Navigate to page '/about'"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_dynamic_elements/link_about'))

"Step 27: Click on link forms -> Navigate to page '/forms'"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_about/link_forms'))

"Step 28: Click on link tables -> Navigate to page '/tables'"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_forms/link_tables'))

"Step 29: Click on link dynamicElements -> Navigate to page '/dynamic-elements'"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_tables/link_dynamicElements'))

"Step 30: Click on link about -> Navigate to page '/about'"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_dynamic_elements/link_about'))

"Step 31: Click on link forms -> Navigate to page '/forms'"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_about/link_forms'))

"Step 32: Click on link tables -> Navigate to page '/tables'"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_forms/link_tables'))

"Step 33: Click on link dynamicElements -> Navigate to page '/dynamic-elements'"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_tables/link_dynamicElements'))

"Step 34: Click on link about -> Navigate to page '/about'"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_dynamic_elements/link_about'))

"Step 35: Click on link forms -> Navigate to page '/forms'"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_about/link_forms'))

"Step 36: Click on link tables -> Navigate to page '/tables'"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_forms/link_tables'))

"Step 37: Click on link dynamicElements -> Navigate to page ''"

TrueTestScripts.click(findTestObject('AI-Generated/Base Component Regression/Page_tables/link_dynamicElements'))

"Step 38: Take full page screenshot as checkpoint"

WebUI.takeFullPageScreenshotAsCheckpoint('TC5-Navigate through the application sections_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}