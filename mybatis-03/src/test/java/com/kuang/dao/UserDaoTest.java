package com.kuang.dao;

import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {
	@Test
	public void test(){
		//第一步：获取SqlSession对象
		SqlSession sqlSession = MybatisUtils.getSqlSession();

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

}
