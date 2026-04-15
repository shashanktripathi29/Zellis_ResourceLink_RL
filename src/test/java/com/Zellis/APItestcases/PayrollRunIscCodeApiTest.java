package com.Zellis.APItestcases;

import com.Zellis.Base.BaseApiTest;
import com.Zellis.Model.API.PayRollRunIdIscCodeApi;
import com.Zellis.Model.Mapper.PayrollRunMapper;
import com.Zellis.Model.PojoClass.PayrollRunDetailsIscCodePojo;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PayrollRunIscCodeApiTest extends BaseApiTest {
    private static final Logger logger = LogManager.getLogger(PayrollRunIscCodeApiTest.class);

    @Test
    public void getCurrentPayrollRunId() {
       
        String country = "GB";

        logger.info("Fetching payroll run data…");
        
        Response response = PayRollRunIdIscCodeApi.getPayrollRunResponse(accessToken,  country);
   
        PayrollRunDetailsIscCodePojo payrollRunDetailsIscCodePojo = PayrollRunMapper.fromResponse(response);
        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200");

        Assert.assertNotNull(payrollRunDetailsIscCodePojo.getPayrollRunId(), "PayrollRunId should not be null");
        System.out.println(payrollRunDetailsIscCodePojo.getPayrollRunId());
        System.out.println(payrollRunDetailsIscCodePojo.getCountry());
        System.out.println(payrollRunDetailsIscCodePojo.getTaxWeekNumber());
        logger.info(payrollRunDetailsIscCodePojo.getPayrollRunId());
        logger.info(payrollRunDetailsIscCodePojo.getPayDate());
        logger.info("getStartDate  - ", payrollRunDetailsIscCodePojo.getStartDate());
        BaseApiTest.payrollRunId = payrollRunDetailsIscCodePojo.getPayrollRunId();
        
    }
}
