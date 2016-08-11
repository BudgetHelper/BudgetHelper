package com.budgethelper.model.entity;

import java.math.BigInteger;
import java.util.Map;
import java.util.TreeMap;

public class BaseFund {

	BigInteger restMoney;
	Map<Integer, Fund> funds;
	BigInteger allFundsMoney;

	public BaseFund() {
		this.restMoney = BigInteger.valueOf(0);
		this.funds = new TreeMap<>();
		this.allFundsMoney = BigInteger.valueOf(0);
	}

	void addFund() {

	}

	void calculateAllFundsMoney() {

	}

	void transferFromBaseFundToFund() {

	}

	void transferFromFundToBaseFund() {

	}

	void transferBetweenFunds() {

	}


	/*
	* BaseFund содержит поля:
	* 	1) нераспределенный остаток
	*   2) список всех фондов
		*
	* Поведение BaseFund:
	* 	1) создание и инициализация фондов
	*   2) подсчет общего количесва средств по всем фондам
	*   3) перераспределение средств между фондами
	   *   3.1) взять из существующего фонда - положить в базовый фонд
	   *   3.2) взять из базового фонда - положить в указанный пользователем фонд
	   *   3.3) взять из существующего фонад - положить в указанный пользователем фонд
	* */
}
