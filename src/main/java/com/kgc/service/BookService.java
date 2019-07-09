package com.kgc.service;

import com.kgc.util.PageUtil;

public interface BookService {
    public PageUtil getBookByPage(Integer pageNo,Integer pageSize,
                                  Integer typeid,
                                  String  author,
                                  Double min_price,
                                  Double max_price);
}
