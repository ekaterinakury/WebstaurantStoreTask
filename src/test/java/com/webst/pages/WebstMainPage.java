package com.webst.pages;

import com.webst.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebstMainPage {

    public WebstMainPage(){
        // Constructor to initialize PageFactory elements with the driver
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//div[@class='hidden flex-1 ml-0 lt:flex max-w-[900px]']//input[@id='searchval']")
    public WebElement searchBar;

    // List of WebElements representing search result
    @FindBy (xpath = "//span[@data-testid='itemDescription']")
    public List<WebElement> searchResult;

    // List of WebElements representing "Add to Cart" buttons
    @FindBy (xpath = "//input[@name='addToCartButton']")
    public List<WebElement> addToCart;

    @FindBy (xpath = "//a[@class='btn btn-small btn-primary']")
    public WebElement viewCart;

    @FindBy (xpath = "//button[@class='emptyCartButton btn btn-mini btn-ui pull-right']")
    public WebElement emptyCart;

    @FindBy (xpath = "//div/footer/button[1]")
    public WebElement emptyCartFinal;

    @FindBy (xpath = "//p[@class='header-1']")
    public WebElement emptyCartText;
}
