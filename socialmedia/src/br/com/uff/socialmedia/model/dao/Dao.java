package br.com.uff.socialmedia.model.dao;

import java.sql.Connection;

public interface Dao<T> {

	public void save(T object);

	public void delete(int index);
	
}