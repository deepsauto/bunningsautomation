package pageobject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddItemsToWishlist {
	
	@FindBy(xpath="//*[contains(@class,'search-container_term')]")
	public static WebElement searchinput_editbox;

	@FindBy(xpath="//*[contains(@class,'search-container_icon-search')]")
	public static WebElement searchicon;
	
	@FindBy (xpath="//*[contains(@class,'page-heading search-result_header')]")
	public static WebElement searchresult_header;
	
	@FindBy (xpath="//*[contains(@class,'product-tile__row--title')]")
	public static List<WebElement> searchresult_item;
	
	@FindBy (xpath="//*[contains(@class,'page-title')]")
	public static WebElement productdetails_header;
	
	@FindBy (xpath="//*[contains(@class,'btn-add-wishlist')]")
	public static WebElement addwishlist_btn;
	
	@FindBy (xpath="//*[contains(@class,'btn-add-wishlist added')]")
	public static WebElement addedwishlist_btn;
	
	@FindBy (xpath="//*[contains(@class,'GAEvent display-block')]")
	public static WebElement wishlist_item;
}
