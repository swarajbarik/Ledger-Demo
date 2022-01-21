package com.ledger.test.stepDefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.codeborne.selenide.WebDriverRunner;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class Hooks {
	
	@AfterStep
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			  final byte[] screenshot = ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
		      scenario.attach(screenshot, "image/png", "image"); 
		}
		
	}

}
