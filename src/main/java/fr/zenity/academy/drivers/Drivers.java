package fr.zenity.academy.drivers;

import org.openqa.selenium.WebDriver;
public interface Drivers {

    void close();

    void quit();

    WebDriver getDriver();
}

