package tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import userInterfaces.Elements_Pokemon;
import static org.junit.Assert.*;

public class ValidationDataPokemon {

    public static void validationNamePokemon(WebDriver driver){
        String namePokemonOrMoveValida = driver.findElement(By.xpath("/html/body/div[3]/div/h1/a")).getText().replaceAll(" ", "-");
        assertTrue(namePokemonOrMoveValida.equalsIgnoreCase(Elements_Pokemon.pokemonOrMove));
    }
}
