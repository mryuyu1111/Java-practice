package com.fdmgroup.command;

public class Sell implements IExecute
{
	private TradeableItem item;
	
	Sell(TradeableItem item)
	{
		this.item = item;
	}
	
	@Override
	public void execute() 
	{
		item.sellTrade();
	}
}
