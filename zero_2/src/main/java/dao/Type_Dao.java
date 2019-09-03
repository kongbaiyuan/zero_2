package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import model.Book;
import model.Type;

@Repository
public interface Type_Dao {
	
	//分页时
		@Select("select * from type ${where} ${limit}")
		public List<Book> select(@Param("where") String where,@Param("limit") String limit);
		
		
		//当不分页时
		@Select("select count(1) from type ${where}")
		public int selectcount(@Param("where") String where);
	
		@Select("select * from type ")
		public List<Type> selectfor();
	
	@Select("select * from type where id=#{id}")
	public Type selectById(int id);
	
	@Insert("insert into type (name) values(#{name})")
	public void insert(Type t);
	
	@Update("update type set name=#{name} where id=#{id}")
	public void update(Type t);
	
	@Delete("delete from type where id=#{id} ")
	public void delete(int id);
	
	
}
