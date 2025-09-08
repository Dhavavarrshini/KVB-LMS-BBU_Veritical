package com.kvb.lms.bbu.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features/login.feature",
                "src/test/resources/features/assignedLeads.feature"},

        glue = {"com.kvb.lms.bbu.steps", "com.kvb.lms.bbu.utils", "com.kvb.lms.bbu.hooks"},

        plugin = {"pretty",
                "json:target/surefire-reports/cucumber.json",  // 👈 must match pom.xml
                "html:target/cucumber-reports.html"},
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
