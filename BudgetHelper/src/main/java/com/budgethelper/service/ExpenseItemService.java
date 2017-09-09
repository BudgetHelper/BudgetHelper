package com.budgethelper.service;

import com.budgethelper.model.ExpenseItem;
import java.time.LocalDateTime;
import java.util.List;

public interface ExpenseItemService extends CrudService<ExpenseItem> {

    List<ExpenseItem> getAll();

    List<ExpenseItem> getByCategory(Long categoryId);

    List<ExpenseItem> getByFund(Long fundId);

    List<ExpenseItem> getByDate(LocalDateTime date);

    List<ExpenseItem> getByDatePeriod(LocalDateTime startDate, LocalDateTime endDate);
}
