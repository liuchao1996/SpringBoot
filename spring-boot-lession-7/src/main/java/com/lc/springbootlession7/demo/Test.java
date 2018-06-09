package com.lc.springbootlession7.demo;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.lc.springbootlession7.model2.Person;


public class Test {

	public static void main(String[] args) throws Exception {
		InputStream inputStream = Resources.getResourceAsStream("mybatis/mybatis-config.xml");
		SqlSessionFactory  sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		Person person = session.selectOne("com.lc.springbootlession7.dao.PersonMapper.selectByPrimaryKey", 1);
		System.out.println(person);
		
		session.close();
	}

}
