package com.Zellis.Model.PojoClass;

public class PayrollResponse {
	private Payments payments;
	private Deductions deductions;
	private Balances balances;
	
	private Pensions pensions;


	
	public Pensions getPensions() {
		return pensions;
	}

	
	public void setPensions(Pensions pensions) {
		this.pensions = pensions;
	}

	public Payments getPayments() {
		return payments;
	}

	public void setPayments(Payments payments) {
		this.payments = payments;
	}

	public Deductions getDeductions() {
		return deductions;
	}

	public void setDeductions(Deductions deductions) {
		this.deductions = deductions;
	}

	public Balances getBalances() {
		return balances;
	}

	public void setBalances(Balances balances) {
		this.balances = balances;
	}
}