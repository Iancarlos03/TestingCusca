package tasks;

import org.openqa.selenium.WebDriver;
import userInterfaces.Elements_CalculoHipoteca;

public class ValidaHomePageMortageCalculator {

    public static void validaHomePage(WebDriver driver){
        driver.findElement(Elements_CalculoHipoteca.logoRocketMortage).isDisplayed();
        driver.findElement(Elements_CalculoHipoteca.labelMortageCalculator).isDisplayed();
        driver.findElement(Elements_CalculoHipoteca.labelEstimatedMonPayment).isDisplayed();
        driver.findElement(Elements_CalculoHipoteca.TableDetailPayment).isDisplayed();
    }
}
