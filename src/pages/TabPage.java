package pages;

import framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Rina Espinoza on 8/8/2015.
 */
public class TabPage extends BasePage {

    @FindBy(name = "new")
    @CacheLookup
    protected WebElement newBtn;

    @FindBy(linkText = "Create New View")
    @CacheLookup
    protected WebElement createNewViewLink;

    @FindBy(xpath = "//a[@title='Logout']")
    @CacheLookup
    private WebElement logout;

    //a[@title='Logout']
    public TabPage(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
    }

    public FormPage clickNewBtn() {
        wait.until(ExpectedConditions
                .visibilityOf(newBtn));
        newBtn.click();
        return new FormPage(driver);
    }

    public FormPage clickCreateNewViewLink() {
        wait.until(ExpectedConditions
                .visibilityOf(createNewViewLink));
        createNewViewLink.click();
        return new FormPage(driver);
    }

    public void clickLogoutBtn() {
        driver.findElement(By.id("userNav")).click();
        logout.click();
        driver.quit();
    }

}
