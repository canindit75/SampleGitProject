package Launch_Locate;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateElements {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.calculator.net/calorie-calculator.html");
		//findElement - id,name,class, getAttribute,getCSSValue
		WebElement ageTextbox = driver.findElement(By.id("cage"));
		ageTextbox.clear(); //clear the textbox
		ageTextbox.sendKeys("56"); //enter 56 in the ageTextbox
		//i want to find other attribute values of element
		System.out.println("id = " + ageTextbox.getAttribute("id"));
		System.out.println("name = " + ageTextbox.getAttribute("name"));
		//value attribute for a textbox - retrives data from the textbox
		System.out.println("value = " + ageTextbox.getAttribute("value"));
		System.out.println("class = " + ageTextbox.getAttribute("class"));
		System.out.println("tagname = " + ageTextbox.getTagName());
		System.out.println("width :"+ageTextbox.getCssValue("width"));
		
		//findElements - name and List, size
		//import java.util.list
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
		
		//AgeLabel by xpath and css
		WebElement ageLabelByCss = driver.findElement(By.cssSelector("#calinputtable > tbody > tr:nth-child(1) > td:nth-child(1)"));
		System.out.println("AgeLabel Text by css : " +ageLabelByCss.getText());

		WebElement ageLabelByxpath = driver.findElement(By.xpath("//*[@id='calinputtable']/tbody/tr[1]/td[1]"));
		System.out.println("AgeLabel Text by xpath : " + ageLabelByxpath.getText());


		//linkText
		  driver.findElement(By.linkText("BMI")).click();//BMI Link Click 
		//From BMI Calculator - this Weight Watcher Points - i am doing from BMI Calculator
		  driver.findElement(By.partialLinkText("Watcher")).click();

	}
	
}
