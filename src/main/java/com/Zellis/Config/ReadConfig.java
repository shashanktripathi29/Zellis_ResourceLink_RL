package com.Zellis.Config;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadConfig {
	 private  Properties properties;

	// Properties properties;
	 private final String path ="C:\\Users\\INE12380099\\OneDrive - Tesco\\Documents\\ResourseLinkAutomation\\ResourseLinkAutomation\\Configuration\\config.properties";
	private final String testdata = "C:\\Users\\INE12380099\\OneDrive - Tesco\\Documents\\ResourseLinkAutomation\\ResourseLinkAutomation\\src\\test\\resources\\testdata\\testdata.json";

	public ReadConfig() throws IOException {

		properties = new Properties();
		FileInputStream file = new FileInputStream(path);
		properties.load(file);

	}

    public String get(String key) {

		return properties.getProperty(key);
	}

	public String getBaseUrl() {
		String value = properties.getProperty("baseUrl");
		if (value != null)
			return value;
		else
			throw new RuntimeException("Base URL not found");
	}

	public static List<Map<String, String>> getTestData(String filePath, String jsonKey)
			throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		FileReader reader = new FileReader(filePath);
		JSONObject jsonObject = (JSONObject) parser.parse(reader);
		JSONArray dataArray = (JSONArray) jsonObject.get(jsonKey);

		List<Map<String, String>> testDataList = new ArrayList<>();
		for (Object obj : dataArray) {
			JSONObject jsonObj = (JSONObject) obj;

			Map<String, String> dataMap = new HashMap<>();
			for (Object key : jsonObj.keySet()) {
				dataMap.put(key.toString(), String.valueOf(jsonObj.get(key)));
			}
			testDataList.add(dataMap);
		}
		return testDataList;
	}

	public static List<JSONObject> getTestData1(String filePath, String jsonKey) throws IOException, ParseException {
		JSONParser parser = new JSONParser();
		FileReader reader = new FileReader(filePath);
		JSONObject JsonObject = (JSONObject) parser.parse(reader);
		JSONArray dataArray = (JSONArray) JsonObject.get(jsonKey);

		List<JSONObject> testDataList1 = new ArrayList<>();
		for (Object obj : dataArray) {
			testDataList1.add((JSONObject) obj);
		}
		return testDataList1;
	}

}