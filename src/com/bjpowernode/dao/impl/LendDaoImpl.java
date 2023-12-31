package com.bjpowernode.dao.impl;

import com.bjpowernode.bean.Book;
import com.bjpowernode.bean.Lend;
import com.bjpowernode.bean.PathConstant;
import com.bjpowernode.dao.LendDao;
import com.bjpowernode.until.BeanUntil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LendDaoImpl implements LendDao {
	@Override
	public List<Lend> select(Lend lend) {
		Book book = lend == null ? new Book() : lend.getBook();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PathConstant.Lend_PATH))) {
			List<Lend> lendList = (List<Lend>)ois.readObject();

			if(lendList != null) {
				if(lend == null || ("".equals(book.getBookName()) && "".equals(book.getIsbn()))) {
					return lendList;
				}
				// 条件查询
				ArrayList<Lend> conditionList = new ArrayList<>();

				// 两个条件都输入
				if(!"".equals(book.getBookName()) && !"".equals(book.getIsbn())) {
					conditionList = (ArrayList<Lend>)lendList.stream().filter(item -> (book.getBookName().equals(item.getBook().getBookName()) && book.getIsbn().equals(item.getBook().getIsbn()))).collect(Collectors.toList());
				} else{
					// 单个条件查询
					// 根据图书名称查询
					if(!"".equals(book.getBookName())) {
						conditionList = (ArrayList<Lend>)lendList.stream().filter(item -> book.getBookName().equals(item.getBook().getBookName())).collect(Collectors.toList());
					}
					// 根据isbn查询
					if(!"".equals(book.getIsbn())) {
						conditionList = (ArrayList<Lend>)lendList.stream().filter(item -> book.getIsbn().equals(item.getBook().getIsbn())).collect(Collectors.toList());
					}
				}
				return conditionList;
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return new ArrayList<>();
	}

	@Override
	public void add(Lend lend) {
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(PathConstant.Lend_PATH));
			List<Lend> lendList = (List<Lend>)ois.readObject();
			lendList.add(lend);
			oos = new ObjectOutputStream(new FileOutputStream(PathConstant.Lend_PATH));
			oos.writeObject(lendList);
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
	 * 还书
	 * @param id
	 */
	@Override
	public void delete(String id) {
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(PathConstant.Lend_PATH));
			List<Lend> lendList = (List<Lend>) ois.readObject();
			if(lendList != null) {
				Lend originLend = lendList.stream().filter(item -> Objects.equals(id, item.getId())).findFirst().get();
				lendList.remove(originLend);

					oos = new ObjectOutputStream(new FileOutputStream(PathConstant.Lend_PATH));
					oos.writeObject(lendList);
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

	@Override
	public void update(Lend lend) {
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(PathConstant.Lend_PATH));
			List<Lend> lendList = (List<Lend>) ois.readObject();
			if(lendList != null) {
				Lend originLend = lendList.stream().filter(item -> Objects.equals(item.getId(), item.getId())).findFirst().get();
				BeanUntil.populate(originLend, lend);

				oos = new ObjectOutputStream(new FileOutputStream(PathConstant.Lend_PATH));
				oos.writeObject(lendList);
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
}
