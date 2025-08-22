package com.narsing.dp;

import java.util.Scanner;

public class Day1_FibonacciSeriesWithoutArray
{
    // Print Fibonacci series up to n without using extra array
    public static void fibonacciSeries(int n)
    {
        int a = 0; // first number
        int b = 1; // second number

        System.out.print("Fibonacci series up to " + n + " : ");

        // loop to generate Fibonacci numbers
        for (int i = 0; i <= n; i++)
        {
            System.out.print(a + " "); 
            int next = a + b; // next number = sum of previous two
            a = b;
            b = next;
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        fibonacciSeries(num); // call method
        sc.close();
    }
}
