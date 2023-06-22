package testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseHRM;
import pompackage.Pomlogin;
import testdata.Excelsheet;

public class LoginTest  extends BaseHRM {
// Creating constructor of this class
	
	Pomlogin Log; 
	public LoginTest ( ) {
		super();
		} 
	
	@BeforeMethod
	public void intsetup () throws Throwable  {
		initiate(); 
		Log = new Pomlogin();
		Thread.sleep(5000);
		screenshots("Login");
		}
	@Test(priority=1)
	public void Title () {
		String actual = Log.verify(); 	
		System.out.println(actual);
		Assert.assertEquals(actual, "OrangeHRM");
	}
	@DataProvider 
	public Object[][] Details() {
		Object result[][]=Excelsheet.readdata("Sheet1");
		return result;
	}
	
	@Test(priority=2, dataProvider="Details")
	public void login(String name,String password) {
		Log.typeusername(name);
		Log.typepassword(password);
		// Log.loginbutton();
	}
	
	@AfterMethod
	public void close() { 
	driver.close(); 
	}

}
	
	

