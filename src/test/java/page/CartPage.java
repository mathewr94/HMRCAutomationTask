package page;

import org.openqa.selenium.By;

// The CartPage class contains locators for elements which are on the cart page
public class CartPage {

    public static final By cartRows = By.cssSelector("table#cart_summary tbody tr");
    public static By getProductSKUByIndex (int index) {
        return By.xpath("(//td[@class='cart_description']//small[@class='cart_ref'])[" + index + "]");
    }
    public static By getProductNameByIndex (int index) {
        return By.xpath("(//td[@class='cart_description']//p[@class='product-name'])[" + index + "]");
    }
    public static By getProductPriceByIndex (int index) {
        return By.xpath("(//td[@class='cart_unit']//span[@class='price'])[" + index + "]");
    }
    public static By getProductQuantityByIndex (int index) {
        return By.xpath("(//td[@class='cart_quantity text-center']//input[@type='hidden'])[" + index + "]");
    }
}
