package com.budgethelper.service;

public interface CrudService<E> {

    void save(E entity);

    void update(E entity);

    void delete(E entity);
}
