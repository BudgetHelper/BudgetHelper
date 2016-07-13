package com.budgethelper.model.item;

import java.math.BigDecimal;
import java.util.Calendar;

public class Item {

	private String title;
	private BigDecimal value;
	private Calendar date;
	private boolean isRegular;

	public Item(String title, BigDecimal value, boolean isRegular) {
		this.title = title;
		this.value = value;
		this.isRegular = isRegular;
	}
}
