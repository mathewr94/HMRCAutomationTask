package page;

import org.openqa.selenium.By;

// The DressesPage class contains locators for elements which are on the Dresses page
public class DressesPage {
    public static final By dressPrices = By.xpath("//div[@class='right-block']//span[@itemprop='price']");
    public static By getProductNameByIndex (int index) {
        return By.xpath("(//div[@class='right-block']//a[@class='product-name'])[" + index + "]");
    }
    public static final By addToCartButtons = By.xpath("//a[@title='Add to cart']");
}
