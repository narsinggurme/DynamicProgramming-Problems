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


---

### How to run
- Open the project in any Java IDE (Eclipse, IntelliJ, etc.) or use terminal.
- Compile and run the respective `.java` files.
- Input the number for Fibonacci when prompted.
