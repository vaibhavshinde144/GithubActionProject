package org.loginpage.qa;

import org.base.qa.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest {
	@FindBy(xpath = "//input[@id ='username']")
	private WebElement userName;
	
	@FindBy(xpath = "//input[@id ='password']")
	private WebElement password;
	
	@FindBy(xpath = "//button[@id ='submit']")
	private WebElement loginBtn;
	
	public LoginPage() throws Exception {
		PageFactory.initElements(driver, this);
	}

	public void Login(String un, String pwd) {
		userName.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
	}

}
