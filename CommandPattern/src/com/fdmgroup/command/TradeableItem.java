package com.fdmgroup.command;

import java.util.Random;

//receiver's abstract class
public abstract class TradeableItem 
{
	String name;
	double price;
	
	Random ran = new Random();
	
	void setPrice(double price)
	{
		if (price < 0)
			this.price = 0;
		else
			this.price = price;
	}
	
	double getPrice()
	{
		return price;
	}
	
	void buyTrade()
	{
		if (price == 0)
			System.out.println(name + " is now worthless.");
		else
			System.out.println(name + " are bought at the price of " + price);
	}
	
	void sellTrade()
	{
		if (price < 0)
			System.out.println(name + " is now worthless.");
		else
			System.out.println(name + " are sold at the price of " + price);
	}
}
