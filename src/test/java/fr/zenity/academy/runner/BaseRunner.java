package fr.zenity.academy.runner;

import fr.zenity.academy.Enum.Browser;
import fr.zenity.academy.config.Properties;
import fr.zenity.academy.manager.WebDriverManager;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.Objects;

public class BaseRunner extends AbstractTestNGCucumberTests {

    @BeforeMethod
    public void setUp(@Optional String browser) {
        System.out.println("------------------------------------ Tests are starting! ---------------------------------------------n");
        WebDriverManager
                .getInstance()
                .setDriver(Objects.isNull(browser) ? Properties.Config.getBrowser() : Browser.valueOf(browser.toUpperCase()));
        System.out.println("-------------------------------INIT " + browser + "  --------------------------------------------------n");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("-------------------------------IN TEAR DOWN--------------------------------------------------n");
        WebDriverManager.getInstance().quit();
        System.out.println("-------------------------------INIT--------------------------------------------------n");
    }
}
