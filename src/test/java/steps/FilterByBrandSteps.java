package steps;

import core.TestSetup;
import io.cucumber.java.en.*;
import model.Product;
import model.ProductBuilder;
import pages.HomePage;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class FilterByBrandSteps{

    HomePage homePage = TestSetup.factory.get(HomePage.class);
    List<Product> products;

    @When("User searches by keyword {string}")   // <-- изменили текст
    public void userSearchesByKeyword(String productName) {
        homePage.searchFor(productName);
    }

    @When("User applies filter for brand {string}")
    public void userAppliesFilterForBrand(String brandName) {
        homePage.selectBrand(brandName);
        products = homePage.getFilteredProductList();
    }

    @Then("All search results should contain brand {string}")
    public void allSearchResultsShouldContainBrand(String expectedBrand) {
        Product expected = ProductBuilder.builder()
                .withBrand(expectedBrand)
                .build();

        for (Product product : products) {
            assertTrue(
                    "Filtered product does not match expected brand: " + product.getName(),
                    product.getName().toLowerCase().contains(expected.getBrand().toLowerCase())
            );
        }
    }
}

