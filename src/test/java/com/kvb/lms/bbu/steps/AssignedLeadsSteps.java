package com.kvb.lms.bbu.steps;

import com.kvb.lms.bbu.hooks.Hooks;
import com.kvb.lms.bbu.pages.AssignedLeadsPage;
import io.cucumber.core.logging.LoggerFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.logging.Logger;

public class AssignedLeadsSteps {

    private static final Logger log = (Logger) LoggerFactory.getLogger(AssignedLeadsSteps.class);
    private AssignedLeadsPage assignedLeadsPage;

    @Given("the user navigates to the Assigned Leads page")
    public void userNavigatesToAssignedLeadsPage() {
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
        log.info("Filled lead details and clicked save");
    }

    @Then("the new Lead should be created successfully and displayed in the Assigned Leads list")
    public void verifyLeadCreatedSuccessfully() {
        boolean leadCreated = assignedLeadsPage.isLeadCreated();
        Assert.assertTrue(leadCreated, "Lead was not created successfully!");
        log.info("Verified lead was created successfully");
    }
}
