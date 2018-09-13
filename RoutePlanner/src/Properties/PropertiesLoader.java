package Properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {
	private static Properties properties = null;
	
	public static Properties getProperties(String filename){
		FileInputStream fileIS = null;
			
		try {
			properties = new Properties();
			//fileIS = new FileInputStream("C:\\Users\\Steven Wong\\workspace\\TradingPlatform\\" + filename);
			fileIS = new FileInputStream("/Users/mryuyu1111/Desktop/Programming/Java/Workspace/RoutePlanner/" + filename);
			properties.load(fileIS);
			fileIS.close();
		}
		catch(IOException ioe) {
			properties = null;
			ioe.printStackTrace();
		}
		
		return properties;		
	}
}
