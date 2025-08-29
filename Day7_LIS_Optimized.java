package com.narsing.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day7_LIS_Optimized
{
    // Function to calculate length of LIS using O(n log n) approach
    public static int lengthOfLIS(int[] arr)
    {
        // This list will store the smallest possible "end elements" 
        // of increasing subsequences of different lengths.
        List<Integer> sub = new ArrayList<Integer>();

        // Iterate through each number in the array
        for (int num : arr)
        {
            // Binary search: find the index where 'num' should go
            int pos = Collections.binarySearch(sub, num);

            // If num is not found, binarySearch returns (-(insertionPoint) - 1)
            if (pos < 0)
            {
                pos = -(pos + 1); // Convert to the correct insertion point
            }

            // If pos == sub.size(), it means 'num' is bigger than all elements
            // -> Append it to the list (extend the subsequence)
            if (pos == sub.size())
            {
                sub.add(num);
            } 
            else
            {
                // Otherwise, replace the element at pos with 'num'
                // (to maintain the smallest possible tail element)
                sub.set(pos, num);
            }
        }

        // The size of 'sub' is the length of the LIS
        return sub.size();
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array length: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter array elements: ");
        for (int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }

        // Print the LIS length
        System.out.println("Length of Longest Increasing Subsequence: " + lengthOfLIS(arr));
        sc.close();
    }
}
