package com.narsing.dp;

import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Day6_CoinChange
{
	public static int coinChange(int[] coins, int amount)
	{
		int max = amount + 1;
		int[] dp = new int[amount + 1]; // dp[i] = min number of coins to make amount i
		int[] prevCoin = new int[amount + 1]; // to track which coin was last used for dp[i]

		Arrays.fill(dp, max); // initially fill with "infinity" (amount+1)
		Arrays.fill(prevCoin, -1); // -1 means no coin chosen yet
		dp[0] = 0; // base case: 0 coins needed for amount 0

		// Process each coin
		for (int coin : coins)
		{
			for (int i = coin; i <= amount; i++)
			{
				// If using this coin gives a better solution (fewer coins), update dp[i]
				if (dp[i - coin] + 1 < dp[i])
				{
					dp[i] = dp[i - coin] + 1;
					prevCoin[i] = coin; // store which coin was used last for amount i
				}
			}
		}

		// If dp[amount] is still greater than amount, it means no solution
		if (dp[amount] > amount)
			return -1;

		// Reconstruct coins used (backtracking from amount)
		List<Integer> chosenCoins = new ArrayList<>();
		int curr = amount;
		while (curr > 0 && prevCoin[curr] != -1)
		{
			chosenCoins.add(prevCoin[curr]); // add the coin used
			curr -= prevCoin[curr]; // reduce the amount by that coin
		}

		// Print chosen coins
		System.out.println("Coins used to make amount " + amount + ": " + chosenCoins);

		return dp[amount];
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter number of coin denominations:");
		int n = sc.nextInt();
		int[] coins = new int[n];
		System.out.println("Enter coin denominations:");
		for (int i = 0; i < n; i++)
		{
			coins[i] = sc.nextInt();
		}

		System.out.println("Enter the target amount:");
		int amount = sc.nextInt();
		int result = coinChange(coins, amount);

		if (result == -1)
			System.out.println("It is not possible to make the given amount.");
		else
			System.out.println("Minimum coins required: " + result);

		sc.close();
	}
}
