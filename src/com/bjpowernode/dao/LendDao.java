package com.bjpowernode.dao;

import com.bjpowernode.bean.Lend;

import java.util.List;

public interface LendDao {
	// ��ѯ
	List<Lend> select(Lend lend);

	// ����
	void add(Lend lend);

	// ����
	void delete(String id);
}
