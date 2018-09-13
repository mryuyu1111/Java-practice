package CRUD;

public class StorageFactory
{
	public static IStorage getStorageLocation(int num) 
	{
		switch (num)
		{
		case 1:
			return new RAM();
		default:
			return new Database();
		}
	}

}
