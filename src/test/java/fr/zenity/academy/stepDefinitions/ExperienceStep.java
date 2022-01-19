package fr.zenity.academy.stepDefinitions;

import fr.zenity.academy.pageObjects.Experience;
import io.cucumber.java8.En;
import org.openqa.selenium.WebDriver;

public class ExperienceStep implements En {
    private WebDriver wDriver;

    public ExperienceStep(Experience experience){
        Given("^I am on the home page$", () -> {
            experience.maximize();
            experience.iNavigateTo();
        });

        When("^I go to the experience section I choose the start date and the end date with \"([^\"]*)\"$", experience::setExperience);

        And("^I filter by number of travelers and by price with \"([^\"]*)\" and \"([^\"]*)\"$", (String minPrice, String maxPrice) -> {
            experience.chooseGuest(minPrice, maxPrice);
            Thread.sleep(3000);
        });

        And("^I create a favorites list for this I log in$", experience::clickOnwishBtn);

        // experience.clickOnRecaptcha();
        When("^I log in with my \"([^\"]*)\" and \"([^\"]*)\"$", experience::logged);

        Then("^I create my list of favorites with \"([^\"]*)\"$", (String listName) -> {
            experience.createList(listName);
            System.out.println("successful scenario...");
        });
    }
}
