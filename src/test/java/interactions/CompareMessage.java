package interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import userInterfaces.Elements_Pokemon;

import static org.junit.Assert.assertTrue;

public class CompareMessage {

    public static void textOfMessage(WebDriver driver, String textoMsg){
        assertTrue(driver.findElement(By.xpath("//span[contains(text(),'"+ textoMsg +"')]")).getText().equals(textoMsg));
    }
}
