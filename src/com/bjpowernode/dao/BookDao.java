package com.bjpowernode.dao;

import com.bjpowernode.bean.Book;

import java.util.List;

public interface BookDao {
	// ��ѯͼ��
	List<Book> select(Book book);

	// ���ͼ��
	void add(Book book);

	// ɾ��ͼ��
	void delte(int id);

	// �޸�ͼ��
	void update(Book book);
}
