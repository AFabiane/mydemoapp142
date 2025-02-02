import io.appium.java_client.remote.options.BaseOptions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
 
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
 
public class ConsultarProdutoEricaTest {
 
  private AndroidDriver driver;
 
  private URL getUrl() {
    try {
      return new URL("https://oauth-fabisn1987-844a4:dbb8f3d4-3e95-4bac-b22a-a67382ff052b@ondemand.us-west-1.saucelabs.com:443/wd/hub");
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
    return null;
  }
 
  @BeforeEach
  public void setUp() {
    var options = new BaseOptions()
      .amend("platformName", "Android")
      .amend("appium:platformVersion", "9.0")
      .amend("appium:deviceName", "Samsung Galaxy S9 FHD GoogleAPI Emulator")
      .amend("appium:deviceOrientation", "portrait")
      .amend("appium:app", "storage:filename=mda-2.2.0-25.apk")
      .amend("appium:appPackage", "com.saucelabs.mydemoapp.android")
      .amend("appium:appActivity", "com.saucelabs.mydemoapp.android.view.activities.SplashActivity")
      .amend("appium:automationName", "UiAutomator2")
      .amend("browserName", "")
      .amend("appium:ensureWebviewsHavePages", true)
      .amend("appium:nativeWebScreenshot", true)
      .amend("appium:newCommandTimeout", 3600)
      .amend("appium:connectHardwareKeyboard", true);
 
 
    driver = new AndroidDriver(this.getUrl(), options);
  }
 
  @Test
  public void sampleTest() {
    var imgMochila = driver.findElement(AppiumBy.xpath("(//android.widget.ImageView[@content-desc=\"Product Image\"])[1]"));
    imgMochila.click();
    var lblTituloProduto = driver.findElement(AppiumBy.id("com.saucelabs.mydemoapp.android:id/productTV"));
    assertEquals("Sauce Labs Backpack", lblTituloProduto.getText());
    var lblPrecoProduto = driver.findElement(AppiumBy.id("com.saucelabs.mydemoapp.android:id/priceTV"));
    assertEquals("$ 29.99", lblPrecoProduto.getText());
  }
 
  @AfterEach
  public void tearDown() {
    driver.quit();
  }
}