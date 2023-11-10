package stepDefinitions;

import interactions.ClickItem;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tasks.*;
import userInterfaces.Elements_Pokemon;

public class UserHistoryTwo extends TestBase {

    @Given("realizo ingreso en la pagina pokemonshowdown opcion Search")
    public void realizo_ingreso_en_la_pagina_pokemonshowdown_opcion_search() {
        HomePageValidation.pageHome(driver);
    }

    @When("realizo una busqueda de Ataque de Pokemon existente")
    public void realizo_una_busqueda_de_ataque_de_pokemon_existente() {
        driver.findElement(Elements_Pokemon.inpSearchPokemon).sendKeys(Elements_Pokemon.pokemonOrMove);
        FindAndSelectPokemonOrMove.selectPokemonOrMoveSearch(driver);
    }

    @Then("se muestra el resultado del ataque esperado desde opcion Search")
    public void se_muestra_el_resultado_del_ataque_esperado_desde_opcion_search() {
        ValidationDataPokemon.validationNamePokemon(driver);
    }

    @Given("realizo ingreso en la pagina pokemonshowdown opcion Moves")
    public void realizo_ingreso_en_la_pagina_pokemonshowdown_opcion_moves() {
        HomePageValidation.pageHome(driver);
    }

    @When("realizo una busqueda de Ataque de Pokemon existente desde Moves")
    public void realizo_una_busqueda_de_ataque_de_pokemon_existente_desde_moves() {
        ClickItem.withText(driver, "Moves");
        driver.findElement(Elements_Pokemon.inpSearchPokemon).sendKeys(Elements_Pokemon.pokemonOrMove);
        FindAndSelectPokemonOrMove.selectPokemonOrMoveSearch(driver);
    }

    @Then("se muestra el resultado del ataque esperado desde opcion Moves")
    public void se_muestra_el_resultado_del_ataque_esperado_desde_opcion_moves() {
        ValidationDataPokemon.validationNamePokemon(driver);
    }

    @Given("ingreso en la pagina pokemonshowdown opcion Moves")
    public void ingreso_en_la_pagina_pokemonshowdown_opcion_moves() {
        HomePageValidation.pageHome(driver);
    }

    @When("realizo una busqueda de Ataque de Pokemon existente desde la tabla Moves")
    public void realizo_una_busqueda_de_ataque_de_pokemon_existente_desde_la_tabla_moves() {
        ClickItem.withText(driver, "Moves");
        FindAndSelectPokemonOrMove.findPokemonOrMoveInTable(driver);
    }

    @Then("se muestra el resultado del ataque esperado desde opcion la tabla Moves")
    public void se_muestra_el_resultado_del_ataque_esperado_desde_opcion_la_tabla_moves() {
        ValidationDataPokemon.validationNamePokemon(driver);
    }

    @Given("ingreso en la pagina pokemonshowdown en cualquier opcion de busqueda")
    public void ingreso_en_la_pagina_pokemonshowdown_en_cualquier_opcion_de_busqueda() {
        HomePageValidation.pageHome(driver);
    }

    @When("realizo una busqueda de Ataque de Pokemon existente desde alguna de las opciones disponibles")
    public void realizo_una_busqueda_de_ataque_de_pokemon_existente_desde_alguna_de_las_opciones_disponibles() {
        driver.findElement(Elements_Pokemon.inpSearchPokemon).sendKeys(Elements_Pokemon.pokemonOrMove);
        FindAndSelectPokemonOrMove.selectPokemonOrMoveSearch(driver);
    }

    @Then("se muestra el resultado del ataque esperado se valida el PP asignado")
    public void se_muestra_el_resultado_del_ataque_esperado_se_valida_el_pp_asignado() {
        ValidaPP.validaPP(driver);
    }
}
