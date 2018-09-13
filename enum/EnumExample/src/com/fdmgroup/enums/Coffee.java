package com.fdmgroup.enums;

/*
 * Coffee makes use of two enums. BeanType has a price that can be 
 * set using it's constructor.
 * Coffee size
 * 
 * */
public class Coffee 
{
	//We are using enums to restrict the size of coffee we allow
	//This enum is declared in the class. I also made a separate 
	//enum in an external file. Try using it. 
	enum CoffeeSize { BIG, HUGE, OVERWHELMING }
	
	//This enum has a private value price that you can take get
	//using a getter method. For ARABICA beans it uses the contructor
	//with int 103 as the argument.
	enum BeanType { 
		ARABICA(103), JAVA(57); 
		
		private int price; 
		BeanType(int p)
		{
			price = p;
		}
		int getPrice()
		{
			return price;
		}
		
		 
		
	}	
	
	private BeanType bean;
	private String name;
	private CoffeeSize size;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CoffeeSize getSize() {
		return size;
	}

	public void setSize(CoffeeSize size) {
		this.size = size;
	}

	public BeanType getBean() {
		return bean;
	}

	public void setBean(BeanType bean) {
		this.bean = bean;
	}
	
	
}