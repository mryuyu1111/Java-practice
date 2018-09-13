package com.fdmgroup.SpringExample;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public class Address {
	private Street Add_Street;
	private int Add_Number;
	
	public Address(Street s, int hn)
	{
		setStreet(s);
		setNumber(hn);
	}

	public int getNumber() {
		return Add_Number;
	}

	public void setNumber(int add_Number) {
		Add_Number = add_Number;
	}

	public Street getStreet() {
		return Add_Street;
	}

	@Resource(name="street")
	public void setStreet(Street add_Street) {
		Add_Street = add_Street;
	}
	
	public String toString()
	{
		return Add_Number + " " + Add_Street;
	}
}
