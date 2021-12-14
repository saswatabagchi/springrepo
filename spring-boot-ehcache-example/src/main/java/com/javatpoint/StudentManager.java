package com.javatpoint;
import java.util.HashMap;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
@Service
public class StudentManager 
{
static HashMap<Integer, Student> student = new HashMap<>();
static 
{
student.put(1, new Student(100, "Alex", "Male", "Berlin"));
student.put(2, new Student(101, "Tony", "Male", "Mexico"));
student.put(3, new Student(102, "Andrew", "Male", "Chicago"));
student.put(4, new Student(103, "Alexa", "Female", "Brussels"));
student.put(5, new Student(104, "Maria", "Female", "Houston"));
}
@Cacheable(cacheNames="demoCache", key="#id")
public Student getStudentById(Integer id) 
{
System.out.println("Fetching students data from cache");
return student.get(id);
}
}