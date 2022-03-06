package fr.zenity.academy.stepDefinitions;

import fr.zenity.academy.pageObjects.LoginPage;
import io.cucumber.java8.En;

public class LoginSteps implements En {
    public LoginSteps(LoginPage loginPage) {
        Given("^I am on the home page \\(La boutique française\\)$", () -> {
            loginPage.maximize();
            loginPage.iNavigateTo();
            loginPage.clickOnLoginLink();
        });

        When("^I log in with my \"([^\"]*)\" and \"([^\"]*)\" on the website$", (String email, String password) -> {
            loginPage.login(email, password);
            loginPage.submit();
            loginPage.loginValidate(email, password);
        });

        Then("^I am logged$", () -> {
            System.out.println("Then Block is calling ...");

        });
    }
}
