package pageinteractions;

import constants.Url;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.time.Duration;

// The CommonInteractions class contains common interactions that you might use, regardless of the webpage or its contents
public class CommonInteractions {

    private WebDriver webDriver;

    public CommonInteractions(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public void navigateToURL (String url) {
        Reporter.log("Navigating to URL: " + url);
        webDriver.get(Url.automationPracticeWebsite);
    }

    public void waitForElementToBeClickable (By elementLocator) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
    }
}
