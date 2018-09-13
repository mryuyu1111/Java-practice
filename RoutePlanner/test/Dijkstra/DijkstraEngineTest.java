package Dijkstra;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import Exception.RoutePlannerException;
import Marker.Station;
import XMLParser.*;

public class DijkstraEngineTest {

	

	public class RouteTest 
	{
		Map<String, Station> map = null;
		@Before
		
		public void setup(){
			try 
			{
				map = new XMLParser().parser("LondonUnderground.xml");
			} catch (RoutePlannerException e) {
				e.printStackTrace();
			}
		}
		
		@Test
		public void CheckDestination() throws RoutePlannerException
		{
			DijkstraEngine engine = new DijkstraEngine(map);
			
			Station start =  map.get("Finchley");
			Station end =  map.get("Elephant");
			
			ArrayList<ArrayList<Station>> sl = engine.execute(start, end);
			
			for (int i = 0; i < sl.size(); i++)
			{
				ArrayList<Station> temp = sl.get(i);
				
				for (int j = temp.size() - 1; j >= 0; j--)
					System.out.println(temp.get(j));
				
				System.out.println();
			}
		}
		
		@Test
		public void SimpleScenarioTest() throws RoutePlannerException
		{
			DijkstraEngine engine = new DijkstraEngine(map);
			Station start = map.get("Finchley");
			Station end = map.get("Chancery Lane");
			ArrayList<ArrayList<Station>> sl = engine.execute(start, end);
			Station[] expectedPath = {new Station("Finchley"), new Station("Baker Street"), new Station("Regents Park"), new Station("Leicester Square"), 
					new Station("Bank"), new Station("Chancery Lane")};
			boolean result = true;
			for(Station s : expectedPath){
				if(!sl.get(1).contains(s)){
					result = false;
					break;
				}
			}
			
			assertTrue(result);
		}
		
		@Test
		public void MoreComplexScenarioTest() throws RoutePlannerException
		{
			DijkstraEngine engine = new DijkstraEngine(map);
			Station start = map.get("Finchley");
			Station end = map.get("Bayswater");
			ArrayList<ArrayList<Station>> sl = engine.execute(start, end);
			Station[] expectedPath = {new Station("Finchley"), new Station("Baker Street"), new Station("Bayswater")};
			boolean result = true;
			for(Station s : expectedPath){
				if(!sl.get(0).contains(s)){
					result = false;
					break;
				}
			}
			
			assertTrue(result);
		}
		
		@Test
		public void MostComplexScenarioTest() throws RoutePlannerException
		{
			DijkstraEngine engine = new DijkstraEngine(map);
			Station start = map.get("Finchley");
			Station end = map.get("Stockwell");
			ArrayList<ArrayList<Station>> sl = engine.execute(start, end);
//			Station[] expectedPath = {new Station("Finchley"), new Station("Baker Street"), new Station("Regents Park"), new Station("Leicester Square"), 
//					new Station("Bank"), new Station("Chancery Lane")};
//			boolean result = true;
//			for(Station s : expectedPath){
//				if(!sl.get(1).contains(s)){
//					result = false;
//					break;
//				}
//			}
			
			assertTrue(sl.get(0).size() == 7);
		}

	}
}
