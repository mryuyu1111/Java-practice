import java.io.*;

public class DataIOExample 
{
	public static void main(String[] args)
	{
		String manufacturer1 = "Cadbury";
		String product1 = "Cream Egg";
		double price1 = 0.50;
		int rating1 = 9;
		
		String manufacturer2 = "Mars";
		String product2 = "Snickers";
		double price2 = 0.35;
		int rating2 = 6;
		
		try
		{
			//write to file
			File file = new File("chocolateFile.txt");
			FileOutputStream fos = new FileOutputStream(file);
			DataOutputStream dos = new DataOutputStream(fos);
			
			dos.writeUTF(manufacturer1);			
			dos.writeUTF(product1);
			dos.writeDouble(price1);
			dos.writeInt(rating1);
		
			dos.writeUTF(manufacturer2);
			dos.writeUTF(product2);
			dos.writeDouble(price2);
			dos.writeInt(rating2);
			
			dos.flush();
			dos.close();
			
			//read from file
			FileInputStream fis = new FileInputStream(file);
			DataInputStream dis = new DataInputStream(fis);
			
			String manufacturer1_read = dis.readUTF();
			String product1_read = dis.readUTF();
			double price1_read = dis.readDouble();
			int rating1_read = dis.readInt();
			
			String manufacturer2_read = dis.readUTF();
			String product2_read = dis.readUTF();		
			double price2_read = dis.readDouble();
			int rating2_read = dis.readInt();
			
			
			
			dis.close();
			
			System.out.println("Manufacturer1: "+manufacturer1_read);
			System.out.println("Product1: "+product1_read);
			System.out.println("Price1: "+price1_read);
			System.out.println("Rating1: "+rating1_read);
			
			System.out.println("Manufacturer2: "+manufacturer2_read);
			System.out.println("Product2: "+product2_read);
			System.out.println("Price2: "+price2_read);
			System.out.println("Rating2: "+rating2_read);
			
		}
		catch (IOException e)
		{
			e.printStackTrace();			
		}
			
	}

}

/*
dos.writeChars(product2);  
Demonstrate that because you write the data as a certain type, 
you have to read it as that type.
*/
