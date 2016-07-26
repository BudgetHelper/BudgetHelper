package com.budgethelper.model.funds;

import com.budgethelper.model.item.Item;

import java.math.BigDecimal;
import java.util.List;

public abstract class Fund {

	private String title;
	private BigDecimal value;
	private boolean isAccumulative;
	private List<Item> itemsList;

	public Fund(boolean isAccumulative, String title) {
		this.isAccumulative = isAccumulative;
		this.title = title;
	}

	public void addItem(Item item) {
		itemsList.add(item);
	}

//	TODO оставлять ли getters & setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public boolean isAccumulative() {
		return isAccumulative;
	}

	public void setAccumulative(boolean accumulative) {
		isAccumulative = accumulative;
	}

	public List<Item> getItemsList() {
		return itemsList;
	}

	public void setItemsList(List<Item> itemsList) {
		this.itemsList = itemsList;
	}


}
