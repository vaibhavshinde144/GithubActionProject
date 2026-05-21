package org.logintest.qa;

import java.time.Duration;

import org.base.qa.BaseTest;
import org.loginpage.qa.LoginPage;
import org.testng.Assert;
import org.utility.qa.ReportUtility;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTest extends BaseTest{
	LoginPage lp;
	
	public LoginTest() throws Exception {
		super();
	}
	
	@BeforeAll
	public static void startReport() {
		ReportUtility.initReport();
	}
	
	@Before
	public void setUp() throws Exception {
		initialisation();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}
	
	@Given("the user is on Demo Web Shop login page")
	public void the_user_is_on_demo_web_shop_login_page() throws Exception {
		ReportUtility.createTest("TC001 - Valid Login Test");
		 ReportUtility.logInfo("Navigating to login page");
		driver.get(pro.getProperty("url"));
		lp = new LoginPage();
	}

	@When("the user enters a valid creadiantials and clicks on the login button")
	public void the_user_enters_a_valid_creadiantials_and_clicks_on_the_login_button() {
		ReportUtility.logInfo("Entering valid credentials");
		lp.Login("student", "Password123");
	}

	@Then("the user should be redirected to Home page")
	public void the_user_should_be_redirected_to_home_page() {
		try {
			ReportUtility.logInfo("Verifying successful login");
			 String currentUrl = driver.getCurrentUrl();
			    Assert.assertEquals(currentUrl, "https://practicetestautomation.com/logged-in-successfully/");
			    ReportUtility.logPass("Login successful with valid credentials");
		}
		catch (AssertionError e) {
	    	ReportUtility.logFail("Login failed: " + e.getMessage(), null);
		}
	}

	@When("the user enters a invalid {string} and {string} clicks on the login button")
	public void the_user_enters_a_invalid_and_clicks_on_the_login_button(String String, String String2) {
	    ReportUtility.logInfo("Entering invalid credentials");
		lp.Login(String, String2);
	}

	@Then("the user should see an error message")
	public void the_user_should_see_an_error_message() {
		try {
			ReportUtility.logInfo("Verifying error message for invalid login");
		String currentUrl2 = driver.getCurrentUrl();
	    Assert.assertEquals(currentUrl2, "https://practicetestautomation.com/practice-test-login/");
	    ReportUtility.logPass("'Username/password does not match' error after wrong credentials");
	}	catch (AssertionError e) {
		ReportUtility.logFail("Able to login after wrong credentials: " + e.getMessage(), null);
	}
	}
	
	@After
	public void tearDown() {
			driver.quit();
	}
	
	@AfterAll
	public static void endReport() {
		ReportUtility.flushReport();
	}

}
