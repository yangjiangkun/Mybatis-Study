package com.kuang.dao;

import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {
	@Test
	public void test(){
		//��һ������ȡSqlSession����
		SqlSession sqlSession = MybatisUtils.getSqlSession();

		//��ʽһ:getMapper
		UserMapper userDao = sqlSession.getMapper(UserMapper.class);
		List<User> userList = userDao.getUserList();

		for (User user : userList){
			System.out.println(user);
		}

		//�ر�SqlSession
		sqlSession.close();
	}


}
