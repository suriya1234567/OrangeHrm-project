package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseHRM;

public class Pomlogin extends BaseHRM {
	
// Object repository
	@FindBy(xpath = "/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")
	WebElement username;
	@FindBy(xpath="/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")
	WebElement password;
	@FindBy(xpath="/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
	WebElement Loginbutton;

// Initiate page elements
	public Pomlogin() {
		PageFactory.initElements(driver, this);	}
	
	public void typeusername(String name) {
		username.sendKeys("name"); 
		}
	
	public void typepassword(String pass) {
		password.sendKeys("password"); 
		}
	
	public void loginbutton() {
		Loginbutton.click(); 
		}
	
	public String verify() {
		return driver.getTitle(); 
		}
	
}
