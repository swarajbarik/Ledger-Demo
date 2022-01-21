package com.ledger.test.stepDefinitions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;

import com.ledger.test.locators.AddPostPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddPostStep {

	public static String articleTitle = "";

	@When("user enters the article details as below")
	public void user_enters_the_article_details_as_below(DataTable dataTable) {
		List<Map<String, String>> table = dataTable.asMaps();
		Map<String, String> data = table.get(0);
		articleTitle = data.get("Title");
		if (articleTitle.equals("auto")) {
			articleTitle = "Post " + new Date();
		}

		$(AddPostPage.TITLE).setValue(articleTitle);
		$(AddPostPage.ABOUT).setValue(data.get("About"));
		$(By.xpath(AddPostPage.ARTICLE_DESCRIPTION)).setValue(data.get("Description"));
		$(By.xpath(AddPostPage.TAGS)).setValue(data.get("Tags"));
	}

	@And("user click on Publish Article button")
	public void user_click_on_publish_article_button() {
		$(By.xpath(AddPostPage.PUBLISH_ARTICLE)).click();
	}

	@Then("verify the post title should display in header")
	public void verify_the_post_title_should_display_in_header() {
		$(AddPostPage.ARTICLE_TITLE).shouldHave(text(articleTitle));
	}
}
