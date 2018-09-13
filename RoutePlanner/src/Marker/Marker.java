package Marker;

import java.util.List;

public interface Marker<T, V> {
	public List<V> getAdjacent();
	public void setAdjacent(List<V> adjacent);
	public void addAdjacent(V adjacent);
	public void removeAdjacent(V adjacent);
	public String getName();
	public void setName(String name);
}
