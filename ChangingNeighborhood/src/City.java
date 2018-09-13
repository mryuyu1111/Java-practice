import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fdmgroup.SpringExample.Address;
import com.fdmgroup.SpringExample.Building;
import com.fdmgroup.SpringExample.Street;


public class City {
	Scanner kb;
	ApplicationContext ctx = null;
	ArrayList<Building> me = new ArrayList<Building>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		City test = new City();
		
		test.run();
	}
	
	public City()
	{
		kb = new Scanner(System.in);
	}

	public void run()
	{
		int choice = 0;
		
		System.out.println("1. Make a neighborhood");
		System.out.println("2. Make a metro");
		System.out.println("Else. Make a basic neighborhood");
		
		choice=Integer.parseInt(kb.nextLine());
		
		switch (choice)
		{
		case 1:
			ctx = new ClassPathXmlApplicationContext("neighborhood.xml");
			break;
		case 2:
			ctx = new ClassPathXmlApplicationContext("metro.xml");
			break;
		default:
			ctx = new AnnotationConfigApplicationContext("com.fdmgroup.SpringExample");
		}
	
		
		choice = 0;
		while(choice != 3)
		{
			System.out.println("1. Add Building");
			System.out.println("2. List Buildings");
			System.out.println("3. Exit");
			System.out.println("4. Add Default Building");
			
			choice=Integer.parseInt(kb.nextLine());
			
			switch (choice)
			{
			case 1:
				addNewBuilding();
				break;
			case 2:
				listBuidlings();
				break;
			case 4:
				me.add((Building) ctx.getBean("building"));
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
		Address bldAdd = new Address( bldStreet, streetNumber);
		
		//Building bld = new Building();
		
		
		//bld.setAddress(bldAdd);
		
		Object[] args = {bldAdd};
		Building bld = (Building) ctx.getBean("building", args);
		me.add(bld);
		
	}
	
	
}
