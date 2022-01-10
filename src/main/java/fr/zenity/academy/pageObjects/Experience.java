package fr.zenity.academy.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class Experience extends Page {

    @FindBy(xpath = "//table[@class='_cvkwaj']//td")
    private List<WebElement> allDates;

    @FindBy(css = "button[data-testid='header-tab-search-block-tab-true-EXPERIENCES']")
    private WebElement experienceBtn;

    @FindBy(className = "_rj7nx")
    private WebElement nearby;

    @FindBy(css = "div[data-testid='menuItemButton-experiences_guest_picker'] > ._1wp3mhe > ._w37zq5")
    private WebElement experiencesGuestPicker;

    @FindBy(css = "div[data-testid='menuItemButton-price_range'] > ._1wp3mhe")
    private WebElement priceRange;

    @FindBy(css = "button[data-testid='stepper-adults-increase-button']")
    private WebElement increaseBtnAdults;

    @FindBy(css = "button[data-testid='pdp-save-button-unsaved']")
    private WebElement buttonSave;

    @FindBy(className = "_j02f84")
    private WebElement btnWishes;

    @FindBy(css = "button[data-testid='stepper-children-increase-button']")
    private WebElement increaseBtnChildren;

    @FindBy(css = "button[data-testid='stepper-infants-increase-button']")
    private WebElement increaseBtnInfants;

    @FindBy(css = "span[data-testid='filterItem-experiences_guest_picker-stepper-adults-0-value']")
    private WebElement initialValueGuestAdults;

    @FindBy(css = "span[data-testid='filterItem-experiences_guest_picker-stepper-children-0-value']")
    private WebElement initialValueGuestChildrenn;

    @FindBy(css = "span[data-testid='filterItem-experiences_guest_picker-stepper-infants-0-value']")
    private WebElement initialValueGuestInfants;

    @FindBy(css = "button[data-testid='filter-panel-save-button']")
    private WebElement btnSave;

    @FindBy(css = "#filter-panel-save-button")
    private WebElement btnSavedPrice;

    @FindBy(css = "#price_filter_min")
    private WebElement btnPriceFilterMinus;

    @FindBy(css = "#price_filter_max")
    private WebElement btnPriceFilterPlus;

    @FindBy(css = "#bigsearch-query-location-input")
    private WebElement whereAreYouGoing;

    @FindBy(css = "#loading-row-title")
    private WebElement listExist;


    @FindBy(xpath = "//*[@id=\"loading\"]/div")
    private List<WebElement> favoriteLists;

    @FindBy(xpath = "//div[@class='_1lds9wb']")
    private List<WebElement> checkMonth;

    @FindBy(css = "//div[@class='_1svux14']")
    private List<WebElement> checkMonth2;

    @FindBy(css = "table[class='_cvkwaj']")
    List<WebElement> listOfDates;

    @FindBy(className = "_m9v25n")
    private WebElement searchBtn;

    @FindBy(css = "div[data-section-id='EXPLORE_WIDE_FILTER_BAR']")
    private WebElement filterBar;

    @FindBy(css = "div[data-testid='main-cookies-banner-container']")
    private WebElement cookiesWindow;

    @FindBy(css = "button[data-testid='accept-btn']")
    private WebElement acceptBtn;

    @FindBy(xpath = "//table[@class='_cvkwaj']//td")
    List<WebElement> checkinSuggestion;

    @FindBy(className = "l1mixh70")
    private WebElement seanceNewWindow;

    @FindBy(css = "button[data-testid='social-auth-button-email']")
    private WebElement connectToEmail;

    @FindBy(css = "input[data-testid='email-login-email']")
    private WebElement emailLogin;

    @FindBy(css = "button[data-testid='signup-login-submit-btn']")
    private WebElement signinBtn;

    @FindBy(css = "#email-signup-password")
    private WebElement emailSignupPassword;

    @FindBy(xpath = "//button[@aria-label='Enregistrer cette expérience']")
    private WebElement unrecordedItem;

    @FindBy(xpath = "//*[@id=\"loading\"]/div/div[1]/div/div/img")
    private WebElement btnCreateList;

    @FindBy(className = "_1qbm6oii")
    private WebElement btnCreate;

    @FindBy(xpath = "//*[@id=\"recaptcha-anchor\"]/div[1]")
    private WebElement recaptCha;

    @FindBy(css = "#name-list-input-save-to-list-modal")
    private WebElement nameToList;


    public void iNavigateTo() {
        driver.get("https://www.airbnb.fr/");
        waitForPageLoading();
        if (waitUntil(driver -> visibilityOf(cookiesWindow))) {
            clickOn(acceptBtn);
        }
    }

    public void setExperience(String endDate) throws InterruptedException {
        wait.until(visibilityOf(experienceBtn));
        experienceBtn.click();
        wait.until(visibilityOf(whereAreYouGoing));
        whereAreYouGoing.click();
        wait.until(visibilityOf(nearby));
        nearby.click();
        List<WebElement> tdList = driver.findElements(By.xpath("//*[@id=\"search-tabpanel\"]/div/div[3]/div[2]/div/section/div/div/div/div/div/div/div[2]/div[2]/div/div[3]/div/table//td"));
        DateUtil.clickGivenDay(allDates, DateUtil.getCurrentDay());
        DateUtil.clickGivenDay(tdList, endDate);
        Thread.sleep(5000);
        searchBtn.click();

    }


    public void chooseGuest(String minPrice, String maxPrice) throws InterruptedException {
        Thread.sleep(5000);
        //Assert.assertTrue(false);
        experiencesGuestPicker.click();
        Thread.sleep(3000);

        wait.until(ExpectedConditions.visibilityOf(increaseBtnAdults));
        increaseBtnAdults.click();
        wait.until(ExpectedConditions.visibilityOf(increaseBtnChildren));
        increaseBtnChildren.click();
        wait.until(ExpectedConditions.visibilityOf(increaseBtnInfants));
        increaseBtnInfants.click();
        btnSave.click();


        priceRange.click();
        Thread.sleep(3000);
        js = (JavascriptExecutor) driver;

        wait.until(ExpectedConditions.visibilityOf(btnPriceFilterMinus));
        btnPriceFilterMinus.sendKeys(minPrice);
        js.executeScript("arguments[0].value='"+minPrice+"';", btnPriceFilterMinus);

        btnPriceFilterPlus.click();
        wait.until(ExpectedConditions.visibilityOf(btnPriceFilterPlus));
        js.executeScript("arguments[0].value='"+maxPrice+"';", btnPriceFilterPlus);
        Thread.sleep(3000);
        clickOn(btnSavedPrice);
        Thread.sleep(3000);
    }

    public void clickOnwishBtn(){
        wait.until(ExpectedConditions.visibilityOf(unrecordedItem));
        clickOn(unrecordedItem);
    }

    public void logged(String email, String password) throws InterruptedException {
        connectToEmail.click();
        longWait.until(ExpectedConditions.visibilityOf(emailLogin));
        emailLogin.sendKeys(email);
        longWait.until(ExpectedConditions.visibilityOf(signinBtn));
        clickOn(signinBtn);
        emailSignupPassword.sendKeys(password);
        longWait.until(ExpectedConditions.visibilityOf(signinBtn));
        clickOn(signinBtn);
    }

    public void clickOnRecaptcha() throws InterruptedException {

        if (waitUntil(driver -> visibilityOf(recaptCha))){
            System.out.println("captcha is displayed");
            clickOn(recaptCha);
            //driver.close();
        } else {
            System.out.println("recapcha does'nt  display..");
        }
        Thread.sleep(3000);

    }

    public void createList(String listName) throws InterruptedException {
        Thread.sleep(5000);

        System.out.println("input name list of favorite does'nt displayed");
        clickToList(favoriteLists,"My List");
    }

    //Add an item to an existing list
    public static void clickToList(List<WebElement> elementList, String listName) {
        elementList.stream()
                .filter(element -> element.getText().contains(listName))
                .findFirst()
                .ifPresent(WebElement::click);
    }

}
