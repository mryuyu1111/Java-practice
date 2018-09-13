package com.fdmgroup.command;

//Client's class
public class ShareHolder 
{
	public static void main(String[] args)
	{
		//create receiver's objects, in this case, it is a stock
		Stock JPM = new Stock("JP Morgan");
		Stock HSBC = new Stock("HSBC");
		Stock MS = new Stock("Morgan Stanley");
		Stock GS = new Stock("Goldman Sachs");
		JPM.setPrice(51.09); //set up stock's price
		HSBC.setPrice(-100);
		MS.setPrice(25.64);
		GS.setPrice(152.90);
		
		//create a different type of receiver's object, in this case, it is a bond
		Bond tenYearsTreasury = new Bond("10 Years Treasury Bond");
		tenYearsTreasury.setPrice(1001.49); //set bond's price
		
		//create another receiver's object, which is commodity
		Commodity oil = new Commodity("Oil");
		Commodity gold = new Commodity("Gold");
		oil.setPrice(108.80); //set commodity's price
		gold.setPrice(1412.90);
		
		//create invoker's instances to be called later to execute the command
		StockExchange NYSE = new StockExchange("New York Stock Exchange");
		StockExchange OTC = new StockExchange("Over The Counter");
		StockExchange CBOT = new StockExchange("Chicago Board of Trade");
		
		//create a command object and assign which command to perform on the receiver's object
		IExecute jpm = new Buy(JPM);
		
		//call the invoker to execute the command
		NYSE.executeTrade(jpm);
		NYSE.executeTrade(new Sell(HSBC));
		NYSE.executeTrade(new Sell(MS));
		NYSE.executeTrade(new Buy(GS));
		OTC.executeTrade(new Buy(tenYearsTreasury));
		CBOT.executeTrade(new Buy(gold));
		CBOT.executeTrade(new Sell(oil));
	}
}
