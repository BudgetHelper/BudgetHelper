package com.budgethelper.model.funds;

public class FundForExpense extends Fund{

	private static final boolean IS_FUND_FOR_ACCUMULATIONS = false;


	public FundForExpense(String title) {
		super(IS_FUND_FOR_ACCUMULATIONS, title);
	}
}
