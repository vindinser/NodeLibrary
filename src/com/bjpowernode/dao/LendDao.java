package com.bjpowernode.dao;

import com.bjpowernode.bean.Lend;

import java.util.List;

public interface LendDao {
	// ≤È—Ø
	List<Lend> select(Lend lend);

	// ΩË‘ƒ
	void add(Lend lend);

	// ªπ È
	void delete(String id);
}
