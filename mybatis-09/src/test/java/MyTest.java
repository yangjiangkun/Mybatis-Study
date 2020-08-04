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

		sqlSession.clearCache();//�ֶ�������

		System.out.println("======================");
		User user2 = mapper.queryUserById(2);
		System.out.println(user2);

		System.out.println(user==user2);

		sqlSession.close();

	}

	/*
	* С�᣺һ������Ĭ���ǿ����ģ�ֻ��һ��SqlSession����Ч��Ҳ�����õ����ӵ��ر������������Σ�
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

//	���⣺������Ҫ��ʵ�������л�������ͻᱨ��

//	С�᣺ֻҪ�����˶������棬��ͬһ��Mapper�¾���Ч��
//	     ���е����ݶ����ȷ���һ�������У�
//	     ֻ�е��Ự�ύ�����߹رյ�ʱ�򣬲Ż��ύ�����������У�










}
