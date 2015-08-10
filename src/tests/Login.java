package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;

/**
 * Created by Rina Espinoza on 8/8/2015.
 */
public class Login {
    @Test
    public void testAddProject() {

        String primaryUsernameLoggedIn = "Sibone Espinoza";
        LoginPage loginPage = new LoginPage();
        MainPage mainPage = loginPage.loginAsPrimaryUser();
        Assert.assertEquals(mainPage.getLoginUsername(), primaryUsernameLoggedIn);
    }
}
