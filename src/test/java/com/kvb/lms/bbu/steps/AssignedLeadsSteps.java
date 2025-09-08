package com.kvb.lms.bbu.steps;

import com.kvb.lms.bbu.hooks.Hooks;
import com.kvb.lms.bbu.pages.AssignedLeadsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AssignedLeadsSteps {

    private static final Logger log = LoggerFactory.getLogger(AssignedLeadsSteps.class);
    private AssignedLeadsPage assignedLeadsPage;

    @Given("user navigates to the Assigned Leads page")
    public void userNavigatesToTheAssignedLeadsPage() {
        assignedLeadsPage = new AssignedLeadsPage(Hooks.page);
        assignedLeadsPage.openAssignedLeads();
        log.info("Navigated to Assigned Leads page");
    }

    @When("the user creates a new Lead by filling in all the fields")
    public void userCreatesNewLeadByFillingAllFields() {
        assignedLeadsPage.clickAddNew();
        assignedLeadsPage.enterLeadName("Nitish");
        assignedLeadsPage.enterPromoterName("Varshini");
        assignedLeadsPage.enterPromoterDesignation("Analyst");
        assignedLeadsPage.selectLeadSource();
        assignedLeadsPage.enterPhoneNumber1("6381214124");
        assignedLeadsPage.selectLocation();
        assignedLeadsPage.enterKVBCustomerID("8977");
        assignedLeadsPage.enterPhoneNumber2("8875009237");
        assignedLeadsPage.enterEmailID1("dhava@gmail.com");
        assignedLeadsPage.enterEmailID2("dhavavarrshini@gmail.com");
        assignedLeadsPage.selectSector();
        assignedLeadsPage.selectIndustry();
        assignedLeadsPage.selectState();
        assignedLeadsPage.enterGSTnumber("22AAAAA0000A1Z5");
        assignedLeadsPage.enterSalesTurnover("67.3");
        assignedLeadsPage.enterNoOfEmployess("100");
        assignedLeadsPage.selectBankingwith();
        assignedLeadsPage.enterTotalExposureWithCurrentBank("100.0");
        assignedLeadsPage.enterTotalExposureRequestedfromKVB("150.90");
        assignedLeadsPage.enterAddress("Anna Nagar");
        assignedLeadsPage.enterCity("Erode");
        assignedLeadsPage.enterPincode("638000");
        assignedLeadsPage.enterAnyOtherDetails("NA");
        assignedLeadsPage.enterMEMO("NA");
        assignedLeadsPage.selectAssignedToRM();
        assignedLeadsPage.selectVisitETA();
        assignedLeadsPage.pressCancelButton();

        log.info("Filled lead details and clicked save");
    }

    @Then("the new Lead should be created successfully and displayed in the Assigned Leads list")
    public void verifyLeadCreatedSuccessfully() {
        boolean leadCreated = assignedLeadsPage.isLeadCreated();
        Assert.assertTrue(leadCreated, "Lead was not created successfully!");
        log.info("Verified lead was created successfully");
    }


}
