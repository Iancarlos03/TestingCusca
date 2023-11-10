package interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClickItem {

    public static void withText(WebDriver driver, String textoDelElemento) {
        driver.findElement(By.xpath("//button[contains(text(),'" + textoDelElemento + "')]")).click();
    }
}
