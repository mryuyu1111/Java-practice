package Marker;

import java.util.ArrayList;
import java.util.List;

public class Station implements Marker<Station, Adjacent>, Comparable<Station> {
	private List<Adjacent> adjacent = new ArrayList<Adjacent>();
	private List<String> line = new ArrayList<String>();
	private String name;
	
	public Station()
	{
		super();
	}
	
	public Station(String name)
	{
		this.name = name;
	}
	
	public List<Adjacent> getAdjacent() {
		return adjacent;
	}
	public void setAdjacent(List<Adjacent> adjacent) {
		this.adjacent = adjacent;
	}
	public void addAdjacent(Adjacent adjacent) {
		if(this.adjacent.contains(adjacent))
			this.adjacent.remove(adjacent);
		this.adjacent.add(adjacent);
	}
	public void removeAdjacent(Adjacent adjacent) {
		this.adjacent.remove(adjacent);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getLine() {
		return line;
	}
	public void setLine(List<String> line) {
		this.line = line;
	}
	public void addLine(String line) {
		this.line.add(line);
	}
	public void removeLine(String line) {
		this.line.remove(line);
	}
	@Override
	public boolean equals(Object o) {
		if((o instanceof Station) && this.name.equalsIgnoreCase(((Station) o).getName()))
			return true;
		else
			return false;
	}
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	@Override
	public String toString() {
		return name;
	}
	@Override
	public int compareTo(Station s) {
		return name.compareTo(s.name);
	}
	
}
