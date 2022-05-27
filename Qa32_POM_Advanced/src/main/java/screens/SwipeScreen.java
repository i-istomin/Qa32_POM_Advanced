package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class SwipeScreen extends BaseScreen{
    public SwipeScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@resource-id='com.h6ah4i.android.example.advrecyclerview:id/button'][2]")
    MobileElement selectSwipeBasic;


    public SwipeableBasicScreen selectSwipeBasic(){
        selectSwipeBasic.click();
        return new SwipeableBasicScreen(driver);
    }

    }

