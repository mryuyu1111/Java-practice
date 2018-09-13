
public class Book //implements Comparable
{
	private String ISBN;
	private String title;
	private double price;
 
	public Book(String isbn, String title, double price) 
	{
		this.ISBN = isbn;
		this.title = title;
		this.price = price;
	}

	public String toString()
	{
		return "ISBN: "+this.ISBN+" Title: "+this.title+" Price: "+this.price;
	}

	
//	@Override
//	public boolean equals(Object obj)
//	{
//		if (obj == null)
//		return false;			
//		
//		if (!(obj instanceof Book))
//			return false;
//		else
//		{
//			if ((((Book)obj).ISBN).equals(this.ISBN))
//			return true;
//		}
//		return false;
//	}
	
 	
//	@Override
//	public int compareTo(Object o) 
//	{
//		if (o == null)
//			throw new NullPointerException("Null Object given to compareTo");
//		
//		if (!(o instanceof Book)) 
//			throw new IllegalArgumentException("Objects passed into compareTo must be of type Book");
//	
//		return (this.ISBN).compareTo(((Book)o).ISBN); 
//	}
	
 
}


