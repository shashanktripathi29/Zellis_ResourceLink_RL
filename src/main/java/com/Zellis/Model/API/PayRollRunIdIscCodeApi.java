package com.Zellis.Model.API;

import com.Zellis.Config.Endpoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PayRollRunIdIscCodeApi {

	private static final Logger logger = LogManager.getLogger(PayRollRunIdIscCodeApi.class);

	/**
	 * Calls payroll-runs API and returns the raw Response.
	 * 
	 * @param accessToken    Bearer token
	 * @param sourceSystemId path param
	 * @param country        path param
	 */
	public static Response getPayrollRunResponse(String accessToken, String country) {
		logger.info("Calling PayrollRun API for country", country);

		return RestAssured.given().
				header("teamnumber", "123").
				header("Authorization", "Bearer " + accessToken).
				get(Endpoints.getpayrollRunIDUsingISCcodeURL("zellis", country)).
				then().
				statusCode(200).
				extract().
				response();
	}
}
