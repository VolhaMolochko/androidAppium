import baseEntities.BaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AppiumBasic extends BaseTest {
    @Test
    public void AppiumTest() {
        //Actual automation
        //Xpath, id, accessibilityId, classname, androidUIAutomator
        //tagName[@atribute='value']

        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
     // driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        Assert.assertFalse(driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).isEnabled());
        driver.findElement(By.id("android:id/checkbox")).click();
        Assert.assertTrue(driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).isEnabled());
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();

        Assert.assertTrue(driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout")).isDisplayed());
        String alertTitle =driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alertTitle, "WiFi settings");

        driver.findElement(By.id("android:id/edit")).click();
        driver.findElement(By.id("android:id/edit")).sendKeys("Lemon Wi-Fi");
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
      }
}
