package fr.zenity.academy.pageObjects;

import fr.zenity.academy.manager.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
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

    public void clickJS(WebElement element){
        try {
            js.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            element.click();
        }
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
    public String getScreenshot() {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
        File destination = new File(path);
        try {
            FileUtils.copyFile(src, destination);
        } catch (IOException e) {
            System.out.println("Capture Failed " + e.getMessage());
        }
        return path;
    }

}

