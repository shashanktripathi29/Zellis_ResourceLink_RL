package com.Zellis.Utilities;

import java.io.*;

import org.openqa.selenium.WebDriver;

import com.Zellis.PageObject.BasePage;

public class UiUtilities extends BasePage{
	

	public UiUtilities(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private static final String PREFIX = "2525";
	private static final String FILE_PATH = "C:\\Users\\INE12380099\\Documents\\ResourseLinkAutomation\\ResourseLinkAutomation\\src\\test\\resources\\testdata\\lastNumber.txt";

	public  String getEmployeeNumber() throws IOException {
		int lastNumber = readLastNumber();
		int newNumber = lastNumber + 1;
		saveLastNumber(newNumber);
		return PREFIX + String.format("%04d", newNumber);
	}
	private static int readLastNumber() throws IOException {
		File file = new File(FILE_PATH);
		if (!file.exists()) {
			return 0;
		}
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			return Integer.parseInt(reader.readLine());
		}
	}

	private static void saveLastNumber(int number) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
			writer.write(String.valueOf(number));
		}
	}
	
}
