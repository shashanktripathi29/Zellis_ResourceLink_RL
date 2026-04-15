package com.Zellis.testcases;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AccessTokenFetcher {

    public static void main(String[] args) {

        String clientId = "8effa105-0181-4b60-9fe6-3a107812fc9a";        // your client_id
        String clientSecret = "5f7dfc48e29c133aa2f3da215624773b7054b52ba6e6c298523e3b12d4393579ICCSN";  // your client_secret

        // 1️⃣ Fetch access token
        Response tokenResponse = RestAssured
            .given()
                .auth()
                .preemptive()
                .basic(clientId, clientSecret)
                .contentType("application/x-www-form-urlencoded")
                .formParam("grant_type", "client_credentials")
            .when()
                .post("https://api-ppe.tesco.com/identity/v4/issue-token/token");

        System.out.println("Token request status: " + tokenResponse.getStatusCode());
        System.out.println("Token response body: " + tokenResponse.asPrettyString());

        if (tokenResponse.getStatusCode() == 200) {
            String accessToken = tokenResponse.jsonPath().getString("access_token");
            System.out.println("Access Token: " + accessToken);

            // 2️⃣ Use token to call colleagues API
            String baseUrl = "https://api-ppe.tesco.com";
            String endpoint = "/colleague/v2/colleagues";
            String employeeId = "17413042"; // Replace with actual employee ID

            Response apiResponse = RestAssured
                .given()
                    .baseUri(baseUrl)
                    .header("Authorization", "Bearer " + accessToken)
                    .queryParam("employeeId", employeeId)
                .when()
                    .get(endpoint)
                .then()
                    .statusCode(200)
                    .extract()
                    .response();

            System.out.println("Colleague API response:");
            System.out.println(apiResponse.getBody().asString());

        } else {
            System.out.println("Failed to fetch access token. Cannot call API.");
        }
    }
}
