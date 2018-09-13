package com.fdmgroup.SpringExample;

import java.util.ArrayList;

public class OfficeBuilding extends Building {
	ArrayList<String> company = new ArrayList<String>();
	
	public OfficeBuilding()
	{
		super();
	}
	public OfficeBuilding(Address a)
	{
		super(a);
	}
	public String toString()
	{
		return "These offices are located at " + super.toString();
	}

}
