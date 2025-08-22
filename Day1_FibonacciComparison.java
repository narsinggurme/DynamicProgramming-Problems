package com.narsing.dp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Program to demonstrate Fibonacci calculation using: 1. Memoization (Top-Down
 * DP) 2. Tabulation (Bottom-Up DP)
 * 
 * It also compares execution times of both approaches.
 */
public class Day1_FibonacciComparison
{

	// -------------------- Memoization --------------------
	static Map<Integer, Long> memo = new HashMap<>();

	public static long fibMemoization(int n)
	{
		if (n <= 1)
			return n;

		// If already computed, return from cache
		if (memo.containsKey(n))
		{
			return memo.get(n);
		}

		long result = fibMemoization(n - 1) + fibMemoization(n - 2);
		memo.put(n, result); // Store in cache
		return result;
	}

	// -------------------- Tabulation --------------------
	public static long fibTabulation(int n)
	{
		if (n <= 1)
			return n;

		long[] dp = new long[n + 1];
		dp[0] = 0;
		dp[1] = 1;

		for (int i = 2; i <= n; i++)
		{
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int num = sc.nextInt();

		// ---------- Memoization ----------
		long startMemo = System.nanoTime();
		long fibMemo = fibMemoization(num);
		long endMemo = System.nanoTime();

		System.out.println("Fibonacci(" + num + ") using Memoization = " + fibMemo);
		System.out.println("Time taken with Memoization: " + (endMemo - startMemo) + " ns");

		// ---------- Tabulation ----------
		long startTab = System.nanoTime();
		long fibTab = fibTabulation(num);
		long endTab = System.nanoTime();

		System.out.println("Fibonacci(" + num + ") using Tabulation = " + fibTab);
		System.out.println("Time taken with Tabulation: " + (endTab - startTab) + " ns");

		sc.close();
	}
}
