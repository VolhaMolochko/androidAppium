import baseEntities.BaseTest;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangeOrientationTest extends BaseTest {
    @Test
    public void ChangeOrientation() {

        //adb shell dumpsys window | find "mCurrentFocus"  - находит активити которая открыта на эмуляторе

        ((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent",
                "io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies")); //https://github.com/appium/appium-uiautomator2-driver#mobile-startactivity

        Assert.assertFalse(driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).isEnabled());
        driver.findElement(By.id("android:id/checkbox")).click();
        DeviceRotation landScape = new DeviceRotation(0, 0, 90);
        driver.rotate(landScape);

        DeviceRotation portrait = new DeviceRotation(0, 0, 0);
        driver.rotate(portrait);

        Assert.assertTrue(driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).isEnabled());
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();

        Assert.assertTrue(driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout")).isDisplayed());
        String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alertTitle, "WiFi settings");

        //скопировать в буфер обмена - вставить из буфера обмена
        driver.setClipboardText("Volha WiFi");  //-скопировали в буфер обмена
        driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());   //-вставили из буфера обмена

        //нажать на кнопки устройства
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();

        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.pressKey(new KeyEvent(AndroidKey.HOME));

    }
}