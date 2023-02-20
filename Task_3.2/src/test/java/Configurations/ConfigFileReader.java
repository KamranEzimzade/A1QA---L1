package Configurations;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

	private Properties properties;
	private final String propertyFilePath = "src/main/resources/properties/config.properties";

	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	public String getBrowser() {
		String browser = properties.getProperty("browser");
		return browser;
	}

	public String getUrl() {
		String url = properties.getProperty("url");
		return url;
	}

	public String getAlertBtnText() {
		String alertText = properties.getProperty("alertBtnText");
		return alertText;
	}

	public String getConfirmBtnText() {
		String confirmBtnText = properties.getProperty("ConfirmBtnText");
		return confirmBtnText;
	}

	public String getConfirmResultText() {
		String confirmResult = properties.getProperty("ConfirmResultText");
		return confirmResult;
	}

	public String getPromptBtnText() {
		String promptBtnText = properties.getProperty("promptBtnText");
		return promptBtnText;
	}

	public String getNewTabText() {
		String newTabText = properties.getProperty("newTabText");
		return newTabText;
	}

}
