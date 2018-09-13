package XMLParser;

import static org.junit.Assert.*;
import java.util.Map;
import org.junit.Test;
import Exception.RoutePlannerException;
import Marker.Adjacent;
import Marker.Station;

public class XMLParserTest {

	@Test
	public void notEmptytest() throws RoutePlannerException {
		XMLParser parse = new XMLParser();
		Map<String, Station> s = parse.parser("LondonUnderground.xml");
		assertTrue(!s.isEmpty());
	}
	
	@Test
	public void sizetest() throws RoutePlannerException {
		XMLParser parse = new XMLParser();
		Map<String, Station> s = parse.parser("LondonUnderground.xml");
		
		assertTrue(s.size() == 29);
	}
	
	@Test
	public void Adjecenttest() throws RoutePlannerException {
		XMLParser parse = new XMLParser();
		Map<String, Station> s = parse.parser("LondonUnderground.xml");
		
		Station angel = new Station();
		angel.setName("Angel");
		boolean angelB = false;
		
		Station farringdon = new Station();
		farringdon.setName("Farringdon");
		boolean farringdonB = false;
		
		Station camden = new Station();
		camden.setName("Camden");
		boolean camdenB = false;
		
		Station euston = new Station();
		euston.setName("Euston");
		boolean eustonB = false;
		
		for(Adjacent j : s.get("Kings Cross").getAdjacent()) {
			if(j.getStation().equals(angel))
				angelB = true;
			if(j.getStation().equals(farringdon))
				farringdonB = true;
			if(j.getStation().equals(camden))
				camdenB = true;
			if(j.getStation().equals(euston))
				eustonB = true;
		}
				
		assertTrue(angelB);
		assertTrue(farringdonB);
		assertTrue(camdenB);
		assertTrue(eustonB);
	}
	
	@Test
	public void NotAdjecenttest() throws RoutePlannerException {
		XMLParser parse = new XMLParser();
		Map<String, Station> s = parse.parser("LondonUnderground.xml");
		
		Station liverpool = new Station();
		liverpool.setName("Liverpool Station");
		boolean liverpoolB = false;
		
		for(Adjacent j : s.get("Kings Cross").getAdjacent()) {
			if(j.getStation().equals(liverpool))
				liverpoolB = true;
		}
		assertFalse(liverpoolB);
	}
	
	@Test
	public void Listtest() throws RoutePlannerException {
		XMLParser parse = new XMLParser();
		Map<String, Station> s = parse.parser("LondonUnderground.xml");
		assertTrue((s.get("Kings Cross").getLine()).size() == 2);
	}
	
	@Test
	public void StockWelltest() throws RoutePlannerException {
		XMLParser parse = new XMLParser();
		Map<String, Station> s = parse.parser("LondonUnderground.xml");
		
		assertTrue((s.get("Camden").getAdjacent()).size() == 4);
	}
}
