package tasks;

import interactions.ElementVisibility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import userInterfaces.Elements_Pokemon;

import java.time.Duration;

public class HomePageValidation {

    public static void pageHome(WebDriver driver){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(Elements_Pokemon.imgPokedex)).isDisplayed();
        ElementVisibility.textOfElement(driver, "Search");
        ElementVisibility.textOfElement(driver, "Pokémon");
        ElementVisibility.textOfElement(driver, "Moves");
        driver.findElement(Elements_Pokemon.inpSearchPokemon).isDisplayed();
        ElementVisibility.textOfElement(driver, "Pokédex Search");
        ElementVisibility.textOfElement(driver, "Feeling Lucky");
    }
}
