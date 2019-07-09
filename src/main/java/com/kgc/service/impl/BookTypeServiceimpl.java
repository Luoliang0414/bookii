package com.kgc.service.impl;

import com.kgc.dao.BookTypeDao;
import com.kgc.entity.BookType;
import com.kgc.service.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookTypeServiceimpl implements BookTypeService {
    @Autowired
    private BookTypeDao bookTypeDao;
    @Override
    public List<BookType> getBookTypeList() {
        return bookTypeDao.getBookTypeList();
    }
}
