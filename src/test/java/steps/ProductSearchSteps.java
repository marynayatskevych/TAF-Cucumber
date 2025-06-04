package steps;

import core.TestSetup;
import io.cucumber.java.en.*;
import model.Product;
import model.ProductBuilder;
import pages.HomePage;
import pages.ProductPage;

import static org.junit.Assert.assertTrue;

public class ProductSearchSteps{

    HomePage homePage = TestSetup.factory.get(HomePage.class);
    ProductPage productPage = TestSetup.factory.get(ProductPage.class);
    String searchTerm;
    String actualProductTitle;

    @When("User searches for {string}")
    public void userSearchesFor(String searchTerm) {
        this.searchTerm = searchTerm;
        homePage.searchFor(searchTerm);
    }

    @Then("The search results should be visible")
    public void theSearchResultsShouldBeVisible() {
        assertTrue("Item list with items doesn't appear", homePage.isSearchResultVisible());
    }

    @Then("The first search result should contain {string}")
    public void theFirstSearchResultShouldContain(String searchTerm) {
        assertTrue("First item doesn't contain current word", homePage.firstProductContains(searchTerm));
    }

    @When("User clicks on the first filtered product")
    public void userClicksOnTheFirstFilteredProduct() {
        homePage.clickFirstFilteredProduct();
    }

    @Then("The product page should display title containing {string}")
    public void theProductPageShouldDisplayTitleContaining(String expectedTerm) {
        actualProductTitle = productPage.getProductTitle();

        Product expected = ProductBuilder.builder()
                .withName(expectedTerm)
                .build();
        Product actual = ProductBuilder.builder()
                .withName(actualProductTitle)
                .build();

        assertTrue(
                "Product name does not contain search term",
                actual.getName().toLowerCase().contains(expected.getName().toLowerCase())
        );
    }
}

