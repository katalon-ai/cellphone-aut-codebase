package truetest.Staging.custom

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword
import groovy.json.JsonSlurper
import internal.GlobalVariable
import java.time.Duration
import java.util.regex.Pattern
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.WebDriverWait

public class TrueTestScripts {
    public static void login(Map parameters = [:]) {
        try {
            // Trigger a Login test case
    // import com.kms.katalon.core.model.FailureHandling
    // import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
    // import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
    // WebUI.callTestCase(findTestCase('<path to testcase>/Login'), [:], FailureHandling.CONTINUE_ON_FAILURE)
    // Trigger a custom Login method
    // import your.package
    // import authentication.Login
    // call your custom login method
    // Login.login()
    // Trigger a custom Login keyword
    // CustomKeywords.login()
        } catch(Exception e) {
            if (e.getCause() instanceof WebElementNotFoundException) {
                KeywordUtil.logInfo(e.getMessage())
                KeywordUtil.markWarning(e.getMessage())
            } else {
                throw e
            }
        }
    }

    private static final int DEFAULT_TIMEOUT = 30

    private static int timeout(String variableName, int fallback = DEFAULT_TIMEOUT) {
        try {
            def value = GlobalVariable.metaClass.getProperty(GlobalVariable, variableName)
            if (value instanceof Number) {
                return ((Number) value).intValue()
            }
            if (value != null && value.toString().trim()) {
                return Integer.parseInt(value.toString().trim())
            }
        } catch (Exception ignored) {
        }
        return fallback
    }

    private static List parseOptions(String rawValue) {
        if (rawValue == null) {
            return []
        }

        String trimmedValue = rawValue.trim()
        if (!trimmedValue.startsWith("[")) {
            return [trimmedValue]
        }

        def parsedValue = new JsonSlurper().parseText(trimmedValue)
        return parsedValue instanceof List ? parsedValue : [parsedValue]
    }

    private static boolean waitForWindowCountAtLeast(int requiredCount, int timeoutSeconds) {
        def driver = DriverFactory.getWebDriver()
        long deadline = System.currentTimeMillis() + (timeoutSeconds * 1000L)
        while (System.currentTimeMillis() < deadline) {
            if (driver.getWindowHandles().size() >= requiredCount) {
                return true
            }
            WebUI.delay(1)
        }
        return driver.getWindowHandles().size() >= requiredCount
    }

    private static boolean waitForWindowTitleReady(String title, int timeoutSeconds) {
        def driver = DriverFactory.getWebDriver()
        String originalHandle = driver.getWindowHandle()
        long deadline = System.currentTimeMillis() + (timeoutSeconds * 1000L)
        while (System.currentTimeMillis() < deadline) {
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle)
                if (title == driver.getTitle()) {
                    driver.switchTo().window(originalHandle)
                    return true
                }
            }
            driver.switchTo().window(originalHandle)
            WebUI.delay(1)
        }
        driver.switchTo().window(originalHandle)
        return false
    }

    private static final String UNRESERVED_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-._~"
    private static final String SUB_DELIMITER_CHARACTERS = "!" + String.valueOf((char) 36) + "&'()*+,;="
    private static final String PATH_SAFE_CHARACTERS = UNRESERVED_CHARACTERS + SUB_DELIMITER_CHARACTERS + "/:@"
    private static final String QUERY_SAFE_CHARACTERS = UNRESERVED_CHARACTERS + SUB_DELIMITER_CHARACTERS + ":@"
    private static final String FRAGMENT_SAFE_CHARACTERS = UNRESERVED_CHARACTERS + SUB_DELIMITER_CHARACTERS + "/?:@"

    private static boolean isHexDigit(char character) {
        return (character >= '0' && character <= '9') ||
            (character >= 'A' && character <= 'F') ||
            (character >= 'a' && character <= 'f')
    }

    private static boolean isPercentEncoded(String value, int index) {
        return index + 2 < value.length() &&
            value.charAt(index) == '%' &&
            isHexDigit(value.charAt(index + 1)) &&
            isHexDigit(value.charAt(index + 2))
    }

    private static String safeEncodePreservingPercentEscapes(String value, String safeCharacters) {
        if (!value) {
            return ""
        }
        StringBuilder encodedValue = new StringBuilder()
        int index = 0
        while (index < value.length()) {
            if (isPercentEncoded(value, index)) {
                encodedValue.append(value, index, index + 3)
                index += 3
                continue
            }
            int codePoint = value.codePointAt(index)
            String character = new String(Character.toChars(codePoint))
            if (safeCharacters.contains(character)) {
                encodedValue.append(character)
            } else {
                character.getBytes("UTF-8").each { byte singleByte ->
                    encodedValue.append(String.format("%%%02X", singleByte & 0xFF))
                }
            }
            index += Character.charCount(codePoint)
        }
        return encodedValue.toString()
    }

    private static String safeEncodeQueryComponent(String value) {
        return safeEncodePreservingPercentEscapes(value, QUERY_SAFE_CHARACTERS)
    }

    private static String safeEncodePath(String path) {
        return safeEncodePreservingPercentEscapes(path, PATH_SAFE_CHARACTERS)
    }

    private static String safeEncodeFragment(String fragment) {
        return safeEncodePreservingPercentEscapes(fragment, FRAGMENT_SAFE_CHARACTERS)
    }

    private static String sanitizeQueryString(String rawQuery) {
        if (!rawQuery) {
            return ""
        }
        return rawQuery
            .split("&")
            .findAll { it }
            .collect { entry ->
                String[] keyValue = entry.split("=", 2)
                String encodedKey = safeEncodeQueryComponent(keyValue[0])
                if (keyValue.length == 1) {
                    return encodedKey
                }
                return encodedKey + "=" + safeEncodeQueryComponent(keyValue[1])
            }
            .join("&")
    }

    private static String mergeQueries(List<String> queryParts) {
        return queryParts.findAll { it }.join("&")
    }

    private static String combineUrlQueryParams(Map<String, String> queryParams) {
        try {
            String globalQueryParameters = sanitizeQueryString(GlobalVariable.query_params?.toString())
            if (queryParams == null || queryParams.isEmpty()) {
                return globalQueryParameters
            }
            List<String> queryParts = []
            if (globalQueryParameters) {
                queryParts.add(globalQueryParameters)
            }
            for (Map.Entry<String, String> param: queryParams.entrySet()) {
                if (param?.getKey() == null) {
                    continue
                }
                String encodedKey = safeEncodeQueryComponent(param.getKey().toString())
                String encodedValue = safeEncodeQueryComponent(param.getValue()?.toString())
                queryParts.add(encodedKey + "=" + encodedValue)
            }
            return mergeQueries(queryParts)
        } catch (Exception ignored) {
            return mergeQueries((queryParams ?: [:]).collect { key, value ->
                key == null ? null : safeEncodeQueryComponent(key.toString()) + "=" + safeEncodeQueryComponent(value?.toString())
            })
        }
    }

    private static Map normalizePath(String rawPath) {
        String path = rawPath ?: ""
        String fragment = ""
        int fragmentIndex = path.indexOf("#")
        if (fragmentIndex >= 0) {
            fragment = path.substring(fragmentIndex + 1)
            path = path.substring(0, fragmentIndex)
        }
        String pathQuery = ""
        int queryIndex = path.indexOf("?")
        if (queryIndex >= 0) {
            pathQuery = path.substring(queryIndex + 1)
            path = path.substring(0, queryIndex)
        }
        if (path && !path.startsWith("/")) {
            path = "/" + path
        }
        return [
            path: safeEncodePath(path),
            query: sanitizeQueryString(pathQuery),
            fragment: safeEncodeFragment(fragment),
        ]
    }

    private static String mergePaths(String basePath, String relativePath) {
        if (!relativePath) {
            return basePath ?: ""
        }
        if (!basePath || basePath == "/") {
            return relativePath
        }
        if (basePath.endsWith("/") && relativePath.startsWith("/")) {
            return basePath[0..-2] + relativePath
        }
        if (!basePath.endsWith("/") && !relativePath.startsWith("/")) {
            return basePath + "/" + relativePath
        }
        return basePath + relativePath
    }

    private static String buildSafeUrl(java.net.URI baseUri, String path, String queryParameters, String fragment) {
        StringBuilder safeUrl = new StringBuilder()
        safeUrl.append(baseUri.getScheme()).append("://").append(baseUri.getRawAuthority())
        if (path) {
            safeUrl.append(path)
        }
        if (queryParameters) {
            safeUrl.append("?").append(queryParameters)
        }
        if (fragment) {
            safeUrl.append("#").append(fragment)
        }
        return safeUrl.toString()
    }

    private static String buildTargetUrl(String path, String queryParameters) {
        String applicationDomain = GlobalVariable.application_domain;
        java.net.URI baseUri = new java.net.URI(applicationDomain)
        Map normalizedPath = normalizePath(path)
        String basePath = safeEncodePath(baseUri.getRawPath())
        String mergedPath = mergePaths(basePath, normalizedPath.path as String)
        String mergedQuery = mergeQueries([
            sanitizeQueryString(baseUri.getRawQuery()),
            normalizedPath.query as String,
            queryParameters,
        ])
        String fragment = normalizedPath.fragment ?: safeEncodeFragment(baseUri.getRawFragment())
        return buildSafeUrl(baseUri, mergedPath, mergedQuery, fragment)
    }

    private static void do_navigate(String path, String queryParameters) {
        String safeUrl = buildTargetUrl(path, queryParameters)
        WebUI.navigateToUrl(safeUrl)
        WebUI.waitForPageLoad(timeout("waitForPageLoadTimeOut"))
    }

    public static void navigate(String path, Map<String, String> searchParams) {
        String queryParameters = this.combineUrlQueryParams(searchParams);
        this.do_navigate(path, queryParameters);
    }

    public static void navigate(String path) {
        this.do_navigate(path, "");
    }

    public static void navigateIfNeeded(String urlPath, Map queryParams = [:]) {
        String queryParameters = this.combineUrlQueryParams(queryParams)
        String targetUrl = buildTargetUrl(urlPath, queryParameters)
        String currentUrl = WebUI.getUrl()
        if (!currentUrl.equals(targetUrl)) {
            navigate(urlPath, queryParams)
        }
    }

    public static void refresh() {
        WebUI.refresh()
        WebUI.waitForPageLoad(timeout("waitForPageLoadTimeOut"))
    }

    public static void click(TestObject to) {
        WebUI.waitForElementClickable(to, timeout("waitForElementClickableTimeOut"))
        WebUI.enhancedClick(to)
    }

    public static void check(TestObject to) {
        WebUI.waitForElementClickable(to, timeout("waitForElementClickableTimeOut"))
        WebUI.check(to)
    }

    public static void uncheck(TestObject to) {
        WebUI.waitForElementClickable(to, timeout("waitForElementClickableTimeOut"))
        WebUI.uncheck(to)
    }

    public static void setText(TestObject to, String text) {
        WebUI.waitForElementVisible(to, timeout("waitForElementVisibleTimeOut"))
        WebUI.setText(to, text)
    }

    public static void setEncryptedText(TestObject to, String text) {
        WebUI.waitForElementVisible(to, timeout("waitForElementVisibleTimeOut"))
        WebUI.setEncryptedText(to, text)
    }

    public static void sendKeys(TestObject to, Object keys) {
        WebUI.waitForElementVisible(to, timeout("waitForElementVisibleTimeOut"))
        WebUI.sendKeys(to, keys)
    }

    public static void uploadFile(TestObject to, String path) {
        WebUI.waitForElementPresent(to, timeout("waitForElementPresentTimeOut"))
        WebUI.uploadFile(to, path)
    }

    public static void selectOption(TestObject to, String rawValue, String selectionMode, boolean shouldFireEvent = false) {
        selectionMode = selectionMode?.toLowerCase() ?: "value"
        int selectionTimeout = timeout("waitForSelectOptionTimeOut")
        WebUI.waitForElementClickable(to, selectionTimeout)

        def options = parseOptions(rawValue)

        if (options && options[0] instanceof Map) {
            options = options.collect {
                switch (selectionMode) {
                    case "value":
                        return it.value
                    case "label":
                        return it.label
                    case "index":
                        return it.index
                    default:
                        throw new IllegalArgumentException("Unsupported selection mode: " + selectionMode)
                }
            }
        }

        for (option in options) {
            switch (selectionMode) {
                case "value":
                    WebUI.selectOptionByValue(to, Pattern.quote(option.toString()), true, FailureHandling.OPTIONAL)
                    WebUI.verifyOptionSelectedByValue(to, Pattern.quote(option.toString()), true, selectionTimeout)
                    break
                case "label":
                    WebUI.selectOptionByLabel(to, Pattern.quote(option.toString()), true, FailureHandling.OPTIONAL)
                    WebUI.verifyOptionSelectedByLabel(to, Pattern.quote(option.toString()), true, selectionTimeout)
                    break
                case "index":
                    def index
                    try {
                        index = option instanceof Number ? option.intValue() : Integer.parseInt(option.toString())
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Invalid index value: " + option.toString() + ". Index must be a number.", e)
                    }
                    WebUI.selectOptionByIndex(to, index, FailureHandling.OPTIONAL)
                    WebUI.verifyOptionSelectedByIndex(to, index, selectionTimeout)
                    break
                default:
                    throw new IllegalArgumentException("Unsupported selection mode: " + selectionMode)
            }
        }

        if (shouldFireEvent) {
            def webElement = WebUI.findWebElement(to)
            WebUI.executeJavaScript("let event = new Event('input', { bubbles: true }); arguments[0].dispatchEvent(event);", [webElement])
        }
    }

    public static void selectOptionByValue(TestObject to, String rawValue) {
        WebUI.waitForElementClickable(to, timeout("waitForSelectOptionTimeOut"))

        def options = parseOptions(rawValue)
        for (option in options) {
            WebUI.selectOptionByValue(to, Pattern.quote(option.toString()), true)
        }
    }

    public static void setSliderValue(TestObject to, double value) {
        int sliderTimeout = timeout("waitForSliderReadyTimeOut")
        WebUI.waitForElementClickable(to, sliderTimeout)
        WebUI.enhancedClick(to)
        def sliderElement = WebUiCommonHelper.findWebElement(to, sliderTimeout)
        double sliderWidth = Double.parseDouble(WebUI.executeJavaScript("return arguments[0].getBoundingClientRect().width", Arrays.asList(sliderElement)).toString())
        def sliderHandleElement = WebUI.executeJavaScript("return arguments[0].querySelector('[role=slider]')", Arrays.asList(sliderElement))
        double min = Double.parseDouble(WebUI.executeJavaScript("return arguments[0].getAttribute('aria-valuemin')", Arrays.asList(sliderHandleElement)).toString())
        double max = Double.parseDouble(WebUI.executeJavaScript("return arguments[0].getAttribute('aria-valuemax')", Arrays.asList(sliderHandleElement)).toString())
        double currentValue = Double.parseDouble(WebUI.executeJavaScript("return arguments[0].getAttribute('aria-valuenow')", Arrays.asList(sliderHandleElement)).toString())
        int offsetX = Math.floor(((value - currentValue) / (max - min)) * sliderWidth)
        WebUI.dragAndDropByOffset(to, offsetX, 0)
    }

    public static void setTinyMCEContent(TestObject to, String content) {
        int editorTimeout = timeout("waitForEditorReadyTimeOut")
        WebUI.waitForElementClickable(to, editorTimeout)
        WebUI.executeJavaScript(
            """
                const mceInstance = window.tinyMCE?.activeEditor;
                if (!mceInstance) {
                    return "No TinyMCE instance found";
                }
                return mceInstance.setContent(arguments[0]);
            """,
            [content]
        )
    }

    public static void dragAndDropToTargetByDirection(TestObject sourceTo, TestObject targetTo, String direction = "CENTER", int padding = 10) {
        boolean isSwitchIntoFrame = false
        try {
            int dragTimeout = timeout("waitForDragAndDropReadyTimeOut")
            WebUI.waitForElementClickable(sourceTo, dragTimeout)
            WebUI.waitForElementClickable(targetTo, dragTimeout)
            isSwitchIntoFrame = WebUiCommonHelper.switchToParentFrame(sourceTo)
            WebElement sourceEl = WebUIAbstractKeyword.findWebElement(sourceTo)
            WebElement targetEl = WebUIAbstractKeyword.findWebElement(targetTo)
            Actions builder = new Actions(DriverFactory.getWebDriver())

            int width = targetEl.getSize().getWidth()
            int height = targetEl.getSize().getHeight()
            int midX = (int) Math.floor(width / 2)
            int midY = (int) Math.floor(height / 2)

            int x = 0
            int y = 0

            switch (direction) {
                case "TOP": x = 0; y = -(midY - padding); break
                case "BOTTOM": x = 0; y = (midY - padding); break
                case "LEFT": x = -(midX - padding); y = 0; break
                case "RIGHT": x = (midX - padding); y = 0; break
                case "TOP_LEFT": x = -(midX - padding); y = -(midY - padding); break
                case "TOP_RIGHT": x = (midX - padding); y = -(midY - padding); break
                case "BOTTOM_LEFT": x = -(midX - padding); y = (midY - padding); break
                case "BOTTOM_RIGHT": x = (midX - padding); y = (midY - padding); break
                case "CENTER": x = 0; y = 0; break
            }

            builder.clickAndHold(sourceEl).moveToElement(targetEl, x, y).release().perform()
        } finally {
            if (isSwitchIntoFrame) {
                WebUiCommonHelper.switchToDefaultContent()
            }
        }
    }

    public static void pressControlAndClick(TestObject to) {
        String osName = System.getProperty("os.name", "").toLowerCase()
        Keys keyToSend = osName.contains("mac") ? Keys.COMMAND : Keys.CONTROL
        WebUI.waitForElementClickable(to, 20)
        WebElement element = WebUI.findWebElement(to)
        Actions actions = new Actions(DriverFactory.getWebDriver())
        actions.keyDown(keyToSend)
            .click(element)
            .keyUp(keyToSend)
            .build()
            .perform()
        WebUI.delay(3)
    }

    public static void pressControlAndDoubleClick(TestObject to) {
        String osName = System.getProperty("os.name", "").toLowerCase()
        Keys keyToSend = osName.contains("mac") ? Keys.COMMAND : Keys.CONTROL
        WebUI.waitForElementClickable(to, 20)
        WebElement element = WebUI.findWebElement(to)
        Actions actions = new Actions(DriverFactory.getWebDriver())
        actions.keyDown(keyToSend)
            .doubleClick(element)
            .keyUp(keyToSend)
            .build()
            .perform()
        WebUI.delay(3)
    }

    public static switchToNextWindow() {
        def driver = DriverFactory.getWebDriver()
        def currentHandle = driver.getWindowHandle()
        int waitTimeout = timeout("waitForWindowSwitchTimeOut")
        Object[] windowHandles = driver.getWindowHandles().toArray()
        if (windowHandles.length < 2) {
            waitForWindowCountAtLeast(2, waitTimeout)
            windowHandles = driver.getWindowHandles().toArray()
        }
        int indexOfCurrent = -1
        for (int i = 0; i < windowHandles.length; i++) {
            String handle = (String) windowHandles[i]
            if (currentHandle.equals(handle)) {
                indexOfCurrent = i
                break
            }
        }
        if (indexOfCurrent >= 0 && indexOfCurrent < windowHandles.length - 1) {
            driver.switchTo().window((String) windowHandles[indexOfCurrent + 1])
            WebUI.waitForPageLoad(waitTimeout)
        } else {
            WebUI.comment("Cannot find next window.")
        }
    }

    public static Set<String> beforeHandles;

    public static getCurrentWindowHandles() {
            this.beforeHandles = DriverFactory.getWebDriver().getWindowHandles()
    }

    public static String switchToNewWindow(int timeout = 10) {

        WebDriver driver = DriverFactory.getWebDriver()

        new WebDriverWait(driver, Duration.ofSeconds(timeout))
                .until {
                    driver.getWindowHandles().size() > this.beforeHandles.size()
                }

        Set<String> newHandles = new HashSet<>(driver.getWindowHandles())
        newHandles.removeAll(this.beforeHandles)

        if (newHandles.isEmpty()) {
            throw new RuntimeException("Cannot find new window.")
        }

        String newHandle = newHandles.iterator().next()

        if (!driver.getWindowHandle().equals(newHandle)) {
            driver.switchTo().window(newHandle)
        }

        return newHandle
    }

    public static void acceptAlert() {
        WebUI.waitForAlert(timeout("waitForAlertTimeOut"))
        WebUI.acceptAlert()
    }

    public static void dismissAlert() {
        WebUI.waitForAlert(timeout("waitForAlertTimeOut"))
        WebUI.dismissAlert()
    }

    public static void setAlertText(String text) {
        WebUI.waitForAlert(timeout("waitForAlertTimeOut"))
        WebUI.setAlertText(text)
    }

    public static void switchToWindowIndex(int index) {
        int waitTimeout = timeout("waitForWindowSwitchTimeOut")
        waitForWindowCountAtLeast(index + 1, waitTimeout)
        WebUI.switchToWindowIndex(index)
        WebUI.waitForPageLoad(waitTimeout)
    }

    public static void switchToWindowTitle(String title) {
        int waitTimeout = timeout("waitForWindowSwitchTimeOut")
        waitForWindowTitleReady(title, waitTimeout)
        WebUI.switchToWindowTitle(title)
        WebUI.waitForPageLoad(waitTimeout)
    }
}
