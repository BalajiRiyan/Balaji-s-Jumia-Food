package com.genericutilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * This method is used to get values from Properties file.
 * @author Balaji
 *
 */
public class FileUtility {
	public String readDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream(IpathConstants.Filepath);
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
		
	}

}
