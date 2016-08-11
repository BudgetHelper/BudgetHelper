package com.budgethelper.model.dao;


import com.budgethelper.model.entity.Fund;

import java.util.ArrayList;

public interface FundDao {

	ArrayList<Fund> getAllFunds();

	Fund getFundById(long id);

	void connect(String dataBase, String userName, String password);

	void addFund();

	void updateFund();

	void removeFund(long id);
}
