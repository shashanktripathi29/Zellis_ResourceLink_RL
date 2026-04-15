package com.Zellis.APItestcases;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ColleagueCFApi123 {

    public static String getColleagueUuid(String accessToken, String employeeId) {
        String baseUrl = "https://api-ppe.tesco.com";
        String endpoint = "/colleague/v2/colleagues";

        Response apiResponse = RestAssured
                .given()
                .baseUri(baseUrl)
                .header("Authorization", "Bearer " + accessToken)
                .queryParam("employeeId", employeeId)
                .get(endpoint)
                .then()
                .statusCode(200)
                .extract()
                .response();

        // Example path: response.data[0].colleagueUuid (depends on actual JSON)
        String colleagueUuid = apiResponse.jsonPath().getString("data[0].colleagueUuid");

        return colleagueUuid;
    }
}
