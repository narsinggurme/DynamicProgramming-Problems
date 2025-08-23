package com.narsing.dp;

import java.util.Scanner;

public class Day2_ClimbingStairsDP
{
	// Function to calculate ways to climb stairs using Dynamic Programming
	public static int climbStairs(int n)
	{
		// dp[i] will store the number of ways to reach the i-th step
		int[] dp = new int[n + 1];

		// Base cases:
		// 0 steps → 1 way (do nothing)
		// 1 step → 1 way (just take one step)
		dp[0] = 1;
		dp[1] = 1;

		// Fill dp[] using the recurrence:
		// dp[i] = dp[i-1] + dp[i-2]
		// (i.e., from (i-1) step with 1 step OR from (i-2) step with 2 steps)
		for (int i = 2; i <= n; i++)
		{
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		// Answer is ways to reach step 'n'
		return dp[n];
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		// Input number of stairs
		System.out.print("Enter a Number: ");
		int num = sc.nextInt();

		// Output result
		System.out.println("Ways to climb Stairs: " + climbStairs(num));

		sc.close();
	}
}
