package truetest.Staging.common

import com.kms.katalon.core.testdata.TestData as TestData
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import truetest.Staging.custom.TrueTestScripts

public class completeOrderWithShippingDetails {
    
    private static def execute(String input_address, String input_city, String input_email, String input_firstName, String input_lastName, String input_phone, String input_state, String input_zipCode) {
        
        "Step 1: Click on button proceedToCheckout -> Navigate to page '/checkout/info'"
        
        TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_cart/button_proceedToCheckout'))
        
        "Step 2: Double-click on input email"
        
        WebUI.doubleClick(findTestObject('AI-Generated/Staging/Page_checkout_info/input_email'))
        
        "Step 3: Click on input email"
        
        TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_checkout_info/input_email'))
        
        "Step 4: Enter input value in input email"
        
        TrueTestScripts.setText(findTestObject('AI-Generated/Staging/Page_checkout_info/input_email'), input_email)
        
        "Step 5: Click on button continueToShipping -> Navigate to page '/checkout/shipping-address'"
        
        TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_checkout_info/button_continueToShipping'))
        
        "Step 6: Double-click on input firstName"
        
        WebUI.doubleClick(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_firstName'))
        
        "Step 7: Click on input firstName"
        
        TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_firstName'))
        
        "Step 8: Enter input value in input firstName"
        
        TrueTestScripts.setText(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_firstName'), input_firstName)
        
        "Step 9: Double-click on input lastName"
        
        WebUI.doubleClick(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_lastName'))
        
        "Step 10: Click on input lastName"
        
        TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_lastName'))
        
        "Step 11: Enter input value in input lastName"
        
        TrueTestScripts.setText(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_lastName'), input_lastName)
        
        "Step 12: Double-click on input address"
        
        WebUI.doubleClick(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_address'))
        
        "Step 13: Click on input address"
        
        TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_address'))
        
        "Step 14: Enter input value in input address"
        
        TrueTestScripts.setText(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_address'), input_address)
        
        "Step 15: Double-click on input zipCode"
        
        WebUI.doubleClick(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_zipCode'))
        
        "Step 16: Click on input zipCode"
        
        TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_zipCode'))
        
        "Step 17: Enter input value in input zipCode"
        
        TrueTestScripts.setText(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_zipCode'), input_zipCode)
        
        "Step 18: Double-click on input city"
        
        WebUI.doubleClick(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_city'))
        
        "Step 19: Click on input city"
        
        TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_city'))
        
        "Step 20: Enter input value in input city"
        
        TrueTestScripts.setText(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_city'), input_city)
        
        "Step 21: Double-click on input state"
        
        WebUI.doubleClick(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_state'))
        
        "Step 22: Click on input state"
        
        TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_state'))
        
        "Step 23: Enter input value in input state"
        
        TrueTestScripts.setText(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_state'), input_state)
        
        "Step 24: Double-click on input phone"
        
        WebUI.doubleClick(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_phone'))
        
        "Step 25: Click on input phone"
        
        TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_phone'))
        
        "Step 26: Enter input value in input phone"
        
        TrueTestScripts.setText(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_phone'), input_phone)
        
        "Step 27: Click on button continueToPayment -> Navigate to page '/checkout/payment'"
        
        TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/button_continueToPayment'))
        
        "Step 28: Click on button completeOrder"
        
        TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_checkout_payment/button_completeOrder'))
    }
}

