package com.java.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Readconfig {
	Properties prop;
	
public	Readconfig() {
	File path=new File(".\\Configuration\\config.properties");
	FileInputStream file;
	try {
		file = new FileInputStream(path);
		prop=new Properties();
		prop.load(file);
	} catch (Exception e) {
		System.out.println("exception is"+e.getMessage());
	}
	
}
public String getAmazonApplicationUrl(){
	String amazonurl=prop.getProperty("amazonURL");
	return amazonurl;	
}
public String getFlipkartApplicationUrl(){
	String Filpkarturl=prop.getProperty("flipkartURL");
	return Filpkarturl ;	
}
public String getTripadvisorUrl(){
	String advisorurl=prop.getProperty("adviserUrl");
	return advisorurl;
	
}
public String Chrome(){
	String chrome=prop.getProperty("ChromePath");
	return chrome ;	
}
public String Ie(){
	String IE=prop.getProperty("IEpath");
	return IE ;	
}
public String firefox(){
	String firefox=prop.getProperty("firefoxPath");
	return firefox ;	
}



}
