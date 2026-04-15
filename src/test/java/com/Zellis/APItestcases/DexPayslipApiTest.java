package com.Zellis.APItestcases;

import com.Zellis.Base.BaseApiTest;
import com.Zellis.Model.API.DexPayslipGeneraterAPI;
import com.Zellis.Model.PojoClass.Group;
import com.Zellis.Model.PojoClass.Line;
import com.Zellis.Model.PojoClass.PayrollResponse;
import com.Zellis.Model.PojoClass.Subgroup;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DexPayslipApiTest extends BaseApiTest {

	private static final Logger logger = LogManager.getLogger(DexPayslipApiTest.class);
	private Response dexPayslipResponse;
	private ObjectMapper mapper;
	private PayrollResponse payrollResponse;

	@Test
	public void verifyDexPayslipStatus() throws Exception {

		logger.info("Fetching DEX Payslip data…");

		Assert.assertNotNull(colleagueUUID, "Colleague UUID must be set from previous test");
		Assert.assertNotNull(payrollRunId, "Payroll Run Id must be set from previous test");

		// Call the API
		dexPayslipResponse = DexPayslipGeneraterAPI.getDexPayslipResponse(accessToken, colleagueUUID, payrollRunId);
		
		Assert.assertEquals(dexPayslipResponse.getStatusCode(), 200, "Status code should be 200");
	}
	
	@Test(dependsOnMethods = "verifyDexPayslipStatus")
	public void countPaymentsSubgroupsAndLines() throws Exception {

	    
	    if (payrollResponse == null) {
	        mapper = new ObjectMapper();
	        payrollResponse = mapper.readValue(dexPayslipResponse.asString(), PayrollResponse.class);
	    }

	    if (payrollResponse.getPayments() == null ||
	        payrollResponse.getPayments().getSubgroups() == null ||
	        payrollResponse.getPayments().getSubgroups().isEmpty()) {

	        logger.info("No payments available");
	        return;
	    }

	    int subgroupCount = 0;
	    int totalLineCount = 0;

	    for (Subgroup subgroup : payrollResponse.getPayments().getSubgroups()) {
	        subgroupCount++;
	        if (subgroup.getLines() != null) {
	            totalLineCount += subgroup.getLines().size();
	            System.out.println(totalLineCount);
	        }
	    }

	    logger.info("Total Payments Subgroups: {}", subgroupCount);
	    logger.info("Total Payments Lines across all Subgroups: {}", totalLineCount);

	  //  Assert.assertEquals(subgroupCount, expectedSubgroupCount);
	  // Assert.assertEquals(totalLineCount, expectedLineCount);
	}


	@Test(dependsOnMethods = "countPaymentsSubgroupsAndLines")
	public void getDexPayslipPayments() throws Exception {

		// Map to PayrollResponse
		mapper = new ObjectMapper();
		payrollResponse = mapper.readValue(dexPayslipResponse.asString(), PayrollResponse.class);

		if (payrollResponse.getPayments() != null && payrollResponse.getPayments().getSubgroups() != null
				&& !payrollResponse.getPayments().getSubgroups().isEmpty()) {

			logger.info("Payments Subgroups:");
			for (Subgroup subgroup : payrollResponse.getPayments().getSubgroups()) {
				logger.info("Subgroup: {}", subgroup.getName());

				logger.info(".............");
				if (subgroup.getLines() != null) {
					for (Line line : subgroup.getLines()) {
						String amount;
						if (line.getAmount() != null) {
							amount = line.getAmount().getCurrency() + " " + line.getAmount().getValue();
						} else {
							amount = "No amount";
						}
						logger.info("  Line: {} | Amount: {}", line.getName(), amount);
					}
				}logger.info(".............");
			}
		} else {
			logger.info("No Payment");
		}
	}
	
	@Test(dependsOnMethods = "getDexPayslipPayments")
	public void countDeductionsSubgroupsAndLines() throws Exception {

	    if (payrollResponse == null) {
	        mapper = new ObjectMapper();
	        payrollResponse = mapper.readValue(dexPayslipResponse.asString(), PayrollResponse.class);
	    }

	    if (payrollResponse.getDeductions() == null ||
	        payrollResponse.getDeductions().getSubgroups() == null ||
	        payrollResponse.getDeductions().getSubgroups().isEmpty()) {

	        logger.info("No deductions available");
	        return;
	    }

	    int subgroupCount = 0;
	    int totalLineCount = 0;

	    for (Subgroup subgroup : payrollResponse.getDeductions().getSubgroups()) {
	        subgroupCount++;
	        if (subgroup.getLines() != null) {
	            totalLineCount += subgroup.getLines().size();
	        }
	    }

	    logger.info("Total deduction Subgroups: {}", subgroupCount);
	    logger.info("Total deduction Lines across all Subgroups: {}", totalLineCount);

	    // Optional assertions if expected numbers are known
	    // Assert.assertEquals(subgroupCount, expectedSubgroupCount);
	    // Assert.assertEquals(totalLineCount, expectedLineCount);
	}


	@Test(dependsOnMethods = "countDeductionsSubgroupsAndLines")
	public void getDexPayslipDeduction() throws Exception {

		if (payrollResponse.getDeductions() != null && payrollResponse.getDeductions().getSubgroups() != null
				&& !payrollResponse.getDeductions().getSubgroups().isEmpty()) {

			logger.info("Deductions Subgroups:");
			for (Subgroup subgroup : payrollResponse.getDeductions().getSubgroups()) {
				logger.info("Subgroup: {}", subgroup.getName());

				if (subgroup.getLines() != null) {
					for (Line line : subgroup.getLines()) {
						String amount;
						if (line.getAmount() != null) {
							amount = line.getAmount().getCurrency() + " " + line.getAmount().getValue();
						} else {
							amount = "No amount";
						}
						logger.info("  Line: {} | Amount: {}", line.getName(), amount);
					}
				}
			}
		} else {
			logger.info("No Deduction");
		}
	}
	
	

	@Test(dependsOnMethods = "getDexPayslipDeduction")
	public void getDexPayslipBalance() throws Exception {

		if (payrollResponse.getBalances() != null && payrollResponse.getBalances().getGroups() != null
				&& !payrollResponse.getBalances().getGroups().isEmpty()) {

			logger.info("Balances Groups:");
			for (Group group : payrollResponse.getBalances().getGroups()) {
				logger.info("Group: {}", group.getName());

				if (group.getLines() != null) {
					for (Line line : group.getLines()) {
						String amount;
						if (line.getAmount() != null) {
							amount = line.getAmount().getCurrency() + " " + line.getAmount().getValue();
						} else {
							amount = "No amount";
						}
						logger.info("  Line: {}| Amount: {} ", line.getName(), amount);
					}
				}
			}
			if (payrollResponse.getBalances().getNetPay() != null) {
				logger.info("NetPay: {} {}", payrollResponse.getBalances().getNetPay().getCurrency(),
						payrollResponse.getBalances().getNetPay().getValue());
			}
		}
	}
}