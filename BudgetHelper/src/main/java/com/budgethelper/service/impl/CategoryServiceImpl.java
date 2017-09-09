package com.budgethelper.service.impl;

import com.budgethelper.dao.CategoryDao;
import com.budgethelper.model.Category;
import com.budgethelper.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public final class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	@Override
	public void save(final Category category) {
		this.categoryDao.add(category);
	}

	@Override
	public void update(final Category category) {
		this.categoryDao.update(category);
	}

	@Override
	public void delete(final Category category) {
		this.categoryDao.delete(category);
	}

	@Override
	public List<Category> getAll() {
		return this.categoryDao.getAll();
	}
}
