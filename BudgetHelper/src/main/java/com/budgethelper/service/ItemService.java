package com.budgethelper.service;

import com.budgethelper.model.Item;

import com.budgethelper.model.RegularItem;
import java.util.List;

public interface ItemService extends CrudService<Item> {

	List<Item> getAll();

	List<RegularItem> getRegularItems();

	void addRegularItem(RegularItem regularItem);

	void updateRegularItem(RegularItem regularItem);

	void deleteRegularItem(RegularItem regularItem);
}
