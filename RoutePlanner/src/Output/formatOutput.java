package Output;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Marker.Adjacent;
import Marker.Station;

public class formatOutput {
	
	public List<String> getSolution(List<ArrayList<Station>> solutions) {
		List<String> output = new ArrayList<String>();
		for(ArrayList<Station> list : solutions)
				output.add(createInstructions(list));
		return output;
	}
	
	private String createInstructions(ArrayList<Station> s) {
		Collections.reverse(s);
		String instructions = "";
		if(s.size() == 1)
		{
			instructions = "You are here";
		}
		else
		{
			int stops = 1;
			String currentLine = null;
			currentLine = lineChange(s.get(0),s.get(1),currentLine);//set the previousLine
			if(currentLine == null)
			{
				//error
			}
			for(int i=1; i<s.size();i++) {
				String nextLine = null;
				if(!(i == s.size()-1))
				{
					nextLine = lineChange(s.get(i),s.get(i+1),currentLine);
				}
				
				if(i == s.size()-1)
				{
					instructions += "Take the "+currentLine+" line "+stops+" stop(s) to "+s.get(i)+"<br>";
					stops = 1;
				}
				else if(nextLine == null)
				{
					stops++;
				}
				else
				{
					instructions += "Take the "+currentLine+" line "+stops+" stop(s) to "+s.get(i)+"<br>";
					currentLine = nextLine;
					stops=1;
				}
			}
		}
		return instructions;
	}
	
	/**
	 * This function will calculate and return the line to travel given the stops
	 * @return
	 */
	
	private String lineChange(Station curr, Station next,String currentline) {//return new line if it must be changed
		String nextLine = null;
		if(next == null)
		{
			return null;
		}
		for(Adjacent adjacent : curr.getAdjacent())
		{
			if(adjacent.getStation().equals(next))
			{
				if(adjacent.getLine().equals(currentline))
				{
					return nextLine;
				}
				else
				{
					nextLine = adjacent.getLine();
					return nextLine;
				}
			}
		}
		return null;
	}
	//Output should be arraylist of string
	
	//Input: [[Farringdon Liverpool Aldgate],[Farringdon, Moorgate, Aldgate]]	
	//Output:["Take the Farringdon line 2 stops to Aldgate"],["Take the Farringdon
	//line 1 stop, transfer to the Northwest line at Moorgate, take 1 stop to Aldgate"]
	//Take the northwest line 6 stops

}
