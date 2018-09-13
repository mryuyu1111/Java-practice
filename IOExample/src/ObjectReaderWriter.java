import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * ReaderWriterExample demonstrates how to use input and ouput streams to read from and write to a file
 * @author shoshana.kesselman
 * @version 1
*/
public class ObjectReaderWriter 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{		
		writingObjects();
	}

	/**
	 * Method writingObjects() uses an instance of the simple ObjectToStore class.
	 * It has no return value but will effect the contents of the file. 
	 */
	public static void writingObjects()
	{

		ObjectToStore objectToStore = new ObjectToStore("Joe",21);		
		
		try 
		{   
			//First set up my input and output streams using the specified file
			FileOutputStream fos = new FileOutputStream("src\\FileToWriteTo");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			FileInputStream fis = new FileInputStream("src\\FileToWriteTo");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			//Write a string to my file
			oos.writeObject("New Line A");			
			
			//Read from the file and save it as a new string -> then output it to the screen
			String stringJustRead = (String)ois.readObject();
			System.out.println(stringJustRead);
			
			
			//Now we write an object to the file and then read it in
			oos.writeObject(objectToStore);			
			ObjectToStore objectStored = (ObjectToStore)ois.readObject();
			System.out.println("Object name from file is: "+objectStored.getName());
			System.out.println("Object age from file is: "+objectStored.getAge());
			
			
			/*
			//Now let's try writing two objects to the file
			oos.writeObject(new ObjectToStore("fred",22));
			oos.writeObject(new ObjectToStore("Jane",23));
			System.out.println("Name of second object in file: "+((ObjectToStore)ois.readObject()).getName());
			System.out.println("Name of third object in file: "+((ObjectToStore)ois.readObject()).getName());
		    */
			
			
			/*
			//See that in order to store an object to a file, 
			//all it's instance objects (e.g. it's math grade) must be serializable too
			System.out.println("Grade 1 is: "+objectStored.getGrade().getGrade1());
			System.out.println("Grade 2 is: "+objectStored.getGrade().getGrade2());
			*/
			
			
			//See that the subclass 'MathGrade' is serializable, so it can be stored to a file.
			//Even if the superclass 'Grade' is not serializable, this object will still get stored to a file.			
			System.out.println("MathGrade is: "+objectStored.getMathGrade().getMathGrade1());
			System.out.println("mathGrade parent data grade1 is: "+objectStored.getMathGrade().getGrade1());
			
			/*
			//Note also that even if Grade is not serializable, we can access it's
			//fields. A default constructor is needed. 
			System.out.println("MathGrade's parent's default vaues are: "+
					objectStored.getMathGrade().getGrade1()+" and "+
					objectStored.getMathGrade().getGrade2());
			*/
		}
		catch (FileNotFoundException e)
		{
			System.out.println("You have made an error, because we can't find the file");
		}
		catch (NotSerializableException exep)
		{
			exep.printStackTrace();
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
		catch (ClassNotFoundException exe)
		{
			System.out.println("You have made a class not found exception");
		}
	}
	
}


/* To serialize an object in a special way, e.g. making a counter:
 * System.out.println("Object written "+objectStored.writeCount + " number of times.");
System.out.println("Object read "+objectStored.readCount + " number of times.");
 */
