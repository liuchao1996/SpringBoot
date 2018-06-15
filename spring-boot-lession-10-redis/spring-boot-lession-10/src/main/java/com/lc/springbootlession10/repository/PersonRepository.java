package com.lc.springbootlession10.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.NoRepositoryBean;

import com.lc.springbootlession10.entity.Person;

//一般用作父类的repository，有这个注解，spring不会去实例化该repository。
@NoRepositoryBean
public interface PersonRepository {
	
	 //   @Cacheable(cacheNames = "persons")
	    Person findPerson(String id);


//	    @CachePut(cacheNames = "persons")
	    boolean savePerson(Person person);
}
