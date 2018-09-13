
import java.util.ArrayList;
import java.util.TreeSet;
 
public class Library 
{

/*
* First show that if we add elements to an ArrayList 
* (without overriding the equals method) then when we add 
* macbeth2 which has all the same data as macbeth, it thinks 
* they are two totally different elements because the equals 
* method of object is calling == which is merely checking 
* references. 
* 
* Then, override the equals method and show that it counts them 
* as being the same object.
* 
* Then change it to a TreeSet. Show that you must implement 
* Comparable and override compareTo. See that now it sorts the 
* elments by ISBN number, as defined in the compareTo method 
*/
 
	public static void main(String[] args)
	{
		Book macbeth = new Book("1234", "Macbeth", 3.40); 
		Book kingLear = new Book("1235", "King Lear", 3.50);
		Book taming = new Book("1236", "Taming Of The Shrew", 2.50);
		Book shylock = new Book("1007", "Merchant Of Venice", 4.50);
		Book capulet = new Book("1064", "Romeo And Juliet", 3.20);
		
		Book macbeth2 = new Book("1234", "Macbeth", 3.40);
		
		//TreeSet<Book> books = new TreeSet<Book>();
		ArrayList<Book> books = new ArrayList<Book>();
	 
		books.add(macbeth);
		books.add(kingLear);
		books.add(taming);
		books.add(shylock);
		books.add(capulet);
		//books.add(macbeth2);
		
		for (Book aBook : books)
		{
			System.out.println(aBook);
		}
		
		
		if (books.contains(macbeth2)) 
			System.out.println("Macbeth was already in book collection");
	}
}
