package interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import userInterfaces.Elements_CalculoHipoteca;

public class BackspaceChar {

    public static void backspaceChar(WebDriver driver, By objectDelete) throws InterruptedException {

        int b = driver.findElement(objectDelete).getAttribute("value").length();
        for (int c = 0; c < b; c++){
            driver.findElement(objectDelete).sendKeys(Keys.BACK_SPACE);
        }
    }
}
