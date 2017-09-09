package com.budgethelper.dao.impl;

import com.budgethelper.dao.CategoryDao;
import com.budgethelper.model.Category;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public final class CategoryDaoImpl extends CrudDaoImpl<Category> implements CategoryDao {

	@Override
	public List<Category> getAll() {
		final Query<Category> query = this.getCurrentSession().createQuery("FROM Category");
		return query.list();
	}
}
