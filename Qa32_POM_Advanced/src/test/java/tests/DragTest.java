package tests;

import config.AppiumConfiguration;
import org.testng.annotations.Test;
import screens.DragScreen;

public class DragTest extends AppiumConfiguration {

    //proshel
    @Test
    public void dragDown() {
        new DragScreen(driver).selectDraggableBasic()
                .dragDown(3);

    }

//proshel
    @Test
    public void dragUp() {
        new DragScreen(driver).selectDraggableBasic()
                .dragUp(5,3);

    }
}
