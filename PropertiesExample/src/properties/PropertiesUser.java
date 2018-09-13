package properties;

import java.util.Properties;

public class PropertiesUser {

	Properties properties;
	
	/**
	 * Demonstrates the use of properties files and the properties class.
	 * @param args
	 */
	public static void main(String[] args) 
	{		
		PropertiesUser propuser = new PropertiesUser();
		
		String firstval = propuser.returnAProperty("firstval");
		System.out.println("My first value from the file is: :"+firstval);

		//Note that even though the value in the properties file 
		//contains a number, it is still returned as a string. 
		String thirdval = propuser.returnAProperty("thirdval");
		System.out.println("My 3rd value from the file is: :"+thirdval);

	}

	public String returnAProperty(String dataIwant)
	{
		properties = PropertiesLoader.getProperties("myprogram.properties");
		String data = new String();
		if (properties != null) 		
			data = properties.getProperty(dataIwant);			
		return data;
	}
}
