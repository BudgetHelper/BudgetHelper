package com.budgethelper.service;

import com.budgethelper.model.Category;

import java.util.List;

public interface CategoryService extends CrudService<Category> {

	List<Category> findAll();
}
