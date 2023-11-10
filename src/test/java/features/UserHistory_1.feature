# Author: mauriciokike@gmail.com

Feature:Busqueda de Pokemon validacion de Abilities y Base stats.

  Scenario: Busqueda de Pokemon existente desde la opcion search
    Given realizo ingreso en la pagina pokemonshowdown opcion Pokedex
    When realizo una busqueda de Pokemon existente
    Then Se muestra el resultado esperado desde opcion Search

  Scenario: Busqueda de Pokemon existente desde la opcion Pokemon
    Given realizo el ingreso en la pagina pokemonshowdown opcion Pokedex
    When realizo una busqueda de Pokemon existente desde opcion Pokemon
    Then Se muestra el resultado esperado desde opcion Pokemon

  Scenario: Busqueda de Pokemon existente desde tabla Pokemon
    Given realizo ingreso en pagina pokemonshowdown opcion Pokedex
    When realizo una busqueda de Pokemon existente desde opcion Pokemon en tabla
    Then encontramos el pokemon validamos que sea correcto

  Scenario: Validar Abilities y Base Stats de Pokemon
    Given realizo ingreso en pagina pokemonshowdown en cualquier opcion de busqueda
    When realizo una busqueda de Pokemon y seleccionar
    Then validamos las Abilities y Base stats en PokeAPI