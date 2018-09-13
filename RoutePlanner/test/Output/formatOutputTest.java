package Output;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import XMLParser.XMLParser;

import Dijkstra.DijkstraEngine;
import Exception.RoutePlannerException;
import Marker.Station;

public class formatOutputTest {
	Map<String, Station> map = null;
	
	DijkstraEngine engine = null;
	
	@Before
	public void setup(){
		try 
		{
			map = new XMLParser().parser("LondonUnderground.xml");
		} catch (RoutePlannerException e) {
			e.printStackTrace();
		}
		engine = new DijkstraEngine(map);
	}
	
	@Test
	public void testOutputrecieved() {
		@SuppressWarnings("unused")
		List<String> path = new ArrayList<String>();
	}
	
	@Test
	public void testcreateInstructionsSize() throws RoutePlannerException {
		Station start = map.get("Finchley");
		Station end = map.get("Chancery Lane");
		ArrayList<ArrayList<Station>> sl = engine.execute(start, end);
		formatOutput directions = new formatOutput();
		List<String> results = directions.getSolution(sl);
		assertTrue(results.size() == 2);
		
	}
	
	@Test
	public void testcreateInstructionsSuceedsOneStop() throws RoutePlannerException {
		Station start = map.get("Bethnel Green");
		Station end = map.get("Liverpool Street");
		ArrayList<ArrayList<Station>> sl = engine.execute(start, end);
		formatOutput directions = new formatOutput();
		List<String> results = directions.getSolution(sl);
		assertTrue(results.get(0).equals("Take the District line 1 stop(s) to Liverpool Street\n"));
	}
	
	@Test
	public void testcreateInstructionsSuceedsOneRoute() throws RoutePlannerException {
		Station start = map.get("Mile End");
		Station end = map.get("Bank");
		ArrayList<ArrayList<Station>> sl = engine.execute(start, end);
		formatOutput directions = new formatOutput();
		List<String> results = directions.getSolution(sl);
		assertTrue(results.get(0).equals("Take the Metropolitan line 3 stop(s) to Bank\n"));
	}
	
	@Test
	public void testCreateInstructionsSuceedsSameStop() throws RoutePlannerException {
		Station start = map.get("Mile End");
		Station end = map.get("Mile End");
		ArrayList<ArrayList<Station>> sl = engine.execute(start, end);
		formatOutput directions = new formatOutput();
		List<String> results = directions.getSolution(sl);
		assertTrue(results.get(0).equals("You are here"));
	}
	
	@Test(expected=RoutePlannerException.class)
	public void testCreateInstructionsFailswithUnknownStop() throws RoutePlannerException {
		Station start = map.get("Happy Tree Friends Forest");
		Station end = map.get("Queensburough Plaza");
		ArrayList<ArrayList<Station>> sl = engine.execute(start, end);
		formatOutput directions = new formatOutput();
		List<String> results = directions.getSolution(sl);
		assertTrue(results.get(0).equals("You are here"));
	}

}
