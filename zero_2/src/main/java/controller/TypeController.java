package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.ReturnInfo;
import model.Book;
import model.Type;
import service.Type_Service;

@Controller
@RequestMapping("Type")
public class TypeController {
	@Autowired
	Type_Service service;
	

	@ExceptionHandler
	public void ex(Exception e) {
		e.printStackTrace();
	}
	
	@RequestMapping("index")
	//参数写在这里,能自动注入
	public @ResponseBody ReturnInfo index(String txt,ModelMap m,Integer page,Integer limit) {
		// 查询时reload向后台传TXT参数
		
		if (txt != null && txt.length() > 0)
			txt = " where type.name like '%" + txt + "%'";
		else
			txt = "";
		// 上级类定义了page和limit,这两个值是前端转过来的
		
		return service.select(txt, page, limit);
	}
	@RequestMapping("edit")
	 public @ResponseBody Type edit(int id,ModelMap m) {
	
	 return service.selectById(id);
	 }
	
	 @RequestMapping("insert")
	 public @ResponseBody String insert(Type b,ModelMap m) {
	 service.insert(b);
	 return "{\"status\":1}";
	 }
	
		
	 @RequestMapping("update")
	 public @ResponseBody String update(Type b,ModelMap m) {
	 service.update(b);
	 
	 return "{\"status\":1}";
	 }
	
//	@RequestMapping("add")
//	public String  add(ModelMap m) {
//		return "Type/edit";
//	}
//	
//	@RequestMapping("edit")
//	public String  edit(int id,ModelMap m) {
//		m.put("info", service.selectById(id));
//		return add(m);
//	}
//	
//	@RequestMapping("insert")
//	public String  insert(Type b,ModelMap m) {
//		service.insert(b);
//		return index(m);
//	}
//	@RequestMapping("update")
//	public String  update(Type b,ModelMap m) {
//		service.update(b);
//		return index(m);
//	}
	@RequestMapping("delete")
	 public @ResponseBody String delete(int id,ModelMap m) {
	 service.delete(id);
	 return "{\"status\":1}";
	 }
}
