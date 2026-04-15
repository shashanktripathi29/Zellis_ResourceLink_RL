package com.Zellis.Model.Mapper;

import com.Zellis.Model.PojoClass.ColleagueDataPojo;
import com.Zellis.Model.PojoClass.DexPayslipPojo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;

public class DexPayslipMapper {

	public static DexPayslipPojo fromResponse(Response response) throws JsonMappingException, JsonProcessingException {

		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(response.asString(), DexPayslipPojo.class);
		} catch (Exception e) {
			throw new RuntimeException("Failed to map DexPayslip API response", e);
		}
	}
}