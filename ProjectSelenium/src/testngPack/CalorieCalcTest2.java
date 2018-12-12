package testngPack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalorieCalcTest2 {
	ChromeDriver driver;
	@BeforeMethod
	public void InitializeBrowser(){
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		driver = new ChromeDriver();		
	}
	
	@Test
	public void EnterCalorieDetails() throws InterruptedException{
		driver.get("https://www.calculator.net/calorie-calculator.html");
		//findElement - id,name,class, getAttribute,getCSSValue
		WebElement ageTextbox = driver.findElement(By.id("cage"));
		ageTextbox.clear(); //clear the textbox
		ageTextbox.sendKeys("56"); //enter 56 in the ageTextbox

		List<WebElement> sexList =driver.findElements(By.name("csex"));
		//looping through the list of elements
		for(WebElement sexElement : sexList){
			System.out.println(sexElement.getAttribute("id") + "  " + sexElement.getAttribute("value"));
			//perform click on female and thats alos only if it is unselected
			if(sexElement.getAttribute("value").equals("f")){
				if(!sexElement.isSelected()){
					sexElement.click();
					break;
				}
			}
		}
	
		WebElement weightTextbox = driver.findElement(By.id("cpound"));
		weightTextbox.clear(); //clear the textbox
		weightTextbox.sendKeys("200"); //enter 56 in the ageTextbox		
		
		Thread.sleep(3000); //wait for 3000 milliseconds
	}
	
	@AfterMethod
	public void CloseBrowser(){
		if(driver!=null){
		  driver.close(); //used to close the current browser which is opened via script
		  driver.quit();//used to quite all browsers opened via script
		}
	}

}
