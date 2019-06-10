package br.com.uff.socialmedia.model.dao;

import java.sql.Connection;

import br.com.uff.socialmedia.conector.Conector;

public interface Dao<T> {

	Connection con = Conector.getConnection();

	public void save(T object);

	public void delete(int index);

	public void lista();

}
