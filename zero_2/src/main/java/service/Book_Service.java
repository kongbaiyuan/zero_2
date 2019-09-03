package service;

import java.util.List;

import model.Book;
import model.Type;
import dao.ReturnInfo;

public interface Book_Service {

	public ReturnInfo select(String where,Integer page,Integer max);
	public Book selectById(int id);

	public void insert(Book t);

	public void update(Book t);

	public void delete(int id);
}
