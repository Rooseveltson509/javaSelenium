package fr.zenity.academy.config;

import fr.zenity.academy.Enum.Browser;
import fr.zenity.academy.Enum.Urls;

public class PropertiesConfig {

    private final static PropertiesConfig INSTANCE = new PropertiesConfig();

    private final PropertiesLoader prop            = PropertiesLoader.of("config");

    private Boolean headless;
    private Browser browser;
    private String proxy;
    private Boolean isProxy;

    private Urls environment;

    //
    private String webDriverPath;

    private PropertiesConfig(){
        String tmp;

        headless =  Boolean.valueOf(System.getProperty("headless",prop.getProperty("headless")));
        tmp = System.getProperty("browser", prop.getProperty("browser", "chrome" ));
        browser = Browser.valueOf(tmp.toUpperCase());

        isProxy  = prop.getProperty("isProxy", false);
        proxy    = prop.getProperty("proxy");

        webDriverPath = prop.getProperty(browser.getBrowserName());

        tmp = System.getProperty("env",prop.getProperty("env","production")).toUpperCase();
        environment = Urls.valueOf(tmp);

    }

    public Boolean getHeadless() { return headless; }

    public Browser getBrowser() { return browser; }

    public String getWebDriverPath(){ return webDriverPath; }

    public String getProxy( ){ return proxy; }

    public Boolean getIsProxy(){ return isProxy; }

    public Urls getEnvironment(){ return environment; }

    public void setBrowser(String b){
        browser = Browser.valueOf(b.toUpperCase());
        webDriverPath = prop.getProperty(browser.getBrowserName());
    }

    public static PropertiesConfig getInstance(){ return INSTANCE; }
}
