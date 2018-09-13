package Sorting;

import java.util.Arrays;

public class MergeSort 
{
	public int[] mergesort(int[] arraylist)
	{	
		int[] left = null, right = null;
		
		if (arraylist.length > 1)
		{
			int length = arraylist.length / 2;

			left = Arrays.copyOfRange(arraylist, 0, length);
			right = Arrays.copyOfRange(arraylist, length, arraylist.length);

			//recursive call
			left = mergesort(left);
			right = mergesort(right);
			
			return merge(left, right);
		}//close if
		else
			return arraylist;
		
	}//close mergesort
	
	public int[] merge(int[] left, int[] right)
	{
		int total = left.length + right.length;
		int[] sortedlist = new int[total];
		int l, r;
		l = r = 0;
		
		for (int i = 0; i < total; i++)
		{
			if (l < left.length && r < right.length)
			{
				if (left[l] < right[r])
				{
					sortedlist[i] = left[l];
					l++;
				}
				else
				{
					sortedlist[i] = right[r];
					r++;
				}
			}
			else if (l >= left.length && r < right.length)
				{
					sortedlist[i] = right[r];
					r++;
				}
			else
				{
					sortedlist[i] = left[l];
					l++;
				}
		}//close for loop
		
		return sortedlist;
		
	}//close method merge
}//close class Mergesort
