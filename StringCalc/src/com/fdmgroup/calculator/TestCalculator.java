package com.fdmgroup.calculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCalculator 
{

	@Test
	public void testDoCalculation_SingleDigit() 
	{
		Calculator calc = new Calculator();
		double answer = calc.doCalculation("3");
		assertTrue(answer == 3.0);
	}
	
	@Test
	public void testDoCalculation_NegativeSingleDigit() 
	{
		Calculator calc = new Calculator();
		double answer = calc.doCalculation("(-3)");
		assertTrue(answer == -3.0);
	}
	
	@Test
	public void testDoCalculation_NegativeSingleDigitAndParentheses() 
	{
		Calculator calc = new Calculator();
		double answer = calc.doCalculation("(-(-(-3)))");
		assertTrue(answer == -3.0);
	}
	
	@Test
	public void testDoCalculation_3digit() 
	{
		Calculator calc = new Calculator();
		double answer = calc.doCalculation("292");
		assertTrue(answer == 292.0);
	}
	
	@Test
	public void testDoCalculation_Letter() 
	{
		Calculator calc = new Calculator();
		double answer = calc.doCalculation("A");
		assertTrue(Double.isNaN(answer));
	}
	
	@Test
	public void testDoCalculation_Adding2Nums() 
	{
		Calculator calc = new Calculator();
		double answer = calc.doCalculation("6+3");
		assertTrue(answer == 9.0);
	}
	
	@Test
	public void testDoCalculation_Substracting2Nums() 
	{
		Calculator calc = new Calculator();
		double answer = calc.doCalculation("6-3");
		assertTrue(answer == 3.0);
	}
	
	@Test
	public void testDoCalculation_Multiplying2Nums() 
	{
		Calculator calc = new Calculator();
		double answer = calc.doCalculation("6*3");
		assertTrue(answer == 18.0);
	}
	
	@Test
	public void testDoCalculation_Dividing2Nums() 
	{
		Calculator calc = new Calculator();
		double answer = calc.doCalculation("6/3");
		assertTrue(answer == 2.0);
	}
	
	@Test
	public void testDoCalculation_AddingMoreThan2NumsWithOrWithoutSpaces() 
	{
		Calculator calc = new Calculator();
		double answer = calc.doCalculation("8 +     3 - 1/2.5");
		assertTrue(answer == 10.6);
	}
	
	@Test
	public void testDoCalculation_OtherOperators() 
	{
		Calculator calc = new Calculator();
		double answer = calc.doCalculation("10 * 1 + 2");
		assertTrue(answer == 12.0);
	}
	
	@Test
	public void testDoCalculation_Parentheses() 
	{
		Calculator calc = new Calculator();
		double answer = calc.doCalculation("(10 * (1 + 2))");
		assertTrue(answer == 30.0);
	}
	
	@Test
	public void testDoCalculation_SingleDigitWithParentheses() 
	{
		Calculator calc = new Calculator();
		double answer = calc.doCalculation("(3)");
		assertTrue(answer == 3.0);
	}
	
	@Test
	public void testDoCalculation_OrderOfOperators() 
	{
		Calculator calc = new Calculator();
		double answer = calc.doCalculation("4 + 2 * 10");
		assertTrue(answer == 24.0);
	}
	
	@Test
	public void testDoCalculation_OrderOfOperators2() 
	{
		Calculator calc = new Calculator();
		double answer = calc.doCalculation("4 / (1/2) + 2 * 10");
		assertTrue(answer == 28.0);
	}
	
	@Test
	public void testDoCalculation_OrderOfOperators3() 
	{
		Calculator calc = new Calculator();
		double answer = calc.doCalculation("(1 / ((2 + 3) - 4) * 10)");
		assertTrue(answer == 10.0);
	}

}
