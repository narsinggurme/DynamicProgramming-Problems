package com.narsing.dp;

import java.util.Scanner;

public class Day3_HouseRobber
{
	/**
	 * Function to calculate the maximum money that can be robbed without robbing
	 * two adjacent houses.
	 * 
	 * Approach: Dynamic Programming (Optimized with O(1) space)
	 */
	public static int rob(int num[])
	{
		if (num.length == 0)
			return 0; // No houses → no money
		if (num.length == 1)
			return num[0]; // Only one house → rob it

		// prev2 -> max money till (i-2)th house
		int prev2 = num[0];
		// prev1 -> max money till (i-1)th house
		int prev1 = Math.max(num[0], num[1]);

		// Iterate from the 3rd house onwards
		for (int i = 2; i < num.length; i++)
		{
			// Either rob current + prev2 OR skip current (prev1)
			int cur = Math.max(prev1, prev2 + num[i]);

			prev2 = prev1;
			prev1 = cur;
		}
		return prev1; // Final answer → max money robbed
	}

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter no. of houses: ");
		int houses = scanner.nextInt();
		int[] nums = new int[houses];

		System.out.print("Enter money in each house: ");
		for (int i = 0; i < houses; i++)
		{
			nums[i] = scanner.nextInt();
		}

		System.out.println("Maximum money that can be robbed: " + rob(nums));
		scanner.close();
	}
}
