package com.skillio.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/FeatureFile",
    glue = {
        "com.skillio.base",
        "com.skillio.stepdefinitions"
    },
    plugin = {
        "pretty",
        "html:target/cucumber-report.html",
        "json:target/cucumber.json"
    },
    monochrome = true,
    dryRun = false
    // No tags = all test cases will run
)
public class Runner extends AbstractTestNGCucumberTests {
}