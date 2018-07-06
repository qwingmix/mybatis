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
 *���ų���
 */
public class MybatisFirst {
	
//����id��ѯ�û���Ϣ���õ�һ����¼���
	@Test
	public void findUserByIdTest() throws IOException {
		
		//mybatis�����ļ�
		String resource = "SqlMapConfig.xml";
		
		//�õ������ļ���...
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		
		//�����Ự����������mybatis�������ļ���Ϣ
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		
		//ͨ�������õ�SqlSession
		//��һ��������ӳ���ļ���statement��id������namespace.statement��id
		//�ڶ���������ָ����ӳ���ļ�����ƥ���parameterType���͵Ĳ���
		//sqlSession.selectOne�Ľ������ӳ���ļ�����ƥ���resultType���Ͷ���
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = sqlSession.selectOne("test.findUserById", 1);
		System.out.println(user);
		
		//�ͷ���Դ
		sqlSession.close();
		
		
		
		
	}
	

}
