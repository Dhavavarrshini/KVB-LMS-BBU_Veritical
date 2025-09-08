package com.kvb.lms.bbu.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.lang.ref.SoftReference;

import static org.apache.commons.io.FileUtils.waitFor;

public class AssignedLeadsPage {
    private final Page page;

    private final String assignedLeads       = "(//span[contains(@class,'mantine-ActionIcon-icon')])[2]";
    private final String addNewButton        = "//span[contains(text(),'Add New')]";
    private final String leadName            = "//input[@placeholder='Lead Name']";
    private final String promoterName        = "(//input[contains(@class,'m_8fb7ebe7 mantine-Input-input mantine-TextInput-input')])[21]";
    private final String promoterDesignation = "(//input[contains(@class,'m_8fb7ebe7 mantine-Input-input mantine-TextInput-input')])[22]";
    private final String leadSource          = "(//input[contains(@class,'m_8fb7ebe7 mantine-Input-input mantine-Select-input')])[9]";
    private final String phoneNumber1        = "(//input[contains(@class,'m_8fb7ebe7 mantine-Input-input mantine-TextInput-input')])[23]";
    private final String location            = "(//input[contains(@class,'m_8fb7ebe7 mantine-Input-input mantine-Select-input')])[10]";
    private final String kvbCustomerID       = "(//input[contains(@class,'m_8fb7ebe7 mantine-Input-input mantine-TextInput-input')])[24]";
    private final String phoneNumber2        = "(//input[contains(@class,'m_8fb7ebe7 mantine-Input-input mantine-TextInput-input')])[25]";
    private final String emailID1            = "(//input[contains(@class,'m_8fb7ebe7 mantine-Input-input mantine-TextInput-input')])[26]";
    private final String emailID2            = "(//input[contains(@class,'m_8fb7ebe7 mantine-Input-input mantine-TextInput-input')])[27]";
    private final String sector              = "(//input[contains(@class,'m_8fb7ebe7 mantine-Input-input mantine-Select-input')])[11]";
    private final String industry            = "(//input[contains(@class,'m_8fb7ebe7 mantine-Input-input mantine-Select-input')])[12]";
    private final String state               = "(//input[contains(@class,'m_8fb7ebe7 mantine-Input-input mantine-Select-input')])[13]";
    private final String GSTnumber           = "(//input[contains(@class,'m_8fb7ebe7 mantine-Input-input mantine-TextInput-input')])[28]";
    private final String salesTurnover       = "(//input[contains(@class,'m_8fb7ebe7 mantine-Input-input mantine-TextInput-input')])[29]";
    private final String NoOfEmployess       = "(//input[contains(@class,'m_8fb7ebe7 mantine-Input-input mantine-TextInput-input')])[30]";
    private final String bankingWith         = "(//input[contains(@class,'m_8fb7ebe7 mantine-Input-input mantine-Select-input')])[14]";
    private final String totalExposurewithcurrentBank  = "(//input[contains(@class,'m_8fb7ebe7 mantine-Input-input mantine-TextInput-input')])[31]";
    private final String totalExposureRequestedfromKVB = "(//input[contains(@class,'m_8fb7ebe7 mantine-Input-input mantine-TextInput-input')])[32]";
    private final String address             = "(//input[contains(@class,'m_8fb7ebe7 mantine-Input-input mantine-TextInput-input')])[33]";
    private final String city                = "(//input[contains(@class,'m_8fb7ebe7 mantine-Input-input mantine-TextInput-input')])[34]";
    private final String pincode             = "(//input[contains(@class,'m_8fb7ebe7 mantine-Input-input mantine-TextInput-input')])[35]";
    private final String anyOtherDetails     = "(//input[contains(@class,'m_8fb7ebe7 mantine-Input-input mantine-TextInput-input')])[36]";
    private final String memo                = "(//input[contains(@class,'m_8fb7ebe7 mantine-Input-input mantine-TextInput-input')])[37]";
    private final String assignedToRM        = "(//input[contains(@class,'m_8fb7ebe7 mantine-Input-input mantine-Select-input')])[15]";
    private final String visitETA            = "(//input[contains(@class,'m_8fb7ebe7 mantine-Input-input mantine-DateInput-input')])[2]";
    private final String cancelButton        = "(//span[contains(text(),'Cancel')])[2]";
    private final String submitButton        = "(//span[contains(text(),'Submit')])[2]";


    private final String successMessage      = "//div[contains(text(),'Lead created successfully')]";


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
        page.fill(phoneNumber1, phonenumber1);
    }

    public void selectLocation(){
        page.click(location);
        page.keyboard().press("ArrowUp");
        page.keyboard().press("Enter");
    }

    public void enterKVBCustomerID(String KVBcustomerID){
        page.fill(kvbCustomerID, KVBcustomerID );
    }

    public void enterPhoneNumber2(String phonenumber2){
        page.fill(phoneNumber2, phonenumber2);
    }

    public void enterEmailID1(String EmailID1){
        page.fill(emailID1, EmailID1);
    }

    public void enterEmailID2(String EmailID2){
        page.fill(emailID2, EmailID2);
    }

    public void selectSector(){
        page.click(sector);
        page.keyboard().press("ArrowUp");
        page.keyboard().press("Enter");
    }

    public void selectIndustry(){
        page.click(industry);
        page.keyboard().press("ArrowUp");
        page.keyboard().press("Enter");
    }

    public void selectState(){
        page.click(state);
        page.keyboard().press("ArrowUp");
        page.keyboard().press("Enter");
    }

    public void enterGSTnumber(String GSTNumber){
        page.fill(GSTnumber, GSTnumber);
    }

    public void enterSalesTurnover(String SalesTurnover){
        page.fill(salesTurnover, SalesTurnover);
    }

    public void enterNoOfEmployess(String noOfEmployess){
        page.fill(NoOfEmployess, noOfEmployess);
    }

    public void selectBankingwith(){
        page.click(bankingWith);
        page.keyboard().press("ArrowDown");
        page.keyboard().press("Enter");
    }

    public void enterTotalExposureWithCurrentBank(String TotalExposureWithCurrentBank){
        page.fill(totalExposurewithcurrentBank, TotalExposureWithCurrentBank);
    }

    public void enterTotalExposureRequestedfromKVB(String TotalExposureRequestedfronKVB){
        page.fill(totalExposureRequestedfromKVB, TotalExposureRequestedfronKVB);
    }

    public void enterAddress(String Address){
        page.fill(address, Address);
    }

    public void enterCity(String City){
        page.fill(city, City);
    }

    public void enterPincode(String Pincode){
        page.fill(pincode, Pincode);
    }

    public void enterAnyOtherDetails(String AnyOtherDetails){
        page.fill(anyOtherDetails, AnyOtherDetails);
    }

    public void enterMEMO(String MEMO){
        page.fill(memo, MEMO);
    }

    public void selectAssignedToRM(){
        page.click(assignedToRM);
        page.keyboard().type("nitish");
        page.keyboard().press("Enter");
    }

    public void selectVisitETA(){
        page.click(visitETA);
        page.keyboard().type("19 August 2026");
        page.keyboard().press("Tab");
    }

    public void pressCancelButton(){
        page.click(cancelButton);
    }

    public void pressSubmitButton(){
        page.click(submitButton);
    }

    public boolean isLeadCreated() {
        return page.isVisible(successMessage);
    }
}
