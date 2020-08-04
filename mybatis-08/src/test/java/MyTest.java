import com.kuang.dao.BlogMapper;
import com.kuang.pojo.Blog;
import com.kuang.utils.IDutils;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MyTest {

	@Test
	public void addInitBlog(){
		SqlSession session = MybatisUtils.getSqlSession();
		BlogMapper mapper = session.getMapper(BlogMapper.class);

		Blog blog = new Blog();
		blog.setId(IDutils.getId());
		blog.setTitle("Mybatis��˼�");
		blog.setAuthor("����˵");
		blog.setCreateTime(new Date());
		blog.setViews(9999);

		mapper.addBlog(blog);

		blog.setId(IDutils.getId());
		blog.setTitle("Java��˼�");
		mapper.addBlog(blog);

		blog.setId(IDutils.getId());
		blog.setTitle("Spring��˼�");
		mapper.addBlog(blog);

		blog.setId(IDutils.getId());
		blog.setTitle("΢������˼�");
		mapper.addBlog(blog);

		session.close();
	}

	@Test
	public void queryBlogIF(){
		SqlSession session = MybatisUtils.getSqlSession();
		BlogMapper mapper = session.getMapper(BlogMapper.class);

		HashMap map = new HashMap();
		map.put("title","Java��˼�");
		map.put("author","����˵");

		List<Blog> blogs = mapper.queryBlogIF(map);

		for (Blog blog : blogs){
			System.out.println(blog);
		}
	}

	@Test
	public void queryBlogChoose(){
		SqlSession session = MybatisUtils.getSqlSession();
		BlogMapper mapper = session.getMapper(BlogMapper.class);

		HashMap map = new HashMap();
//		map.put("title","Java��˼�");
		map.put("author","����˵");
		map.put("views",9999);

		List<Blog> blogs = mapper.queryBlogChoose(map);

		for (Blog blog : blogs){
			System.out.println(blog);
		}
	}

	@Test
	public void updateBlog(){
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

		HashMap map = new HashMap();
//		map.put("title","Java��˼�2");
		map.put("author","����˵2");
		map.put("id","7b01fd62753b4187a77fc25eb8bd2c4e");
//		map.put("views",9999);

		mapper.updateBlog(map);

		sqlSession.close();
	}



	@Test
	public void queryBlogForeach(){
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

		HashMap map = new HashMap();

		ArrayList<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(2);
		ids.add(3);

		System.out.println(ids);
		map.put("ids",ids);
		List<Blog> blogs = mapper.queryBlogForeach(map);

		for(Blog blog : blogs) {
			System.out.println(blog);
		}

		sqlSession.close();
	}

}
