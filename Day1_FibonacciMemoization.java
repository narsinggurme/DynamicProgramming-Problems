package com.narsing.dp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Day 1: Fibonacci using Memoization (Top-Down DP Approach).
 * 
 * <p>
 * Efficient Fibonacci calculation using memoization:
 * <ul>
 * <li>Stores previously calculated results in a HashMap.</li>
 * <li>Reduces duplicate recursive calls.</li>
 * <li>Handles multiple inputs until user enters -1.</li>
 * </ul>
 * </p>
 * 
 * Example: Input: 10 Output: Fibonacci(10) = 55
 * 
 * Time Complexity: O(n) Space Complexity: O(n)
 * 
 * @author Narsing Gurme
 * @since Aug 2025
 */
public class Day1_FibonacciMemoization
{

	/** Cache to store computed Fibonacci values */
	static Map<Integer, Integer> map = new HashMap<>(Map.of(0, 0, 1, 1));

	/**
	 * Computes Fibonacci of a given number using Memoization.
	 * 
	 * @param n the Fibonacci term to calculate
	 * @return Fibonacci number at position n
	 */
	public static int fib(int n)
	{
		if (map.containsKey(n))
		{
			return map.get(n);
		}

		int result = fib(n - 1) + fib(n - 2);
		map.put(n, result);
		return result;
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		while (true)
		{
			System.out.print("Enter a number (or -1 to exit): ");
			int num = sc.nextInt();

			if (num == -1)
			{
				break;
			} else if (num < -1)
			{
				System.out.println("⚠ Please enter a non-negative number!");
				continue;
			}

			System.out.println("Fibonacci(" + num + ") = " + fib(num));
		}

		sc.close();
	}
}
