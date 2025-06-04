**Cucumber (BDD) and JUnit** project demonstrates how to use Cucumber for Behavior-Driven Development (BDD) in conjunction with JUnit for testing.

## Acceptance Criteria

| Acceptance Criteria | Where Implemented / How |
|:--|:--|
| **Use `Scenario Outline` and `Examples:`** | `features/add_to_cart.feature`, `features/product_search.feature` <br> - `Scenario Outline` with `<productName>`, `<searchTerm>` <br> - `Examples:` provides multiple test data rows |
| **Apply `Background` keyword** | `features/add_to_cart.feature`, `features/filter_by_brand.feature`, `features/product_search.feature` <br> - `Background` defines preconditions like `Given User is on the Home page` |
| **Use parameterization and regular expressions in step definitions** | `steps/AddToCartSteps.java`, `steps/FilterByBrandSteps.java`, `steps/ProductSearchSteps.java` <br> - Gherkin steps parameterized with `{string}` |
| **Step Definitions (`steps`)** | `src/test/java/steps/` <br> - Contains step definition classes implementing test steps |
| **Setup and Driver Management (`core`)** | `src/test/java/core/` <br> - `DriverFactory.java`, `TestSetup.java`, `PageFactoryManager.java`, `BasePage.java` |
| **Page Object Classes (`pages`)** | `src/main/java/pages/` <br> - `HomePage.java`, `ProductPage.java`, `CartModalPage.java` implementing page elements and actions |

---

## Technologies Used

- **Java**
- **Maven**
- **Selenium WebDriver**
- **JUnit 4**
- **Cucumber**
- **WebDriverManager**
- **Page Object Model (POM)**
- **Gherkin** (for feature files)
- **Allure** (optional, for reporting)
