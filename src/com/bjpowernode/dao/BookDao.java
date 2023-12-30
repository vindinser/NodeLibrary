package com.bjpowernode.dao;

import com.bjpowernode.bean.Book;

import java.util.List;

public interface BookDao {
	// 查询图书
	List<Book> select(Book book);

	// 添加图书
	void add(Book book);
}
