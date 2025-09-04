package com.kvb.lms.bbu.pages;

import com.microsoft.playwright.Page;

public class AssignedLeadsPage {
    private final Page page;

    private final String assignedLeads = "(//span[contains(@class,'mantine-ActionIcon-icon')])[2]";
    private final String addNewButton = "//span[contains(text(),'Add New')]";
    private final String leadName = "//input[@placeholder='Lead Name']";
    private final String promoterName = "(//input[contains(@class,'m_8fb7ebe7 mantine-Input-input mantine-TextInput-input')])[21]";
    private final String promoterDesignation = "(//input[contains(@class,'m_8fb7ebe7 mantine-Input-input mantine-TextInput-input')])[22]";
    private final String leadSource = "(//input[contains(@class,'m_8fb7ebe7 mantine-Input-input mantine-Select-input')])[9]";
    private final String phoneNumber1 = "(//input[contains(@class,'m_8fb7ebe7 mantine-Input-input mantine-TextInput-input')])[23]";
    private final String location = "(//input[contains(@class,'m_8fb7ebe7 mantine-Input-input mantine-Select-input')])[10]";


    private final String successMessage = "//div[contains(text(),'Lead created successfully')]";


    public AssignedLeadsPage(Page page) {
        this.page = page;
    }

    public void openAssignedLeads() {
        page.click(assignedLeads);
    }

    public void clickAddNew() {
        page.click(addNewButton);
    }

    public void enterLeadName(String name) {
        page.fill(leadName, name);
    }

    public void enterPromoterName(String promotername) {
        page.fill(promoterName, promotername);
    }

    public void enterPromoterDesignation(String promoterdeignation) {
        page.fill(promoterDesignation, promoterdeignation);
    }

    public void selectLeadSource() {
        page.click(leadSource);
        page.keyboard().press("ArrowDown");
        page.keyboard().press("Enter");
    }

    public void enterPhoneNumber1(String phonenumber1){
        page.fill(phonenumber1, phonenumber1);
    }

    public void selectLocation(String Location){
        page.click(location);
        page.keyboard().press("ArrowUp");
        page.keyboard().press("Enter");
    }


    public boolean isLeadCreated() {
        return page.isVisible(successMessage);
    }
}
