package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private Properties prop;
	public Properties readConfig() 
	{
		prop = new Properties();
		System.out.println("Properties is going to Initalize");
		try {
		FileInputStream fi;
		fi = new FileInputStream(new File("src//test//resources//config//config.properties"));
			prop.load(fi);
		} catch (FileNotFoundException e) {
			System.out.println("config file is not found"+ e);
		}	
		catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Properties has been Initalized");
		return prop;
	
	}

}
