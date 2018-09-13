package com.fdmgroup.command;

import java.util.ArrayList;

//Invoker's class
public class StockExchange 
{
	private String name;
	private ArrayList<IExecute> history = new ArrayList<IExecute>();

	StockExchange(String name) 
	{
		this.name = name;
	}

	public void executeTrade(IExecute cmd) 
	{
		this.history.add(cmd);
		cmd.execute();
    }
}
