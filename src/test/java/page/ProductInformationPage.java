package page;

import org.openqa.selenium.By;

// The ProductInformationPage class contains locators for elements which are on the product information page
public class ProductInformationPage {
    public static final By productNameH1 = By.xpath("//h1[@itemprop='name']");
    public static final By addToCartButton = By.xpath("//span[text()='Add to cart']/..");
    public static final By proceedToCheckoutButton = By.xpath("//a[@title='Proceed to checkout']");
    public static final By productSKULabel = By.xpath("//span[@itemprop='sku']");
    public static final By productPriceLabel = By.id("our_price_display");
    public static final By productQuantityValue = By.xpath("//input[@id='quantity_wanted']");
}
