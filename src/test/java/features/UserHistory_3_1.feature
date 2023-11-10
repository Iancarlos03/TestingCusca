# Author: mauriciokike@gmail.com

Feature:Busqueda y validacion de habilidad de Pokemon

  Scenario: Busqueda de habilidad de Pokemon existente desde la opcion search
    Given ingreso en la pagina pokemonshowdown opcion Search
    When realizo una busqueda de habilidad de Pokemon existente
    Then se muestra el resultado de habilidad esperado desde opcion Search
