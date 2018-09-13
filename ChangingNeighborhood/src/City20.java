import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fdmgroup.SpringExample.Address;
import com.fdmgroup.SpringExample.Building;
import com.fdmgroup.SpringExample.Street;


public class City20 extends City {
	Scanner kb;
	ApplicationContext ctx = null;
	ArrayList<Building> me = new ArrayList<Building>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		City20 test = new City20();
		
		test.run();
	}
	
	public City20()
	{
		ctx = new ClassPathXmlApplicationContext("city.xml");
		kb = new Scanner(System.in);
	}

	public void run()
	{
		
		int choice = 0;
		while(choice != 3)
		{
			System.out.println("1. Add Building");
			System.out.println("2. List Buildings");
			System.out.println("3. Exit");
			
			choice=Integer.parseInt(kb.nextLine());
			
			switch (choice)
			{
			case 1:
				addNewBuilding();
				break;
			case 2:
				listBuidlings();
				break;
			}
		}
	}

	private void listBuidlings() {
		
		for(Building x: me)
		{
			System.out.println(x.toString());
		}
		
	}

	private void addNewBuilding() {
		System.out.println("Enter Building Number:");
		int streetNumber = Integer.parseInt(kb.nextLine());
		
		System.out.println("Enter Street:");
		String streetName = kb.nextLine();
		
		System.out.println("Enter Street Type:");
		String streetType = kb.nextLine();
		
		
		Street bldStreet = new Street(streetName,streetType);
		//Address bldAdd = new Address(bldStreet, streetNumber);
		
		//Building bld = new Building(bldAdd);
		
		//bld.setAddress(bldAdd);
		
		//me.add(bld);
		
	}
	
	
}
