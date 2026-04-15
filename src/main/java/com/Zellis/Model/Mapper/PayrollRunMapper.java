package com.Zellis.Model.Mapper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.Zellis.Model.PojoClass.PayrollRunDetailsIscCodePojo;
import com.Zellis.Utilities.TokenUtilities;

import io.restassured.response.Response;

/**
 * Maps PayrollRun API JSON response to PayrollRunDetailsIscCodePojo using
 * Jackson's JsonNode
 */
public class PayrollRunMapper {

	public static PayrollRunDetailsIscCodePojo fromResponse(Response response) {
		try {
			// ObjectMapper is the main Jackson class used to convert JSON --> Java objects.
			ObjectMapper mapper = new ObjectMapper();

			// Parse the JSON response into a tree structure (JsonNode).
			JsonNode root = mapper.readTree(response.asString());
			// Get the first payrollRun node.
			JsonNode payrollRunNode = root.get("payrollRuns").get(0);

			// Fill the Pojo
			PayrollRunDetailsIscCodePojo payrollRunDetails = new PayrollRunDetailsIscCodePojo();

			payrollRunDetails.setPayrollRunId(payrollRunNode.get("payrollRunId").asText());
			payrollRunDetails
					.setCountry(payrollRunNode.get("payrollGroup").get("payrollSource").get("country").asText());
			payrollRunDetails.setTaxYear(payrollRunNode.get("payrollPeriod").get("taxYear").asInt());
			payrollRunDetails.setStartDate(payrollRunNode.get("payrollPeriod").get("startDate").asText());
			payrollRunDetails.setEndDate(payrollRunNode.get("payrollPeriod").get("endDate").asText());
			payrollRunDetails.setTaxWeekNumber(payrollRunNode.get("payrollPeriod").get("taxWeekNumber").asInt());
			payrollRunDetails.setPayDate(payrollRunNode.get("payrollPeriod").get("payDate").asText());

			return payrollRunDetails;

		} catch (Exception e) {
			throw new RuntimeException("Failed to map PayrollRun API response", e);
		}
	}
}
