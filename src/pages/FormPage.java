package pages;

import framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by Rina Espinoza on 8/8/2015.
 */
public class FormPage extends BasePage {

    @FindBy(className = "pageDescription")
    @CacheLookup
    public WebElement pageDescriptionText;

    @FindBy(name = "save")
    @CacheLookup
    public WebElement saveBtn;

    @FindBy(name = "save_new")
    @CacheLookup
    public WebElement saveNewBtn;

    @FindBy(name = "cancel")
    @CacheLookup
    public WebElement cancelBtn;

    public FormPage(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPageDescription() {
        return pageDescriptionText.getText();
    }

    public FormPage clickSaveNewBtn() {
        wait.until(ExpectedConditions
                .visibilityOf(saveNewBtn));
        saveNewBtn.click();
        return new FormPage(driver);
    }

    public DetailsPage clickSaveBtn() {
        wait.until(ExpectedConditions
                .visibilityOf(saveBtn));
        saveBtn.click();
        return new DetailsPage(driver);
    }

    public TabPage clickCancelBtn() {
        wait.until(ExpectedConditions
                .visibilityOf(cancelBtn));
        cancelBtn.click();
        return new TabPage(driver);
    }

    public FormPage setTextFieldValue(String fieldName, String fieldValue) {
        String fieldXpath = "//label[text()='" + fieldName + "' ]/following::input";
        driver.findElement(By.xpath(fieldXpath)).clear();
        driver.findElement(By.xpath(fieldXpath)).sendKeys(fieldValue);
        return this;
    }

    public FormPage setPickListValue(String fieldName, String fieldValue) {
        String fieldXpath = "//label[text()='" + fieldName + "' ]/following::select";
        Select select = new Select(driver.findElement(By.xpath(fieldXpath)));
        select.selectByVisibleText(fieldValue);
        return this;
    }

    public FormPage setMultiSelectValue(String fieldName, List<String> selectedOptions) {
        String fieldXpath = "//label[text()='" + fieldName + "' ]/following::select";
        Select multiSelect = new Select(driver.findElement(By.xpath(fieldXpath)));
        for (String selectOption : selectedOptions) {
            multiSelect.selectByVisibleText(selectOption);
        }
        return this;
    }

    public FormPage clickAddMultiSelection() {
        driver.findElement(By.cssSelector("img.rightArrowIcon")).click();
        return this;
    }

    public FormPage clickRemoveMultiSelection() {
        driver.findElement(By.cssSelector("img.leftArrowIcon")).click();
        return this;
    }

    public FormPage setRadioButton(String fieldName) {
        String fieldXpath = "//label[contains(text(),'" + fieldName + "')]/preceding-sibling::input";
        driver.findElement(By.xpath(fieldXpath)).click();
        return this;
    }


    public FormPage selectLookupValue(String fieldName, String selectedValue) {
        //String fieldText = "//label[text()='" +fieldName + "' ]/following::input[@type='text']";
        //String lookupLocator = "img.lookupIconOn";
        String windowID = driver.getWindowHandle();
        driver.findElement(By.className("lookupIcon")).click();

        try {
            Set<String> setWindows = driver.getWindowHandles();
            LinkedList<String> listWindows = new LinkedList<String>(setWindows);
            driver.switchTo().window(listWindows.getLast());
            driver.switchTo().frame("resultsFrame");
            //wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("resultsFrame")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(selectedValue)));
            driver.findElement(By.linkText(selectedValue)).click();
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            driver.switchTo().window(windowID);
        }
        return this;
    }

}
