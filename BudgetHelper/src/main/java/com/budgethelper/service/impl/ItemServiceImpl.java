package com.budgethelper.service.impl;

import com.budgethelper.dao.ItemDao;
import com.budgethelper.model.Item;
import com.budgethelper.model.RegularItem;
import com.budgethelper.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public final class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDao itemDao;

	@Override
	public void save(final Item item) {
		this.itemDao.add(item);
	}

	@Override
	public void update(final Item item) {
		this.itemDao.add(item);
	}

	@Override
	public void delete(final Item item) {
		this.itemDao.delete(item);
	}

	@Override
	public List<Item> getAll() {
		return this.itemDao.getAllItems();
	}

	@Override
	public List<RegularItem> getRegularItems() {
		return null;
	}

	@Override
	public void addRegularItem(final RegularItem regularItem) {

	}

	@Override
	public void updateRegularItem(final RegularItem regularItem) {

	}

	@Override
	public void deleteRegularItem(final RegularItem regularItem) {

	}
}
