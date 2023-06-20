//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package starter.facebook;

import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class LoginExitoso {
    private static AndroidDriver driver = null;
    Objects obj = new Objects();

    LoginExitoso() {
    }

    @BeforeAll
    public static void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Samsung_Galaxy_S21_5G_real_us");
        capabilities.setCapability("automationName", "uiautomator2");
        capabilities.setCapability("autoAcceptAlerts", "true");
        capabilities.setCapability("autoGrantPermissions", "true");
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("username", "");
        sauceOptions.setCapability("accessKey", "");
        capabilities.setCapability("app", "storage:filename=app-gms-qa 3.17.0(570).apk");
        capabilities.setCapability("sauce:options", sauceOptions);
        URL url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
        driver = new AndroidDriver(url, capabilities);
    }

    @Test
    public void login() throws InterruptedException {
        try {
            Thread.sleep(3000);
            WebDriverWait wait = new WebDriverWait(driver, 15L);
            wait.until(ExpectedConditions.elementToBeClickable(By.id("com.rimac.rimac_surrogas.qa:id/dropdownEditText"))).sendKeys("40861606");
            wait.until(ExpectedConditions.elementToBeClickable(By.id("com.rimac.rimac_surrogas.qa:id/materialBtn"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.id("com.rimac.rimac_surrogas.qa:id/bodyEt"))).sendKeys("Rimac2021");
            wait.until(ExpectedConditions.elementToBeClickable(By.id("com.rimac.rimac_surrogas.qa:id/materialBtn"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.id("com.rimac.rimac_surrogas.qa:id/registerTextNotYet")));
            WebElement elemento = driver.findElement(By.id("com.rimac.rimac_surrogas.qa:id/registerTextNotYet"));
            boolean esVisible = elemento.isDisplayed();
            //Assert.assertTrue(esVisible);
            driver.executeScript("sauce:job-result=passed", new Object[0]);
        } catch (Exception var7) {
            driver.executeScript("sauce:job-result=failed", new Object[0]);
        } finally {
            driver.quit();
        }

    }

    public static AndroidDriver getDriver() {
        return driver;
    }
}
