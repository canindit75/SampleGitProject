package Launch_Locate;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExtractWebTable {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.calculator.net/calorie-calculator.html");
		//identify the element table with class =cinfoT
		//WebElement table = driver.findElement(By.className("cinfoT"));
		WebElement table = driver.findElement(By.cssSelector(".cinfoT"));
		//i want to find all the table rows 
		//if i get all the rows with respect to driver - it will get the rows from page which 
		//can comprise of more than table 
		//our objective is to get the rows of the table with class = cinfoT
		//with respect to the table we will get the rows
		//because this table does not have any header rows we are directly getting cells using td tagname
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for(WebElement row : rows){
			List<WebElement> cols = row.findElements(By.tagName("td"));
			{
				for(WebElement col : cols){
					//i want to print all the cell values for a particular in one line by tabspace
					//retrieving value/text from between opening and closing tag requires use of getText()
					System.out.print(col.getText() + "\t");
				}
				System.out.println(""); //next line for the next row
			}
		}
		
		

	}

}
