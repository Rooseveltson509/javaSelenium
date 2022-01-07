package fr.zenity.academy.stepDefinitions;

import fr.zenity.academy.pageObjects.RegisterPage;
import io.cucumber.java.en.Given;
import io.cucumber.java8.En;
import org.openqa.selenium.WebDriver;

public class RegisterSteps implements En {
    private WebDriver driver;
    //private LoginPage loginPage= new LoginPage();

    public RegisterSteps(RegisterPage registerPage) {

        Given("^user is on the popup register page$", () -> {
            registerPage.maximize();
            registerPage.iNavigateTo();
            System.out.println("register pop up");
        });


        When("^user wants to signup with email \"([^\"]*)\"$", (String email) -> {
            Thread.sleep(5000);
            registerPage.clickOnPopUpButton();
            Thread.sleep(5000);
            registerPage.clickOnRegisterLink();
            Thread.sleep(5000);
            System.out.println("Register page");
            registerPage.emailRegister(email);
            System.out.println("register with email address");
            Thread.sleep(3000);
        });

        Then("^he should be at the account page$", () -> {
            System.out.println("first Given");
        });

        When("^user fills all the fields register with email \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$", (String firstName, String lastName, String fdate, String password) -> {
            Thread.sleep(3000);
            registerPage.fillInputFields(firstName, lastName, fdate, password);
            System.out.println("register completed");
        });

        Then("^he should be at validate form$", () -> {
            System.out.println("SUCCESSFULL");
        });
        When("^user fill the \"([^\"]*)\" field with a correct password$", (String password) -> {
            //Thread.sleep(3000);
            registerPage.fillPassword(password);
            registerPage.clickOnLoginButton();
            registerPage.clickOnRecaptcha();

        });

        Then("^he should be at the home page$", () -> {
            System.out.println("he should be at the home page");
        });

    }
}