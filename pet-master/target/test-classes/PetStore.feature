Feature: Create Pet Store 
  As an employe of the pet store
  I Want to create a new pet

  Scenario Outline: Create a new pet
    Given Enter name '<name>'
    When Do post request 
    Then Status for '<result>'

    @test_1
    Examples:
      | name | result                |
      | ironman    | 200 |


  Scenario Outline: Delete an pet
    Given Enter name '<name>'
    When Do delete request
    Then Status for '<result>'

    @test_2
    Examples:
      | name | result                |
      | spiderman    | 200 |


  Scenario Outline: Placing an order
    Given Enter name '<name>'
    When Do place order request
    Then Status for '<result>'

    @test_3
    Examples:
      | name | result                |
      | blackpanter    | 200 |
