package testngPack;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNGExample {
	//I added reference to TestNG library - JavaBuildPath > Add Library > Select TestNG > Click Finish
	//Ctrl+Shift+O
	
	@BeforeSuite
	public void BeforeSuiteMethod(){
		System.out.println("BeforeSuite1");
	}

	
	@AfterSuite
	public void AfterSuiteMethod(){
		System.out.println("AfterSuite");
	}
	
	

	@BeforeMethod
	public void Initialize(){
		System.out.println("Initialize");
	}
	
	@AfterMethod
	public void TearDown(){
		System.out.println("TearDown");
	}
	@Test(priority=2)
	public void testngmethod(){
		System.out.println("Testng test");
	}

	@Test(priority=1)
	public void AccountEnquiry(){
		System.out.println("AccountEnquiry");
	}
	
	@Test(priority=0)
	public void Login(){
		System.out.println("Login");		
	}
	
}
