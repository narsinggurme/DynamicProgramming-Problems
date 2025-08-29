# Dynamic Programming Problems

This repository contains daily Dynamic Programming (DP) problems solved in Java.

## Day 1: Fibonacci Problems

1. **Day1_FibonacciSeriesWithoutArray.java**
   - Iterative Fibonacci series without using an array.
   - Space efficient (O(1) space).

2. **Day1_FibonacciSeriesArray.java**
   - Iterative Fibonacci series using an array (bottom-up DP).
   - Time Complexity: O(n), Space Complexity: O(n).

3. **Day1_FibonacciMemoization.java**
   - Recursive Fibonacci calculation using memoization (top-down DP).
   - Avoids repeated calculations using a HashMap.
   - Time Complexity: O(n), Space Complexity: O(n).


## Day 2: Climbing Stairs Problems

1. **Day2_ClimbingStairsRec.java**
   - Recursive solution for climbing stairs.
   - Very inefficient due to repeated calculations (exponential time).
   - Time Complexity: O(2^n), Space Complexity: O(n) (recursion stack).

2. **Day2_ClimbingStairsDP.java**
   - Dynamic Programming solution using an array (bottom-up approach).
   - Stores results of subproblems in a dp[] array.
   - Time Complexity: O(n), Space Complexity: O(n).

3. **Day2_ClimbingStairsOptimized.java**
   - Optimized DP solution without using an array.
   - Uses only two variables (`prev1` and `prev2`) to track results.
   - Time Complexity: O(n), Space Complexity: O(1).

## Day 3: House Robber Problem

1. **Day3_HouseRobber.java**
   - Classic DP problem: given money in each house, find the maximum money that can be robbed without robbing two adjacent houses.
   - Uses an iterative bottom-up approach with **space optimization**.
   - Transitions:
     - `cur = max(prev1, prev2 + num[i])`
     - `prev2 = prev1`, `prev1 = cur`
   - Time Complexity: O(n), Space Complexity: O(1).
   - Example:
     ```
     Input:  [2, 7, 9, 3, 1]
     Output: 12
     Explanation: Rob house 1 (2) + house 3 (9) + house 5 (1) = 12
     ```

---
## Day 4: Maximum Sum of Non-Adjacent Elements

1. **Day4_MaxSumNonAdjacent.java**
      - Problem: Given an array of integers, find the maximum sum of elements such that no two chosen elements are adjacent.
   - Similar to the House Robber problem.
   - Uses **space optimized DP** with two variables:
     - `include` → max sum including the current element
     - `exclude` → max sum excluding the current element
   - Transition:
     ```
     newInclude = exclude + arr[i]
     newExclude = max(include, exclude)
     include = newInclude
     exclude = newExclude
     ```
   - Final Answer = `max(include, exclude)`
   - Time Complexity: O(n)
   - Space Complexity: O(1)
   - Example:
     ```
     Input:  [3, 2, 5, 10, 7]
     Output: 15
     Explanation: Pick 3 + 5 + 7 → maximum = 15

     ```
---
## Day 5: Min Cost Climbing Stairs

1. **Day5_MinCostClimbingStairs.java**
   - Problem: Each step has an associated cost. You can climb either **1 or 2 steps** at a time. Find the minimum cost to reach the top.
   - Uses **space optimized DP**.
   - Transition:
     ```java
     cur = cost[i] + Math.min(prev1, prev2)
     prev1 = prev2
     prev2 = cur
     ```
   - Final Answer = `Math.min(prev1, prev2)`
   - Time Complexity: O(n)  
   - Space Complexity: O(1)  
   - Example:
     ```
     Input:  [10, 15, 20]
     Output: 15
     Explanation: Take step 1 (cost=15) → reach top
     ```
---
# Day 6 – Coin Change Problem (Dynamic Programming)

## Problem Statement
Given an array of coin denominations and a target amount, find the **minimum number of coins** required to make that amount.  
If it is not possible to make the amount, return `-1`.

Additionally, show **which coins** were used in the solution.

---
## Day 7: Longest Increasing Subsequence (LIS)

1. **Day7_LIS_Length.java** (O(n²) DP Approach)
   - Problem: Given an array, find the length of the **longest increasing subsequence**.
   - Approach:
     - `dp[i]` = length of LIS ending at index `i`.
     - Transition:  
       ```
       if (arr[i] > arr[j]) 
           dp[i] = max(dp[i], dp[j] + 1)
       ```
   - Time Complexity: O(n²)  
   - Space Complexity: O(n)  

2. **Day7_LIS_Optimized.java** (O(n log n) Approach)
   - Uses a **patience sorting technique** with binary search.
   - Maintains a list `sub` that stores the smallest possible last elements of increasing subsequences of different lengths.
   - Uses `Collections.binarySearch()` to find position to insert/replace.
   - Time Complexity: O(n log n)  
   - Space Complexity: O(n)  
---
## Approach
We solve this using **Dynamic Programming (DP)**:

- `dp[i]` → minimum number of coins needed to make amount `i`.
- `prevCoin[i]` → stores the last coin used to make amount `i`.

### Steps:
1. Initialize `dp[0] = 0` (base case, 0 coins needed for amount 0).
2. Fill the `dp` array with a large value (`amount+1` → acts as infinity).
3. For each coin, update `dp[i]` for all amounts `i >= coin`.
4. If using this coin gives a better solution (`dp[i-coin] + 1 < dp[i]`), update both `dp[i]` and `prevCoin[i]`.
5. At the end:
   - If `dp[amount] > amount`, no solution exists.
   - Otherwise, backtrack using `prevCoin[]` to reconstruct which coins were chosen.
---
### How to run
- Open the project in any Java IDE (Eclipse, IntelliJ, etc.) or use terminal.
- Compile and run the respective `.java` files.
- Input the number for Fibonacci when prompted.
