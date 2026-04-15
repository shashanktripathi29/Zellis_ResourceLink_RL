package com.Zellis.Model.API;

import com.Zellis.Config.Endpoints;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DexPayslipGeneraterAPI {
	 public static Response getDexPayslipResponse(String accessToken,String colleagueUUID,String payrollrunId) {
		
		 
		 return RestAssured
                .given()
                .header("teamnumber", "123") 
                .header("Authorization", "Bearer " + accessToken)
                .get(Endpoints.getDexPayslipURL(colleagueUUID, payrollrunId))
            .then()
               .statusCode(200)
                .extract()
                .response();		 
	 }
	 
}
