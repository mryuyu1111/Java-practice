package CRUD;

public interface IStorage 
{
	String create(String s);
	String read(int num);
	void update(int num, String s);
	void delete(String s);
}
