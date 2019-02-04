package com.fdmgroup.test.uiAutomation.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverUtilities {
	private static DriverUtilities driverUtilities;
	private WebDriver driver;

	public DriverUtilities() {
		super();
	}

	public static DriverUtilities getInstance() {
		if (driverUtilities == null) {
			driverUtilities = new DriverUtilities();
		}

		return driverUtilities;
	}

	public WebDriver getDriver() {
		if (driver == null) {
			createDriver();
		}
		return driver;
		
	}

	private void createDriver() {
		String driverName = getDriverName();
		
		switch (driverName) {
		case "Google Chrome":
			System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
			this.driver = new ChromeDriver();
			break;
		
		case "Firefox":
			System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\geckodriver.exe");
			this.driver = new FirefoxDriver();
			break;
			
		default:
			System.out.println("Not an appropriate driver.");
		}
	}

	private String getDriverName() {
		String driverName = "";
		Properties config = new Properties();
		File file = new File("src\\test\\resources\\config.properties");
		
		try {
			config.load(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (String key : config.stringPropertyNames()) {
			if(key.equals("browser")){
				driverName = config.getProperty(key);
			}
		}
		
		return driverName;
	}
}
