package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

/**
 * Created by Rina Espinoza on 8/10/2015.
 */
public class Exam {
    FormPage accountFormPage;
    DetailsPage accountDetails;
    String accountName = "MyExamAccount";
    FormPage opportunityFormPage;
    DetailsPage opportunityDetails;

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
    public void createNewOpportunity() {

        String opportunityName = "Opportunity";
        String closeDate = "10/05/2015";
        String stageSelected = "Prospecting";


        TabBar tabBar = accountDetails.goToTabBar();
        TabPage opportunityTabPage = tabBar.clickOppLinkText();
        opportunityFormPage = opportunityTabPage.clickNewBtn();
        opportunityFormPage.setTextFieldValue("Opportunity Name", opportunityName);
        opportunityFormPage.setTextFieldValue("Close Date", closeDate);
        opportunityFormPage.setPickListValue("Stage", stageSelected);
        opportunityFormPage.selectLookupValue("text", accountName);
        opportunityDetails = opportunityFormPage.clickSaveBtn();

        Assert.assertEquals(opportunityDetails.getPageDescription(), opportunityName);
        Assert.assertEquals(opportunityDetails.getFieldValue("Opportunity Name"), opportunityName);
        Assert.assertEquals(opportunityDetails.getFieldValue("Close Date"), closeDate);
        Assert.assertEquals(opportunityDetails.getFieldValue("Stage"), stageSelected);
        Assert.assertEquals(opportunityDetails.getFieldValue("Account Name"), accountName);
    }

    @AfterClass
    public void tearDown() {
        TabPage opportunityTab = opportunityDetails.clickDeleteOppBtn();
        TabBar tabBar = opportunityTab.goToTabBar();
        TabPage accountTabPage = tabBar.clickAccountLinkText();
        //accountDetails = accountTabPage.clickRecentCreatedObjectLink();
        //accountTabPage = accountDetails.clickDeleteBtn();
        accountTabPage.clickLogoutBtn();
    }
}
