package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class SwipeableBasicScreen extends BaseScreen {
    public SwipeableBasicScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.h6ah4i.android.example.advrecyclerview:id/container']")
    List<MobileElement> list;

    public SwipeableBasicScreen swipeFromLeftToRight(int index) {
        Dimension size = driver.manage().window().getSize();
        System.out.println(size.getHeight());
        System.out.println(size.getWidth());


        MobileElement element = list.get(index);
        Rectangle rect = element.getRect();//zaprosim obyekt rectangle
        int y = rect.getY() + rect.getHeight() / 2;// spustili "y" na polovinu, chtoby tochno popast na element
       // int xFrom = rect.getX()+10;
        int xFrom = rect.getX()+ rect.getWidth()/4;//vziali odnu chetvertuyu, chtobi nachat ot tuda dvigat element
        int xTo = rect.getX()+(rect.getWidth()/4)*3;


        TouchAction<?> touchAction=new TouchAction<>(driver);
        touchAction.longPress(PointOption.point(xFrom,y))
                .moveTo(PointOption.point(xTo,y))
                .release()
                .perform();

        return this;
    }

    public SwipeableBasicScreen swipeFromRightToLeft(int index) {
        Dimension size = driver.manage().window().getSize();
        System.out.println(size.getHeight());
        System.out.println(size.getWidth());


        MobileElement element = list.get(index);
        Rectangle rect = element.getRect();//zaprosim obyekt rectangle
        int y = rect.getY() + rect.getHeight() / 2;// spustili "y" na polovinu, chtoby tochno popast na element
        // int xFrom = rect.getX()+10;
        int xTo = rect.getX()+ rect.getWidth()/4;//vziali odnu chetvertuyu, chtobi nachat ot tuda dvigat element
        int xFrom = rect.getX()+(rect.getWidth()/4)*3;


        TouchAction<?> touchAction=new TouchAction<>(driver);
        touchAction.longPress(PointOption.point(xFrom,y))
                .moveTo(PointOption.point(xTo,y))
                .release()
                .perform();

        return this;
    }
}
