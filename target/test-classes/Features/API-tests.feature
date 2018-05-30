@APITests
Feature: Test Light bulb APIs

  Scenario Outline: Verify Light bulb ON/OFF
    When I send POST request with <state>
    Then I verify that it returns <response>

    Examples:
      | state | response |
      |  ON   | 200      |
      |  OFF  | 200      |

  Scenario Outline: Verify Light bulb ON with Power setting
    When I set <power> setting
    And I send POST request with <state>
    Then I verify that it returns <response>
    Examples:
      | state | power | response |
      |ON     |1      | 200      |
      |ON     |60     | 200      |


  Scenario: Verify Light bulb All methods
    When I send POST request with All methods
    Then I verify that it returns all methods

