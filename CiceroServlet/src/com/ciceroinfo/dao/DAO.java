package com.ciceroinfo.dao;

import java.sql.SQLException;
import java.util.List;

public interface DAO<E> {

	public boolean add(E e) throws SQLException;

	public boolean remove(E e) throws SQLException;

	public boolean edit(E e) throws SQLException;

	public List<E> list() throws SQLException;

	public E getById(long id) throws SQLException;

}
