package com.caloriecalc.testcases;

import java.io.IOException;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.caloriecalc.pageobjects.CalorieCalcPage;
import com.caloriecalc.utils.ExcelReader;

public class CalorieCalcPageExcelTestCase {
	ChromeDriver driver;
	@BeforeMethod
	public void Initialize(){
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	@Test(dataProvider="getCalorieDetails")
	//public void CalorieCalcTestCaseMethod(String age, String sex, String weight) throws InterruptedException{
	public void CalorieCalcTestCaseMethod(Hashtable<String,String> caldata) throws InterruptedException{		
		driver.get("https://www.calculator.net/calorie-calculator.html");
		//pass the driver instance to pageobject
		CalorieCalcPage cp = new CalorieCalcPage(driver);
		//cp.EnterCalorieDetails("45", "m", "200");
		cp.EnterCalorieDetails(caldata.get("age"), caldata.get("sex"), caldata.get("weight"),caldata.get("heightinch"),caldata.get("heightfeet"));
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void CloseBrowser(){
		if(driver!=null){
		  driver.close(); //used to close the current browser which is opened via script
		  driver.quit();//used to quite all browsers opened via script
		}
	}
	@Test(dataProvider="login")
	//@Test(dataProvider="getLoginData")
	public void Login(String username, String password){
		System.out.println("username = " + username+ " password = " +password);
		
	}
	
	@DataProvider(name="login")
	public Object[][] getLoginData(){
		Object[][] obj = new Object[2][2];
		obj[0][0] = "user1";//username
		obj[0][1] = "pass1";//password
		obj[1][0] = "user2";
		obj[1][1] = "pass2";
		return obj;
	}
	
	
	@DataProvider //this is how it is marked as a dataprovider for testng testcase
	public Object[][] getCalorieDetails() throws IOException{
		String filepath= System.getProperty("user.dir")+"/src/com/caloriecalc/testdata";
		String filename="CalorieData.xlsx";
		String sheetname ="CalorieTestSet";
		return ExcelReader.ReadExcelDataToObjArr(filepath, filename, sheetname);
		
/*		Hashtable<String,String> record1 = new Hashtable<String,String>();
		record1.put("age","45");
		record1.put("sex","m");
		record1.put("weight","200");
		
		Hashtable<String,String> record2 = new Hashtable<String,String>();
		record2.put("age","56");
		record2.put("sex","f");
		record2.put("weight","300");

		Hashtable<String,String> record3 = new Hashtable<String,String>();
		record3.put("age","35");
		record3.put("sex","m");
		record3.put("weight","150");
		
		Object[][] obj = new Object[3][1];
		obj[0][0] = record1;
		obj[1][0] = record2;
		obj[2][0] = record3;
		return obj;
*/		
		

	/*	Object[][] obj = new Object[3][3];
		obj[0][0] = "45";//age
		obj[0][1] = "m";//sex
		obj[0][2] = "200";//weight
		
		obj[1][0] = "56";//age
		obj[1][1] = "f";//sex
		obj[1][2] = "300";//weight

		obj[2][0] = "35";//age
		obj[2][1] = "m";//sex
		obj[2][2] = "150";//weight

		return obj;
*/	}
	
}

