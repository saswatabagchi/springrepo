package com.in28minutes.database.databasedemo.resttempalte;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;




@Service
public class SpringRestClient {

	private static final String GET_EMPLOYEES_ENDPOINT_URL = "http://localhost:8080/api/v1/employees";
	private static final String GET_EMPLOYEE_ENDPOINT_URL = "http://localhost:8080/api/v1/employees/{id}";
	private static final String CREATE_EMPLOYEE_ENDPOINT_URL = "http://localhost:8080/api/v1/employees";
	private static final String UPDATE_EMPLOYEE_ENDPOINT_URL = "http://localhost:8080/api/v1/employees/{id}";
	private static final String DELETE_EMPLOYEE_ENDPOINT_URL = "http://localhost:8080/api/v1/employees/{id}";
	private static RestTemplate restTemplate = new RestTemplate();

	

	public List<Employee> getEmployees() throws JsonMappingException, JsonProcessingException {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		ResponseEntity<String> result = restTemplate.exchange(GET_EMPLOYEES_ENDPOINT_URL, HttpMethod.GET, entity,
				String.class);
		ObjectMapper objectMapper = new ObjectMapper();
		Employee[] empArray = objectMapper.readValue(result.getBody(), Employee[].class );
		List<Employee> emplist = Arrays.asList(empArray);
		System.out.println(result);
		return emplist ;

		
	}

	public Employee getEmployeeById(String id) {

		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		RestTemplate restTemplate = new RestTemplate();
		Employee result = restTemplate.getForObject(GET_EMPLOYEE_ENDPOINT_URL, Employee.class, params);
		System.out.println(result);
		return result;
	}

	public void createEmployee() {

		
		Employee newEmployee = new Employee("admin123", "admin123", "admin123@gmail.com");
		RestTemplate restTemplate = new RestTemplate();
		Employee result = restTemplate.postForObject(CREATE_EMPLOYEE_ENDPOINT_URL, newEmployee, Employee.class);
		System.out.println(result);
		MultiValueMap<String, String> headers = new HttpHeaders();
		headers.add("User-Agent", "EmployeeRestClient demo class");
		headers.add("Accept-Language", "en-US");
		HttpEntity<Employee> entity = new HttpEntity<>(newEmployee, headers);
		System.out.println(entity);
		ResponseEntity<Employee> result2 = restTemplate.postForEntity(CREATE_EMPLOYEE_ENDPOINT_URL, newEmployee, Employee.class);
		System.out.println(result2);
		
	}

	private void updateEmployee(String id) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		Employee updatedEmployee = new Employee("admin123", "admin123", "admin1235@gmail.com");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(UPDATE_EMPLOYEE_ENDPOINT_URL, updatedEmployee, params);
	}

	private void deleteEmployee(String id) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(DELETE_EMPLOYEE_ENDPOINT_URL, params);
	}
}
