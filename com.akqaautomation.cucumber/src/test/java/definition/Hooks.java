package definition;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {


	public static WebDriver driver;
	@Before
	public void launch_browser()
	{
		//System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver=new ChromeDriver();
	}
	@After
	public void screenshort(Scenario s)
	{
		if(s.isFailed())
		{
		   try {
			Robot r=new Robot();
			   BufferedImage bi=r.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			   ImageIO.write(bi, "png",new File("/target/screenshot.png"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		}
	}

}

