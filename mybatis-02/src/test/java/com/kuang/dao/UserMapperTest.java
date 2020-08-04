package com.kuang.dao;

import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {
	@Test
	public void test(){
		//第一步：获取SqlSession对象
		SqlSession sqlSession = MybatisUtils.getSqlSession();

		//方式一:getMapper
		UserMapper userDao = sqlSession.getMapper(UserMapper.class);
		List<User> userList = userDao.getUserList();

		for (User user : userList){
			System.out.println(user);
		}

		//关闭SqlSession
		sqlSession.close();
	}


}
