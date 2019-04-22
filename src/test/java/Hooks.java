import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Hooks {
    private AndroidDriver driver;
    public void setup() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.0.2");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "SF1");
        cap.setCapability(MobileCapabilityType.APP, "D:\\workspace\\android-appium\\src\\test\\resources\\zooplus_v5.3.3.apk");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        cap.setCapability("appPackage", "de.zooplus");
        cap.setCapability("appWaitActivity", "de.zooplus.lib.ui.WelcomeActivity");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "30");

        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(serverURL, cap);
    }

    @Test
    public void setDriver() throws MalformedURLException{
        Hooks hook = new Hooks();
        hook.setup();
    }
}
