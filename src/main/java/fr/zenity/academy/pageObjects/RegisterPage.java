package fr.zenity.academy.pageObjects;

import fr.zenity.academy.config.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class RegisterPage extends Page {
    /**
     * FindBy
     * */
    @FindBy(css ="input#email-login-email")
    WebElement inputLogin;

    @FindBy(css = "button[data-testid='signup-login-submit-btn']")
    private WebElement loginButton;

    @FindBy( css = "button.jss6" )
    private WebElement imOnConnetedPage;

    @FindBy(css = "div[data-testid='main-cookies-banner-container']")
    private WebElement cookiesWindow;

    @FindBy(css = "button[data-testid='accept-btn']")
    private WebElement acceptBtn;

    @FindBy( css = "._ojs7nk" )
    private WebElement registerPage;

    @FindBy( css = "#recaptcha-anchor")
    private WebElement recaptCha;

    @FindBy( css = "button[data-testid='social-auth-button-email']" )
    private WebElement emailInput;

    @FindBy(css= "div.MuiTabs-scroller a")
    private List<WebElement> lstUser;

    @FindBy(css = "input[name=\"user[first_name]\"]")
    private WebElement firstName;

    @FindBy(css = "input[name=\"user[last_name]\"]")
    private WebElement lastName;

    @FindBy(css = "input[name=\"user[password]\"]")
    private WebElement pPassword;

    @FindBy(css = "#email-signup-date")
    private WebElement rDate;

    @FindBy(css = "button[data-testid='cc-accept']")
    private WebElement acceptSubscription;

    @FindBy(css = "input[name='user[password]'")
    private WebElement passwordConnexion;

    @FindBy(css = "button[data-testid='cc-accept']")
    private WebElement ccAccept;

    //data-testid="cc-accept"

    /***
     * By
     */
    private final By togglePopUp = By.id("field-guide-toggle");

    private final By inputPassword = By.id("password-login");

    public void clickOnUser(String type){
        lstUser.stream()
                .filter(element-> element.getText().equals(type))
                .findFirst()
                .orElseThrow(()->new RuntimeException("Element "+ type + " not Found"))
                .click();
    }

    public void iNavigateTo(){
        driver.get("https://www.airbnb.fr/");
        waitForPageLoading();
        if (waitUntil(driver -> visibilityOf(cookiesWindow))) {
            clickOn(acceptBtn);
        }
    }

    public void fillFirstName( String fName ){
        wait.until(visibilityOf(inputLogin));
        firstName.sendKeys(fName);
    }

    public void fillLastName( String lName ){
        wait.until(visibilityOf(inputLogin));
        lastName.sendKeys(lName);
    }

    public void fillPassword(String password){
        wait.until(ExpectedConditions.visibilityOf(passwordConnexion));
        passwordConnexion.sendKeys(password);
    }

    public void clickOnLoginButton(){
        clickOn(loginButton);
        if (waitUntil(driver -> visibilityOf(recaptCha))){
            System.out.println("captcha is displayed");
        }
    }

    public void clickOnPopUpButton(){
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(togglePopUp)));
        driver.findElement(togglePopUp).click();
        //System.out.println("===== STEP 1 ===== toggle");
    }
    public void clickOnRegisterLink(){
        //wait.until(ExpectedConditions.visibilityOf(registerPage));
        clickOn(registerPage);
        //System.out.println("===== STEP 2 ===== Register link");
    }
    public void emailRegister(String email){
        //wait.until(ExpectedConditions.visibilityOf(registerPage));
        clickOn(emailInput);
        inputLogin.sendKeys(email);
        //System.out.println("===== STEP 3 ===== Register link");
        loginButton.click();
    }
    public void fillInputFields(String fName, String lName, String date, String pasword){
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        rDate.sendKeys(date);
        pPassword.sendKeys(pasword);
        loginButton.click();
        if (waitUntil(driver -> visibilityOf(recaptCha))){
            System.out.println("captcha is displayed");
        }
        clickOn(acceptSubscription);
    }

    public void clickOnRecaptcha(){
        clickOn(recaptCha);
    }

    public void checkIfIConnected(){
        wait.until(visibilityOf(imOnConnetedPage));
    }
}
