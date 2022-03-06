package fr.zenity.academy.stepDefinitions;

import fr.zenity.academy.pageObjects.SigninPage;
import io.cucumber.java8.En;

public class SigninSteps implements En {

    public SigninSteps(SigninPage signinPage) {

        Given("^I am on the homePage LeBonCoin$", () -> {
            System.out.println("-------------- Given ---------------");
            signinPage.maximize();
            signinPage.iNavigateTo();
            assert signinPage.linkIsActive();
        });

        When("^I connect with my \"([^\"]*)\" and \"([^\"]*)\"$", (String email, String password) -> {
            System.out.println("-------------- When ---------------");
            signinPage.login(email, password);
            signinPage.submit();
            signinPage.loginValidate(email, password);

        });

        Then("^I am connected$", () -> {
            System.out.println("-------------- Then ---------------");
            assert signinPage.userIsConnected();
            signinPage.closeSnackBar();
        });
    }
}
