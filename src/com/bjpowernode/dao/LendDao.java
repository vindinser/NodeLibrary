package com.bjpowernode.dao;

import com.bjpowernode.bean.Lend;

import java.util.List;

public interface LendDao {
	// 查询
	List<Lend> select(Lend lend);

	// 借阅
	void add(Lend lend);

	// 还书
	void delete(String id);

	// 修改
	void update(Lend lend);
}
