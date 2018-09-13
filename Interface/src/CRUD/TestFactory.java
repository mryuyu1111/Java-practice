package CRUD;

public class TestFactory 
{
	public static void main(String[] args) 
	{
		IStorage test = StorageFactory.getStorageLocation(3);
		
		System.out.println(test.create("this string"));

	}	
}