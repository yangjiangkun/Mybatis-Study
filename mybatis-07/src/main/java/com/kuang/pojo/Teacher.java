package com.kuang.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Teacher {
	private int id;
	private String name;

	//һ����ʦӵ�ж��ѧ��
	private List<Student> students;
}
