package CRUD;

import java.util.ArrayList;

public class Database extends AllKindOfStorage
{
private ArrayList<String> listOfString = new ArrayList<String>();
	
	@Override
	public String create(String s) 
	{
		listOfString.add(s);
		return "\"" + s + "\" has been created.";
	}

	@Override
	public String read(int num) 
	{
		return listOfString.get(num);
	}

	@Override
	public void update(int num, String s) 
	{
		listOfString.set(num, s);
		System.out.println("\"" + s + "\" has been updated.");
	}

	@Override
	public void delete(String s) 
	{
		listOfString.remove(s);
		System.out.println("\"" + s + "\" has been deleted.");
	}
}
