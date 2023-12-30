package com.bjpowernode.dao;

import com.bjpowernode.bean.Book;

import java.util.List;

public interface BookDao {
	// ≤È—ØÕº È
	List<Book> select(Book book);
}
