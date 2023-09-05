package testLayer;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseHRMClass;
import pompackage.PomLogin;
import testdata.Excelsheet;



public class LoginTest extends BaseHRMClass {
	
	PomLogin log;
	
	
	public LoginTest() throws IOException  {
		
		super();
	}
	
	@BeforeMethod
	public void initialsetup() throws FileNotFoundException {
		
	initiate();
	log=new PomLogin();
	
	
	}
	
	@Test(priority=1)
	public void Title() {
		String actual=log.verify();
		System.out.println(actual);
		Assert.assertEquals(actual, "OrangeHRM");
		
	}
	
	@DataProvider
	public Object[][] Details(){
		Object result[][]=Excelsheet.readdata("sheet1");
		return result;
	}
	
	@Test(dataProvider="Details")
	public void loginHRM(String namel, String password) throws InterruptedException 
	{
		
		log.typeusername(namel);
		log.typepassword(password);
		//log.login();
		Thread.sleep(2000);
		screenshots("Login");
	}
	
	@AfterMethod
	public void close() {
		driver.close();
		
	}

}
