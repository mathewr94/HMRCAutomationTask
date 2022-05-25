package page;

import org.openqa.selenium.By;

// The DressesPage class contains locators for elements which are on the Dresses page
public class DressesPage {
    public static final By dressPrices = By.cssSelector("div.right-block > div.content_price > span.price");
    public static By getDressNameByIndex(int index) {
        return By.xpath("(//div[@class='right-block']//a[@class='product-name'])[" + index + "]");
    }
}
