package fr.zenity.academy.utils;

import fr.zenity.academy.manager.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.qameta.allure.Attachment;

public class Utils {


    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] takeScreenShot(String methodName) {
        return ((TakesScreenshot) WebDriverManager.getInstance().getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
