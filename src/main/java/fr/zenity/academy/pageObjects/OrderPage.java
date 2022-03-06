package fr.zenity.academy.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class OrderPage extends Page{


    @FindBy(css = "#title-product")
    private List<WebElement> productItem;

    @FindBy(css = "#catalogue")
    private WebElement backToCatalogue;



    //check an item to an existing list
    public void chooseProductToList(String name) throws InterruptedException {
        Thread.sleep(3000);
        WebElement el = productItem.stream()
                .filter(element -> name.equals(element.getText()))
                .findFirst().get();

        el.click();
        Thread.sleep(3000);
        longWaitUntil(visibilityOf(backToCatalogue));
        backToCatalogue.click();
    }

    //check an item to an existing list
    public void chooseProductToList2(String name) throws InterruptedException {
        Thread.sleep(3000);
        WebElement el = productItem.stream()
                .filter(element -> name.equals(element.getText()))
                .findFirst().get();

        el.click();
        Thread.sleep(3000);
    }

}
