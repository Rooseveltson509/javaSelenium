package fr.zenity.academy.stepDefinitions;

import fr.zenity.academy.pageObjects.OrderPage;
import fr.zenity.academy.utils.CSVWorker;
import io.cucumber.java8.En;

public class OrderSteps implements En {
    public OrderSteps(OrderPage orderView) {
        CSVWorker worker = new CSVWorker("src\\test\\resources\\data\\products.csv");
        Given("^I am on the product catalog page$", () -> {
            System.out.println("------ Given ---------");
            //orderView
        });

        And("^I choose a product \"([^\"]*)\"$", (String product1) -> {
            System.out.println("------ When --------- " + worker.getColumn("productName").get(2));
            orderView.chooseProductToList(product1);
        });

        Then("^I am on the product detail page$", () -> {
            //orderView.checkItemToCart();
            System.out.println("---------------- Then --------------------");
        });
    }
}
