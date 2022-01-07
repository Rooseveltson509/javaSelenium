package fr.zenity.academy.drivers;

import fr.zenity.academy.config.Properties;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.Objects;

public interface DriverFactoryImpl extends Drivers{
    default ChromeOptions chromeOptions(){
        ChromeOptions options = new ChromeOptions();

        // SSL -
        options.setAcceptInsecureCerts(true);
        options.setHeadless(Properties.Config.getHeadless());

        // Proxy
        if(Properties.Config.getIsProxy()){
            options.setProxy(getProxy());
        }
        //
        if(Properties.Config.getHeadless()){
            options.addArguments("window-size=1200,1100");
            options.addArguments("--headless");
            options.addArguments("--disabled-gpu");
        }

        //
        options.addArguments("-no-sandbox");
        options.addArguments("--disabled-infobars");
        options.addArguments("--disabled-browser-side-navigation");

        return options;
    }

    default FirefoxOptions firefoxOptions( ){
        FirefoxProfile profile = new FirefoxProfile();
        FirefoxOptions options = new FirefoxOptions();

        // SSL
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(true);

        // Profile SSL - HeadLess
        // options.setProfile(profile);
        options.setAcceptInsecureCerts(true);
        options.setHeadless(Properties.Config.getHeadless());
        options.setCapability("acceptSslCerts",true);

        return options;
    }
    /***
     *
     * @return proxy
     */
    default Proxy getProxy(){
        Proxy proxy = new Proxy();

        proxy.setSslProxy(Properties.Config.getProxy());
        proxy.setHttpProxy(Properties.Config.getProxy());
        proxy.setNoProxy("127.0.0.1;::1");

        return proxy;
    }

}
