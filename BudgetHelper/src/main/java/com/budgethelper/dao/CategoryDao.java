package com.budgethelper.dao;

import com.budgethelper.model.Category;

import java.util.List;

public interface CategoryDao extends CrudDao<Category> {

	List<Category> getAll();
}
