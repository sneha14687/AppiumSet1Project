package AppiumProject1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import junit.framework.Assert;

public class TestInvalidLogin {
	public AndroidDriver driver;
  @Test
  public void InvalidLogin() throws InterruptedException {
	  	
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  	driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Dismiss\")")).click();
        Thread.sleep(5000);
        driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Sign in\")")).click();
        Thread.sleep(5000);
        driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Sign in\")")).click();
        Thread.sleep(20000);
        driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Enter an e-mail address or username\")")).sendKeys("sneha");
        driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Password\")")).sendKeys("sneha");
        driver.hideKeyboard();
        driver.findElement(MobileBy.AccessibilityId("Sign in")).click();
        Thread.sleep(3000);
        String invalid =driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Invalid password\")")).getText();
        String expected="Invalid password";
        System.out.println("Incorrect login message is : "+invalid);
        Assert.assertEquals(invalid, expected);
        
  }
  @BeforeMethod
  public void Login() throws MalformedURLException, InterruptedException {
	  	DesiredCapabilities capability= new DesiredCapabilities();
        capability.setCapability("deviceName", "Sneha");
        capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capability.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "org.khanacademy.android");
        capability.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "org.khanacademy.android.ui.library.MainActivity");
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
  }

  
}
