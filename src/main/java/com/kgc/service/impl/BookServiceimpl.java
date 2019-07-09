package com.kgc.service.impl;

import com.kgc.dao.BookDao;
import com.kgc.entity.Book;
import com.kgc.service.BookService;
import com.kgc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceimpl implements BookService {
    @Autowired
    private BookDao bookDao;
    @Override
    public PageUtil getBookByPage(Integer pageNo, Integer pageSize, Integer typeid, String author, Double min_price, Double max_price) {
        int totalCount = bookDao.getTotalCount(typeid, author, min_price, max_price);
        PageUtil page=new PageUtil(pageNo,totalCount,pageSize);
        List<Book> list = bookDao.getBookByPage((page.getPageNo() - 1) * pageSize,
                pageSize, typeid, author, min_price, max_price);
        page.setList(list);
        return page;
    }
}
