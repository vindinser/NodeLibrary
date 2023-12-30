package com.bjpowernode.service.impl;

import com.bjpowernode.bean.Book;
import com.bjpowernode.dao.BookDao;
import com.bjpowernode.dao.impl.BookDaoImpl;
import com.bjpowernode.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
	private BookDao bookDao = new BookDaoImpl();
	/**
	 * 按条件搜索图书
	 * @param book
	 * @return
	 */
	@Override
	public List<Book> select(Book book) {
		return bookDao.select(book);
	}

	@Override
	public void add(Book book) {
		bookDao.add(book);
	}

	@Override
	public void delte(int id) {
		bookDao.delte(id);
	}
}
