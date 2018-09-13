package Marker;

public class Adjacent {
	private Station station;
	private String line;
	
	public Adjacent(Station station, String line) {
		this.station = station;
		this.line = line;
	}
	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}
	
//	@Override
//	public boolean equals(Object o) {
//		
//		if((o instanceof Adjacent) && this.hashCode() == ((Adjacent) o).hashCode())
//			return true;
//		else
//			return false;
//	}
//	
//	@Override
//	public int hashCode() {
//		return (station + line).hashCode();
//	}
}