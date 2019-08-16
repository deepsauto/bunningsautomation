package utilities;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Generic {

	public static void webpageScrollDown(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
	}

	public static Integer generateRandomNumber(List<WebElement> WebElement) {
		Random r = new Random();
		Integer randomNumber = r.nextInt(WebElement.size());
		return randomNumber;
	}

}
