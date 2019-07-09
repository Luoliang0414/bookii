package com.kgc.dao;

import com.kgc.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookDao {
    public int addBook(Book book);
    public int updateBook(Book book);
    public int deleteBook(Integer bookid);
    public Book detailBook(Integer bookid);
    public Book getById(Integer bookid);
    public List<Book> getBookByPage(@Param("pageNo")Integer pageNo,
                                    @Param("pageSize")Integer pageSize,
                                    @Param("typeid")Integer typeid,
                                    @Param("author")String author,
                                    @Param("min_price")Double min_price,
                                    @Param("max_price")Double max_price);
    public int getTotalCount( @Param("typeid")Integer typeid,
                              @Param("author")String author,
                              @Param("min_price")Double min_price,
                              @Param("max_price")Double max_price);
}
