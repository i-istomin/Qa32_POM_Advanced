package config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.events.EventFiringWebDriverFactory;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;

//{
//        "deviceName": "Nex",
//        "platformName": "android",
//        "platformVersion": "8.0",
//        "appPackage": "com.h6ah4i.android.example.advrecyclerview",
//        "appActivity": ".launcher.MainActivity"
//        }


public class AppiumConfiguration {
    protected static AppiumDriver<MobileElement> driver;
    //appium driver hochet znat s chem on rabotaet
    //on mojet rabotat tolko s android elementami: AndroidElement/IOSElement/MobileElement

   protected Logger logger= LoggerFactory.getLogger(AppiumConfiguration.class);


    @BeforeSuite //doljno bit soedenenie s appiumom
    public void setUp() throws MalformedURLException {

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("deviceName", "Nex");

            capabilities.setCapability("platformName", "Android");

            capabilities.setCapability("platformVersion", "8.0");
            capabilities.setCapability("appPackage", "com.h6ah4i.android.example.advrecyclerview");
            capabilities.setCapability("appActivity", ".launcher.MainActivity");
            capabilities.setCapability("automationName", "Appium");


          // driver govorit o tom chto rabotaet s mobilnimi elementami i s localnim hostom
        driver=new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

        }
@AfterSuite
public void tearDown() {
    driver.quit();
}

    }