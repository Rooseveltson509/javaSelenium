package fr.zenity.academy.listeners;

import fr.zenity.academy.manager.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.ByteArrayInputStream;
import java.util.UUID;

public class TestngListener implements ITestListener {
    private WebDriver driver;
    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    // Text attachments for Allure
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    // Text attachments for Allure
    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    // HTML attachments for Allure
    @Attachment(value = "{0}", type = "text/html")
    public static String attachHtml(String html) {
        return html;
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("I am in onStart method " + iTestContext.getName());
        iTestContext.setAttribute("WebDriver", driver);
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("I am in onFinish method " + iTestContext.getName());
        Allure.addAttachment(UUID.randomUUID().toString(), new ByteArrayInputStream(((TakesScreenshot)WebDriverManager.getInstance().getDriver()).getScreenshotAs(OutputType.BYTES)));

    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("I am in onTestStart method " + getTestMethodName(iTestResult) + " start");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("I am in onTestSuccess method " + getTestMethodName(iTestResult) + " succeed");
        saveScreenshotPNG(driver);
        Allure.addAttachment(UUID.randomUUID().toString(), new ByteArrayInputStream(((TakesScreenshot)WebDriverManager.getInstance().getDriver()).getScreenshotAs(OutputType.BYTES)));

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("I am in onTestFailure method " + getTestMethodName(iTestResult) + " failed");
        Object testClass = iTestResult.getInstance();
        Allure.addAttachment(UUID.randomUUID().toString(), new ByteArrayInputStream(((TakesScreenshot)WebDriverManager.getInstance().getDriver()).getScreenshotAs(OutputType.BYTES)));

        //WebDriver driver = WebDriverManager.getInstance().getDriver();
        // Allure ScreenShotRobot and SaveTestLog
        if (WebDriverManager.getInstance().getDriver() != null) {
            Allure.addAttachment(UUID.randomUUID().toString(), new ByteArrayInputStream(((TakesScreenshot)WebDriverManager.getInstance().getDriver()).getScreenshotAs(OutputType.BYTES)));

            System.out.println("Screenshot captured for test case:" + getTestMethodName(iTestResult));
            saveScreenshotPNG(driver);
        }
        // Save a log on allure.
        saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        saveScreenshotPNG(driver);
        Allure.addAttachment(UUID.randomUUID().toString(), new ByteArrayInputStream(((TakesScreenshot)WebDriverManager.getInstance().getDriver()).getScreenshotAs(OutputType.BYTES)));

        System.out.println("I am in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        saveScreenshotPNG(driver);
        Allure.addAttachment(UUID.randomUUID().toString(), new ByteArrayInputStream(((TakesScreenshot)WebDriverManager.getInstance().getDriver()).getScreenshotAs(OutputType.BYTES)));

        System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }
}
