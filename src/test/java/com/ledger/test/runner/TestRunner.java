package com.ledger.test.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/ledger/test/feature/", glue = {
		"com.ledger.test.stepDefinitions" }, tags = "@e2e" , plugin = {
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, monochrome = true, dryRun = false

)
public class TestRunner {

}
