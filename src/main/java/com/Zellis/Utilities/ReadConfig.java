package com.Zellis.Utilities;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadConfig {
	Properties properties;
	String path = "C:\\Users\\INE12380099\\Documents\\ResourseLinkAutomation\\ResourseLinkAutomation\\Configuration\\config.properties";
	String testdata="C:\\Users\\INE12380099\\Documents\\ResourseLinkAutomation\\ResourseLinkAutomation\\src\\test\\resources\\testdata\\testdata.json";

	public ReadConfig() throws IOException {

		properties = new Properties();
		FileInputStream file = new FileInputStream(path);
		properties.load(file);

	}

	public String getBaseUrl() {
		String value = properties.getProperty("baseUrl");
		if (value != null)
			return value;
		else
			throw new RuntimeException("Base URL not found");
	}

	public static List<JSONObject> getTestData(String filePath, String jsonKey) throws IOException, ParseException {
		JSONParser parser = new JSONParser();
		FileReader reader = new FileReader(filePath);
		JSONObject JsonObject = (JSONObject) parser.parse(reader);
		JSONArray dataArray = (JSONArray) JsonObject.get(jsonKey);

		List<JSONObject> testDataList = new ArrayList<>();
		for (Object obj : dataArray) {
			testDataList.add((JSONObject) obj);
		}
		return testDataList;
	}
}