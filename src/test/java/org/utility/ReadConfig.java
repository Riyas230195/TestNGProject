package org.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties properties;
	
	public ReadConfig() {
		
		File source =new File("./Configurations/config.properties");
		 try {
			
			FileInputStream inputStream =new FileInputStream(source) ;
			
			 
			 properties=new Properties();
			 properties.load(inputStream);
			 
			 } catch (Exception e) {
			System.out.println("Exception is:"+ e.getMessage());
		}
			
	}
	
	/**
	 * author Riyas
	 * @return
	 */
	
	public String getApplicationUrl() {
		String property = properties.getProperty("baseURL");
		return property;

	}
	
	
	public String getUserName() {
		String username2 = properties.getProperty("username");
		return username2;

	}
	
	
    public String getPassWord() {
	String password = properties.getProperty("password");
	return password;

}
		

}
