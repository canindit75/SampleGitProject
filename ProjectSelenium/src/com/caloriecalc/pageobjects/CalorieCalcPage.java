package com.caloriecalc.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalorieCalcPage {
	
	//identification of elements and methods 
	//you will not use steps for launching browser or hardcoding data
	//we are segregating testcase from business logic 
	//we pass the data from testcase 
	//for identifying elements by POM - selenium uses @FindBy
	@FindBy(id="cage")
	private WebElement ageTextbox;
	
	@FindBy(xpath="//*[@id='cpound']")
	private WebElement weightTextbox;
	
	@FindBy(name="csex")
	private List <WebElement> sexList;
	
	@FindBy(id="cheightinch")
	private WebElement heightinchTextbox;
	

	@FindBy(id="cheightfeet")
	private WebElement heightfeetTextbox;
	
	WebDriver driver; //locally declaring driver object instance 
	//which can be assigned the reference from the testcase
	public CalorieCalcPage(WebDriver driver){
		this.driver = driver;
		//PageFactory support class which is used for Initializing our page elements
		//when use @FindBy annotation otherwise it throws NullPointerException 
		PageFactory.initElements(driver, this);
	}
	
	public void EnterCalorieDetails(String age, String sex, String weight,String feet,String inch){
		ageTextbox.clear();
		ageTextbox.sendKeys(age);
		for(WebElement sexElement : sexList){
			if(sexElement.getAttribute("value").equals(sex)){
				if(!sexElement.isSelected()){
					sexElement.click();
					break;
				}
			}
		}
		
		weightTextbox.clear();
		weightTextbox.sendKeys(weight);
		//for every added column the method code for entering data is modified
		heightinchTextbox.clear();
		heightinchTextbox.sendKeys(inch);
		
		heightfeetTextbox.clear();
		heightfeetTextbox.sendKeys(feet);
		
	}

	public void EnterCalorieDetails1(String age, String sex, String weight){
		ageTextbox.clear();
		ageTextbox.sendKeys(age);
		for(WebElement sexElement : sexList){
			if(sexElement.getAttribute("value").equals(sex)){
				if(!sexElement.isSelected()){
					sexElement.click();
					break;
				}
			}
		}
		
		weightTextbox.clear();
		weightTextbox.sendKeys(weight);
		
	}


}
