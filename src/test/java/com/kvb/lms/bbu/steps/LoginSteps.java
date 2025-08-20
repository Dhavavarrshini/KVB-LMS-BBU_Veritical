package com.kvb.lms.bbu.steps;

import com.kvb.lms.bbu.hooks.Hooks;
import com.kvb.lms.bbu.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginSteps {

    private static final Logger log = LoggerFactory.getLogger(LoginSteps.class);
    private LoginPage loginPage;

    @Given("user navigates to the login page")
    public void userNavigatesToLoginPage() {
        loginPage = new LoginPage(Hooks.page);
        loginPage.navigateToLogin();
    }

    // ✅ Valid login
    @When("the user enters valid username and password")
    public void userEntersValidCredentials() {
        loginPage.enterEmpID("PENTA009");
        loginPage.enterPassword("kvb@1234");
    }

    @Then("the user should be logged in successfully")
    public void userShouldBeLoggedIn() {
        loginPage.clickLogin();
    }

    // ✅ Valid username + Invalid password
    @When("the user enters valid username and invalid password")
    public void userEntersValidUsernameInvalidPassword() {
        loginPage.enterEmpID("PENTA009");
        loginPage.enterPassword("wrongPassword");
    }

    @Then("the user should be logged out with invalid password")
    public void userShouldBeLoggedOutInvalidPassword() {
        loginPage.clickLogin();
    }

    // ✅ Invalid username + Valid password
    @When("the user enters invalid username and valid password")
    public void userEntersInvalidUsernameValidPassword() {
        loginPage.enterEmpID("WrongUser");
        loginPage.enterPassword("kvb@1234");
    }

    @Then("the user should be logged out with invalid username")
    public void userShouldBeLoggedOutInvalidUsername() {
        loginPage.clickLogin();
    }

    // ✅ Invalid username + Invalid password
    @When("the user enters invalid username and password")
    public void userEntersInvalidCredentials() {
        loginPage.enterEmpID("WrongUser");
        loginPage.enterPassword("WrongPass");
    }

    @Then("the user should be logged out with invalid credentials")
    public void userShouldBeLoggedOutInvalidCredentials() {
        loginPage.clickLogin();
    }
}
