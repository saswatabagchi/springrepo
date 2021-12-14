package com.example.springcache.domain;

import java.util.Date;

import org.springframework.stereotype.Component;

//@Component
public class Student {
	String id;
	String name;
	String clz;

	public Student(String id, String name, String clz) {
		//super();
		System.out.println("inside constructor"+ new Date());
		this.id = id;
		this.name = name;
		this.clz = clz;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClz() {
		return clz;
	}

	public void setClz(String clz) {
		this.clz = clz;
	}

}
