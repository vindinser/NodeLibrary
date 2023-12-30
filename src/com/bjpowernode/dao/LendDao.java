package com.bjpowernode.dao;

import com.bjpowernode.bean.Lend;

import java.util.List;

public interface LendDao {
	// ²éÑ¯
	List<Lend> select(Lend lend);

	// ½èÔÄ
	void add(Lend lend);
}
