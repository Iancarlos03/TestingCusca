package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tasks.*;
import userInterfaces.Elements_Pokemon;

public class UserHistoryThree extends TestBase {

    @Given("ingreso en la pagina pokemonshowdown opcion Search")
    public void ingreso_en_la_pagina_pokemonshowdown_opcion_search() {
        HomePageValidation.pageHome(driver);
    }
    @When("realizo una busqueda de habilidad de Pokemon existente")
    public void realizo_una_busqueda_de_habilidad_de_pokemon_existente() {
        driver.findElement(Elements_Pokemon.inpSearchPokemon).sendKeys(Elements_Pokemon.pokemonOrMove);
        FindAndSelectPokemonOrMove.selectPokemonOrMoveSearch(driver);
    }
    @Then("se muestra el resultado de habilidad esperado desde opcion Search")
    public void se_muestra_el_resultado_de_habilidad_esperado_desde_opcion_search() {
        ValidationDataPokemon.validationNamePokemon(driver);
    }
}
