package Launch_Locate;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LaunchBrowser {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		//First we want to launch chrome 
		//I need to create a instance of ChromeDriver -- launch the chrome browser
		//this import appeara only if you have selenium java jars
		//Ctrl+Shift+O - importing packages 
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		Thread.sleep(2000);
		driver.close();
		
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		FirefoxDriver fdriver = new FirefoxDriver();
		fdriver.get("http://www.calculator.net/calorie-calculator.html");
		
		Thread.sleep(2000);
		fdriver.close();
		
		//Internet Explorer
		// Protected Mode settings are not the same for all zones. Enable Protected Mode must be set 
		//to the same value (enabled or disabled) for all zones
		System.setProperty("webdriver.ie.driver","./drivers/IEDriverServer.exe");
		InternetExplorerDriver idriver = new InternetExplorerDriver();
		idriver.get("http://www.google.com");
		Thread.sleep(2000);
		idriver.close();
		

	}

}
