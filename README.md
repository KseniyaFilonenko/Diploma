Author - Kseniya Filonenko

Project for belita-shop.by - B2C E-Commerce website of Belarusian cosmetics, 
which can be purchased by customers from Belarus and Russia.

Project structure:
1. BasePage - created for WebDriver
2. HomePage - selectors, constructors and methods on the Home page (extends BasePage)
3. LoginPage - selectors, constructors and methods on the Login page (extends BasePage)
4. SearchPage - selectors, constructors and methods on the Search page (extends BasePage)
5. TestListeners - created for listeners with LOGGERs
6. ApiTest - created for API tests
7. BaseTest - created for Before- and AfterMethod for UI tests
8. WebsiteTest - created for UI tests
9. allure properties - to use Allure report
10. json resources - to use json parameters in UI test
11. testsuites resources - to create two .xml files for UI and API tests separately
12. log4j2.properties - to use LOGGERs
13. DriverFactory - for Chrome and Firefox drivers
14. ScreenshotUtils - for screenshots