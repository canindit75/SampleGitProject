package com.caloriecalc.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	public static FileInputStream inputStream = null;
	public static Properties prop=null;
	public static String getProperty(String PropertyName) throws IOException{
		String PropertyValue= null;
		inputStream = new FileInputStream(new File(System.getProperty("user.dir")+"/src/com/caloriecalc/config/config.properties"));
		prop = new Properties();
		prop.load(inputStream);//this loads your property file
		PropertyValue = prop.getProperty(PropertyName);
		return PropertyValue;
	}
	
	
	public static void main(String args[]) throws IOException{
		System.out.println(PropertyReader.getProperty("appurl"));
	}

}
