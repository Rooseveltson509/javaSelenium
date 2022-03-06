package fr.zenity.academy.stepDefinitions;

import fr.zenity.academy.pageObjects.HomePage;
import io.cucumber.java8.En;

public class HomePageSteps implements En {

    public HomePageSteps(HomePage homePage) {
        Given("^I check the page exist$", () -> {
            homePage.maximize();
            homePage.iNavigateTo();
            assert homePage.checkImg();
        });

        Then("^I am on the home page store$", () -> {
        });
    }
}
