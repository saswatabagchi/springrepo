package com.example.springcache.service;

import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.example.springcache.domain.Student;

@Configuration
public class StudentConfig {
	
	 @Bean(name="std1")
	 //@Bean
	    public Student studentOne() {
		 System.out.println("inside bean 1" + new Date());
		 return new Student("1","saswata" ,"V");
		 //return new Student();-> as no constructor is ther in the class so in will throw compile time issue 
	    }

	    @Bean(name="std2")
	    //@Bean
	    public Student studentTwo() {
	    	System.out.println("inside bean 2");
	    	return new Student("2","antara" ,"Vq");
	    	//return new Student();
	    }

}
