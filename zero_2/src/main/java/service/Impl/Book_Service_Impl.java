package service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.Book_Dao;
import model.Book;
import service.Book_Service;
import dao.ReturnInfo;

@Service
public class Book_Service_Impl implements Book_Service{
	@Autowired
	Book_Dao dao;
	
	//为了方便.做了一个returninfo类
		//page可能传,也可能不传,所以用integer类型
		public ReturnInfo select(String where,Integer page,Integer max) {
			boolean canpage=page!=null;//判断是否换页
			ReturnInfo info = new ReturnInfo();
			info.setList(dao.select(where,ReturnInfo.getLimit(page, max)));
			if(canpage)info.setCount(dao.selectcount(where));
			  return info;
		}

	
	public void insert(Book t) {
		dao.insert(t);
		
	}

	
	public void update(Book t) {
		dao.update(t);
		
	}

	
	public void delete(int id) {
		dao.delete(id);
		
	}


	//一种优化,加上limit 1 不用从头到尾查了
		public Book selectById(int id) {
			return  (Book) dao.select(" where book.id="+id," limit 1").get(0);
		}


		

}
