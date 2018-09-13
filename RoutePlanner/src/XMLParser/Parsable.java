package XMLParser;

import java.util.Map;
import Exception.RoutePlannerException;
import Marker.Station;

public interface Parsable<T> {
	public Map<String, Station> parser(String directory) throws RoutePlannerException;
}
