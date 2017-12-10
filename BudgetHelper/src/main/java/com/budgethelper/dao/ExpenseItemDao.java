package com.budgethelper.dao;

import com.budgethelper.model.ExpenseItem;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseItemDao extends JpaRepository<ExpenseItem, Long> {

    List<ExpenseItem> findAll();
}
