package com.bjpowernode.service;

import com.bjpowernode.bean.User;

import java.util.List;

public interface UserService {
	// 用户查询
	List<User> select();

	// 添加用户
	void add(User user);

	// 修改用户
	void update(User user);
}
