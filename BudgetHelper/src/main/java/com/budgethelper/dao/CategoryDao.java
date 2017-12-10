package com.budgethelper.dao;

import com.budgethelper.model.Category;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category, Long> {

	List<Category> findAll();
}
