package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import model.Book;



@Repository
public interface Book_Dao {
	
	//select book.*,type.name typename from book inner join type on type.id=book.typeid
	
	//分页时
	@Select("select Book.*,Type.name typename from type inner join book on type.id=book.typeid ${where} ${limit}")
	public List<Book> select(@Param("where") String where,@Param("limit") String limit);
	
	
	//当不分页时
	@Select("select count(1) from book inner join type on type.id=book.typeid ${where}")
	public int selectcount(@Param("where") String where);
	
	@Delete("delete from book where id=#{id} ")
	public void delete(int id);
	
//	@Select("select * from book where id=#{id}")
//	public Book selectById(Book t);
	
	@Insert("insert into book(name,sex,typeid) values(#{name},#{sex},#{typeid})")
	public void insert(Book t);
	
	@Update("update Book set name=#{name},sex=#{sex},typeid=#{typeid} where id=#{id}")
	public void update(Book t);
	
	
}
