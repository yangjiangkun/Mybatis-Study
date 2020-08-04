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

	@Test
	public void getUserById(){
		//��һ������ȡSqlSession����\
		SqlSession sqlSession = MybatisUtils.getSqlSession();

		UserMapper mapper = sqlSession.getMapper(UserMapper.class);

		User user = mapper.getUserById(1);
		System.out.println(user);

		//�ر�SqlSession
		sqlSession.close();
	}

	//��ɾ����Ҫ�ύ����
	@Test
	public void addUser(){
		//��һ������ȡSqlSession����\
		SqlSession sqlSession = MybatisUtils.getSqlSession();

		UserMapper mapper = sqlSession.getMapper(UserMapper.class);

		int res = mapper.addUser(new User(4,"����","123333"));

		if(res > 0) {
			System.out.println("����ɹ�!");

		}

		//�ύ����
		sqlSession.commit();

		//�ر�SqlSession
		sqlSession.close();
	}

	@Test
	public void updateUser(){
		//��һ������ȡSqlSession����\
		SqlSession sqlSession = MybatisUtils.getSqlSession();

		UserMapper mapper = sqlSession.getMapper(UserMapper.class);

		mapper.updateUser(new User(4,"�Ǻ�","123123"));

		//�ύ����
		sqlSession.commit();

		//�ر�SqlSession
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
