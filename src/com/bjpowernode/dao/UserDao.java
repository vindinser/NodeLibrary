package com.bjpowernode.dao;

import com.bjpowernode.bean.User;

import java.util.List;

// �û���ѯ
public interface UserDao {
  // �û���ѯ
  List<User> select();
	// ���ز�ѯ
  List<User> select(User user);

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

	// ��ѯ���Խ�����û�
	List<User> selectUserToLend();
}
