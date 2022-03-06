package fr.zenity.academy.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Page{

    @FindBy(css = "logo > img ")
    private WebElement imageLogo;




    public void iNavigateTo() {
        driver.get("http://localhost:8000/");
        waitForPageLoading();
    }

    public boolean checkImg(){
        System.out.println("get attribute img: " + imageLogo.getAttribute("src"));
         CheckImage(imageLogo);
         return true;
    }

}
