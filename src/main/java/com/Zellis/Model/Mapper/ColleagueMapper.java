package com.Zellis.Model.Mapper;



import com.Zellis.Model.PojoClass.ColleagueDataPojo;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;

public class ColleagueMapper {

    public static ColleagueDataPojo fromResponse(Response response) {
        try {
        	//ObjectMapper is the main Jackson class used to convert JSON----> Java objects.
            ObjectMapper mapper = new ObjectMapper();
          //  Jackson library. JsonNode is a tree representation of JSON (like a DOM for JSON)
            JsonNode root = mapper.readTree(response.asString());
			JsonNode colleagueNode = root.get("colleagues").get(0);
			System.out.println("colleagueNode shashank"+colleagueNode);

            ColleagueDataPojo colleagueDataPojo = new ColleagueDataPojo();
            colleagueDataPojo.setColleagueUUID(colleagueNode.get("colleagueUUID").asText());
            colleagueDataPojo.setEmployeeId(colleagueNode.get("employeeId").asText());
            colleagueDataPojo.setHcmid(colleagueNode.get("externalSystems").get("hcm").get("id").asInt());
            colleagueDataPojo.setSalaryFrequency(colleagueNode.get("workRelationships").get(0).get("salaryFrequency").asText());

            return colleagueDataPojo;
        } catch (Exception e) {
            throw new RuntimeException("Failed to map colleague API response", e);
        }
    }
}
