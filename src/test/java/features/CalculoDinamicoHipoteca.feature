# Author: mauriciokike@gmail.com

Feature:Validacion calculo dinamico de cuota en hipoteca

  Scenario: Validacion de campos requeridos en rocket mortage
    Given ingreso en la pagina rocket mortage
    When dejo los campos requeridos vacios
    Then se muestra mensaje de advertencia en cada campo.

  Scenario: Validacion de campos mayores a 0 en rocket mortage
    Given ingreso en pagina rocket mortage
    When ingreso valor 0 en campos Home Price y Interest Rate
    Then se muestra mensaje de advertencia en cada campo por colocar 0

  Scenario: Validacion de campo Interest Rate mayor a 11 en rocket mortage
    Given ingreso en ambiente rocket mortage
    When ingreso valor mayor a 10 en campos Interest Rate
    Then se muestra mensaje de advertencia en campo Interest Rate al colocar numero mayor a 10

  Scenario: Validacion total payment con $ en opcion Down Payment en rocket mortage
    Given ingreso en web rocket mortage
    When selecciono $ en down payment y completo los campos requeridos
    Then valido que Total Payment sea correcto

  Scenario: Validacion total payment con % en opcion Down Payment en rocket mortage
    Given ingreso a web rocket mortage
    When selecciono % en down payment y completo los campos requeridos
    Then valido Total Payment sea correcto