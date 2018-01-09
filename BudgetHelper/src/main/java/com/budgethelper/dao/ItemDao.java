package com.budgethelper.dao;

import com.budgethelper.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDao extends JpaRepository<Item, Long> {

}
