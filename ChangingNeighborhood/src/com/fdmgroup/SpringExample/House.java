package com.fdmgroup.SpringExample;

public class House extends Building {

	public House()
	{
		super();
	}
	public House(Address a)
	{
		super(a);
	}
	@Override
	public boolean isResidential() {
		return true;
	}
	
	public String toString()
	{
		return "This house resides at " + super.toString();
	}
}
