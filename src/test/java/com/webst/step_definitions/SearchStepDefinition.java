package com.webst.step_definitions;

import com.webst.pages.WebstMainPage;
import com.webst.utils.CR;
import com.webst.utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class SearchStepDefinition {

    // Creating an instance of the WebstMainPage class
    WebstMainPage wmp = new WebstMainPage();
    // Creating an instance of the Actions class for mouse and keyboard actions
    Actions actions = new Actions(Driver.getDriver());

    @Given("User is on the Webstaurant Store Main Page")
    public void user_is_on_the_webstaurant_store_main_page() {

        // Navigate to the Webstaurant Store Main Page using the WebDriver instance
        Driver.getDriver().get(CR.getProperty("webst"));

    }

    @When("User search for {string}")
    public void user_search_for(String string) {

        // Perform a search by interacting with the search bar element.
        actions.moveToElement(wmp.searchBar).click().sendKeys("stainless work table" + Keys.ENTER).perform();

    }

    @When("User check the search result ensuring every product has the word {string} in its title")
    public void user_check_the_search_result_ensuring_every_product_has_the_word_in_its_title(String string) {

        // Retrieve a list of search result elements
        List<WebElement> tableItems = wmp.searchResult;

        String table = "table";

        // Loop through the search results and verify that each contains the word "table" in its title
        for (WebElement web : tableItems) {

            Assert.assertTrue("ERROR: DOES NOT CONTAIN 'TABLE'", web.getText().toLowerCase().contains(table));

        }
    }

    @When("User add last of found items to cart")
    public void user_add_last_of_found_items_to_cart() {

        // Identify the last item in the search results and add it to the cart
        int lastElement = wmp.addToCart.size() - 1;

        WebElement lastItem = wmp.addToCart.get(lastElement);

        actions.moveToElement(lastItem).click().perform();

        // Click on the "View Cart" button to go to the shopping cart page
        actions.moveToElement(wmp.viewCart).click().perform();

    }

    @Then("User Empty Cart")
    public void user_empty_cart() {

        // Click on the "Empty Cart" button and then the final confirmation button
        actions.moveToElement(wmp.emptyCart).click().perform();
        actions.moveToElement(wmp.emptyCartFinal).click().perform();

        // Assert that the cart is empty by verifying the displayed text
        Assert.assertEquals("ERROR: CART IS NOT EMPTY", wmp.emptyCartText.getText(), "Your cart is empty.");

    }

}
