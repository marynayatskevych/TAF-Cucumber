package core;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class TestSetup {

    public static WebDriver driver;
    public static PageFactoryManager factory;

    @Before
    public void initializeTest() {
        driver = DriverFactory.getDriver();
        factory = new PageFactoryManager(driver);
        driver.get("https://rozetka.com.ua/");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            DriverFactory.closeDriver();
        }
    }
}
