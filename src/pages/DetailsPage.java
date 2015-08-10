package pages;

import framework.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Rina Espinoza on 8/9/2015.
 */
public class DetailsPage extends BasePage {

    @FindBy(className = "topName")
    @CacheLookup
    private WebElement objectNameText;

    @FindBy(name = "edit")
    @CacheLookup
    public WebElement editBtn;

    @FindBy(name = "delete")
    @CacheLookup
    public WebElement deleteBtn;

    @FindBy(xpath = "//select[@class='title']")
    @CacheLookup
    private WebElement ViewNameText;

    @FindBy(linkText = "Edit")
    @CacheLookup
    public WebElement editLink;

    @FindBy(linkText = "Delete")
    @CacheLookup
    public WebElement deleteLink;

    public DetailsPage(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getObjectName() {
        return objectNameText.getText();
    }


    public FormPage clickEditBtn() {
        wait.until(ExpectedConditions
                .visibilityOf(editBtn));
        editBtn.click();
        return new FormPage(driver);
    }

    public TabPage clickDeleteBtn() {
        wait.until(ExpectedConditions
                .visibilityOf(deleteBtn));
        deleteBtn.click();

        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } finally {

            return new TabPage(driver);
        }
    }

    public String getViewName() {
        Select select = new Select(ViewNameText);
        return select.getFirstSelectedOption().getText();
    }


    public FormPage clickEditViewLink() {
        wait.until(ExpectedConditions
                .visibilityOf(editLink));
        editLink.click();
        return new FormPage(driver);
    }

    public TabPage clickDeleteViewLink() {
        wait.until(ExpectedConditions
                .visibilityOf(deleteLink));
        deleteLink.click();

        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } finally {

            return new TabPage(driver);
        }
    }
}
