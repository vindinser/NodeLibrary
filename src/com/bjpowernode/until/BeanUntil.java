package com.bjpowernode.until;

import java.lang.reflect.Field;

public class BeanUntil {
	/**
	 * 对象属性值的拷贝
	 * @param origin
	 * @param dest
	 */
	public static void populate(Object origin, Object dest) {
		try {
			// 使用反射
			// 两个对象是否是同意类型
			if(origin.getClass() != dest.getClass()) {
				throw new RuntimeException("两个对类型不同！无法拷贝");
			}

			// 获取字节码文件
			Class<?> clazz = origin.getClass();
			// 获取 原对象中的所有属性
			Field[] declaredFields = clazz.getDeclaredFields();

			// 循环原数组赋值
			for(Field f : declaredFields) {
				// 排除 serialVersionUID
				if("serialVersionUID".equals(f.getName())) {
					continue;
				}
				// 打破封装
				f.setAccessible(true);
				// 从dest中找到对应的属性值赋值到origin
				f.set(origin, f.get(dest));
			}
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
}
