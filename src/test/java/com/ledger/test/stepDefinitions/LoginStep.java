package com.ledger.test.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static com.codeborne.selenide.Selenide.*;

import org.openqa.selenium.By;

import com.codeborne.selenide.WebDriverRunner;
import com.ledger.test.locators.LoginPage;

import static com.codeborne.selenide.Condition.*;
public class LoginStep {

	@Given("user navigates to {string}")
	public void user_navigates_to(String url) {
		open(url);
		WebDriverRunner.getWebDriver().manage().window().maximize();
	}

	@When("user click on {string} link from top menu")
	public void user_click_on_link_from_top_menu(String link) {
		$(By.partialLinkText(link)).click();
	}

	@When("user enters username as {string}")
	public void user_enters_username_as(String username) {
		$(LoginPage.EMAIL).setValue(username);
	}

	@When("user enters password as {string}")
	public void user_enters_password_as(String password) {
		$(LoginPage.PASSWORD).setValue(password);
	}

	@When("user click on Sign In button")
	public void user_click_on_sign_in_button() {
		$(By.xpath(LoginPage.LOGIN_BUTTON)).click();
	}

	@Then("user verifies the user should display as {string}")
	public void user_verifies_the_user_should_display_as(String userName) {
		$(By.xpath(LoginPage.USER_PROFILE)).shouldHave(text(userName));
	}

}
