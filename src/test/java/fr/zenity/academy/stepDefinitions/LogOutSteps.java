package fr.zenity.academy.stepDefinitions;

import fr.zenity.academy.pageObjects.SigninPage;
import io.cucumber.java8.En;

public class LogOutSteps implements En {
    public  LogOutSteps(SigninPage signinPage){

        Given("^I finish my visit to the store$", () -> {
            System.out.println("log me out");
            signinPage.logOut();
        });

        Then("^I am login out$", () -> {
            System.out.println("I disconnect to the application");
            assert signinPage.linkIsActive();
        });

    }
}
