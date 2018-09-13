package com.fdmgroup.SpringExample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public class Street {
	private String StreetName = null;
	private String RoadType = null;
	
	public Street(String sn,String rt)
	{
		setStreetName(sn);
		setRoadType(rt);
	}

	public String getStreetName() {
		return StreetName;
	}

	public void setStreetName(String streetName) {
		StreetName = streetName;
	}
	public String toString()
	{
		return StreetName + " " + RoadType;
	}

	public String getRoadType() {
		return RoadType;
	}

	public void setRoadType(String roadType) {
		RoadType = roadType;
	}
}
