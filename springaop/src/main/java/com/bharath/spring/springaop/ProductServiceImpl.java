package com.bharath.spring.springaop;

public class ProductServiceImpl implements ProductService {

	@Override
	public int multiply(int num1, int num2) {
		int x = num1 * num2;
		return  x ;
	}
	


}
