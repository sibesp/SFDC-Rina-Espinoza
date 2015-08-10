package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

/**
 * Created by Rina Espinoza on 8/9/2015.
 */
public class EditAccount {
    private FormPage accountFormPage;
    DetailsPage accountDetails;
    String accountName = "First Account";
    String accountNameEdited = "Edit Account";

    @BeforeClass
    public void setUp() {
        LoginPage loginPage = new LoginPage();
        MainPage mainPage = loginPage.loginAsPrimaryUser();
        TabBar tabBar = mainPage.goToTabBar();
        TabPage tabPage = tabBar.clickAccountLinkText();
        accountFormPage = tabPage.clickNewBtn();
        accountFormPage.setTextFieldValue("Account Name", accountName);
        accountDetails = accountFormPage.clickSaveBtn();
    }

    @Test
    public void createNewAccount() {

        accountFormPage = accountDetails.clickEditBtn();
        accountFormPage.setTextFieldValue("Account Name", accountNameEdited);
        accountDetails = accountFormPage.clickSaveBtn();
        Assert.assertEquals(accountDetails.getObjectName(), accountNameEdited);
    }

    @AfterClass
    public void tearDown() {

        TabPage accountTab = accountDetails.clickDeleteBtn();
        accountTab.clickLogoutBtn();
    }
}
