package com.bjpowernode.service;

import com.bjpowernode.bean.Lend;

import java.util.List;

public interface LendService {
	// ��ѯ
	List<Lend> select(Lend lend);

	// ����
	void add(int bookId, int userId);
}
