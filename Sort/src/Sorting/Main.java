package Sorting;

import java.util.ArrayList;
import java.util.Random;

public class Main 
{
	public static void main(String[] args)
	{
		int[] testlist = new int[11];
		Random ran = new Random();
		MergeSort merge = new MergeSort();
		QuickSort quick = new QuickSort();
		ArrayList<Integer> test = new ArrayList<Integer>();
		
		for (int i = 0; i < 11; i++)
		{
			testlist[i] = ran.nextInt(10);
			test.add(testlist[i]);
		}
		
		for (int i = 0; i < 11; i++)
			System.out.print(testlist[i] + " ");
		
		System.out.println();
		
		for (int i = 0; i < 11; i++)
			System.out.print((merge.mergesort(testlist))[i] + " ");
		
		System.out.println();
		System.out.println(quick.quickSort(test));
	}
}
