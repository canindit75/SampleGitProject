package Launch_Locate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ChangeDropDownValues {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.calculator.net/calorie-calculator.html");
		//we are using Select class which helps us to change dropdown
		WebElement activitydd = driver.findElement(By.xpath("//*[@id='cactivity']"));
		Select ss= new Select(activitydd);
		System.out.println("Current default Dropdown Value : " + ss.getFirstSelectedOption().getText());
		//Identify by index - Sedentry - starts with 0
		ss.selectByIndex(1);
		Thread.sleep(2000);
		System.out.println("Dropdown Value changed by index to Sedentry : " + ss.getFirstSelectedOption().getText());
		ss.selectByValue("1.55"); //Moderately Active
		Thread.sleep(2000);
		System.out.println("Dropdown Value changed by value to Moderatively Active : " + ss.getFirstSelectedOption().getText());
		//Extra Active 
		ss.selectByVisibleText("Extra Active - very hard exercise/sports or physical job");
		Thread.sleep(2000);
		System.out.println("Dropdown Value changed by VisibleText to Extra Active : " + ss.getFirstSelectedOption().getText());
		
		WebElement ModerativelyActiveOption = driver.findElement(By.xpath("//*[@id='cactivity']/option[text()='Moderately Active - exercise/sports 3-5 times/week']"));
		System.out.println(ModerativelyActiveOption.getText());
		
		
		System.out.println("Is dropdown selection allows multiple select : "+ss.isMultiple()); //true if multiselect
		//for multiselect dropdown 
		//deselectAll
		//deselectByIndex, deselectByValue and deselectByVisibleText
		for(int i=0;i<ss.getOptions().size();i++){
		System.out.println(ss.getOptions().get(i).getText());
		if(ss.getOptions().get(i).getText().equals("Moderately Active - exercise/sports 3-5 times/week")){
			
		}
		}

		
	}

}
