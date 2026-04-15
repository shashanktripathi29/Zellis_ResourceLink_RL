package com.Zellis.Model.PojoClass;

import java.util.List;

public class Subtotal {
	private List<InputUnit> inputUnits;
	private Amount amount;

	// Getters & Setters
	public List<InputUnit> getInputUnits() {
		return inputUnits;
	}

	public void setInputUnits(List<InputUnit> inputUnits) {
		this.inputUnits = inputUnits;
	}

	public Amount getAmount() {
		return amount;
	}

	public void setAmount(Amount amount) {
		this.amount = amount;
	}
}
