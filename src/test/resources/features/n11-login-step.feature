Feature: Feature 1

  Scenario: I want to check that when  invalid credentials are entered  in login page, I get an error message
    Given Go to home page of o11
    When I enter my username "onur@swtestacademy.com" and password "11122233444"
    Then I Should be a error message