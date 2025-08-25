package com.narsing.dp;

import java.util.Scanner;

//Day4_MaxSumNonAdjacent.java
//Problem: Find maximum sum of non-adjacent elements in an array
public class Day4_MaxSumNonAdjacent
{

	// Optimized DP solution (O(n) time, O(1) space)
	public static int maxSumNonAdjacent(int[] arr)
	{
		if (arr.length == 0)
			return 0;
		if (arr.length == 1)
			return arr[0];

		int include = arr[0]; // sum including current element
		int exclude = 0; // sum excluding current element

		for (int i = 1; i < arr.length; i++)
		{
			int newInclude = exclude + arr[i]; // if we include current
			int newExclude = Math.max(include, exclude); // if we exclude current

			include = newInclude;
			exclude = newExclude;
		}

		return Math.max(include, exclude);
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter number of elements: ");
		int n = sc.nextInt();
		int[] arr = new int[n];

		System.out.println("Enter array elements:");
		for (int i = 0; i < n; i++)
		{
			arr[i] = sc.nextInt();
		}

		int result = maxSumNonAdjacent(arr);
		System.out.println("Maximum sum of non-adjacent elements: " + result);

		sc.close();
	}
}
