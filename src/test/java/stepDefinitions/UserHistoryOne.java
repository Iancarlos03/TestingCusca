package stepDefinitions;

import interactions.ClickItem;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tasks.*;
import userInterfaces.Elements_Pokemon;

public class UserHistoryOne extends TestBase {

    @Given("realizo ingreso en la pagina pokemonshowdown opcion Pokedex")
    public void realizo_ingreso_en_la_pagina_pokemonshowdown_opcion_pokedex() {
        HomePageValidation.pageHome(driver);
    }

    @When("realizo una busqueda de Pokemon existente")
    public void realizo_una_busqueda_de_pokemon_existente() {
        driver.findElement(Elements_Pokemon.inpSearchPokemon).sendKeys(Elements_Pokemon.pokemonOrMove);
        FindAndSelectPokemonOrMove.selectPokemonOrMoveSearch(driver);
    }

    @Then("Se muestra el resultado esperado desde opcion Search")
    public void se_muestra_el_resultado_esperado_desde_opcion_search() {
        ValidationDataPokemon.validationNamePokemon(driver);
    }

    @Given("realizo el ingreso en la pagina pokemonshowdown opcion Pokedex")
    public void realizo_el_ingreso_en_la_pagina_pokemonshowdown_opcion_pokedex() {
        HomePageValidation.pageHome(driver);
    }

    @When("realizo una busqueda de Pokemon existente desde opcion Pokemon")
    public void realizo_una_busqueda_de_pokemon_existente_desde_opcion_pokemon() {
        ClickItem.withText(driver, "Pokémon");
        driver.findElement(Elements_Pokemon.inpSearchPokemon).sendKeys(Elements_Pokemon.pokemonOrMove);
        FindAndSelectPokemonOrMove.selectPokemonOrMoveSearch(driver);
    }

    @Then("Se muestra el resultado esperado desde opcion Pokemon")
    public void se_muestra_el_resultado_esperado_desde_opcion_pokemon() {
        ValidationDataPokemon.validationNamePokemon(driver);
    }

    @Given("realizo ingreso en pagina pokemonshowdown opcion Pokedex")
    public void realizo_ingreso_en_pagina_pokemonshowdown_opcion_pokedex() {
        HomePageValidation.pageHome(driver);
    }

    @When("realizo una busqueda de Pokemon existente desde opcion Pokemon en tabla")
    public void realizo_una_busqueda_de_pokemon_existente_desde_opcion_pokemon_en_tabla() {
        ClickItem.withText(driver, "Pokémon");
        FindAndSelectPokemonOrMove.findPokemonOrMoveInTable(driver);
    }

    @Then("encontramos el pokemon validamos que sea correcto")
    public void encontramos_el_pokemon_validamos_que_sea_correcto() {
        ValidationDataPokemon.validationNamePokemon(driver);
    }

    @Given("realizo ingreso en pagina pokemonshowdown en cualquier opcion de busqueda")
    public void realizo_ingreso_en_pagina_pokemonshowdown_en_cualquier_opcion_de_busqueda() {
        HomePageValidation.pageHome(driver);
    }

    @When("realizo una busqueda de Pokemon y seleccionar")
    public void realizo_una_busqueda_de_pokemon_y_seleccionar() {
        driver.findElement(Elements_Pokemon.inpSearchPokemon).sendKeys(Elements_Pokemon.pokemonOrMove);
        FindAndSelectPokemonOrMove.selectPokemonOrMoveSearch(driver);
    }

    @Then("validamos las Abilities y Base stats en PokeAPI")
    public void validamos_las_abilities_y_base_stats_en_poke_api() throws InterruptedException {
        ValidaInAPI.validaApiAbilties(driver);
        ValidaInAPI.validaApiBaseStats(driver);
    }
}
