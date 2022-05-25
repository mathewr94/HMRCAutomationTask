package pageinteractions;

import datavalidationclass.ProductInformation;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import page.ProductInformationPage;

// The ProductInformationPageInteractions class contains interactions that you might use on the product information page
public class ProductInformationPageInteractions extends CommonInteractions {

    private WebDriver webDriver;

    public ProductInformationPageInteractions (WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }

    public ProductInformation recordProductDetails() {
        Reporter.log("Recording all product info into a data validation object, for validation later on");
        ProductInformation productInformation = new ProductInformation();
        productInformation.setProductSKU(getProductSKU());
        productInformation.setProductName(getProductName());
        productInformation.setProductPrice(getProductPrice());
        productInformation.setProductQuantity(getProductQuantity());
        return productInformation;
    }

    private String getProductSKU () {
        return webDriver.findElement(ProductInformationPage.productSKULabel).getText();
    }

    private String getProductName () {
        return webDriver.findElement(ProductInformationPage.productNameH1).getText();
    }

    private String getProductPrice () {
        return webDriver.findElement(ProductInformationPage.productPriceLabel).getText();
    }

    private int getProductQuantity () {
        final String productQuantityAsString = webDriver.findElement(ProductInformationPage.productQuantityValue).getAttribute("value");
        return Integer.parseInt(productQuantityAsString);
    }

    public void addProductToCart () {
        final String productName = webDriver.findElement(ProductInformationPage.productNameH1).getText();
        Reporter.log("Adding the " + productName + " product to the cart");
        webDriver.findElement(ProductInformationPage.addToCartButton).click();
    }

    public void clickProceedToCheckoutButtonFromPopup () {
        Reporter.log("Clicking the Proceed to checkout button from the popup that appears after adding a product to the cart");
        waitForElementToBeClickable(ProductInformationPage.proceedToCheckoutButton);
        webDriver.findElement(ProductInformationPage.proceedToCheckoutButton).click();
    }
}
