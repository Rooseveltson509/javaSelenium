package fr.zenity.academy.drivers;


import fr.zenity.academy.Enum.Browser;
import fr.zenity.academy.config.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverFactory implements DriverFactoryImpl {

    private final WebDriver driver;

    public DriverFactory(Browser browser){
        driver = createDriver(browser);
    }

    @Override
    public void close() { driver.close(); }

    @Override
    public void quit() { driver.quit(); }

    @Override
    public WebDriver getDriver() { return driver; }

    private WebDriver createDriver(Browser browser){

        System.setProperty(browser.webDriverProp(), browser.webDriverPath());

        return Browser.FIREFOX.equals(browser) ?
                new FirefoxDriver(firefoxOptions()) :
                new ChromeDriver(chromeOptions());
    }
}

