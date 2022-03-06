package fr.zenity.academy.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Objects;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class SigninPage extends Page{

    @FindBy(css = "#connexion")
    private WebElement isConnected;

    @FindBy(css = "#email")
    private WebElement inputEmail;

    @FindBy(css = ".mat-simple-snackbar > span:nth-child(1)")
    private WebElement userConnect;

    @FindBy(css = ".mat-button")
    private WebElement closeSnackBar;

    @FindBy(css = "#input_pawd")
    private WebElement inputPassword;

    @FindBy(css = "#btn_login")
    private WebElement btn_login;

    @FindBy(xpath = "/html/body/div[2]/div/div/snack-bar-container/div/div/simple-snack-bar/span")
    private WebElement INVALID_CREDENTIALS;


    public boolean linkIsActive(){
        assertTrue(isConnected.getAttribute("class").contains("active"));
        return true;
    }

    public boolean userIsConnected() throws InterruptedException {
        Thread.sleep(5000);
        assertTrue(Boolean.parseBoolean(String.valueOf(Objects.equals(userConnect.getText(), "Connected..."))));
        return true;
    }


    public void closeSnackBar(){
        longWaitUntil(visibilityOf(closeSnackBar));
        closeSnackBar.click();
    }


    public void iNavigateTo() {
        driver.get("http://localhost:4200/login");
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
            loginIsValid(INVALID_CREDENTIALS, email, password);
        } else{
            System.out.println("Nothing to report.....");
        }
    }

}
