package com.example.springcache;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.springcache.domain.Student;

@SpringBootApplication
@EnableCaching
public class SpringCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCacheApplication.class, args);
	}
	
	@Autowired
	@Qualifier(value ="std1")
	Student std1;
	@Qualifier(value ="std2")
	Student std2;
	
	 @Bean
	  public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
	     System.out.println("Check the bean "+(std1==std2) );
		 return args -> {
          //ctx. 
	      System.out.println("Let's inspect the beans provided by Spring Boot:");

	      String[] beanNames = ctx.getBeanDefinitionNames();
	      Arrays.sort(beanNames);
	      for (String beanName : beanNames) {
	        System.out.println(beanName);
	      }
	    };
	  }    
}
