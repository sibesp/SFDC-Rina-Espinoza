package pages;

import framework.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {


    @FindBy(id = "userNavLabel")
    @CacheLookup
    private WebElement loginUsername;

    @FindBy(css = "a[title='Logout']")
    @CacheLookup
    private WebElement logout;

//a[@title='Logout']

    public MainPage(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getLoginUsername() {
        return loginUsername.getText();
    }

    public TabBar goToTabBar() {
        return new TabBar(driver);
    }

    public LoginPage clickLogoutBtn() {
        logout.click();
        return new LoginPage();
    }

}
