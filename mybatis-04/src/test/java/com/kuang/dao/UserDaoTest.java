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
		//第一步：获取SqlSession对象
		SqlSession sqlSession = MybatisUtils.getSqlSession();

		logger.info("测试，进入getUserLike方法成功！");

		//方式一:getMapper
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = mapper.getUserById(1);

			System.out.println(user);


		//关闭SqlSession
		sqlSession.close();
	}

	//select * from mybatis.user where id = #{id}
	//类型处理器
	//select id,name,pwd as password from mybatis.user where id = #{id}

	@Test
	public void testLog4j(){
		logger.info("info:进入了testLog4j");
		logger.debug("debug:进入了testLog4j");
		logger.error("error:进入了testLog4j");

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

		//RowBounds实现
		RowBounds rowBounds = new RowBounds(1, 2);


		//通过java代码层面实现分页
		List<User> userList = sqlSession.selectList("com.kuang.dao.UserMapper.getUserByRowBounds",null,rowBounds);

		for(User user : userList){
			System.out.println(user);
		}

		sqlSession.close();

	}

}
