package com.narsing.dp;

import java.util.Scanner;

public class Day2_ClimbingStairsRec
{
	// Recursive function to calculate number of ways to climb stairs
	public static int climbStairs(int num)
	{
		// Base case:
		// If num = 0 → only 1 way (do nothing, stay at ground)
		// If num = 1 → only 1 way (take 1 single step)
		if (num == 0 || num == 1)
		{
			System.out.println("Reached base case for num: " + num);
			return 1;
		}

		// Recursive case:
		// To reach step "num", we can come from:
		// - step (num-1) by taking 1 step
		// - step (num-2) by taking 2 steps
		// So total ways = ways(num-1) + ways(num-2)
		return climbStairs(num - 1) + climbStairs(num - 2);
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		// Take input: total number of stairs
		System.out.print("Enter a Number (stairs): ");
		int num = sc.nextInt();

		// Print the result
		System.out.println("Ways to climb Stairs: " + climbStairs(num));

		sc.close();
	}
}
