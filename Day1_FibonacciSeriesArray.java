package com.narsing.dp;

import java.util.Scanner;

public class Day1_FibonacciSeriesArray
{
    // Print Fibonacci series up to n using an array (DP - bottom-up)
    public static void fibonacciSeriesUsingArray(int n)
    {
        int[] dp = new int[n + 1]; // store Fibonacci numbers
        dp[0] = 0; // first number

        if (n > 0)
        {
            dp[1] = 1; // second number
        }

        System.out.print("Fibonacci series up to " + n + " : ");

        // build series iteratively
        for (int i = 0; i <= n; i++)
        {
            if (i >= 2)
            {
                dp[i] = dp[i - 1] + dp[i - 2]; // F(n) = F(n-1) + F(n-2)
            }
            System.out.print(dp[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = sc.nextInt();

        fibonacciSeriesUsingArray(num); // call method
        sc.close();
    }
}
