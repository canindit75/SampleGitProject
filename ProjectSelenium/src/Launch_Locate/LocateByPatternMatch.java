package Launch_Locate;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateByPatternMatch {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.calculator.net/calorie-calculator.html");

		System.out.println("Pattern match on attribute value id starting with c - xpath");
		List<WebElement> startswithxpathc =driver.findElements(By.xpath("//*[starts-with(@id,'c')]"));
		for(WebElement e :startswithxpathc )
			System.out.println(e.getAttribute("id"));
		
		System.out.println("Pattern match on attribute value name contains height - xpath");
		List<WebElement> containsxpathheight =driver.findElements(By.xpath("//*[contains(@name,'height')]"));
		for(WebElement e :containsxpathheight )
			System.out.println(e.getAttribute("name"));
		System.out.println("Pattern match on attribute value id starting with c - css");
		List<WebElement> startswithCssc =driver.findElements(By.cssSelector("[id^='c']"));
		for(WebElement e :startswithCssc )
			System.out.println(e.getAttribute("id"));
		System.out.println("Pattern match on attribute value name contains height - css");
		List<WebElement> containsCssheight =driver.findElements(By.cssSelector("[name*='height']"));
		for(WebElement e :containsCssheight )
			System.out.println(e.getAttribute("name"));


	}

}
