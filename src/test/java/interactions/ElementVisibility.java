package interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementVisibility{

    public static void textOfElement(WebDriver driver, String textoDelElemento){

        try {
            driver.findElement(By.xpath("//button[contains(text(),'"+ textoDelElemento + "')]")).isDisplayed();
        }catch (Exception e){
            driver.findElement(By.xpath("//strong[contains(text(),'" + textoDelElemento + "')]")).isDisplayed();
        }

    }
}
