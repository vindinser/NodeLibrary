package com.bjpowernode.until;

import java.lang.reflect.Field;

public class BeanUntil {
	/**
	 * ��������ֵ�Ŀ���
	 * @param origin
	 * @param dest
	 */
	public static void populate(Object origin, Object dest) {
		try {
			// ʹ�÷���
			// ���������Ƿ���ͬ������
			if(origin.getClass() != dest.getClass()) {
				throw new RuntimeException("���������Ͳ�ͬ���޷�����");
			}

			// ��ȡ�ֽ����ļ�
			Class<?> clazz = origin.getClass();
			// ��ȡ ԭ�����е���������
			Field[] declaredFields = clazz.getDeclaredFields();

			// ѭ��ԭ���鸳ֵ
			for(Field f : declaredFields) {
				// �ų� serialVersionUID
				if("serialVersionUID".equals(f.getName())) {
					continue;
				}
				// ���Ʒ�װ
				f.setAccessible(true);
				// ��dest���ҵ���Ӧ������ֵ��ֵ��origin
				f.set(origin, f.get(dest));
			}
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
}
