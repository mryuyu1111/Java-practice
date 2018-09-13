package Dijkstra;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import Exception.RoutePlannerException;
import Marker.Adjacent;
import Marker.Station;

/**
 * An implementation of Dijkstra's shortest path algorithm. It computes the shortest path (in distance)
 * to all cities in the map. The output of the algorithm is the shortest distance from the start city 
 * to every other city, and the shortest path from the start city to every other.
 * <p>
 * Upon calling
 * {@link #execute(Station, Station)}, 
 * the results of the algorithm are made available by calling
 * {@link #getPredecessor(Station)}
 * and 
 * {@link #getShortestDistance(Station)}.
 * 
 * To get the shortest path between the city <var>destination</var> and
 * the source city after running the algorithm, one would do:
 * <pre>
 * ArrayList&lt;City&gt; l = new ArrayList&lt;City&gt;();
 *
 * for (City city = destination; city != null; city = engine.getPredecessor(city))
 * {
 *     l.add(city);
 * }
 *
 * Collections.reverse(l);
 *
 * return l;
 * </pre>
 * 
 * @see #execute(Station, Station)
 * 
 * @author Renaud Waldura &lt;renaud+tw@waldura.com&gt;
 * @version $Id: DijkstraEngine.java 2379 2007-08-23 19:06:29Z renaud $
 */
@SuppressWarnings({ "rawtypes", "unused" })
public class DijkstraEngine
{
    /**
     * Infinity value for distances.
     */
    public static final int INFINITE_DISTANCE = Integer.MAX_VALUE;

    /**
     * Some value to initialize the priority queue with.
     */
    private static final int INITIAL_CAPACITY = 1000;
    
    /**
     * This comparator orders cities according to their shortest distances,
     * in ascending fashion. If two cities have the same shortest distance,
     * we compare the cities themselves.
     */
    private final Comparator<Station> shortestDistanceComparator = new Comparator<Station>()
        {
            public int compare(Station left, Station right)
            {
                // note that this trick doesn't work for huge distances, close to Integer.MAX_VALUE
                int result = getShortestDistance(left) - getShortestDistance(right);
                
                return (result == 0) ? left.compareTo(right) : result;
            }
        };
    
    /**
     * The graph.
     */
//    private final RoutesMap map;

	private final Map map;
    
    private String startPoint;
    
    /**
     * The working set of cities, kept ordered by shortest distance.
     */
    private final PriorityQueue<Station> unsettledNodes = new PriorityQueue<Station>(INITIAL_CAPACITY, shortestDistanceComparator);
    
    /**
     * The set of cities for which the shortest distance to the source
     * has been found.
     */
    private final Set<Station> settledNodes = new HashSet<Station>();
    
    /**
     * The currently known shortest distance for all cities.
     */
    private final Map<Station, Integer> shortestDistances = new HashMap<Station, Integer>();

    /**
     * Predecessors list: maps a city to its predecessor in the spanning tree of
     * shortest paths.
     */
    private final Map<Station, ArrayList<Station>> predecessors = new HashMap<Station, ArrayList<Station>>();
    
    private ArrayList<ArrayList<Station>> pathStation = new ArrayList<ArrayList<Station>>();
    /**
     * Constructor.
     */
    public DijkstraEngine(Map map)
    {
        this.map = map;
    }

    /**
     * Initialize all data structures used by the algorithm.
     * 
     * @param start the source node
     * @throws RoutePlannerException 
     */
    private void init(Station start) throws RoutePlannerException
    {
        settledNodes.clear();
        unsettledNodes.clear();
        
        shortestDistances.clear();
        predecessors.clear();
        
        // add source
        setShortestDistance(start, 0);
        unsettledNodes.add(start);
        
        startPoint = start.getName();
    }
    
    /**
     * Run Dijkstra's shortest path algorithm on the map.
     * The results of the algorithm are available through
     * {@link #getPredecessor(Station)}
     * and 
     * {@link #getShortestDistance(Station)}
     * upon completion of this method.
     * 
     * @param start the starting city
     * @param destination the destination city. If this argument is <code>null</code>, the algorithm is
     * run on the entire graph, instead of being stopped as soon as the destination is reached.
     * @throws RoutePlannerException 
     */
    public ArrayList<ArrayList<Station>> execute(Station start, Station destination) throws RoutePlannerException
    {
    	
        init(start);
        
        // the current node
        Station u;
        
        // extract the node with the shortest distance
        while ((u = unsettledNodes.poll()) != null)
        {
            assert !isSettled(u);
            
            // destination reached, stop
            if (u == destination) break;
            
            settledNodes.add(u);
            
            relaxNeighbors(u);
        }
        
        return returnPath(u);
    }
    
    private ArrayList<ArrayList<Station>> returnPath(Station u) {
        
        ArrayList<Station> temp = new ArrayList<Station>();
        temp.add(u);
        
        recursion(u, temp);
        
    	return pathStation;
    }
    
    private void recursion(Station u, ArrayList<Station> temp)
    {
    	ArrayList<Station> pre = null;
    	
    	if ((pre = predecessors.get(u)) != null)
        {
    		for (int i = 0; i < pre.size(); i++)
    		{
    			if (i != 0)
    				temp.remove(pre.get(i - i));
    			
    			temp.add(pre.get(i));
    			recursion(pre.get(i), temp);
    		}
    		
    		temp.remove(temp.size() - 1);
        }
    	
    	else if (u.getName().equals(startPoint))
    	{
    		ArrayList<Station> newTemp = new ArrayList<Station>();
    		
    		for (Station s : temp)
    			newTemp.add(s);
    		pathStation.add(newTemp);
    	}
    }

    /**
	 * Compute new shortest distance for neighboring nodes and update if a shorter
	 * distance is found.
	 * 
	 * @param u the node
     * @throws RoutePlannerException 
	 */
    private void relaxNeighbors(Station u) throws RoutePlannerException
    {   //loop through all the adjacent nodes
        for (Adjacent a : u.getAdjacent())
        {
        	//find station from adjacency list
        	Station v = a.getStation();
            // skip node already settled
            if (isSettled(v)) continue;
            
            int shortDist = getShortestDistance(u) + 1;
            
            if (shortDist <= getShortestDistance(v))
            {
            	// assign new shortest distance and mark unsettled
                setShortestDistance(v, shortDist);
                                
                // assign predecessor in shortest path
                setPredecessor(v, u);
            }
        }        
    }

	/**
	 * Test a node.
	 * 
     * @param v the node to consider
     * 
     * @return whether the node is settled, ie. its shortest distance
     * has been found.
     */
    private boolean isSettled(Station v)
    {
        return settledNodes.contains(v);
    }

    /**
     * @return the shortest distance from the source to the given city, or
     * {@link DijkstraEngine#INFINITE_DISTANCE} if there is no route to the destination.
     */    
    public int getShortestDistance(Station station)
    {
        Integer d = shortestDistances.get(station);
        return (d == null) ? INFINITE_DISTANCE : d;
    }

	/**
	 * Set the new shortest distance for the given node,
	 * and re-balance the queue according to new shortest distances.
	 * 
	 * @param city the node to set
	 * @param distance new shortest distance value
	 */        
    private void setShortestDistance(Station station, int distance) throws RoutePlannerException
    {
        /*
         * This crucial step ensures no duplicates are created in the queue
         * when an existing unsettled node is updated with a new shortest 
         * distance.
         * 
         * Note: this operation takes linear time. If performance is a concern,
         * consider using a TreeSet instead instead of a PriorityQueue. 
         * TreeSet.remove() performs in logarithmic time, but the PriorityQueue
         * is simpler. (An earlier version of this class used a TreeSet.)
         */
    	
        unsettledNodes.remove(station);

        /*
         * Update the shortest distance.
         */
        shortestDistances.put(station, distance);
        
		/*
		 * Re-balance the queue according to the new shortest distance found
		 * (see the comparator the queue was initialized with).
		 */
		unsettledNodes.add(station);        
    }
    
    /**
     * @return the city leading to the given city on the shortest path, or
     * <code>null</code> if there is no route to the destination.
     */
    public ArrayList<Station> getPredecessor(Station station)
    {
        return predecessors.get(station);
    }
    
//    private void setPredecessor(Station a, Station b)
//    {
//        predecessors.put(a, b);
//    }
    
    private void setPredecessor(Station a, Station b)
    {
    	ArrayList<Station> newArray = null;
    	
    	if (predecessors.containsKey(a)) 
    	{
    		newArray = predecessors.get(a);
    		
    		if (!newArray.contains(b))
    		{
	    		newArray.add(b);
	    		predecessors.put(a, newArray);
	    		return;
    		}
    	}
    	
    	newArray = new ArrayList<Station>();
    	newArray.add(b);
    	
    	predecessors.put(a, newArray);
    }

}
