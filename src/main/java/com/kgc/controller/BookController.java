package com.kgc.controller;

import com.kgc.entity.BookType;
import com.kgc.service.BookService;
import com.kgc.service.BookTypeService;
import com.kgc.util.BookParam;
import com.kgc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private BookTypeService bookTypeService;
    @RequestMapping("/index")
    public String index(@RequestParam(value = "pageNo",defaultValue ="1" )
                        Integer pageNo,
                        @RequestParam(value = "pageSize",defaultValue = "3")
                        Integer pageSize,
                        Integer typeid,
                        String author,
                        Double min_price,
                        Double max_price,
                        Model model){
        PageUtil page = bookService.getBookByPage(pageNo, pageSize, typeid, author, min_price, max_price);
        List<BookType> bookTypeList = bookTypeService.getBookTypeList();
        //数据回显的值,用BookParam封装
        BookParam bookParam=new BookParam();
        bookParam.setTypeid(typeid);
        bookParam.setAuthor(author);
        bookParam.setMin_price(min_price);
        bookParam.setMax_price(max_price);
        //将数据填充到作用域
        model.addAttribute("page",page);
        model.addAttribute("bookTypeList",bookTypeList);
        model.addAttribute("bookParam",bookParam);
        return "index";
    }

}
