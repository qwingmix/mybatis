package cn.itcast.mybatis.first;


import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.itcast.mybatis.po.User;

/**
 * @author 64
 *入门程序
 */
public class MybatisFirst {
	
//根据id查询用户信息，得到一条记录结果
	@Test
	public void findUserByIdTest() throws IOException {
		
		//mybatis配置文件
		String resource = "SqlMapConfig.xml";
		
		//得到配置文件流...
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		
		//创建会话工厂，传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		
		//通过工厂得到SqlSession
		//第一个参数：映射文件中statement的id，等于namespace.statement的id
		//第二个参数：指定和映射文件中所匹配的parameterType类型的参数
		//sqlSession.selectOne的结果是与映射文件中所匹配的resultType类型对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = sqlSession.selectOne("test.findUserById", 1);
		System.out.println(user);
		
		//释放资源
		sqlSession.close();
		
		
		
		
	}
	

}
