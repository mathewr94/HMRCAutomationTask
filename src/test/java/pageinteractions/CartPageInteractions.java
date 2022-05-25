package pageinteractions;

import datavalidationclass.ProductInformation;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import page.CartPage;

// The CartPageInteractions class contains interactions that you might use on the cart page
public class CartPageInteractions extends CommonInteractions {

    private WebDriver webDriver;

    public CartPageInteractions(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }

    public void checkThatItemIsInCart(ProductInformation expectedProductInfo) {
        Reporter.log("Checking that the " + expectedProductInfo.getProductName() + " product with SKU " + expectedProductInfo.getProductSKU() + " is in the cart");
        final int numberOfItemsInCart = webDriver.findElements(CartPage.cartRows).size();
        // Traverse all items in the cart and attempt to match to the expectedProductInfo provided
        ProductInformation cartItemProductInfo;
        for (int item = 1; item <= numberOfItemsInCart; item++) {
            cartItemProductInfo = getCartItemProductInfoByIndex(item);
            if (cartItemMatchesExpectedProduct(cartItemProductInfo, expectedProductInfo)) {
                Reporter.log("Success: The " + expectedProductInfo.getProductName() + " product with SKU " + expectedProductInfo.getProductSKU() + " is in the cart");
                return;
            }
        }
        Reporter.log("Fail: The " + expectedProductInfo.getProductName() + " product with SKU " + expectedProductInfo.getProductSKU() + " is not in the cart");
        Assert.fail();
    }

    private ProductInformation getCartItemProductInfoByIndex (int index) {
        ProductInformation cartItemProductInfo = new ProductInformation();
        cartItemProductInfo.setProductSKU(webDriver.findElement(CartPage.getProductSKUByIndex(index)).getText().split(":")[1].trim()); // The full label text will always contain "SKU : " before the SKU #, so take everything after the : symbol and trim whitespace
        cartItemProductInfo.setProductName(webDriver.findElement(CartPage.getProductNameByIndex(index)).getText());
        cartItemProductInfo.setProductPrice(webDriver.findElement(CartPage.getProductPriceByIndex(index)).getText());
        cartItemProductInfo.setProductQuantity(Integer.parseInt(webDriver.findElement(CartPage.getProductQuantityByIndex(index)).getAttribute("value")));
        return cartItemProductInfo;
    }

    private boolean cartItemMatchesExpectedProduct(ProductInformation cartItemProductInfo, ProductInformation expectedProductInfo) {
        boolean skuValuesMatch = false;
        boolean nameValuesMatch = false;
        boolean priceValuesMatch = false;
        boolean quantityValuesMatch = false;
        if (cartItemProductInfo.getProductSKU().equals(expectedProductInfo.getProductSKU())) {
            skuValuesMatch = true;
        } else {
            Reporter.log("cart item SKU = " + cartItemProductInfo.getProductSKU() + ", expected product SKU = " + expectedProductInfo.getProductSKU() + ".");
        }

        if (cartItemProductInfo.getProductName().equals(expectedProductInfo.getProductName())) {
            nameValuesMatch = true;
        } else {
            Reporter.log("cart item name = " + cartItemProductInfo.getProductName() + ", expected product name = " + expectedProductInfo.getProductName() + ".");
        }

        if (cartItemProductInfo.getProductPrice().equals(expectedProductInfo.getProductPrice())) {
            priceValuesMatch = true;
        } else {
            Reporter.log("cart item price = " + cartItemProductInfo.getProductPrice() + ", expected product price = " + expectedProductInfo.getProductPrice() + ".");
        }

        if (cartItemProductInfo.getProductQuantity() == expectedProductInfo.getProductQuantity()) {
            quantityValuesMatch = true;
        } else {
            Reporter.log("cart item quantity = " + cartItemProductInfo.getProductQuantity() + ", expected product quantity = " + expectedProductInfo.getProductQuantity() + ".");
        }

        return skuValuesMatch && nameValuesMatch && priceValuesMatch && quantityValuesMatch;
    }
}
