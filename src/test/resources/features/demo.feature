Feature: demo

  Scenario: I want login success to page guru99
    Given I login into system with info
      | email            |
      | kimnga@gmail.com |
    And I login to page with info
      | userID | pass   |
      | ngantk | 123456 |
    When I create a New Customer with info
      | Customer Name | Date of Birth | Address    | City   | State  | PIN    | Mobile Number | E-mail       | Password |
      | Kim Nga       | 03/25/1997    | Dan Phuong | Ha Noi | abczyx | 123456 | 0123456789    | kimnga@gmail | 1234567  |
    Then I see the account creation is successful and showing with info
      | Customer Name | Birthdate  | Address    | City   | State  | Pin    | Mobile No. | Email        |
      | Kim Nga       | 1997-03-25 | Dan Phuong | Ha Noi | abczyx | 123456 | 0123456789 | kimnga@gmail |



