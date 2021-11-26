package fr.zenity.academy.manager;

import fr.zenity.academy.Enum.Browser;
import fr.zenity.academy.drivers.DriverFactory;
import fr.zenity.academy.drivers.Drivers;
import org.openqa.selenium.WebDriver;

public class WebDriverManager implements Drivers {

    private final static WebDriverManager INSTANCE = new WebDriverManager();

    private ThreadLocal<DriverFactory> driver = new ThreadLocal<>();

    protected WebDriverManager(){ }

    @Override
    public WebDriver getDriver( ){ return driver.get().getDriver(); }

    @Override
    public void close(){ driver.get().close(); }

    @Override
    public void quit(){ driver.get().quit(); }

    public void setDriver(Browser browser){
        driver.set(new DriverFactory(browser));
    }

    public void setDriver(String browser){
        setDriver(Browser.valueOf(browser.toUpperCase()));
    }

    public static WebDriverManager getInstance(){ return INSTANCE; }
}

