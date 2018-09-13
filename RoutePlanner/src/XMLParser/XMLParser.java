package XMLParser;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import Exception.RoutePlannerException;
import Marker.Adjacent;
import Marker.Station;

/**
 * This class implements Parsable, where it parses an xml file and outputs a HashMap where the keys are the station name (String) and the value 
 * is a station object.
 * 
 * @author Steven Wong, Philip Jones
 *
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class XMLParser implements Parsable<Station> {
	private Map<String, Station> route = new HashMap<String, Station>();
	
	/**
	 * Parser will open the XML document for parsing. It takes the filename of an XML document and generates a HasMap Collection.
	 * This method will throw an RoutePlannerException if the input file cannot be located.
	 */
	
	public Map<String, Station> parser(String directory) throws RoutePlannerException {
		SAXBuilder saxbuilder = new SAXBuilder();
		File file = new File(directory);
		
		try {
			return this.generateMap(saxbuilder.build(file));
			
		}
		catch (JDOMException e) {
			throw new RoutePlannerException(e, "Invalid XML File");
		}
		catch (IOException e) {
			throw new RoutePlannerException(e, "Invalid XML File");
		}
	}
	
	/**
	 * 
	 * @param doc
	 * @return
	 */
	private Map<String, Station> generateMap(Document doc) {
		Element root = doc.getRootElement();
		Element currentLine, currentStation;
		List<String> lines, stations;
		lines = root.getChildren();
		Iterator LineIterator = lines.iterator();
		while(LineIterator.hasNext()) {
			Station previous = null;
			currentLine = (Element) LineIterator.next();
			String line = currentLine.getAttribute("name").getValue();
			stations = currentLine.getChildren();
			Iterator StationIterator = stations.iterator();
			
			while(StationIterator.hasNext()) {
				currentStation = (Element) StationIterator.next();
				Station s;
				if(!route.containsKey(currentStation.getText().toUpperCase())) {
					s = new Station();
					s.setName(currentStation.getText());
					if(!(s.getLine().contains(line)))
						s.addLine(line);
				}
				else {
					s = route.get(currentStation.getText().toUpperCase());
					if(!(s.getLine().contains(line)))
						s.addLine(line);
				}
				
				this.storeStation(previous, s, line);
				previous = s;
			}
		}
		return route;
	}
	
	private void storeStation(Station previous, Station current, String line) {
		if(previous != null) {
			current.addAdjacent(new Adjacent(previous, line));
			previous.addAdjacent(new Adjacent(current, line));
			route.put(previous.getName(), previous);
		}
		route.put(current.getName().toUpperCase(), current);
	}
}