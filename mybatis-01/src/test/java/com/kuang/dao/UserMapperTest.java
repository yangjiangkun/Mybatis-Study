package com.kuang.dao;

import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import javax.sound.midi.SoundbankResource;
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

	@Test
	public void getUserById(){
		//第一步：获取SqlSession对象\
		SqlSession sqlSession = MybatisUtils.getSqlSession();

		UserMapper mapper = sqlSession.getMapper(UserMapper.class);

		User user = mapper.getUserById(1);
		System.out.println(user);

		//关闭SqlSession
		sqlSession.close();
	}

	//增删改需要提交事务
	@Test
	public void addUser(){
		//第一步：获取SqlSession对象\
		SqlSession sqlSession = MybatisUtils.getSqlSession();

		UserMapper mapper = sqlSession.getMapper(UserMapper.class);

		int res = mapper.addUser(new User(4,"哈哈","123333"));

		if(res > 0) {
			System.out.println("插入成功!");

		}

		//提交事务
		sqlSession.commit();

		//关闭SqlSession
		sqlSession.close();
	}

	@Test
	public void updateUser(){
		//第一步：获取SqlSession对象\
		SqlSession sqlSession = MybatisUtils.getSqlSession();

		UserMapper mapper = sqlSession.getMapper(UserMapper.class);

		mapper.updateUser(new User(4,"呵呵","123123"));

		//提交事务
		sqlSession.commit();

		//关闭SqlSession
		sqlSession.close();
	}

	@Test
	public void deleteUser(){
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);

		mapper.deleteUser(4);
		sqlSession.commit();
		sqlSession.close();
	}



}
