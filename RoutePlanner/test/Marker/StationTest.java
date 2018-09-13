package Marker;

import static org.junit.Assert.*;

import org.junit.Test;

import Marker.Station;

public class StationTest {

	@Test
	public void TwoStationObjectEqualtest() {
		Station s1 = new Station();
		s1.setName("station");
		Station s2 = new Station();
		s2.setName("station");
		assertTrue(s1.equals(s2));
	}
	
	@Test
	public void TwoStationObjectNotEqualtest() {
		Station s1 = new Station();
		s1.setName("station1");
		Station s2 = new Station();
		s2.setName("station2");
		assertFalse(s1.equals(s2));
	}
	
	@Test
	public void TwoStationHashCodeEqualtest() {
		Station s1 = new Station();
		s1.setName("station");
		Station s2 = new Station();
		s2.setName("station");
		assertTrue(s1.hashCode() == s2.hashCode());
	}
	
	@Test
	public void TwoStationHashCodeNotEqualtest() {
		Station s1 = new Station();
		s1.setName("station1");
		Station s2 = new Station();
		s2.setName("station2");
		assertFalse(s1.hashCode() == s2.hashCode());
	}
}
