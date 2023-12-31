package com.bjpowernode.service;

import com.bjpowernode.bean.Lend;

import java.util.List;

public interface LendService {
	// 查询
	List<Lend> select(Lend lend);

	// 借阅
	void add(int bookId, int userId);

	// 还书
	List<Lend> returnBook(Lend lend);

	// 修改
	void update(Lend lend);
}
