package com.budgethelper.view;

public interface View {

	// вывод в пользовательский интерфейс
	void write(String message);

	// ввод данных из пользовательского интерфейса
	String read();
}
