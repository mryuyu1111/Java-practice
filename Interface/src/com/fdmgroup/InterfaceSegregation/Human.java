package com.fdmgroup.InterfaceSegregation;

public class Human implements IFeedable, IWorkable, IRestable
{
	private double salary;
	
	@Override
	public void rest() 
	{
		System.out.println("I am just a human, I need to rest now.");
	}

	@Override
	public void work() 
	{
		System.out.println("Work, work and work.");
	}

	@Override
	public void feed() 
	{
		System.out.println("Eating lunch.");
	}
	
	void setSalary(double wage)
	{
		salary = wage;
	}
	
	double getSalary()
	{
		return salary;
	}
	
}
