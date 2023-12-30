package com.bjpowernode.service;

import com.bjpowernode.bean.Book;

import java.util.List;

public interface BookService {
	// 查询图书
	List<Book> select(Book book);

	// 添加图书
	void add(Book book);

	// 删除图书
	void delte(int id);
}
