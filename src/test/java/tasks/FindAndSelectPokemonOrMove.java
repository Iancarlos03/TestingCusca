package tasks;

import org.openqa.selenium.*;
import userInterfaces.Elements_Pokemon;

public class FindAndSelectPokemonOrMove {

    public static void findPokemonOrMoveInTable(WebDriver driver) {
        int numlinePokemonOrMove = 2;
        int numGeneration = 1;
        int cellName = 0;

        if (driver.findElement(By.xpath("/html/body/div[2]/div/div/ul/li[1]/div/button[1]")).getText()
                .equalsIgnoreCase("Name")){
            cellName = 1;
        }else{
            cellName = 3;
        }

        while (numlinePokemonOrMove >= 2) {

            if (driver.findElement(By.xpath("/html/body/div[2]/div/div/ul/li["+ numlinePokemonOrMove +"]")).getText()
                    .equalsIgnoreCase("Generation " + numGeneration)){
                numlinePokemonOrMove++;
                numGeneration ++;
            }else if (driver.findElement(By.xpath("/html/body/div[2]/div/div/ul/li["+ numlinePokemonOrMove +"]")).getText()
                    .equalsIgnoreCase("Moves")){
                numlinePokemonOrMove = 3;
            }

            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement Element = driver.findElement(By.xpath("/html/body/div[2]/div/div/ul/li["+ numlinePokemonOrMove +"]/a/span["+cellName+"]"));
            js.executeScript("arguments[0].scrollIntoView();", Element);

            String opcPokemon = driver.findElement(By.xpath("/html/body/div[2]/div/div/ul/li["+ numlinePokemonOrMove +"]/a/span["+cellName+"]"))
                    .getText().replaceAll(" ", "-"); //OBTENER NOMBRE DE POKEMON O MOVE
            //System.out.println("GetPokemon: "+opcPokemon);
            //System.out.println("VariablePokemon: "+Elements_UserHistory_One.pokemonOrMove);

            if (opcPokemon.equalsIgnoreCase(Elements_Pokemon.pokemonOrMove)) {
                driver.findElement(By.xpath("/html/body/div[2]/div/div/ul/li["+ numlinePokemonOrMove +"]/a/span["+cellName+"]")).click(); //CLICK EN POKEMON
                break;
            }
            numlinePokemonOrMove++;
        }
    }

    public static void selectPokemonOrMoveSearch(WebDriver driver){
        int findPokemon = 2;
        int labelOption = 0;

        if (driver.findElement(By.xpath("/html/body/div[2]/div/div/ul/li[1]")).getText()
                .equalsIgnoreCase("Pokémon")){
            labelOption = 3;
        }else{
            labelOption = 1;
        }

        while (findPokemon > 1){
            if (driver.findElement(By.xpath("/html/body/div[2]/div/div/ul/li["+findPokemon+"]/a/span["+labelOption+"]")).getText().replaceAll(" ", "-")
                    .equalsIgnoreCase(Elements_Pokemon.pokemonOrMove)){
                driver.findElement(Elements_Pokemon.inpSearchPokemon).sendKeys(Keys.ENTER);
                break;
            }
        }
    }
}
