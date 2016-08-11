package com.budgethelper.model.funds;

import com.budgethelper.model.dao.FundDao;
import com.budgethelper.model.entity.Fund;

import java.util.ArrayList;

public class InMemoryFund implements FundDao {

	@Override
	public ArrayList<Fund> getAllFunds() {
		return null;
	}

	@Override
	public Fund getFundById(long id) {
		return null;
	}

	@Override
	public void connect(String dataBase, String userName, String password) {

	}

	@Override
	public void addFund() {

	}

	@Override
	public void updateFund() {

	}

	@Override
	public void removeFund(long id) {

	}
}
