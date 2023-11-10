package userInterfaces;

import org.openqa.selenium.By;

import java.util.ResourceBundle;

public class Elements_Pokemon {

    public static ResourceBundle rb = ResourceBundle.getBundle("variablesSearch");
    public static String pokemonOrMove = rb.getString("pokemonNameOrMove")
            .replaceAll(" ", "-");

    public static By imgPokedex = By.xpath("//a[contains(text(),'Pokédex') and @data-target='replace']");
    public static By inpSearchPokemon = By.xpath("//*[@class=\"textbox searchbox\"]");
    public static By btnPokedexInDetailPokemon = By.xpath("//a[contains(text(),'Pokédex') and @class='pfx-backbutton']");
}
