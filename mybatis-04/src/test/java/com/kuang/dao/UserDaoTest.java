package com.kuang.dao;

import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;


public class UserDaoTest {

	static Logger logger = Logger.getLogger(UserDaoTest.class);

	@Test
	public void test(){
		//��һ������ȡSqlSession����
		SqlSession sqlSession = MybatisUtils.getSqlSession();

		logger.info("���ԣ�����getUserLike�����ɹ���");

		//��ʽһ:getMapper
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = mapper.getUserById(1);

			System.out.println(user);


		//�ر�SqlSession
		sqlSession.close();
	}

	//select * from mybatis.user where id = #{id}
	//���ʹ�����
	//select id,name,pwd as password from mybatis.user where id = #{id}

	@Test
	public void testLog4j(){
		logger.info("info:������testLog4j");
		logger.debug("debug:������testLog4j");
		logger.error("error:������testLog4j");

	}

	@Test
	public void getUserByLimit(){
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("startIndex",0);
		map.put("pageSize",2);

		List<User> userList = mapper.getUserByLimit(map);
		for(User user : userList){
			System.out.println(user);
		}

		sqlSession.close();

	}


	@Test
	public void getUserByRowBounds(){
		SqlSession sqlSession = MybatisUtils.getSqlSession();

		//RowBoundsʵ��
		RowBounds rowBounds = new RowBounds(1, 2);


		//ͨ��java�������ʵ�ַ�ҳ
		List<User> userList = sqlSession.selectList("com.kuang.dao.UserMapper.getUserByRowBounds",null,rowBounds);

		for(User user : userList){
			System.out.println(user);
		}

		sqlSession.close();

	}

}
