package com.budgethelper.dao.impl;

import com.budgethelper.dao.CrudDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CrudDaoImpl<E> implements CrudDao<E> {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(final E entity) {
		// todo test how works save
		this.sessionFactory.getCurrentSession().persist(entity);
	}

	@Override
	public void update(final E entity) {
		this.sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void delete(final E entity) {
		this.sessionFactory.getCurrentSession().delete(entity);
	}

	protected Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}
}
