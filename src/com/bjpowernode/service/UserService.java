package com.bjpowernode.service;

import com.bjpowernode.bean.User;

import java.util.List;

public interface UserService {
	// �û���ѯ
	List<User> select();

	// ����û�
	void add(User user);
}
