package com.Zellis.Model.API;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.Zellis.Config.Endpoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ColleagueApi {
	private static final Logger logger = LogManager.getLogger(ColleagueApi.class);

	public static Response getColleagueResponse(String accessToken, String employeeId) {
		
		logger.info("Get Colleague Response-(Bearer token,Header,Quaryparam,Endpoint)");
		System.out.println("shashank"+ Endpoints.getColleagueUrl().toString());
				return RestAssured
                .given()
                    .header("Authorization", "Bearer " + accessToken)
                    .header("teamnumber", "123")
                    .queryParam("employeeId", employeeId)
                .get(Endpoints.getColleagueUrl())
                .then()
                    .statusCode(200)
                    .extract()
                    .response();
				
	}
}
