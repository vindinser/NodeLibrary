package com.bjpowernode.service;

import com.bjpowernode.bean.Lend;

import java.util.List;

public interface LendService {
	// ≤È—Ø
	List<Lend> select(Lend lend);

	// ΩË‘ƒ
	void add(int bookId, int userId);
}
