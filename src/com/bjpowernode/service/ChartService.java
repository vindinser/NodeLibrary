package com.bjpowernode.service;

import java.util.Map;

public interface ChartService {
	// 查询不同类别下的书籍数量
	Map<String, Integer> bookTypeCount();
}
