package com.kuang.dao;

import com.kuang.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
	//��������
	int addBlog(Blog blog);

	//��ѯ����
	List<Blog> queryBlogIF(Map map);

	List<Blog> queryBlogChoose(Map map);

	//���²���
	int updateBlog(Map map);

	//��ѯ1-2-3�Ų��͵ļ�¼
	List<Blog> queryBlogForeach(Map map);

}
