package com.fdmgroup.command;

public class Buy implements IExecute
{
	private TradeableItem item;
	
	Buy(TradeableItem item)
	{
		this.item = item;
	}
	
	@Override
	public void execute() 
	{
		item.buyTrade();
	}
}
