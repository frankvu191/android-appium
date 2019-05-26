import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Hooks {

    private AndroidDriver setup() throws MalformedURLException {
        AndroidDriver driver;

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "GooglePixel");
        cap.setCapability(MobileCapabilityType.APP, "D:\\workspace\\android-appium\\src\\test\\resources\\zooplus.apk");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        cap.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, "de.zooplus.lib.ui.HomeActivity*");
        cap.setCapability("noReset", "true");
        cap.setCapability("autoGrantPermissions", "true");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "30");

        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(serverURL, cap);

        return driver;
    }

    @Test
    public void setDriver() throws MalformedURLException {
        AndroidDriver driver = this.setup();

        try {
            driver.findElementById("Login");
        } catch (NoSuchElementException e) {
            System.out.println("Finish waiting");
        }

        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+"Recently viewed"+"\").instance(0))");

        try {
            driver.findElementById("Login");
        } catch (NoSuchElementException e) {
            System.out.println("Finish waiting");
        }

        driver.findElementById("tv_tool_bar_app_name").click();

        try {
            driver.findElementById("Login");
        } catch (NoSuchElementException e) {
            System.out.println("Finish waiting");
        }

        //TouchActions action = new TouchActions(driver);
        //action.scroll(driver.findElementsByAccessibilityId("Top Sellers for Cats"),10, 100);
        //action.perform();

        try {
            driver.findElementById("Login");
        } catch (NoSuchElementException e) {
            System.out.println("Finish waiting");
        }

        driver.findElementById("android:id/search_src_text").sendKeys("dog");

        try {
            driver.findElementById("Login");
        } catch (NoSuchElementException e) {
            System.out.println("Finish waiting");
        }
    }
}
