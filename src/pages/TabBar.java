package pages;

import framework.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


/**
 * Created by Rina Espinoza on 8/8/2015.
 */
public class TabBar extends BasePage {

    @FindBy(linkText = "Accounts")
    @CacheLookup
    private WebElement accountsLinkText;

    @FindBy(linkText = "Opportunities")
    @CacheLookup
    private WebElement oppLinkText;

    public TabBar(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public TabPage clickAccountLinkText() {
        wait.until(ExpectedConditions
                .visibilityOf(accountsLinkText));
        accountsLinkText.click();
        return new TabPage(driver);
    }

    public TabPage clickOppLinkText() {
        wait.until(ExpectedConditions
                .visibilityOf(oppLinkText));
        oppLinkText.click();
        return new TabPage(driver);
    }
}
