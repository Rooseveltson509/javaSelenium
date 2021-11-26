package fr.zenity.academy.stepDefinitions;

import fr.zenity.academy.PageObjects.LoginPage;
import io.cucumber.java8.En;
import org.openqa.selenium.WebDriver;

public class LoginSteps implements En {

    private WebDriver driver;
    //private LoginPage loginPage= new LoginPage();

    public LoginSteps(LoginPage loginPage) {
        Given("^user is on the login page$", () -> {
            System.out.println("first Given");
            //System.out.println("first Given");
            loginPage.iNavigateTo();
            System.out.println("first Given");

        });

        When("^user is logging-in with \"([^\"]*)\" \"([^\"]*)\"$", (String username, String password) -> {
            System.out.println("first Given");
            System.out.println("first when");
            loginPage.fillUsername(username);
            loginPage.fillPassword(password);
            loginPage.clickOnLoginButton();
            System.out.println("first Given");
        });

        Then("^he should be at the home page$", () -> {
            System.out.println("first then");
            loginPage.checkIfIConnected();
        });

        Then("^he should not be able to go to the home page$", () -> {
            System.out.println("wrong then");
            //loginPage.checkLoginFailed();
        });
    }
}
