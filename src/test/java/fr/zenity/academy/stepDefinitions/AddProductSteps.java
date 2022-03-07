package fr.zenity.academy.stepDefinitions;

import fr.zenity.academy.pageObjects.AddProductPage;
import io.cucumber.java8.En;

public class AddProductSteps implements En {

    public AddProductSteps(AddProductPage addPage) {

        Given("^I am on the add page$", () -> {
            System.out.println("------ Given ---------");
            addPage.goToAddProductPage();
        });
        When("^I go to the register page and I create a product with \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$", (String title, String price, String description) -> {
            System.out.println("------ When ---------");
            addPage.addProduct(title, price, description);
            addPage.submit();
            addPage.openProductCreated();
        });
        Then("^then I added the product$", () -> {
            System.out.println("------ Then ---------");
        });

    }

}
