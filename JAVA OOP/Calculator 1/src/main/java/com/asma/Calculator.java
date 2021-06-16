package com.asma;

public class Calculator {
	private double num1;
	private double num2;
	private char operator;
	private double result;
	public Calculator(double num1, char operator,double num2 ) {
		super();
		this.num1 = num1;
		this.num2 = num2;
		this.operator = operator;
	}
	public double getResults() {
		if (this.operator == '+') {
			 result = num1+num2;
		}if (this.operator == '-') {
			 result = num1-num2;
		}
		return result;
	}
}
