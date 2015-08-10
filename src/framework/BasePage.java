package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Rina Espinoza on 8/8/2015.
 */
public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage() {
        driver = WebDriverManager.getInstance().getDriver();
        wait = WebDriverManager.getInstance().getWait();
    }
}
