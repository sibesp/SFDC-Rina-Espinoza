package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

/**
 * Created by Rina Espinoza on 8/9/2015.
 */
public class NewAccount {

    private FormPage accountFormPage;
    DetailsPage accountDetails;

    @BeforeClass
    public void setUp() {
        LoginPage loginPage = new LoginPage();
        MainPage mainPage = loginPage.loginAsPrimaryUser();
        TabBar tabBar = mainPage.goToTabBar();
        TabPage tabPage = tabBar.clickAccountLinkText();
        accountFormPage = tabPage.clickNewBtn();
    }

    @Test
    public void createNewAccount() {

        String accountName = "First Account";
        accountFormPage.setTextFieldValue("Account Name", accountName);

        accountFormPage.selectLookupValue("text", "Parent Account");

        accountDetails = accountFormPage.clickSaveBtn();
        Assert.assertEquals(accountDetails.getObjectName(), accountName);
    }

    @AfterClass
    public void tearDown() {
        TabPage accountTab = accountDetails.clickDeleteBtn();
        accountTab.clickLogoutBtn();
    }
}
