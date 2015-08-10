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

}
