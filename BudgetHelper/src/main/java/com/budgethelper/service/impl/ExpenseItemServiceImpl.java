package com.budgethelper.service.impl;

import com.budgethelper.dao.ExpenseItemDao;
import com.budgethelper.dao.ItemDao;
import com.budgethelper.model.ExpenseItem;
import com.budgethelper.model.RegularItem;
import com.budgethelper.service.ExpenseItemService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public final class ExpenseItemServiceImpl implements ExpenseItemService {

    @Autowired
    private ExpenseItemDao expenseItemDao;

    @Autowired
    private ItemDao itemDao;

    @Override
    public void save(final ExpenseItem expenseItem) {
        //todo Добавиль логику по добавлению нового RegularItem
        if (Objects.isNull(expenseItem.getItem())) {
            // todo save new Item
        }
        if (isItemPersistenceRequired(expenseItem)) {
            final RegularItem regularItem = new RegularItem();
        }
        expenseItem.setCreatedDate(LocalDateTime.now());
        this.expenseItemDao.add(expenseItem);
    }
    //todo Разобраться как будет работать save, update, delete RegularItem
    @Override
    public void update(final ExpenseItem expenseItem) {
        expenseItem.setUpdatedDate(LocalDateTime.now());
        this.expenseItemDao.update(expenseItem);
    }

    @Override
    public void delete(final ExpenseItem expenseItem) {
        this.expenseItemDao.delete(expenseItem);
    }

    @Override
    public List<ExpenseItem> getAll() {
        return this.expenseItemDao.getAll();
    }

    @Override
    public List<ExpenseItem> getByCategory(final Long categoryId) {
        return this.expenseItemDao.getByCategory(categoryId);
    }

    @Override
    public List<ExpenseItem> getByFund(final Long fundId) {
        return this.expenseItemDao.getByFund(fundId);
    }

    @Override
    public List<ExpenseItem> getByDate(final LocalDateTime date) {
        return this.expenseItemDao.getByDate(date);
    }

    @Override
    public List<ExpenseItem> getByDatePeriod(final LocalDateTime startDate, final LocalDateTime endDate) {
        return this.expenseItemDao.getByDatePeriod(startDate, endDate);
    }

    boolean isItemPersistenceRequired(final ExpenseItem expenseItem) {
        return expenseItem.isRegular() && !itemDao.isRegularItemExists(expenseItem.getItem().getId());
    }
}
