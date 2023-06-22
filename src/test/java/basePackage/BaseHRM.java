package basePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utilities.Timeutilities;

public class BaseHRM {
		public static Properties prop = new Properties();
		public static WebDriver driver;
//STEP 1	
		public BaseHRM () {
	try {
		FileInputStream file=new FileInputStream("C:\\Users\\ramprasath\\eclipse-workspace\\HRProject\\src\\test\\java\\environmentPackage\\config.properties");
		prop.load(file);
	} 	
	
	catch(FileNotFoundException e) {
		e.printStackTrace();
	} 
	catch(IOException a) {
		a.printStackTrace();
	} }
//STEP 2 
			public static void initiate() {
				
				String browsername = prop.getProperty("browser");
				
	 if (browsername.equals("firfox")) {
			System.setProperty("Webdriver.gecko.driver", "geckodriver.exe");
			driver = new FirefoxDriver();
			}
	else if (browsername.equals("Chrome")) {
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				driver = new ChromeDriver();	
			}
	 
		driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Timeutilities.timepage));
        driver.get(prop.getProperty("url"));
    }
			public static void  screenshots(String Filename) { 
				
				File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				try {
				FileUtils.copyFile(file, new File("C:\\Users\\ramprasath\\eclipse-workspace\\HRProject\\src\\test\\java\\screenshot\\screenshot" +Filename+".jpg"));
	}
			catch(IOException e) {
				e.printStackTrace();
			}
							
}}