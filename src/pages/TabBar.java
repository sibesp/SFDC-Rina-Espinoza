package pages;

import framework.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by Rina Espinoza on 8/8/2015.
 */
public class TabBar extends BasePage {

    @FindBy(linkText = "Accounts")
    @CacheLookup
    private WebElement accountsLinkText;

    public TabBar(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public TabPage clickAccountLinkText() {
        accountsLinkText.click();
        return new TabPage(driver);
    }
}
