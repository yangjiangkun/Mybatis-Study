package com.kuang.dao;

import com.kuang.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {

	//��ȡ��ʦ
//	List<Teacher> getTeacher();

	//��ȡָ����ʦ�µ�����ѧ������ʦ����Ϣ
	Teacher getTeacher(@Param("tid") int id);

	//��ȡָ����ʦ�µ�����ѧ������ʦ����Ϣ
	Teacher getTeacher2(@Param("tid") int id);

}
