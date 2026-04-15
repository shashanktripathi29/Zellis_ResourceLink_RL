package com.Zellis.Model.PojoClass;

import java.util.List;

public class Deductions {
	private List<Subgroup> subgroups;
	private Amount total;

	// Getters & Setters
	public List<Subgroup> getSubgroups() {
		return subgroups;
	}

	public void setSubgroups(List<Subgroup> subgroups) {
		this.subgroups = subgroups;
	}

	public Amount getTotal() {
		return total;
	}

	public void setTotal(Amount total) {
		this.total = total;
	}

}
