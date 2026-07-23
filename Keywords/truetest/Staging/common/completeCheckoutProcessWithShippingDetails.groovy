package truetest.Staging.common

import com.kms.katalon.core.testdata.TestData as TestData
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import truetest.Staging.custom.TrueTestScripts

public class completeCheckoutProcessWithShippingDetails {
    
    private static def execute(String input_address, String input_city, String input_email, String input_firstName, String input_lastName, String input_phone, String input_state, String input_zipCode) {
        
        "Step 1: Click on button proceedToCheckout -> Navigate to page '/checkout/info'"
        
        TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_cart/button_proceedToCheckout'))
        
        "Step 2: Click on input email"
        
        TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_checkout_info/input_email'))
        
        "Step 3: Enter input value in input email"
        
        TrueTestScripts.setText(findTestObject('AI-Generated/Staging/Page_checkout_info/input_email'), input_email)
        
        "Step 4: Click on button continueToShipping -> Navigate to page '/checkout/shipping-address'"
        
        TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_checkout_info/button_continueToShipping'))
        
        "Step 5: Click on input firstName"
        
        TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_firstName'))
        
        "Step 6: Enter input value in input firstName"
        
        TrueTestScripts.setText(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_firstName'), input_firstName)
        
        "Step 7: Click on input lastName"
        
        TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_lastName'))
        
        "Step 8: Enter input value in input lastName"
        
        TrueTestScripts.setText(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_lastName'), input_lastName)
        
        "Step 9: Click on input address"
        
        TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_address'))
        
        "Step 10: Enter input value in input address"
        
        TrueTestScripts.setText(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_address'), input_address)
        
        "Step 11: Click on input zipCode"
        
        TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_zipCode'))
        
        "Step 12: Enter input value in input zipCode"
        
        TrueTestScripts.setText(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_zipCode'), input_zipCode)
        
        "Step 13: Click on input city"
        
        TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_city'))
        
        "Step 14: Enter input value in input city"
        
        TrueTestScripts.setText(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_city'), input_city)
        
        "Step 15: Click on input state"
        
        TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_state'))
        
        "Step 16: Enter input value in input state"
        
        TrueTestScripts.setText(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_state'), input_state)
        
        "Step 17: Click on input phone"
        
        TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_phone'))
        
        "Step 18: Enter input value in input phone"
        
        TrueTestScripts.setText(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/input_phone'), input_phone)
        
        "Step 19: Click on button continueToPayment -> Navigate to page '/checkout/payment'"
        
        TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_checkout_shipping_address/button_continueToPayment'))
        
        "Step 20: Click on button completeOrder"
        
        TrueTestScripts.click(findTestObject('AI-Generated/Staging/Page_checkout_payment/button_completeOrder'))
    }
}

