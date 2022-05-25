package testscript;

import constants.Url;
import datavalidationclass.ProductInformation;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageinteractions.*;

public class AddHighestPriceDressToCartTest {
    WebDriver webDriver;
    @Test
    public void addHighestPriceDressToCartTest() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        CommonInteractions onBrowser = new CommonInteractions(webDriver);
        AutomationPracticeHomePageInteractions onAutomationPracticeHomePage = new AutomationPracticeHomePageInteractions(webDriver);
        DressesPageInteractions onDressesPage = new DressesPageInteractions(webDriver);
        ProductInformationPageInteractions onProductInfoPage = new ProductInformationPageInteractions(webDriver);
        CartPageInteractions onCartPage = new CartPageInteractions(webDriver);
        try {
            // Main test code
            webDriver.manage().window().maximize(); // Maximises the Chrome window
            onBrowser.navigateToURL(Url.automationPracticeWebsite);
            onAutomationPracticeHomePage.navigateToDressesPage();
            onDressesPage.selectHighestPriceDress();
            ProductInformation highestPriceDressInfo = onProductInfoPage.recordProductDetails();
            onProductInfoPage.addProductToCart();
            onProductInfoPage.clickProceedToCheckoutButtonFromPopup();
            onCartPage.checkThatItemIsInCart(highestPriceDressInfo);
            Reporter.log("addHighestPriceDressTestToCart test completed successfully");
        } catch (Exception e) {
            // In case of an exception, log it and fail the test
            Reporter.log("Exception thrown: " + e.getMessage());
            Assert.fail("Failed due to exception thrown");
        } finally {
            // Make sure the WebDriver instance always gets closed in the end
            webDriver.quit();
        }
    }
}