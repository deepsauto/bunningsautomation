package definition;

import java.util.regex.Pattern;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import TestBase.Base;
import utilities.Generic;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageobject.AddItemsToWishlist;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddWishListStepDefinition {
	WebDriver driver;
	String productFullText;

	public AddWishListStepDefinition() {
		this.driver = Hooks.driver;
	}

	@Given("^the user enters into bunnings site$")
	public void the_user_enters_into_bunnings_site() {
		driver.get(Base.getconfig("url"));
		driver.manage().window().maximize();
	}

	@Given("^enter text \"([^\"]*)\" to search for items$")
	public void enter_text_to_search_for_items(String name) {
		PageFactory.initElements(driver, AddItemsToWishlist.class);
		AddItemsToWishlist.searchinput_editbox.sendKeys(name);
		AddItemsToWishlist.searchicon.click();

	}

	@Given("^search for items$")
	public void search_for_items() {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(AddItemsToWishlist.searchresult_header));
		String searchresultstext = AddItemsToWishlist.searchresult_header.getText();
		if (Pattern.compile("([1-9])").matcher(searchresultstext).find()) {
			Generic.webpageScrollDown(driver);
			wait.until(ExpectedConditions.visibilityOfAllElements(AddItemsToWishlist.searchresult_item));
			Integer myRandomNumber = Generic.generateRandomNumber(AddItemsToWishlist.searchresult_item);
			productFullText = AddItemsToWishlist.searchresult_item.get(myRandomNumber).getText();
			AddItemsToWishlist.searchresult_item.get(myRandomNumber).click();
		}

	}

	@When("^the search results show required items$")
	public void the_search_results_show_required_items() {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(AddItemsToWishlist.productdetails_header));

	}

	@When("^the user adds to wishlist$")
	public void the_user_adds_to_wishlist() {
		if (AddItemsToWishlist.productdetails_header.getText().contains(productFullText.replaceAll("[^.]", ""))) {
			Generic.webpageScrollDown(driver);
			AddItemsToWishlist.addwishlist_btn.click();
		}
	}

	@Then("^the wishlist shows added item$")
	public void the_wishlist_shows_added_item() {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(AddItemsToWishlist.addedwishlist_btn));
		driver.get(Base.getconfig("wishlisturl"));
		Generic.webpageScrollDown(driver);
		Assert.assertTrue("Added items are in wishlist",
				AddItemsToWishlist.wishlist_item.getText().contains(productFullText.replaceAll("[^.]", "")));

	}

}
