package com.Zellis.Model.PojoClass;

public class Line {
	private String name;
	private Amount amount;
	private InputUnit inputUnit; // may be null if not present

	// Getters & Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Amount getAmount() {
		return amount;
	}

	public void setAmount(Amount amount) {
		this.amount = amount;
	}

	public InputUnit getInputUnit() {
		return inputUnit;
	}

	public void setInputUnit(InputUnit inputUnit) {
		this.inputUnit = inputUnit;
	}
}