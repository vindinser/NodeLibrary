package com.bjpowernode.service;

import com.bjpowernode.bean.Book;

import java.util.List;

public interface BookService {
	// ��ѯͼ��
	List<Book> select(Book book);
}
