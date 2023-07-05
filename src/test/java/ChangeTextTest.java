import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ChangeTextTest {

    private AppiumDriver driver;
    private String textEmpty = " ";
    private String textToSet = "Netology";

    @BeforeEach
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "Pixel 4 API 33 2");
        desiredCapabilities.setCapability("appium:appPackage", "ru.netology.testing.uiautomator");
        desiredCapabilities.setCapability("appium:appActivity", "ru.netology.testing.uiautomator.MainActivity");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AppiumDriver(remoteUrl, desiredCapabilities);

    }
    @Test
    public void checkEmptyTextInputTest1() {

        MobileElement el5 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/userInput");
        el5.click();
        el5.sendKeys(textToSet);
        MobileElement el6 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/buttonChange");
        el6.click();
        el5.click();
        el5.sendKeys(textEmpty);
        MobileElement el4 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/textToBeChanged");
        el4.click();

        assertEquals(textToSet, el4.getText());

    }

    @Test
    public void checkNewActivityTest() {

        MobileElement el5 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/userInput");
        el5.click();
        el5.sendKeys(textToSet);
        MobileElement el7 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/buttonActivity");
        el7.click();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        MobileElement el8 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/text");
        el8.click();

        assertEquals(textToSet, el8.getText());

    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
