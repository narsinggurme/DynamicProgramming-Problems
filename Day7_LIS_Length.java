package com.narsing.dp;

import java.util.Scanner;

/**
 * Day 7 - Longest Increasing Subsequence (LIS)
 * 
 * Problem: Given an array of integers, find the length of the longest increasing subsequence (LIS).
 * 
 * Example:
 * Input:  [10, 9, 2, 5, 3, 7, 101, 18]
 * Output: 4
 * Explanation: LIS = [2, 3, 7, 101]
 * 
 * Approach: Dynamic Programming (O(n^2) solution)
 * dp[i] represents the length of the LIS ending at index i.
 */
public class Day7_LIS_Length {

    /**
     * Method to calculate the length of LIS using Dynamic Programming.
     * 
     * @param arr Input array
     * @return Length of LIS
     */
    public static int lengthOfLIS(int[] arr) {
        int n = arr.length;

        // Edge case: empty array
        if (n == 0) return 0;

        int[] dp = new int[n];
        int maxLen = 1;

        // Every element is an LIS of length 1 by itself
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        // Build dp array
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]); // Track maximum LIS so far
        }

        return maxLen;
    }

    /**
     * Main method for user input and testing.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array length: ");
        int len = sc.nextInt();
        int[] arr = new int[len];

        System.out.println("Enter array elements:");
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }

        int lisLength = lengthOfLIS(arr);
        System.out.println("Length of Longest Increasing Subsequence: " + lisLength);

        sc.close();
    }
}
