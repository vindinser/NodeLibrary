package com.bjpowernode.service;

import com.bjpowernode.bean.User;

import java.util.List;

public interface UserService {
	// �û���ѯ
	List<User> select();

	// ����û�
	void add(User user);

	// �޸��û�
	void update(User user);

	// ɾ���û�
	void delete(int id);

	// �����û�
	void freeze(int id);

	// ��������û�
	void unFreeze(int id);
}
