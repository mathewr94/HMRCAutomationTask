package pageinteractions;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import page.AutomationPracticeHomePage;

// The AutomationPracticeHomePageInteractions class contains interactions that you might use on the automation practice home page
public class AutomationPracticeHomePageInteractions extends CommonInteractions {

    private WebDriver webDriver;

    public AutomationPracticeHomePageInteractions (WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }
    public void navigateToDressesPage () {
        Reporter.log("Navigating from the Home page to the Dresses page");
        webDriver.findElement(AutomationPracticeHomePage.dressesNavBarItem).click();
    }
}
