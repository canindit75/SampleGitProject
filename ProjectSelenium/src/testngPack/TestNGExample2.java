package testngPack;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestNGExample2 {
	//I added reference to TestNG library - JavaBuildPath > Add Library > Select TestNG > Click Finish
	//Ctrl+Shift+O
	
	@BeforeSuite
	public void BeforeSuiteMethod(){
		System.out.println("BeforeSuite2");
	}
	@Ignore
	@Test(priority=2)
	public void testngmethod2(){
		System.out.println("Testng test");
	}

	@Test(priority=1,enabled=false)
	public void AccountEnquiry2(){
		System.out.println("AccountEnquiry");
	}
	
	@Test(priority=0)
	public void Login2(){
		System.out.println("Login");		
	}
	
}
