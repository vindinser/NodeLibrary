package com.bjpowernode.dao;

import java.util.Map;

public interface ChartDao {

	// 查询不同类别下的书籍数量
	Map<String, Integer> bookTypeCount();
}
