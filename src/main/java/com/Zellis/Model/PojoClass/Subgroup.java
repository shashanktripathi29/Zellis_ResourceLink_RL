package com.Zellis.Model.PojoClass;

import java.util.List;

public class Subgroup {
	private String name;
	private String displayName; // optional field
	private List<Line> lines;
	private Subtotal subtotal;

	// Getters & Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public List<Line> getLines() {
		return lines;
	}

	public void setLines(List<Line> lines) {
		this.lines = lines;
	}

	public Subtotal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Subtotal subtotal) {
		this.subtotal = subtotal;
	}
}
