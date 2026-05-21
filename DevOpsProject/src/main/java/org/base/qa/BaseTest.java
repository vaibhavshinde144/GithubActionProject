package org.base.qa;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BaseTest {
	public static WebDriver driver;
	public static Properties pro;
	
	public BaseTest() throws IOException {
		InputStream in = getClass().getClassLoader().getResourceAsStream("application.properties");
		if (in == null) {
			throw new IOException("application.properties not found in classpath");
		}
		pro = new Properties();
		pro.load(in);
	}
	public static void initialisation () {
		String browser = pro.getProperty("browser");
		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if (browser.equals("firfox")) {
			driver = new FirefoxDriver();
		}
		else if (browser.equals("safari")) {
			driver = new SafariDriver();
		}
		else {
			System.out.println("Browser not found");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		}
}
