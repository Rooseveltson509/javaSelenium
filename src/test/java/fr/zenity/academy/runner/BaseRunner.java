package fr.zenity.academy.runner;

import fr.zenity.academy.Enum.Browser;
import fr.zenity.academy.config.Properties;
import fr.zenity.academy.manager.WebDriverManager;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.*;

import java.util.Objects;


public class BaseRunner extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public void setUp(@Optional String browser) {
        System.out.println("------------------------------------ Tests are starting! ---------------------------------------------n");
        WebDriverManager
                .getInstance()
                .setDriver(Objects.isNull(browser) ? Properties.Config.getBrowser() : Browser.valueOf(browser.toUpperCase()));
        System.out.println("-------------------------------INIT " + browser + "  --------------------------------------------------n");
    }


    @AfterSuite
    public void tearDown() {
        System.out.println("-------------------------------IN TEAR DOWN--------------------------------------------------n");
        WebDriverManager.getInstance().quit();
        System.out.println("-------------------------------INIT--------------------------------------------------n");
    }
}
