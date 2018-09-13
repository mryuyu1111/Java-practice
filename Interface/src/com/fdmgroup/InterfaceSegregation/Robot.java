package com.fdmgroup.InterfaceSegregation;

public class Robot implements IWorkable, IChargeable
{
	private double price;
	
	@Override
	public void work() 
	{
		System.out.println("I am working, Master.");
	}

	@Override
	public void charge() 
	{
		System.out.println("I need some juice.");
	}
	
	void setPrice(double p)
	{
		price = p;
	}
	
	double getPrice()
	{
		return price;
	}
	
}
