package com.Zellis.Config;

public class Endpoints {

	// Base URLs
	private static final String TESCO_PPE_BASE_URL = "https://azure-eun.ppe.isc.tescocloud.com";
	private static final String AZURE_PPE_Tesco_Cloud_URL = "https://azure-eun.ppe.isc.tescocloud.com";
	                                                         
//	/colleague-experience/v1/dex-payslip/colleagues/{{colleagueUUID}}/payroll-runs/{{payrollRunId}}/payslip

	// Token URL
	public static String getTokenUrl() {
		return TESCO_PPE_BASE_URL + "/identity/v4/issue-token/token";
	}

	// Colleague API
	public static String getColleagueUrl() {
		return TESCO_PPE_BASE_URL + "/colleague/v3/facts/colleagues";
	}

	// Contractual Shifts API (needs colleagueUuid)
	public static String getContractualShiftUrl(String colleagueUuid) {
		return AZURE_PPE_Tesco_Cloud_URL
				+ "/timemanagement/ppe/timeapi-contractual-shifts-api/contractual-shift-patterns/colleagues/"
				+ colleagueUuid;
	}

	public static String getpayrollRunIDUsingISCcodeURL(String sourceSystemId, String country) {

		return AZURE_PPE_Tesco_Cloud_URL + "/compensation/v1/pay/pay-api/payrolls/" + sourceSystemId + "/countries/"
				+ country + "/payroll-runs";
	}

	public static String getDexPayslipURL(String collegueUUID, String payrollRunId) {
		return AZURE_PPE_Tesco_Cloud_URL + "/colleague-experience/v1/dex-payslip/colleagues/" + collegueUUID
				+ "/payroll-runs/" + payrollRunId + "/payslip";
	}
	
}
