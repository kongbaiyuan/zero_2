package service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ReturnInfo;
import dao.Type_Dao;
import model.Book;
import model.Type;
import service.Type_Service;

@Service
public class Type_Service_Impl implements Type_Service{
	@Autowired
	Type_Dao dao;
	public ReturnInfo select(String where,Integer page,Integer max) {
		boolean canpage=page!=null;//≈–∂œ «∑Òªª“≥
		ReturnInfo info = new ReturnInfo();
		info.setList(dao.select(where,ReturnInfo.getLimit(page, max)));
		if(canpage)info.setCount(dao.selectcount(where));
		  return info;
	}
	public List<Type> selectfor(){
		return dao.selectfor();
	}
	public void insert(Type t) {
		dao.insert(t);
	}

	public void update(Type t) {
		dao.update(t);
		
	}

	public void delete(int id) {
		dao.delete(id);
	}

	public Type selectById(int id) {
		// TODO Auto-generated method stub
		return dao.selectById(id);
	}

}
