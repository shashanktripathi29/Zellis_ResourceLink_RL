package com.Zellis.Model.PojoClass;

public class PayrollRunDetailsIscCodePojo {
	private static  String payrollRunId;
	private String country;
	private int taxYear;
	private String startDate;
	private String endDate;
	private int taxWeekNumber;
	private String payDate;

	// getters and setters
	public String getPayrollRunId() {
		return payrollRunId;
	}

	public void setPayrollRunId(String payrollRunId) {
		this.payrollRunId = payrollRunId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getTaxYear() {
		return taxYear;
	}

	public void setTaxYear(int taxYear) {
		this.taxYear = taxYear;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getTaxWeekNumber() {
		return taxWeekNumber;
	}

	public void setTaxWeekNumber(int taxWeekNumber) {
		this.taxWeekNumber = taxWeekNumber;
	}

	public String getPayDate() {
		return payDate;
	}

	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
}
