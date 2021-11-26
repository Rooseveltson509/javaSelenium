package fr.zenity.academy.PageObjects;

import fr.zenity.academy.manager.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;


public abstract class Page {

    /***
     * Driver
     */
    protected WebDriver driver;
    /**
     * Waiter
     * */
    protected WebDriverWait wait;
    protected WebDriverWait shortWait;
    protected WebDriverWait middleWait;
    protected WebDriverWait longWait;
    /**
     * JS
     * */
    protected JavascriptExecutor js;
    /***
     * Actions
     */
    protected Actions action;

    /**
     * logger
     */
    private static final Logger LOG = Logger.getLogger(Page.class);


    protected Page(){

        driver = WebDriverManager.getInstance().getDriver();
        PageFactory.initElements(driver,this);

        wait        = new WebDriverWait(driver, Duration.ofSeconds(5));
        shortWait   = new WebDriverWait(driver, Duration.ofSeconds(10));
        middleWait  = new WebDriverWait(driver, Duration.ofSeconds(15));
        longWait    = new WebDriverWait(driver, Duration.ofSeconds(30));

        js          = (JavascriptExecutor)driver;
        action      = new Actions(driver);

    }

    public void clickOn(WebElement element ){
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void maximize(){ driver.manage().window().maximize(); }

    protected void waitForPageLoading(){
        if (!middleWait.until(condition -> js.executeScript("return document.readyState").equals("complete") || js.executeScript("return document.readyState").equals("interactive"))) {
            LOG.warn("Page not completely loaded after a loading wait");
            return;
        }
        LOG.debug("Page loading wait successfull");
    }

    public <V> boolean waitUntil(Function<? super WebDriver, V> isTrue){
        try {
            wait.until(isTrue);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public <V> boolean shortWaitUntil(Function<? super WebDriver, V> isTrue){
        try {
            shortWait.until(isTrue);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public <V> boolean middleWaitUntil(Function<? super WebDriver, V> isTrue){
        try {
            shortWait.until(isTrue);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public <V> boolean longWaitUntil(Function<? super WebDriver, V> isTrue){
        try {
            shortWait.until(isTrue);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}

