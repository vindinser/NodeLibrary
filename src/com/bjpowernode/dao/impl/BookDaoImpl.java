package com.bjpowernode.dao.impl;

import com.bjpowernode.bean.Book;
import com.bjpowernode.bean.PathConstant;
import com.bjpowernode.dao.BookDao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookDaoImpl implements BookDao {

	/**
	 * 按条件搜索图书
	 * @param book
	 * @return
	 */
	@Override
	public List<Book> select(Book book) {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(PathConstant.BOOK_PATH));
			List<Book> bookList = (List<Book>)ois.readObject();
			if(bookList != null) {
				if(book == null || ("".equals(book.getBookName()) && "".equals(book.getIsbn()))) {
					return bookList;
				}
				// 条件查询
				ArrayList<Book> conditionList = new ArrayList<>();

				// 两个条件都输入
				if(!"".equals(book.getBookName()) && !"".equals(book.getIsbn())) {
					conditionList = (ArrayList<Book>)bookList.stream().filter(item -> (book.getBookName().equals(item.getBookName()) && book.getIsbn().equals(item.getIsbn()))).collect(Collectors.toList());
				} else{
					// 单个条件查询
					// 根据图书名称查询
					if(!"".equals(book.getBookName())) {
						conditionList = (ArrayList<Book>)bookList.stream().filter(item -> book.getBookName().equals(item.getBookName())).collect(Collectors.toList());
					}
					// 根据isbn查询
					if(!"".equals(book.getIsbn())) {
						conditionList = (ArrayList<Book>)bookList.stream().filter(item -> book.getIsbn().equals(item.getIsbn())).collect(Collectors.toList());
					}
				}
				return conditionList;
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (ois != null) {
					ois.close();
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return new ArrayList<>();
	}
}
