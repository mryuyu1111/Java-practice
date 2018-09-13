import java.io.*;


public class MixingData 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		File file1 = new File("mixing.txt");
		try 
		{
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(file1));
			DataInputStream dis = new DataInputStream(new FileInputStream(file1));
			dos.writeInt(125);
			dos.flush();
			dos.close();
			
			int newInt = dis.readInt();
			System.out.println("New int is: "+newInt);
			dis.close();
		} 
		catch (FileNotFoundException e) 
		{		
			e.printStackTrace();
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
		

	}

}
