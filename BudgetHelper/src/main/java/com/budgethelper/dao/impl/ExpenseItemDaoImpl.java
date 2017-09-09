package com.budgethelper.dao.impl;

import com.budgethelper.dao.ExpenseItemDao;
import com.budgethelper.model.ExpenseItem;
import java.time.LocalDateTime;
import java.util.List;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public final class ExpenseItemDaoImpl extends CrudDaoImpl<ExpenseItem> implements ExpenseItemDao {

    @Override
    public List<ExpenseItem> getAll() {
        final Query<ExpenseItem> query = this.getCurrentSession().createQuery("FROM ExpenseItem");
        return query.list();
    }

    @Override
    public List<ExpenseItem> getByCategory(final Long categoryId) {
        final Query<ExpenseItem> query = this.getCurrentSession().createQuery(
            "SELECT ei FROM ExpenseItem ei WHERE ei.category.id = :id"
        );
        query.setParameter("id", categoryId);
        return query.list();
    }

    @Override
    public List<ExpenseItem> getByFund(final Long fundId) {
        final Query<ExpenseItem> query = this.getCurrentSession().createQuery(
            "SELECT ei FROM ExpenseItem ei WHERE ei.fund.id = :id"
        );
        query.setParameter("id", fundId);
        return query.list();
    }

    @Override
    public List<ExpenseItem> getByDate(final LocalDateTime date) {
        final Query<ExpenseItem> query = this.getCurrentSession().createQuery(
            "SELECT ei FROM ExpenseItem ei WHERE date(ei.createdDate) = date(:date)"
        );
        query.setParameter("date", date);
        return query.list();
    }

    @Override
    public List<ExpenseItem> getByDatePeriod(final LocalDateTime startDate, final LocalDateTime endDate) {
        final Query<ExpenseItem> query = this.getCurrentSession().createQuery(
            "SELECT ei FROM ExpenseItem ei WHERE date(ei.createdDate) BETWEEN date(:start) AND date(:end)"
        );
        query.setParameter("start", startDate);
        query.setParameter("end", endDate);
        return query.list();
    }
}