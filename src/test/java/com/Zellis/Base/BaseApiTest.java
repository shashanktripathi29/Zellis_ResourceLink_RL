package com.Zellis.Base;


import com.Zellis.Utilities.TokenUtilities;

import java.io.IOException;

import org.testng.annotations.BeforeClass;

public class BaseApiTest {
	
	public static String employeeId = "55663007";
    public static String accessToken;
    public static String colleagueUUID;
    public static String payrollRunId;

    @BeforeClass
    public void setUp() throws IOException {
    	TokenUtilities tokenutilities=new TokenUtilities();
        accessToken = tokenutilities.getAccessToken();
    }
}
