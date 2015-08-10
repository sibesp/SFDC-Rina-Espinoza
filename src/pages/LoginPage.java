package pages;

import framework.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(id = "Login")
    @CacheLookup
    private WebElement loginBtn;

    @FindBy(id = "username")
    @CacheLookup
    private WebElement usernameTxt;

    @FindBy(id = "password")
    @CacheLookup
    private WebElement passwordTxt;


    public LoginPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public MainPage clickLoginBtn() {
        loginBtn.click();
        return new MainPage(driver);
    }

    public LoginPage setPasswordTxt(String password) {
        passwordTxt.clear();
        passwordTxt.sendKeys(password);
        return this;
    }

    public LoginPage setUsernameTxt(String username) {
        usernameTxt.clear();
        usernameTxt.sendKeys(username);
        return this;
    }

    public MainPage loginAs(String username, String password) {
        setUsernameTxt(username);
        setPasswordTxt(password);
        return clickLoginBtn();
    }

    public MainPage loginAsPrimaryUser() {
        return loginAs("sibesp@salesforce.com", "LoginLluvia04");
    }
}
