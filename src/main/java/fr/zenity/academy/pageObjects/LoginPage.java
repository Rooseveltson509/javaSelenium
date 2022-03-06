package fr.zenity.academy.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LoginPage extends Page{

    @FindBy(css = "#connexion")
    private WebElement connexionMenu;

    @FindBy(css = "#inputEmail")
    private WebElement inputEmail;

    @FindBy(css = "#inputPassword")
    private WebElement inputPassword;

    @FindBy(css = "#btn_login")
    private WebElement btn_login;

    @FindBy(css = "form > .alert-danger")
    private WebElement INVALID_CREDENTIALS;


    public void clickOnLoginLink(){
        longWaitUntil(visibilityOf(connexionMenu));
        connexionMenu.click();
    }

    public void iNavigateTo() {
        driver.get("http://localhost:8000/");
        waitForPageLoading();
    }

    /**
     *
     * @param email
     * @param password
     * @throws InterruptedException
     */
    public void login(String email, String password) throws InterruptedException {
        Thread.sleep(5000);
        longWaitUntil(visibilityOf(inputEmail));
        inputEmail.click();
        inputEmail.sendKeys(email);

        longWaitUntil(visibilityOf(inputPassword));
        inputPassword.click();
        inputPassword.sendKeys(password);
    }

    public void submit() throws InterruptedException {
        longWaitUntil(visibilityOf(btn_login));
        btn_login.click();
        Thread.sleep(3000);
    }

    public void loginValidate(String email,String password) {
        if(longWaitUntil(visibilityOf(INVALID_CREDENTIALS))){
            loginValidator(INVALID_CREDENTIALS, email, password);
        } else{
            System.out.println("Nothing to report.....");
        }
    }


}
