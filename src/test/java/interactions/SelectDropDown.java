package interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import userInterfaces.Elements_CalculoHipoteca;

public class SelectDropDown {

    public static void selectDropDown(WebDriver driver){
        Select dropdown = new Select(driver.findElement(By.id("term")));
        int loanTerm = Integer.parseInt(Elements_CalculoHipoteca.loanTerm);
        int loanTermConver = loanTerm * 12;
        String loanTermConStr = String.valueOf(loanTermConver);
        dropdown.selectByValue(loanTermConStr);
    }
}
