package com.kvb.lms.bbu.pages;

import com.microsoft.playwright.Page;

public class LoginPage {

    private final Page page;

    // Locators – ideally replace with more stable ones
    private final String EmpID = "//input[contains(@class, 'mantine-TextInput-input')]";
    private final String password = "//input[contains(@class, 'mantine-PasswordInput-innerInput')]";
    private final String loginButton = "//span[contains(@class, 'mantine-Button-inner')]";

    public LoginPage(Page page) {
        this.page = page;
    }

    public void navigateToLogin() {
        page.navigate("https://cbglms-uat.kvbank.in/");
        System.out.println("Navigated to Login Page");

        // Wait for the EmpID input field to load
        page.waitForSelector(EmpID, new Page.WaitForSelectorOptions().setTimeout(10000));
    }

    public void enterEmpID(String empID) {
        page.fill(EmpID, empID);
    }

    public void enterPassword(String password) {
        page.fill(this.password, password);
    }

    public void clickLogin() {
        page.click(loginButton);
    }
}
