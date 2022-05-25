package page;

import org.openqa.selenium.By;

// The ProductInformationPage class contains locators for elements which are on the product information page
public class ProductInformationPage {
    public static final By productNameH1 = By.cssSelector("h1[itemprop=name]");
    public static final By productSKULabel = By.cssSelector("#product_reference > span");
    public static final By productPriceLabel = By.id("span#our_price_display");
    public static final By productQuantityValue = By.id("input#quantity_wanted");
    public static final By addToCartButton = By.cssSelector("#add_to_cart > button");
    public static final By proceedToCheckoutButton = By.cssSelector("a[title='Proceed to checkout']");
}
