package com.bjpowernode.dao.impl;

import com.bjpowernode.bean.Constant;
import com.bjpowernode.bean.PathConstant;
import com.bjpowernode.bean.User;
import com.bjpowernode.dao.UserDao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * �û�Dao��
 */
public class UserDaoImpl implements UserDao {
	  /**
	   * ��Ӳ�������ж�ȡ�ļ�
	   * @return
	   */
	  @Override
	  public List<User> select() {
			// �Զ��ر���
			try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PathConstant.USER_PATH))) {
				List<User> list = (List<User>) ois.readObject();
				return list;
			} catch(Exception e) {
				e.printStackTrace();
			}
			// ��������쳣���򷵻�һ��List����
			return new ArrayList<>();
	  }

	/**
	 * ����û�
	 * @param user
	 */
	@Override
	public void add(User user) {
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		try {
			// ��ȡ�ļ��е�List����
			ois = new ObjectInputStream(new FileInputStream(PathConstant.USER_PATH));
			List<User> list = (List<User>)ois.readObject();
			if(list != null) {
				// ���һ���û�
				User lastUser = list.get(list.size() - 1);
				// �����û����
				user.setId(lastUser.getId() + 1);
			} else {
				list = new ArrayList<>();
				user.setId(1001);
			}
			// ��user����ŵ�list��
			list.add(user);
			// ��listд���ļ�
			oos = new ObjectOutputStream(new FileOutputStream(PathConstant.USER_PATH));
			oos.writeObject(list);
		} catch (IOException e) {
				throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
		} finally {
			try {
				if(ois != null) {
					ois.close();
				}
				if(oos != null) {
					oos.close();
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

	/**
	 * �޸��û�
	 * @param user
	 */
	@Override
	public void update(User user) {
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		// ��list������ļ���ȡ��
		try {
			ois = new ObjectInputStream(new FileInputStream(PathConstant.USER_PATH));
			List<User> list = (List<User>)ois.readObject();
			if(list != null) {
				// ��list�в���Ҫ�޸ĵ�����
				User originUser = list.stream().filter(item -> item.getId() == user.getId()).findFirst().get();
				// �޸�����
				originUser.setName(user.getName());
				originUser.setMoney(user.getMoney());
				// �����ݳ־û����ļ���
				oos = new ObjectOutputStream(new FileOutputStream(PathConstant.USER_PATH));
				oos.writeObject(list);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if(ois != null) {
					ois.close();
				}
				if(oos != null) {
					oos.close();
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

	/**
	 * ɾ���û�
	 * @param id
	 */
	@Override
	public void delete(int id) {
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(PathConstant.USER_PATH));
			List<User> list = (List<User>) ois.readObject();
			// ʹ��stream������ɾ���û�
			User user = list.stream().filter(item -> item.getId() == id).findFirst().get();
			// ��list��ɾ��
			list.remove(user);
			// �־û����ļ���
			oos = new ObjectOutputStream(new FileOutputStream(PathConstant.USER_PATH));
			oos.writeObject(list);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if(ois != null) {
					ois.close();
				}
				if(oos != null) {
					oos.close();
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

	/**
	 * �����û�
	 * @param id
	 */
	@Override
	public void freeze(int id) {
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(PathConstant.USER_PATH));
			List<User> list = (List<User>) ois.readObject();
			User user = list.stream().filter(item -> item.getId() == id).findFirst().get();
			user.setStatus(Constant.USER_FROZEN);
			oos = new ObjectOutputStream(new FileOutputStream(PathConstant.USER_PATH));
			oos.writeObject(list);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if(ois != null) {
					ois.close();
				}
				if(oos != null) {
					oos.close();
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
