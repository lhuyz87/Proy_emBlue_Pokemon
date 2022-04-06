@MantenimientoPokemon
Feature: Dar mantenimiento al registro de pokemón

  @CrearNPokemon @regresion
  Scenario: Validar que permita el correcto registro de n pokemóns
    Given ingreso al sistema corporación capsula
    When selecciono opción 'crear nuevo pokemón'
    And registro la información de los pokemons:
      | id_pokemon | nombre_pokemon | color_pokemon | nivel_pokemon |
      |          2 | ponita         | rojo          |            10 |
      |          3 | ratata         | blanco        |           100 |
      |          4 | butterfly      | morado        |            30 |
      |          5 | hunter         | negro         |            10 |
    And selecciono opción 'ver todos los pokemón'
    Then se muestra la lista de los pokemones creados correctamente

  @CrearPokemon @regresion
  Scenario Outline: Validar que permita el correcto registro de pokemón
    Given ingreso al sistema corporación capsula
    When selecciono opción 'crear nuevo pokemón'
    And ingreso la información del pókemon: "<id_pokemon>", "<nombre_pokemon>", "<color_pokemon>" y "<nivel_pokemon>"
    And grabo los valores
    And selecciono opción 'ver todos los pokemón'
    Then se muestra el pokemón creado

    Examples: 
      | id_pokemon | nombre_pokemon | color_pokemon | nivel_pokemon |
      |          2 | ponita         | rojo          |            10 |
      |          3 | wisin          | morado        |            12 |

  @IdRepetido @regresion
  Scenario Outline: Validar que no permita el registro de IDs repetidos
    Given ingreso al sistema corporación capsula
    When selecciono opción 'crear nuevo pokemón'
    And ingreso la información del pókemon: "<id_pokemon>", "<nombre_pokemon>", "<color_pokemon>" y "<nivel_pokemon>"
    And grabo los valores
    Then se debe mostrar mensaje de error
    And selecciono opción 'ver todos los pokemón'
    And no se debe mostrar el id repetido

    Examples: 
      | id_pokemon | nombre_pokemon | color_pokemon | nivel_pokemon |
      |          1 | ponita         | rojo          |            10 |

  @CamposObligatorios
  Scenario Outline: Validar la obligatoriedad de los campos
    Given ingreso al sistema corporación capsula
    When selecciono opción 'crear nuevo pokemón'
    And ingreso la información del pókemon: "<id_pokemon>", "<nombre_pokemon>", "<color_pokemon>" y "<nivel_pokemon>"
    And grabo los valores
    Then se debe mostrar mensaje de error indicando la falta del campo obligatorio "mensaje_esperado"

    Examples: 
      | id_pokemon | nombre_pokemon | color_pokemon | nivel_pokemon | mensaje_esperado           |
      |          1 | ponita         | rojo          |            10 | Please complete all fields |
      |          1 |                | rojo          |            10 | Please complete all fields |
      |          1 | ponita         |               |            10 | Please complete all fields |
      |          1 | ponita         | rojo          |               | Please complete all fields |

  @CamposObligatorios
  Scenario Outline: Validar el formato de los campos
    Given ingreso al sistema corporación capsula
    When selecciono opción 'crear nuevo pokemón'
    And ingreso la información del pókemon: "<campo>", "<valor>"
    And selecciono "TAB"
    Then no debe permitir el ingreso o se debe mostrar mensaje de error indicando el formato errado "mensaje_esperado"

    Examples: 
      | campo  | valor | mensaje_esperado |
      | id     | nnnn  | Error de formato |
      | id     | %&/   | Error de formato |
      | id     | " "   | Error de formato |
      | nombre | " "   | Error de formato |
      | color  | " "   | Error de formato |
      | level  | a     | Error de formato |
      | level  | " "   | Error de formato |
