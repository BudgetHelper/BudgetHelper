package com.budgethelper.service.impl;

import com.budgethelper.dao.CategoryDao;
import com.budgethelper.model.Category;
import com.budgethelper.service.CategoryService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryDao categoryDao;

    public CategoryServiceImpl(final CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public void save(final Category entity) {
        // do more
    }

    @Override
    public void update(final Category entity) {
        // do more
    }

    @Override
    public void delete(final Category entity) {
        // do more
    }

    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }
}
