package com.fdmgroup.enums;

public class CoffeeMaker 
{
	public static void main(String[] args)
	{
		Coffee decaf = new Coffee();
		decaf.setName("Decaf");		
		//Coffee object needs a size that is restricted by the enum
		decaf.setSize(Coffee.CoffeeSize.HUGE); 
		
		//For our coffee object we can set the bean type and then
		//call getPrice() using the getter in the enum. 
		decaf.setBean(Coffee.BeanType.ARABICA);
		System.out.println(decaf.getBean().getPrice());
		decaf.setBean(Coffee.BeanType.JAVA);
		System.out.println(decaf.getBean().getPrice());
		
		
		//See that values() returns all options in the enum
		Coffee.BeanType[] beans = Coffee.BeanType.values();
		for (int i=0; i<beans.length; i++)
		{
			System.out.println(beans[i]);
		}
		
		//Finally we can use the getter methods of the class 
		System.out.println("Type of coffee is: "+decaf.getName());
		System.out.println("Size of coffee is: "+decaf.getSize());
	}
}