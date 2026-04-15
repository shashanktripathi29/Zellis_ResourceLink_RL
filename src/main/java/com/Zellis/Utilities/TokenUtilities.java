package com.Zellis.Utilities;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.Zellis.Config.Endpoints;
import com.Zellis.Config.ReadConfig;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TokenUtilities {
	private static final Logger logger = LogManager.getLogger(TokenUtilities.class);

	public String getAccessToken() throws IOException {

		logger.info("Fetching access token from Token endpoint…");
		ReadConfig ReadConfig = new ReadConfig();
		String clientId = ReadConfig.get("UserName_PPE");
		String clientSecret = ReadConfig.get("Password_PPE");

		Response tokenResponse = RestAssured.given().auth().preemptive().basic(clientId, clientSecret)
				.contentType("application/x-www-form-urlencoded").header("teamnumber", "123").
				formParam("grant_type", "client_credentials")
				.post(Endpoints.getTokenUrl());

		if (tokenResponse.statusCode() == 200) {
			logger.info("Successfully fetched access token");
			return tokenResponse.jsonPath().getString("access_token");

		} else {
			logger.error("Failed to fetch token. Response: {}", tokenResponse.asString());
			throw new RuntimeException("Failed to fetch token: " + tokenResponse.asString());
		}
	}
}
