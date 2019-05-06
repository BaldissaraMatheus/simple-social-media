package br.com.uff.socialmedia.model.dao;

public interface Dao<T> {
	
	public void save(T object);
	
	public void delete(int index);
	
	public void lista();
	
	public T get(int index);
	
}