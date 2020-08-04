package com.kuang.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

//sqlSessionFactory--> sqlSession
public class MybatisUtils {

	private static SqlSessionFactory sqlSessionFactory;

	static {
		try {
			//ʹ��Mybatis��һ������ȡsqlSessionFactory����
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//��Ȼ����sqlSessionFactory������˼�壬���ǾͿ��Դ��л�ȡ��SqlSession��������
	//SqlSession ��ȫ�������������ݿ�ִ��SQL ������������з�����
	public static SqlSession getSqlSession(){
			return sqlSessionFactory.openSession();
	}
}
