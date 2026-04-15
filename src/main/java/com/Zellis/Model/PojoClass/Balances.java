package com.Zellis.Model.PojoClass;

import java.util.List;

public class Balances {
	private List<Group> groups;
	private Amount netPay;

	// Getters & Setters
	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	public Amount getNetPay() {
		return netPay;
	}

	public void setNetPay(Amount netPay) {
		this.netPay = netPay;
	}
}