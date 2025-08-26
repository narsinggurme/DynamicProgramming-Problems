package com.narsing.dp;

import java.util.Scanner;

public class Day5_MinCostClimbingStairs
{
    // Function to calculate the minimum cost to reach the top
    public static int minCostClimbingStairs(int[] cost)
    {
        // Base cases: cost to start from step 0 or step 1
        int prev = cost[0];
        int prev2 = cost[1];

        // DP iteration from step 2 onwards
        for(int i = 2; i < cost.length; i++)
        {
            // Current step cost = cost[i] + min(previous two steps)
            int cur = cost[i] + Math.min(prev, prev2);

            // Move forward: shift the window
            prev = prev2;
            prev2 = cur;
        }
        // Answer is min of last two steps (since you can reach top from either)
        return Math.min(prev, prev2);
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter how many steps:");
        int steps = sc.nextInt();

        int[] costs = new int[steps];
        System.out.println("Enter the cost for each step:");
        for (int i = 0; i < steps; i++)
        {
            costs[i] = sc.nextInt();
        }

        System.out.println("Minimum cost to reach top: " + minCostClimbingStairs(costs));

        sc.close();
    }
}
