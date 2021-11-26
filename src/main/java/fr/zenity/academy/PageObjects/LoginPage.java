package fr.zenity.academy.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class LoginPage  extends Page{
    /**
     * FindBy
     * */
    @FindBy(css ="input#user-login")
    WebElement inputLogin;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    @FindBy( css = "button.jss6" )
    private WebElement imOnConnetedPage;

    @FindBy(css= "div.MuiTabs-scroller a")
    private List<WebElement> lstUser;

    /***
     * By
     */
    private By inputPassword = By.id("password-login");

    public void clickOnUser(String type){
        lstUser.stream()
                .filter(element-> element.getText().equals(type))
                .findFirst()
                .orElseThrow(()->new RuntimeException("Element "+ type + " not Found"))
                .click();
    }

    public void iNavigateTo( ){
        driver.get("https://rec-desbugs.herokuapp.com/login");
        waitForPageLoading();
    }

    public void fillUsername( String user ){
        wait.until(visibilityOf(inputLogin));
        inputLogin.sendKeys(user);
    }

    public void fillPassword(String password){
        wait.until(visibilityOfElementLocated(inputPassword));
        driver.findElement(inputPassword).sendKeys(password);
    }

    public void clickOnLoginButton(){
        clickOn(loginButton);
    }

    public void checkIfIConnected(){
        wait.until(visibilityOf(imOnConnetedPage));
    }

}
