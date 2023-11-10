# Author: mauriciokike@gmail.com

Feature:Busqueda y validacion de Ataque y efecto de Pokemon

  Scenario: Busqueda de un Ataque de Pokemon existente desde la opcion search
    Given realizo ingreso en la pagina pokemonshowdown opcion Search
    When realizo una busqueda de Ataque de Pokemon existente
    Then se muestra el resultado del ataque esperado desde opcion Search

  Scenario: Busqueda de un Ataque de Pokemon existente desde la opcion Moves
    Given realizo ingreso en la pagina pokemonshowdown opcion Moves
    When realizo una busqueda de Ataque de Pokemon existente desde Moves
    Then se muestra el resultado del ataque esperado desde opcion Moves

  Scenario: Busqueda de un Ataque de Pokemon existente desde tabla Moves
    Given ingreso en la pagina pokemonshowdown opcion Moves
    When realizo una busqueda de Ataque de Pokemon existente desde la tabla Moves
    Then se muestra el resultado del ataque esperado desde opcion la tabla Moves

  Scenario: Busqueda de un Ataque de Pokemon y validar PP
    Given ingreso en la pagina pokemonshowdown en cualquier opcion de busqueda
    When realizo una busqueda de Ataque de Pokemon existente desde alguna de las opciones disponibles
    Then se muestra el resultado del ataque esperado se valida el PP asignado