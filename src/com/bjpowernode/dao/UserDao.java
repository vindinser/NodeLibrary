package com.bjpowernode.dao;

import com.bjpowernode.bean.User;

import java.util.List;

// �û���ѯ
public interface UserDao {
  // �û���ѯ
  List<User> select();

  // ����û�
  void add(User user);
}
