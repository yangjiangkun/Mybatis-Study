package com.kuang.pojo;

import lombok.Data;

@Data
public class Student {
	private int id;
	private String name;

	//ѧ����Ҫ����һ����ʦ
	private Teacher teacher;

}