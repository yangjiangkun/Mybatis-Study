import com.kuang.dao.UserMapper;
import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.List;

public class UserMapperTest {
	@Test
	public void test(){
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		List<User> users = mapper.getUser();
		for (User user : users){
			System.out.println(user);
		}
		sqlSession.close();
	}


	@Test
	public void test1(){
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User userByID = mapper.getUserByID(1);
		System.out.println(userByID);
		sqlSession.close();

	}

	@Test
	public void test2(){
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		mapper.addUser(new User(5,"hello","123123"));
		sqlSession.close();

	}

	@Test
	public void test3(){
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		mapper.updateUser(new User(5,"to","2222222"));
		sqlSession.close();

	}

	@Test
	public void test4(){
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		mapper.deleteUser(5);
		sqlSession.close();

	}
}
