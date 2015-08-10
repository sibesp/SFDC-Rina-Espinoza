package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Rina Espinoza on 8/10/2015.
 */
public class CreateAccountView {
    private FormPage accountViewPage;
    DetailsPage accountViewDetails;

    @BeforeClass
    public void setUp() {
        LoginPage loginPage = new LoginPage();
        MainPage mainPage = loginPage.loginAsPrimaryUser();
        TabBar tabBar = mainPage.goToTabBar();
        TabPage tabPage = tabBar.clickAccountLinkText();
        accountViewPage = tabPage.clickCreateNewViewLink();
    }

    @Test
    public void createNewAccountView() {

        String accountViewName = "AccountView";
        String accountViewUniqueName = "accview";
        List<String> multiselectOption = new ArrayList<String>();
        multiselectOption.add("Fax");
        multiselectOption.add("Website");

        accountViewPage.setTextFieldValue("View Name:", accountViewName);
        accountViewPage.setTextFieldValue("View Unique Name:", accountViewUniqueName);
        accountViewPage.setMultiSelectValue("Available Fields", multiselectOption);
        accountViewPage.clickAddMultiSelection();
        accountViewPage.setRadioButton("My Accounts");


        accountViewDetails = accountViewPage.clickSaveBtn();
        Assert.assertEquals(accountViewDetails.getViewName(), accountViewName);
    }

    @AfterClass
    public void tearDown() {
        TabPage accountViewTab = accountViewDetails.clickDeleteViewLink();
        accountViewTab.clickLogoutBtn();
    }
}
