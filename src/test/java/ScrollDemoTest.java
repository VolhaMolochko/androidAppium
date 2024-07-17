import baseEntities.BaseTest;
import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class ScrollDemoTest extends BaseTest {
    @Test
    public void scroll()  {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        //where to scroll is known prior
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
    }
}