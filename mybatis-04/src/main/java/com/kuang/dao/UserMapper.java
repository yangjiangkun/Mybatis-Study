package com.kuang.dao;

import com.kuang.pojo.User;

import java.util.List;
import java.util.Map;


public interface UserMapper {
//	//��ѯȫ���û�
//	List<User> getUserList();

	//����ID��ѯ�û�
	User getUserById(int id);

//	//insertһ���û�
//	int addUser(User user);
//
//
//	//�޸��û�
//	int updateUser(User user);
//
//	//ɾ��һ���û�
//	int deleteUser(int id);

   //��ҳ
	List<User> getUserByLimit(Map<String,Integer> map);

	//��ҳ2
	List<User> getUserByRowBounds();
}
