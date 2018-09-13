package com.fdmgroup.calculator;

import java.util.ArrayList;


public class Calculator 
{
	public double doCalculation(String expression)
	{
		double answer = 0;
		
		try
		{
			if (expression.indexOf("+") != -1 || expression.indexOf("-") != -1 || 
				expression.indexOf("*") != -1 || expression.indexOf("/") != -1 ||
				(expression.indexOf("(") != -1 && expression.indexOf(")") != -1))
			{
				String reg = "((?<=[<=|>=|==|\\+|\\*|\\-|<|>|/|=|(|)])|(?=[<=|>=|==|\\+|\\*|\\-|<|>|/|=|(|)]))";
				ArrayList<String> exp = new ArrayList<String>();
				ArrayList<Double> number = new ArrayList<Double>();
				ArrayList<String> operator = new ArrayList<String>();

				for (String each: expression.split(reg))
					exp.add(each);
				
				exp.remove("");

				//recursive if parentheses exist
				if (expression.indexOf("(") != -1 || expression.indexOf(")") != -1)
				{
					int indexOfOpen = 0;
					int indexOfClose = 0;
					int listSize = 0;
					String newStr = new String();
					
					//find the index of the outer open parentheses
					int openPath = 0;
					for (String each: exp)
					{
						if (each.equals("("))
						{	
							indexOfOpen = openPath;
							break;
						}
						openPath++;
					}
				
					//find the index of the outer close parentheses
					int closePath = 0;
					int numOfClose = 0;
					int numOfOpen = 0;
					for (String each: exp)
					{	
						if (each.equals("("))
							numOfOpen++;
						
						if (each.equals(")"))
						{
							indexOfClose = closePath;
							numOfClose++;
						}
						closePath++;
						
						if (numOfOpen == numOfClose && indexOfOpen < indexOfClose)
						{
							for (String each2: exp.subList(indexOfOpen + 1, indexOfClose))
								newStr += each2;
							
							exp.set(indexOfOpen, Double.toString(doCalculation(newStr)));
							for (int i = 0; i < indexOfClose - indexOfOpen; i++)
								exp.remove(indexOfOpen + 1);
							
							newStr = "";
							
							for (String each3: exp)
								newStr += each3;
							
							if (newStr.indexOf("(") != -1 || newStr.indexOf(")") != -1)
								newStr = Double.toString(doCalculation(newStr));
							
							break;
						}
					}

					listSize = exp.size();
					for (int i = 0; i < listSize; i++)
						exp.remove(0);
					
					for (String each: newStr.split(reg))
						exp.add(each);
				}
				
				exp.remove(" ");
				
				//assign numbers and operators to ArrayList<double> and ArrayList<String>
				for (String each: exp)
				{
					if (isNumeric(each))
						number.add(Double.parseDouble(each));
					else
						operator.add(each);
				}
				
				//Math Order
				int opsIndex = 0;
				int remove = 0;
				
				if (operator.indexOf("/") != -1 || operator.indexOf("*") != -1)
				{
					for (String ops: operator)
					{
						if (ops.equals("/"))
						{
							number.set(opsIndex - remove, divide(number.get(opsIndex - remove), number.get(opsIndex + 1 - remove)));
							number.remove(opsIndex + 1 - remove);
							remove++;
						}
					
						if (ops.equals("*"))
						{
							number.set(opsIndex - remove, multiply(number.get(opsIndex - remove), number.get(opsIndex + 1 - remove)));
							number.remove(opsIndex + 1 - remove);
							remove++;
						}
						opsIndex++;
					}
				}
				
				operator.remove("*");
				operator.remove("/");
				operator.remove("");
				

				//Only adding and subtracting
				int opsCount = 0;
				
				for (String each: operator)
				{
				    if (each.equals("+"))
					{
				    	if (operator.indexOf("+") == opsCount && operator.indexOf("-") == (opsCount + 1) && number.size() == 2)
						{
							number.set(opsCount, minus(number.get(opsCount), number.get(opsCount + 1)));
							number.remove(opsCount + 1);
							operator.remove(opsCount + 1);
							break;
						}
				    	else
				    		number.set(opsCount + 1, add(number.get(opsCount), number.get(opsCount + 1)));
					}
					if (each.equals("-"))
					{
						if (operator.size() >= 1 && number.size() == 1)
						{
							if (operator.size() > 1)
							{
								number.set(opsCount, minus(number.get(opsCount), 0.0));
								break;
							}
							else
							{
								number.set(opsCount, minus(0.0, number.get(opsCount)));
								break;
							}
						}
						else
							number.set(opsCount + 1, minus(number.get(opsCount), number.get(opsCount + 1)));
					}
					
					opsCount++;
				}//finish looping through the operators
				
				answer = number.get(opsCount);
			}
			else
				answer =  Double.parseDouble(expression);
		}

		catch (NumberFormatException e)
		{
			answer =  Double.NaN;
		}
		
		return answer;
	}
	
	//determine whether the string element a number or operator
	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    double d = Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
	
	//addition, subtraction, multiplication, division
	public double add(double a, double b)
	{
		return a + b;
	}
	
	public double minus(double a, double b)
	{
		return a - b;
	}
	
	public double multiply(double a, double b)
	{
		return a * b;
	}
	
	public double divide(double a, double b)
	{
		return a / b;
	}
}
