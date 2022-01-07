package fr.zenity.academy.runner;

import fr.zenity.academy.Enum.Browser;
import fr.zenity.academy.config.Properties;
import fr.zenity.academy.manager.WebDriverManager;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.ByteArrayInputStream;
import java.util.Objects;
import java.util.UUID;

//@Listeners({TestAllureListener.class})
//@Listeners({TestngListener.class})
public class BaseRunner extends AbstractTestNGCucumberTests {
    private WebDriver driver;

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(@Optional String browser) {
        System.out.println("------------------------------------ Tests are starting! ---------------------------------------------n");
        WebDriverManager
                .getInstance()
                .setDriver(Objects.isNull(browser) ? Properties.Config.getBrowser() : Browser.valueOf(browser.toUpperCase()));
        System.out.println("-------------------------------INIT " + browser + "  --------------------------------------------------n");
    }

    /*@Attachment(value = "Screenshot", type = "image/png")
    public byte[] takeScreenShot(String methodName) {
        return ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.BYTES);
    }*/

    @AfterMethod
    public void tearDown(/*ITestResult result*/)/* throws InterruptedException*/ {
        //Thread.sleep(10000);
            /*if(ITestResult.FAILURE == result.getStatus()){
                Allure.addAttachment(UUID.randomUUID().toString(), new ByteArrayInputStream(((TakesScreenshot)WebDriverManager.getInstance().getDriver()).getScreenshotAs(OutputType.BYTES)));
                //Assert.fail("ERROR");
                System.out.println("SCREENSHOT TAKEN");
                System.out.println("<<<<<<<<<<<<<< "+ITestResult.SUCCESS+" >>>>>>>>>>>>>>");
            }*/
        System.out.println("-------------------------------IN TEAR DOWN--------------------------------------------------n");
        WebDriverManager.getInstance().quit();
        System.out.println("-------------------------------INIT--------------------------------------------------n");
    }
}
