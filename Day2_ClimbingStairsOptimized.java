package com.narsing.dp;

import java.util.Scanner;

public class Day2_ClimbingStairsOptimized
{
	// Optimized DP approach: O(n) time, O(1) space
	public static int climbStairs(int num)
	{
		// Base cases:
		// num = 0 → 1 way (do nothing)
		// num = 1 → 1 way (one single step)
		int prev1 = 1; // stores dp[i-1]
		int prev2 = 1; // stores dp[i-2]

		// Loop from step 2 to step 'num'
		for (int i = 2; i <= num; i++)
		{
			int cur = prev1 + prev2; // current ways = ways(i-1) + ways(i-2)
			prev2 = prev1; // shift prev2 to previous prev1
			prev1 = cur; // update prev1 to current
		}

		// At the end, prev1 = dp[num]
		return prev1;
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		// Input number of stairs
		System.out.print("Enter a Number: ");
		int num = sc.nextInt();

		// Output total ways
		System.out.println("Ways to climb Stairs: " + climbStairs(num));

		sc.close();
	}
}
