import com.kuang.dao.UserMapper;
import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {


	@Test
	public void test(){
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);

		User user = mapper.queryUserById(1);
		System.out.println(user);

//		mapper.updateUser(new User(2,"aaaaaaaaa","bbbbbb"));

		sqlSession.clearCache();//手动清理缓存

		System.out.println("======================");
		User user2 = mapper.queryUserById(2);
		System.out.println(user2);

		System.out.println(user==user2);

		sqlSession.close();

	}

	/*
	* 小结：一级缓存默认是开启的，只在一次SqlSession中有效，也就是拿到连接到关闭连接这个区间段！
	* */



	@Test
	public void test1(){
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		SqlSession sqlSession2 = MybatisUtils.getSqlSession();

		UserMapper mapper = sqlSession.getMapper(UserMapper.class);

		UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);

		User user = mapper.queryUserById(1);
		System.out.println(user);

		sqlSession.close();

		User user2 = mapper2.queryUserById(1);
		System.out.println(user);

		User user3 = mapper2.queryUserById(2);
		System.out.println(user2);
		System.out.println(user3);

		User user4 = mapper2.queryUserById(2);
		System.out.println(user4);


		System.out.println(user==user2);

		sqlSession2.close();

	}

//	问题：我们需要将实体类序列化！否则就会报错！

//	小结：只要开启了二级缓存，在同一个Mapper下就有效；
//	     所有的数据都会先放在一级缓存中；
//	     只有当会话提交，或者关闭的时候，才会提交到二级缓存中！










}
