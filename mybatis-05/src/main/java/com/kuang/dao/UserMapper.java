package com.kuang.dao;

import com.kuang.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;


public interface UserMapper {

	@Select("select * from user")
	List<User> getUser();

	//�������ڶ�����������еĲ���ǰ��������@Param
	@Select("select * from user where id = #{id}")
	User getUserByID(@Param("id") int id);

	@Insert("insert into user(id,name,pwd) values (#{id},#{name},#{password})")
	int addUser(User user);

	@Update("update user set name=#{name},pwd=#{password} where id = #{id}")
	int updateUser(User user);

	@Delete("delete from user where id=#{uid}")
	int deleteUser(@Param("uid") int id);

}
