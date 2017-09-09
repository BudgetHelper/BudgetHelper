package com.budgethelper.dao;

import com.budgethelper.model.Item;
import com.budgethelper.model.RegularItem;
import java.util.List;

public interface ItemDao extends CrudDao<Item> {

	List<Item> getAllItems();

	List<RegularItem> getAllRegularItems();

	void addRegularItem(RegularItem regularItem);

	void updateRegularItem(RegularItem regularItem);

	void deleteRegularItem(RegularItem regularItem);

	boolean isRegularItemExists(Long itemId);
}
