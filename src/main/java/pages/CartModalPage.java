package pages;

import core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static utils.LoggerMarkers.TEST;

public class CartModalPage extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(CartModalPage.class);

    private static final By cartModalLocator = By.cssSelector("rz-modal-layout.modal-layout");
    private static final By cartItemLocator = By.cssSelector("li.cart-list__item");

    @Step("Check if cart modal is visible")
    public boolean isModalVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(cartModalLocator));
            log.info(TEST, "Cart modal is visible");
            return true;
        } catch (TimeoutException e) {
            log.warn(TEST, "Cart modal did not appear");
            return false;
        }
    }

    @Step("Check if cart contains items")
    public boolean hasItemsInCart() {
        try {
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(cartItemLocator, 0));
            int count = driver.findElements(cartItemLocator).size();
            log.debug(TEST, "Items in cart: {}", count);
            return count > 0;
        } catch (TimeoutException e) {
            log.warn(TEST, "No items found in cart within the timeout");
            return false;
        }
    }

    @Step("Get first cart item title")
    public String getFirstCartItemTitle() {
        List<WebElement> items = driver.findElements(cartItemLocator);
        if (items.isEmpty()) {
            log.warn(TEST, "No items in cart to get title from");
            return "";
        }
        return items.get(0).getText();
    }
}
