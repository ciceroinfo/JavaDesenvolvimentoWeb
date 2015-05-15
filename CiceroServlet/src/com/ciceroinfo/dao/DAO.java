package com.ciceroinfo.dao;

import java.sql.SQLException;
import java.util.List;

public interface DAO<E> {

	public boolean add(E e) throws SQLException;

	public boolean remove(E e);

	public boolean edit(E e) throws SQLException;

	public List<E> getList();

	public Object getById(long id);

}
