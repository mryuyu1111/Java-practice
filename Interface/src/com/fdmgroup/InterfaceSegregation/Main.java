package com.fdmgroup.InterfaceSegregation;

public class Main 
{
	public static void main(String[] args)
	{
		Human man = new Human();
		
		man.work();
		
		Robot iRobot = new Robot();
		
		iRobot.charge();
	}
}
