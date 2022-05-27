package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DraggableBasicScreen extends BaseScreen {
    public DraggableBasicScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.h6ah4i.android.example.advrecyclerview:id/drag_handle']")
    List<MobileElement> list;//t.k. vo vseh elementah odinakovie "id" i poetomu mi vospolzuemsia listom i indexami


    public DraggableBasicScreen dragDown() {
        MobileElement element = list.get(0);//zabrali perviy element
        Rectangle rect = element.getRect();
        int xFrom = rect.getX() + rect.getWidth() / 2;
        int yFrom = rect.getY() + rect.getHeight() / 2;

        int xTo = xFrom;
        int yTo = yFrom + rect.getHeight();


        TouchAction<?> touchAction = new TouchAction<>(driver);//?-> budet rabotat s tem , s chem rabotaet nash driver
        touchAction.longPress(PointOption.point(xFrom, yFrom))//zajimaem elemeny v kakoy to tochke
                .moveTo(PointOption.point(xTo, yTo))
                .release() //sobiraet izmalenkih deystviy zeliy object touchaction a poto vizivaet metod perform
                .perform();//ispolnit

        return this;
    }



    public DraggableBasicScreen dragDown(int index) {
        MobileElement element = list.get(0);
        Rectangle rect = element.getRect();
        int xFrom = rect.getX() + rect.getWidth() / 2;
        int yFrom = rect.getY() + rect.getHeight() / 2;

        int xTo = xFrom;
        int yTo = yFrom + rect.getHeight() * index;


        TouchAction<?> touchAction = new TouchAction<>(driver);
        touchAction.longPress(PointOption.point(xFrom, yFrom))
                .moveTo(PointOption.point(xTo, yTo))
                .release()
                .perform();


        return this;
    }


    public DraggableBasicScreen dragUp(int index, int count) {
        MobileElement element = list.get(index);

        Rectangle rect = element.getRect();
        int xFrom = rect.getX() + rect.getWidth() / 2;
        int yFrom = rect.getY() + rect.getHeight() / 2;

        int xTo = xFrom;//tianem, no nikuda ne smeshaetsia
        int yTo = yFrom - rect.getHeight()*count;//

        TouchAction<?> touchAction = new TouchAction<>(driver);//?-> budet rabotat s tem , s chem rabotaet nash driver
        touchAction.longPress(PointOption.point(xFrom, yFrom))//zajimaem elemeny v kakoy to tochke
                .moveTo(PointOption.point(xTo, yTo))
                .release() //sobiraet izmalenkih deystviy zeliy object touchaction a poto vizivaet metod perform
                .perform();


        return this;
    }


}
