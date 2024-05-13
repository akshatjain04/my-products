
package com.bootexample4.RoostTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Arrays;

// Test Loader loads the data from ENV, Properties File and CSV file in given order.
public class TestdataLoader {

	Properties properties = new Properties();

	private String fromENV(String name) {
		return System.getenv(name);
	}

	private void loadPropertiesFile() {
		String propertiesFileName = this.fromENV("PROPERTIES_FILE");
		InputStream content = null;
		try {
			if (propertiesFileName == null || propertiesFileName.equals("")) {
				content = getClass().getClassLoader().getResourceAsStream("application.properties");
			}
			else if (propertiesFileName.contains(File.separator)) {
				// handles if PROPERTIES_FILE contains path.
				content = new FileInputStream(propertiesFileName);
			}
			else {
				// handles if PROPERTIES_FILE is inside src/main/resources folder.
				content = getClass().getClassLoader().getResourceAsStream(propertiesFileName);
			}
			if (content != null) {
				this.properties.load(content);
			}
			else {
				System.out.println(
						"Skip loading from properties file. ENV['PROPERTIES_FILE'] or src/main/resources/application.properties file doesn't exists.");
			}
		}
		catch (IOException e) {
			String errorMessage = e.getMessage();
			System.out.printf("Skip loading from properties file as encountered error : %s" + errorMessage);
		}
	}

	private String fromPropertiesFile(String name) {
		return properties.getProperty(name);
	}

	private List<Map<String, String>> fromCSVFile(String filePath) {
		List<Map<String, String>> data = new ArrayList<>();
		String delimiter = "\\^\\|\\^";

		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			boolean headerSkipped = false;
			List<String> headers = new ArrayList<>();

			while ((line = br.readLine()) != null) {
				if (!headerSkipped) {
					headers.addAll(List.of(line.split(delimiter)));
					headerSkipped = true;
					continue;
				}

				String[] values = line.split(delimiter);
				if (values.length > 0) {
					Map<String, String> row = new HashMap<>();
					for (int i = 0; i < Math.min(headers.size(), values.length); i++) {
						row.put(headers.get(i), values[i].trim());
					}
					data.add(row);
				}
			}
		}
		catch (IOException e) {
			String errorMessage = e.getMessage();
			System.out.printf("Skip loading from csv file : %s" + errorMessage);
		}
		return data;
	}

	public List<Map<String, String>> load(String csvFileName, String[] envVarsList) {
		Map<String, String> envMap = new HashMap<>();
		List<Map<String, String>> csvData = this.fromCSVFile(csvFileName);
		List<Map<String, String>> envVars = new ArrayList<>();
		this.loadPropertiesFile();

		for (String key : envVarsList) {
			envMap.put(key, "");
			String value = this.fromENV(key);
			if (value != null) {
				envMap.put(key, value);
			}
			value = this.fromPropertiesFile(key);
			if (value != null) {
				envMap.put(key, value);
			}
		}
		for (Map<String, String> row : csvData) {
			Map<String, String> envMapwithCSV = new HashMap<>(envMap);
			for (Map.Entry<String, String> entry : row.entrySet()) {
				String key = entry.getKey();
				String value = entry.getValue();
				if (!value.equals("")) {
					envMapwithCSV.put(key, value);
				}
			}
			envVars.add(envMapwithCSV);
		}
		return envVars;
	}

}
