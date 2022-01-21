package com.ledger.test.stepDefinitions;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.codeborne.selenide.WebDriverRunner;
import com.ledger.test.locators.FavoritesPage;
import com.ledger.test.locators.LoginPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FavoritesStep {
	
	@When("user click on profile")
	public void user_click_on_profile() {
	    $(By.xpath(LoginPage.USER_PROFILE)).click();
	}

	@When("user click on heart icon of {string} post")
	public void user_click_on_heart_icon_of_post(String post) {
		if(post.equals("auto"))
			post = AddPostStep.articleTitle;
		
		$(By.xpath(String.format(FavoritesPage.FAVORITE_BUTTON, post))).click();
	}
	@Then("verify the count shows as {string} for post {string}")
	public void verify_the_count_shows_as(String count, String post) {
		if(post.equals("auto"))
			post = AddPostStep.articleTitle;
		
		$(By.xpath(String.format(FavoritesPage.FAVORITE_BUTTON, post))).shouldHave(text("1"));
	}
	@When("user click on Favorited Articles")
	public void user_click_on_favorited_articles() {
		$(By.xpath(FavoritesPage.FAVORITED_ARTICLES_TAB)).click();
	}
	
	@Then("verify {string} post displayed in the list")
	public void verify_post_displayed_in_the_list(String post) {
		if(post.equals("auto"))
			post = AddPostStep.articleTitle;
		
		boolean postFound = false;
		$(FavoritesPage.ARTICLE_PREVIEW).should(exist);
		List<WebElement> elements = WebDriverRunner.getWebDriver().findElements(By.cssSelector(FavoritesPage.ARTICLE_PREVIEW));
		for(WebElement ele : elements) {
			if(ele.getText().equals(post)) {
				postFound = true;
				break;
			}
		}
		
		Assert.assertTrue(postFound);
	}

}
