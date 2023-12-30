package com.bjpowernode.dao.impl;

import com.bjpowernode.bean.Book;
import com.bjpowernode.bean.Lend;
import com.bjpowernode.bean.PathConstant;
import com.bjpowernode.dao.LendDao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
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
				// ������ѯ
				ArrayList<Lend> conditionList = new ArrayList<>();

				// ��������������
				if(!"".equals(book.getBookName()) && !"".equals(book.getIsbn())) {
					conditionList = (ArrayList<Lend>)lendList.stream().filter(item -> (book.getBookName().equals(item.getBook().getBookName()) && book.getIsbn().equals(item.getBook().getIsbn()))).collect(Collectors.toList());
				} else{
					// ����������ѯ
					// ����ͼ�����Ʋ�ѯ
					if(!"".equals(book.getBookName())) {
						conditionList = (ArrayList<Lend>)lendList.stream().filter(item -> book.getBookName().equals(item.getBook().getBookName())).collect(Collectors.toList());
					}
					// ����isbn��ѯ
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
}