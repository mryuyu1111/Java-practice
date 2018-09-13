package Sorting;

import java.util.ArrayList;

public class QuickSort 
{
	public ArrayList<Integer> quickSort(ArrayList<Integer> arraylist) 
	{
		if (!arraylist.isEmpty()) 
		{
		    int pivot = arraylist.get(0);
		 
		    ArrayList<Integer> less = new ArrayList<Integer>();
		    ArrayList<Integer> pivotList = new ArrayList<Integer>();
		    ArrayList<Integer> more = new ArrayList<Integer>();
		 
		    // Partition
		    for (int i: arraylist) 
		    {
		        if (i < pivot)
		            less.add(i);
		        else if (i > pivot)
		            more.add(i);
		        else
		            pivotList.add(i);
		    }
		 
		    // Recursively sort sublists
		    less = quickSort(less);
		    more = quickSort(more);
		 
		    // Concatenate results
		    less.addAll(pivotList);
		    less.addAll(more);
		    return less;
		 }//close if
		
		return arraylist;
		 
	}//close quickSort
}
