package com.kvb.lms.bbu.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/login.feature",
        glue = {"com.kvb.lms.bbu.steps", "com.kvb.lms.bbu.utils", "com.kvb.lms.bbu.hooks"},
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
