package truetest.Staging.common

import com.kms.katalon.core.testdata.TestData as TestData
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import internal.GlobalVariable
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import truetest.Staging.custom.TrueTestScripts

public class selectAppleIphoneProductOptions {
    
    private static def execute(String button_quantityAdjustment_ButtonTitle, String button_quantityAdjustment_ButtonTitle_1, String button_quantityAdjustment_css_value, String button_quantityAdjustment_css_value_1, String label_storageColorOptions_LabelInternalText, String label_storageColorOptions_LabelInternalText_1, String label_storageColorOptions_css_value, String label_storageColorOptions_css_value_1, String link_appleIphoneProducts_InternalRoleLinkName, String link_appleIphoneProducts_css_value) {
        
        "Step 1: Click on link appleIphoneProducts (iphone16e)"
        
        // Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_category_phone_apple/link_appleIphoneProducts"
        TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_category_phone_apple/link_appleIphoneProducts', ['link_appleIphoneProducts_InternalRoleLinkName_1': link_appleIphoneProducts_InternalRoleLinkName, 'link_appleIphoneProducts_css_value_1': link_appleIphoneProducts_css_value]))
        
        "Step 2: Click on label storageColorOptions (colorWhite)"
        
        // Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/label_storageColorOptions"
        TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/label_storageColorOptions', ['label_storageColorOptions_LabelInternalText_1': label_storageColorOptions_LabelInternalText, 'label_storageColorOptions_css_value_1': label_storageColorOptions_css_value]))
        
        "Step 3: Click on label storageColorOptions ( 128Gb)"
        
        // Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/label_storageColorOptions"
        TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/label_storageColorOptions', ['label_storageColorOptions_LabelInternalText_1': label_storageColorOptions_LabelInternalText_1, 'label_storageColorOptions_css_value_1': label_storageColorOptions_css_value_1]))
        
        "Step 4: Click on button quantityAdjustment (increase)"
        
        // Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/button_quantityAdjustment"
        TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/button_quantityAdjustment', ['button_quantityAdjustment_ButtonTitle_1': button_quantityAdjustment_ButtonTitle, 'button_quantityAdjustment_css_value_1': button_quantityAdjustment_css_value]))
        
        "Step 5: Click on button quantityAdjustment (decrease)"
        
        // Bind values to the variables in the locators of "AI-Generated/Staging/Dynamic Objects/Page_product/button_quantityAdjustment"
        TrueTestScripts.click(findTestObject('AI-Generated/Staging/Dynamic Objects/Page_product/button_quantityAdjustment', ['button_quantityAdjustment_ButtonTitle_1': button_quantityAdjustment_ButtonTitle_1, 'button_quantityAdjustment_css_value_1': button_quantityAdjustment_css_value_1]))
    }
}

