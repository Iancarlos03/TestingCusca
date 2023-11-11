package tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import userInterfaces.Elements_Pokemon;

import java.time.Duration;

import static org.hamcrest.CoreMatchers.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.junit.Assert.assertTrue;

public class ValidaInAPI {

    public static void validaApiAbilties(WebDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        int countAbilities = 1;

        while (countAbilities > 0){
            try{
                driver.findElement(By.xpath("/html/body/div[3]/div/dl[3]/dd/a["+countAbilities+"]")).isDisplayed();
                countAbilities++;
            }catch (Exception e){
                break;
            }
        }

        countAbilities --;

        int newCountAbilities = 1;

        String[] NumAbilities;
        NumAbilities = new String[countAbilities];


        for (int count = 0; count < countAbilities; count++){
            NumAbilities[count] = driver.findElement(By.xpath("/html/body/div[3]/div/dl[3]/dd/a["+newCountAbilities+"]"))
                    .getAttribute("innerText").replaceAll(" ", "-");
            //System.out.println(NumAbilities[count]);
            driver.findElement(By.xpath("/html/body/div[3]/div/dl[3]/dd/a["+newCountAbilities+"]")).click();

            //System.out.println(driver.findElement(By.xpath("/html/body/div[4]/div/h1/a")).getText());
            //System.out.println(NumAbilities[count]);
            Thread.sleep(1000);
            String abilitieGet = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("/html/body/div[4]/div/h1/a"))).getText();
            assertTrue(abilitieGet.replaceAll(" ", "-")
                    .equalsIgnoreCase(NumAbilities[count]));
            Thread.sleep(1000);
            driver.findElement(Elements_Pokemon.btnPokedexInDetailPokemon).click();
            newCountAbilities++;
        }

        baseURI = "https://pokeapi.co/api/v2/pokemon/" + Elements_Pokemon.pokemonOrMove.toLowerCase();

        for (int countApi = 0; countApi < countAbilities; countApi++){
            //System.out.println("Estoy en for API");
            String body = given().when().get().then().statusCode(200).body("abilities["+countApi+"].ability.name",
                            equalToIgnoringCase(NumAbilities[countApi])).extract().body().asString();
            //System.out.println(body);
        }
    }

    public static void validaApiBaseStats(WebDriver driver){
        int countAbilities = 2;
        int countTotal = 0;

        while (countAbilities > 0){
            try{
                driver.findElement(By.xpath("/html/body/div[3]/div/dl[4]/dd[1]/table/tbody/tr["+countAbilities+"]/th")).isDisplayed();
                countAbilities++;
            }catch (Exception e){
                break;
            }
        }

        countAbilities = countAbilities - 2;
        //System.out.println("countAbilities "+ countAbilities);

        int newCountAbilities = 2;

        String[][] NumAbilities;
        NumAbilities = new String[countAbilities][2];

        for (int count = 0; count < countAbilities; count++){
            NumAbilities[count][0] = driver.findElement(By.xpath("/html/body/div[3]/div/dl[4]/dd[1]/table/tbody/tr["+newCountAbilities+"]/th"))
                    .getAttribute("innerText").replaceAll(":", "");
            //System.out.println(NumAbilities[count][0]);
            for (int count2 = 0; count2 < 1; count2++){
                NumAbilities[count][1] = driver.findElement(By.xpath("/html/body/div[3]/div/dl[4]/dd[1]/table/tbody/tr["+newCountAbilities+"]/td[1]"))
                        .getAttribute("innerText");
                //System.out.println(NumAbilities[count][1]);
            }
            newCountAbilities++;
        }

        int[] convert;
        convert = new int[countAbilities];

        for (int count3 = 0; count3 < countAbilities; count3++){
            convert[count3] = Integer.parseInt(NumAbilities[count3][1]);
            //System.out.println("convert string "+ convert[count3]);
        }


        baseURI = "https://pokeapi.co/api/v2/pokemon/" + Elements_Pokemon.pokemonOrMove.toLowerCase();

        for (int countApi = 0; countApi < countAbilities; countApi++){
            //System.out.println("Estoy en for API");

            if (NumAbilities[countApi][0].equals("Sp. Atk")){
                NumAbilities[countApi][0] = "special-attack";
            }else if (NumAbilities[countApi][0].equals("Sp. Def")){
                NumAbilities[countApi][0] = "special-defense";
            }else if (NumAbilities[countApi][0].equals("Total")){
                assertTrue(convert[countApi] == countTotal);
                break;
            }else {
                String body = given().when().get().then().statusCode(200).body("stats["+countApi+"].stat.name", equalToIgnoringCase(NumAbilities[countApi][0])).
                        extract().body().asString();
                //System.out.println(NumAbilities[countApi][0]);
            }

            for (int countApi2 = 0; countApi2 < 1; countApi2++){
                //System.out.println("for2 "+convert[countApi]);
                //System.out.println("countApi "+countApi);
                String body2 = given().when().get().then().statusCode(200).body("stats["+countApi+"].base_stat", equalTo(convert[countApi])).
                        extract().body().asString();
                if (countApi < 1){
                    countTotal = convert[countApi];
                }else {
                    countTotal = countTotal + convert[countApi];
                }
                //System.out.println(body2);
            }
        }
    }

}
