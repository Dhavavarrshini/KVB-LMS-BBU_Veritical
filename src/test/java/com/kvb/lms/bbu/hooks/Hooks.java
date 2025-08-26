package com.kvb.lms.bbu.hooks;

import com.microsoft.playwright.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import com.kvb.lms.bbu.utils.EmailSender;
import io.cucumber.java.AfterAll;

public class Hooks {

    private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext context;
    public static Page page;

    @Before
    public void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
        System.out.println("✅ Playwright Page initialized: " + page);
    }

    @After
    public void tearDown() {
        if (page != null) {
            page.close();
        }
        if (context != null) {
            context.close();
        }
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
        System.out.println("✅ Playwright resources closed.");
    }

    @AfterAll
    public static void sendReportEmail() {
        String reportPath = System.getProperty("user.dir") + "/target/cucumber-reports/report.html";
        EmailSender.sendReport(
                "dhavavarrshini.m@pentafox.in",
                "C:\\Users\\dhava\\IdeaProjects\\KVB-LMS BBU_Vertical\\target\\cucumber-reports"
        );

    }
}

