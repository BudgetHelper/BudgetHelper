package com.budgethelper.dao.impl;

import com.budgethelper.dao.ItemDao;
import com.budgethelper.model.Item;
import com.budgethelper.model.RegularItem;
import java.util.List;
import java.util.Objects;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public final class ItemDaoImpl extends CrudDaoImpl<Item> implements ItemDao {

	@Override
	public List<Item> getAllItems() {
		final Query<Item> query = this.getCurrentSession().createQuery("FROM Item");
		return query.list();
	}

	@Override
	public List<RegularItem> getAllRegularItems() {
		final Query<RegularItem> query = this.getCurrentSession().createQuery("FROM RegularItem");
		return query.list();
	}

	@Override
	public void addRegularItem(final RegularItem regularItem) {
		this.getCurrentSession().persist(regularItem);
	}

	@Override
	public void updateRegularItem(final RegularItem regularItem) {
		this.getCurrentSession().update(regularItem);
	}

	@Override
	public void deleteRegularItem(final RegularItem regularItem) {
		this.getCurrentSession().delete(regularItem);
	}

	@Override
	public boolean isRegularItemExists(final Long itemId) {
		final Query<RegularItem> query =
			this.getCurrentSession().createQuery("FROM RegularItem ri WHERE ri.item.id = :itemId");
		query.setParameter("itemId", itemId);
		return Objects.nonNull(query.getSingleResult());
	}
}
