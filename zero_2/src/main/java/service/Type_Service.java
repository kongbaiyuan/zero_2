package service;

import java.util.List;

import dao.ReturnInfo;
import model.Book;
import model.Type;

public interface Type_Service {
	public List<Type> selectfor();
	public ReturnInfo select(String where,Integer page,Integer max);
	
	public Type selectById(int id);
	
	public void insert(Type t);
	
	public void update(Type t);
	
	public void delete(int id);
}
