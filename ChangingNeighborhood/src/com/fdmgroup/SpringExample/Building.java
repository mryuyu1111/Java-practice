package com.fdmgroup.SpringExample;

import java.util.Scanner;
import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public class Building {
	private Address address;
	Scanner kb;
	
	public Building(Address a)
	{
		//kb = new Scanner(System.in);
		setAddress(a);
	}
	
	public Building() {
		kb = new Scanner(System.in);

	}
	public Address getAddress() {
		return address;
	}

	@Resource(name="address")
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public String toString()
	{
		return getAddress().toString();
	}
	
	public boolean isResidential()
	{
		return false;
	}
	/*
	public void setupBuilding()
	{
		System.out.println("Enter Building Number:");
		int streetNumber = Integer.parseInt(kb.nextLine());
		
		System.out.println("Enter Street:");
		String streetName = kb.nextLine();
		
		System.out.println("Enter Street Type:");
		String streetType = kb.nextLine();
		
		
		Street bldStreet = new Street(streetName,streetType);
		Address bldAdd = new Address(bldStreet, streetNumber);

		setAddress(bldAdd);
	}
	*/
}
