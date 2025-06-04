package steps;

import core.TestSetup;
import io.cucumber.java.en.*;
import pages.CartModalPage;
import pages.HomePage;
import pages.ProductPage;

import static org.junit.Assert.assertTrue;

public class AddToCartSteps {

    HomePage homePage;
    ProductPage productPage;
    CartModalPage cartModalPage;

    @Given("User is on the Home page")
    public void userIsOnHomePage() {
        homePage = TestSetup.factory.get(HomePage.class);
        productPage = TestSetup.factory.get(ProductPage.class);
        cartModalPage = TestSetup.factory.get(CartModalPage.class);
        TestSetup.driver.get("https://rozetka.com.ua/");
    }

    @When("User performs search for {string}")
    public void userPerformsSearchForProduct(String productName) {
        homePage.searchFor(productName);
        assertTrue("Search results are not displayed", homePage.areCategoryItemsPresent());
    }

    @When("User selects the first product from the search results")
    public void userSelectsFirstProduct() {
        homePage.clickFirstProduct();
    }

    @When("User adds the product to the cart")
    public void userAddsProductToCart() {
        productPage.addToCart();
    }

    @When("User opens the cart")
    public void userOpensCart() {
        productPage.openCart();
    }

    @Then("The cart should display at least one item")
    public void cartShouldDisplayItems() {
        assertTrue("Cart modal is not visible", cartModalPage.isModalVisible());
        assertTrue("Cart is empty", cartModalPage.hasItemsInCart());
    }

    @Then("The first item in the cart should contain {string}")
    public void firstItemInCartShouldContain(String expectedProductName) {
        String actualProductTitle = cartModalPage.getFirstCartItemTitle();
        assertTrue("Product name mismatch in cart",
                actualProductTitle.toLowerCase().contains(expectedProductName.toLowerCase()));
    }
}
