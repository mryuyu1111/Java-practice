package Sorting;

import java.util.ArrayList;

public class BubbleSort<T>
{
	public ArrayList<Integer> bubbleSort(ArrayList<Integer> arraylist)
	{
		for (int i = 0; i < arraylist.size() - 1; i++)
		{
			for (int j = i + 1; j < arraylist.size(); j++)
			{
				if (arraylist.get(j) < arraylist.get(i))
				{
					int temp = arraylist.get(j);
					arraylist.set(j, arraylist.get(i));
					arraylist.set(i, temp);
				}
			}//close for inner loop
		}//close for outer loop
		
		return arraylist;
		
	}//close bubbleSort
}//close class BubbleSort
