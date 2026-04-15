package com.Zellis.APItestcases;

import com.Zellis.Model.API.ColleagueApi;
import com.Zellis.Model.Mapper.ColleagueMapper;
import com.Zellis.Base.BaseApiTest;
import com.Zellis.Model.PojoClass.ColleagueDataPojo;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ColleagueFactApiTest extends BaseApiTest {

	private static final Logger logger = LogManager.getLogger(ColleagueFactApiTest.class);

	@Test
	public void testColleagueFactApi() {
		 // your test employee ID

		logger.info("Calling Colleague API to Get Colleague Response");
		Response response = ColleagueApi.getColleagueResponse(accessToken, employeeId);
		logger.info(response.asPrettyString());

		logger.info("Map response to pojo- takes response and return colleague object");
		ColleagueDataPojo colleagueDataPojoObj = ColleagueMapper.fromResponse(response);

		logger.info("Assert Status code, CollegueUUID, HCM id");
		Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200");
		Assert.assertNotNull(colleagueDataPojoObj.getColleagueUUID(), "Colleague UUID should not be null");
		Assert.assertTrue(colleagueDataPojoObj.getHcmid() > 0, "hcmid should be present");

		// Optionally print for debug
		logger.info("Colleague UUID: " + colleagueDataPojoObj.getColleagueUUID());
		logger.info("Colleague Employee ID: " + colleagueDataPojoObj.getEmployeeId());
		logger.info("Colleague HCM ID: " + colleagueDataPojoObj.getHcmid());
		
		BaseApiTest.colleagueUUID = colleagueDataPojoObj.getColleagueUUID();
	}
}
