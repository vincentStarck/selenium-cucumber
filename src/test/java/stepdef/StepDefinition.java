package stepdef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Page;

public class StepDefinition {


    private Page page;

    public StepDefinition(Page page) {
        this.page = page;

    }

    @Given("Go to home page of o11")
    public void go_to_home_page_of_o_com() {

        page.homePage().goToLoginPage();

    }

    @When("I enter my username {string} and password {string}")
    public void i_enter_username_and_password(String username,String password) {

        page.loginPage().WhenILoginToN11(username, password);

    }

    @Then("I Should be a error message")
    public void i_Should_be_a_error_message() {

        page.loginPage().ThenIVerifyLoginPassword("E-posta adresiniz veya şifreniz hatalı");
    }

}
