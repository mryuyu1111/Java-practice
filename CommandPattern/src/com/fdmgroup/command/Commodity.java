package com.fdmgroup.command;

public class Commodity extends TradeableItem
{
	Commodity(String name)
	{
		this.name = name;
	}
	
	void buyTrade()
	{
		if (price == 0)
			System.out.println(name + " is now worthless.");
		else
			System.out.println(ran.nextInt(1000) + " ounces of " + name + " are bought at the price of " + price);
	}
	
	void sellTrade()
	{
		if (price < 0)
			System.out.println(name + " is now worthless.");
		else
			System.out.println(ran.nextInt(1000) + " ounces of " + name + " are sold at the price of " + price);
	}
}
