package fr.zenity.academy.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class AddProductPage extends Page{
    public String myProduct;

    @FindBy(css = "#toSell")
    private WebElement linkToAddProduct;

    @FindBy(css = "#title")
    private WebElement wTitle;

    @FindBy(css = "form.ng-untouched > input:nth-child(3)")
    private WebElement fileName;

    @FindBy(css = "#price")
    private WebElement wPrice;

    @FindBy(css = "#description")
    private WebElement wDescription;

    @FindBy(css = "#createNew")
    private WebElement btncreateNew;


    @FindBy(css = "#title-product")
    private List<WebElement> productItem;



public void goToAddProductPage(){
    longWaitUntil(visibilityOf(linkToAddProduct));
    linkToAddProduct.click();
}
    public void addProduct(String title, String price, String description) throws InterruptedException {

        WebElement chooseFile = driver.findElement(By.xpath("/html/body/app-root/app-new-thing-with-upload/div/mat-card/form/input"));
        //chooseFile.sendKeys("C:\\Users\\roose\\javaSelenium\\src\\test\\resources\\data\\img\\iphoeXS.jpg");


        longWaitUntil(visibilityOf(wTitle));
        wTitle.click();
        wTitle.sendKeys(title);

        myProduct = title;
        chooseFile.sendKeys("C:\\Users\\roose\\javaSelenium\\src\\test\\resources\\data\\img\\iphoeXS.jpg");

        longWaitUntil(visibilityOf(wPrice));
        wPrice.click();
        wPrice.clear();
        wPrice.sendKeys(price);

        longWaitUntil(visibilityOf(wDescription));
        wDescription.click();
        wDescription.sendKeys(description);

        Thread.sleep(5000);
    }

    public void openProductCreated() throws InterruptedException {
        chooseAProductToTheList(productItem, myProduct);
    }

    public void backToCatalogue(){
        /*longWaitUntil(visibilityOf(backToCatalogue));
        backToCatalogue.click();*/
    }
    public void submit() {
        longWaitUntil(visibilityOf(btncreateNew));
        btncreateNew.click();
    }
}
