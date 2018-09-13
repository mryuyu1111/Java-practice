package Output;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import XMLParser.XMLParser;

import Dijkstra.DijkstraEngine;
import Exception.RoutePlannerException;
import Marker.Station;
import Properties.PropertiesLoader;

public class CalculateRoute {
	private Properties properties;
	public List<String> calcRoute(String start, String end) throws RoutePlannerException {
		if(start.equals("") && end.equals(""))
			throw new RoutePlannerException("The starting and ending station is empty.");
		else if(start.equals(""))
			throw new RoutePlannerException("The starting station is empty.");
		else if(end.equals(""))
			throw new RoutePlannerException("The ending station is empty.");
		
		
		properties = PropertiesLoader.getProperties("XML.properties");
		String data = new String();
		if (properties != null)
			data = properties.getProperty("xml");
		Map<String, Station> map = null;
		DijkstraEngine engine = null;
		try {
			map = new XMLParser().parser(data);
			engine = new DijkstraEngine(map);
		}
		catch (RoutePlannerException e) {
			e.printStackTrace();
		}
		Station startStation = map.get(start.toUpperCase());
		Station endStation = map.get(end.toUpperCase());
		
		if(startStation == null && endStation == null)
			throw new RoutePlannerException("Invalid Station Name.");
		else if(startStation == null)
			throw new RoutePlannerException("The starting station is invalid.");
		else if(endStation == null)
			throw new RoutePlannerException("The ending station is invalid.");
		
		formatOutput directions = new formatOutput();
		return directions.getSolution(engine.execute(startStation, endStation));
	}
}
