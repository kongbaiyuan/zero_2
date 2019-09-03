package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.ReturnInfo;
import model.Book;
import model.Type;
import service.Book_Service;
import service.Type_Service;

@Controller
@RequestMapping("Book")
public class BookController {
	@Autowired
	Book_Service tservice;
	@Autowired
	Type_Service service;

	@ExceptionHandler
	public void ex(Exception e) {
		e.printStackTrace();
	}


	
	@GetMapping("index")
	public @ResponseBody ReturnInfo index(String txt,ModelMap m,Integer page,Integer limit) {
		// 查询时reload向后台传TXT参数
		
		if (txt != null && txt.length() > 0)
			txt = " where book.name like '%" + txt + "%'";
		else
			txt = "";
		// 上级类定义了page和limit,这两个值是前端转过来的
		
		return tservice.select(txt, page, limit);
	}
	
//	 @RequestMapping("add")
//	 public String add(ModelMap m) {
//	tservice.in
//	 return "Book/edit";
//	 }
	
	 @GetMapping("edit/{id}")
	 public @ResponseBody Book edit(@PathVariable("id") int id,ModelMap m) {
		
	 return tservice.selectById(id);
	 }
	
	 @PostMapping("insert")
	 public @ResponseBody String insert(Book b,ModelMap m) {
		 System.err.println("afqa");
	 tservice.insert(b);
	 return "{\"status\":1}";
	 }
	@GetMapping("getSexs")
	 public @ResponseBody String[] getSexs(ModelMap m) {
			return Book.sexs;
		}
	@GetMapping("getTypes")
	 public @ResponseBody List<Type> getTypes(ModelMap m) {
			return service.selectfor();
		}
		
	 @PutMapping("update")
	 public @ResponseBody String update(Book b,ModelMap m) {
	 tservice.update(b);
	 
	 return "{\"status\":1}";
	 }
//	 @RequestMapping("delete")
	 @DeleteMapping("delete/{id}")
	 public @ResponseBody String delete(@PathVariable("id") int id,ModelMap m) {
		
	 tservice.delete(id);
	 return "{\"status\":1}";
	 }

}
