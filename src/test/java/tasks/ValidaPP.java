package tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import userInterfaces.Elements_Pokemon;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class ValidaPP {

    public static void validaPP(WebDriver driver){
        int convertNumPP;

        try{
            String numPP = driver.findElement(By.xpath("/html/body/div[3]/div/dl[4]/dd")).getAttribute("innerText").substring(0,2);
            convertNumPP = Integer.parseInt(numPP);
        }catch (Exception e){
            String numPP = driver.findElement(By.xpath("/html/body/div[3]/div/dl[3]/dd")).getAttribute("innerText").substring(0,2);
            convertNumPP = Integer.parseInt(numPP);
        }

        baseURI = "https://pokeapi.co/api/v2/move/" + Elements_Pokemon.pokemonOrMove.toLowerCase();

        String body2 = given().when().get().then().statusCode(200).body("pp", equalTo(convertNumPP)).
                extract().body().asString();

        //System.out.println(numPP);

    }
}
