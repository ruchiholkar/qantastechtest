Feature:  Populate the field values in QFF program

  Scenario Outline: Sign up for QFF Program(without submitting)
    Given I am on QFF Landing page
    Then I verify the contents of the page
    And I enter <countryOfResidency>
    And I enter Name details like <title>,<gender>,<firstName>,<lastName>
    And I enter Phone details like <phoneType>,<areaCode>,<phoneNumber>
    And I enter Postal address details like <postalAddressType>,<addressLine1>,<addressLine2>,<suburb-Town-City>,<state>,<postCode>
    And I enter Email and consent details like <emailAddress>
    And I enter Security questions details like <date>,<month>,<year>,<motherMaideName>,<pin>
    And I accept the terms and conditions
    And I enter Credit card details like <cardHolderName>,<cardNumber><exipryDateMonth>,<exipryDateYear>,<securityCode>
    And I select I am not a robot
    When I click on Pay button
    Then I should see confirmation message

    Examples:
      |countryOfResidency |title|gender|firstName|lastName|phoneType|areaCode|phoneNumber|postalAddressType|addressLine1|addressLine2|suburb-Town-City|state|postCode|emailAddress|date|month|year|motherMaideName|pin|cardHolderName|cardNumber|exipryDateMonth|exipryDateYear|securityCode|
      |Australia          |Mrs  |Female|Abc      |Xyz     |Home     |02      |12345678   |Business         |Address1    |Address2    |Sydney          |NSW  |2000    |a@a.com     |22  |03   |1985|Mother         |1235|Abc Xyz      |123456789012|12           |22            |234         |


    #Scenario: To validate the different fields