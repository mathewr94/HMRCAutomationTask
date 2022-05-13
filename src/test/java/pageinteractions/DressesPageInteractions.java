package pageinteractions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import page.DressesPage;

import java.util.List;

// The DressesPageInteractions class contains interactions that you might use on the Dresses page
public class DressesPageInteractions extends CommonInteractions {

    private WebDriver webDriver;

    public DressesPageInteractions (WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }
    public void selectHighestPriceDress() {
        final int indexOfHighestPriceDress = getIndexOfHighestPriceDress();
        Reporter.log("Selecting the highest price dress");
        final By highestPriceDressNameLocator = DressesPage.getProductNameByIndex(indexOfHighestPriceDress);
        WebElement highestPriceDressNameElement = webDriver.findElement(highestPriceDressNameLocator);
        // Scroll to the name of the highest price dress and click it
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView(true);", highestPriceDressNameElement);
        highestPriceDressNameElement.click();
    }

    private int getIndexOfHighestPriceDress () {
        Reporter.log("Finding the highest price dress");
        int highestPriceDressIndex = 0;
        float highestDressPrice = 0.0f;
        String highestPriceDressName = "";
        // Get all dress price web elements as a list
        List<WebElement> dressPriceElements = webDriver.findElements(DressesPage.dressPrices);
        // Presence check validation (ensuring there are dress prices on the page at all)
        final int dressPriceElementsSize = dressPriceElements.size();
        Assert.assertTrue(dressPriceElementsSize > 0, "There are no dress prices on the page");
        // Traverse the dress price web elements and record the index of the dress with highest price
        for (int i = 0; i < dressPriceElementsSize; i++) {
            final String currentDressPriceString = dressPriceElements.get(i).getText(); // Still contains $ symbol and potential whitespace
            final float currentDressPrice = convertDressPriceStringToFloat(currentDressPriceString);
            if (currentDressPrice > highestDressPrice) {
                highestDressPrice = currentDressPrice;
                highestPriceDressIndex = i + 1; // xPath indexes start at 1, not 0, so the index taken from the WebElement list needs to be incremented
                highestPriceDressName = webDriver.findElement(DressesPage.getProductNameByIndex(highestPriceDressIndex)).getText();
            }
        }
        Reporter.log("Highest price dress found; Name = " + highestPriceDressName + ", Price = " + highestDressPrice);
        return highestPriceDressIndex;
    }

    private float convertDressPriceStringToFloat (String dressPriceString) {
        dressPriceString = dressPriceString.replace("$", ""); // Remove the $ symbol from the price
        dressPriceString = dressPriceString.trim(); // Remove any potential whitespace from the price
        return Float.parseFloat(dressPriceString);
    }
}
