package pompackage;


import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseHRMClass;

public class PomLogin extends BaseHRMClass{
	
	


	//object repository
	
	@FindBy(name="username")WebElement Username;
	
	@FindBy(name="password")WebElement Password;
	
	@FindBy(css=".oxd-button") WebElement loginbutton;
	
	//initiate page elements
	

	public PomLogin() throws FileNotFoundException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	public void typeusername(String name) {
		Username.sendKeys(name);
	}
	
	public void typepassword(String pass) {
		Password.sendKeys(pass);
	}
	
	public void login() {
		loginbutton.click();
	}
	
	public String verify() {
		return driver.getTitle();
	}

}
