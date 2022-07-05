package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {

	//To read the values present in the config file
	
	private static ConfigManager manager;
	private static final Properties prop=new Properties();
	
	/*
	 * Create a private constructor and read the data with the help of InputStream
	 * And load the file with prop
	 */
	
	
	private ConfigManager() {
		/*
		 * Creating a private constructor and specifying where the config file is located
		 * then we're loading it into the properties file
		 */
	
		FileInputStream fis;
		try {
			fis=new FileInputStream("./resources/config.properties");
			prop.load(fis);
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public static ConfigManager getInstance() {
		/*
		 * We are creating an object for configmanager if it is null
		 */
		if(manager==null) {
			synchronized (ConfigManager.class) {
				manager=new ConfigManager();
			}
		}
		return manager;
	}
	
	public String getString(String key) {
		/*
		 * In this method, whatever the key we pass, it will load and fetch from the 
		 * config file
		 */
		return System.getProperty(key,prop.getProperty(key));
	}
}
