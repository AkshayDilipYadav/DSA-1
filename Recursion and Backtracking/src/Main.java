/* RECURSION -
* Recursion is a programming technique where a function calls itself in order to solve a problem.
* This approach is often used when a problem can be broken down into smaller, similar sub-problems.
*  Each recursive call works on a smaller version of the problem until it reaches a base case,
* which is a simple case that can be solved directly without further recursion.

Key Components of Recursion:

Base Case: The condition under which the recursion stops. It is essential to have a base case to avoid infinite recursion.
Recursive Case: The part of the function where the function calls itself with a modified parameter,
* gradually working towards the base case.
* */

/*BACKTRACKING
* Backtracking is a technique used to solve problems incrementally,
* trying to build a solution piece by piece and removing those solutions that fail to satisfy the conditions of the problem at any point in time.
* It is often used in problems involving searching through a large space of possible solutions, like puzzles, games, or combinatorial problems.

Key Concepts in Backtracking:

Candidate Solution: A possible solution to the problem.
Constraints: Conditions that must be met for a candidate solution to be valid.
Backtracking Step: If a candidate solution violates any constraints,
* the algorithm discards the last step (or steps) and tries a different option.
* */

/*
* Recursion vs. Backtracking
Recursion is a broader concept that refers to any function that calls itself.
Backtracking is a specific algorithmic technique that uses recursion to explore all potential solutions to a problem.
* It involves exploring a solution space and abandoning paths that don't lead to a solution.
Backtracking essentially uses recursion to search through possible solutions and systematically
* discard those that don't meet the problem's criteria, making it an efficient way to solve combinatorial problems.
* */

/*
* 1. Find Fibonacci - 2
* 2. Find Factorial!
* 3. Print 1 to A function
* 4. Implement Power Function
* 5. Sum of Digits!
* 6. Print A to 1 function
* 7. Check Palindrome using Recursion
* 8. Tower of Hanoi
* 9. Generate all Parenthesis 2
* 10. kth Symbol - easy
* 11. is magic?
* 12. kth symbol - hard
* 13. NQueens
* 14. Generate Subsets
* 15. Permutations
* 16. Unique Paths 3
* 17. Subsets 2
* */

//1. Find Fibonacci - 2
public class Solution {
    public int findAthFibonacci(int A) {
        if (A <= 1){return A;}
        return findAthFibonacci(A -1) + findAthFibonacci (A -2);
    }
}

//* 2. Find Factorial!
public class Solution {
    public int solve(int A) {
        if (A == 0) {
            return 1;
        }

        return A * solve(A - 1);
    }

}

//* 3. Print 1 to A function
private void printRecursive(int current, int A) {
    if (current > A) {
        return;
    }

    System.out.print(current + " ");

    printRecursive(current + 1, A);
}
//* 4. Implement Power Function



public class Solution {

    public int pow(int A, int B, int C) {
        if (B == 0){return 1 % C;}
        long result;
        if (B % 2 == 0){
            long temp = pow(A, B/2 , C);
            result = (temp * temp) % C;
        }
        else{
            long temp = pow(A, B -1, C);
            result = (A % C * temp)% C;
        }

        return (int)((result + C) % C);
    }
}

//* 5. Sum of Digits!
public class Solution {
    public int solve(int A) {
        if (A == 0){ return A;}
        return A % 10 + solve(A / 10);
    }
}

//* 6. Print A to 1 function
private void printRecursive(int current, int A) {
    if (current > A) {
        return;
    }
    printRecursive(current + 1, A);
    System.out.print(current + " ");


}
//* 7. Check Palindrome using Recursion



public class Solution {
    public int solve(String A) {
        return isPalindromeHelper(A, 0, A.length() -1) ? 1:0;

    }
    private boolean isPalindromeHelper(String A, int start, int end){
        if (start >= end){
            return true;
        }
        if (A.charAt(start) != A.charAt(end)){return false;}
        return isPalindromeHelper(A, start +1, end -1);
    }
}


//8. Tower of Hanoi
public class Solution {
    public static int[][] towerOfHanoi(int n) {
        List<int[]> movesList = new ArrayList<>();
        hanoi(n, 'A', 'C', 'B', movesList);

        int[][] movesArray = new int[movesList.size()][3];
        for (int i = 0; i < movesList.size(); i++) {
            int[] move = movesList.get(i);
            movesArray[i][0] = move[0];
            movesArray[i][1] = move[1] - 'A' + 1;
            movesArray[i][2] = move[2] - 'A' + 1;
        }

        return movesArray;
    }

    private static void hanoi(int n, char fromRod, char toRod, char auxRod, List<int[]> moves) {
        if (n == 0) {
            return;
        }
        hanoi(n - 1, fromRod, auxRod, toRod, moves);
        moves.add(new int[]{n, fromRod, toRod});
        hanoi(n - 1, auxRod, toRod, fromRod, moves);
    }
}

//* 9. Generate all Parenthesis 2
public class Solution {
    public String[] generateParenthesis(int A) {
        List<String> result = new ArrayList<>();
        generateParenthesesHelper(result, "", A, A);
        Collections.sort(result);
        return result.toArray(new String[0]);
    }

    private void generateParenthesesHelper(List<String> result, String current, int open, int close) {
        if (open == 0 && close == 0) {
            result.add(current);
            return;
        }

        if (open > 0) {
            generateParenthesesHelper(result, current + "(", open - 1, close);
        }

        if (close > open) {
            generateParenthesesHelper(result, current + ")", open, close - 1);
        }
    }
}

//* 10. kth Symbol - easy
public class Solution {
    public int solve(int A, int B) {
        if (A == 1) {
            return 0;
        }

        int mid = (1 << (A - 2)); // This is 2^(A-2)

        if (B < mid) {
            return solve(A - 1, B); // First half
        } else {
            return 1 - solve(A - 1, B - mid); // Second half, complement
        }}
}

//* 11. is magic?
public class Solution {
    public int solve(int A) {
        if (A == 0) {
            return 0;
        }

        int remainder = A % 9;

        if (remainder == 0) {
            remainder = 9;
        }

        return remainder == 1 ? 1 : 0;
    }
}

//* 12. kth symbol - hard

public class Solution {
    public int solve(int A, long B) {
        return kthGrammar(A, B);
    }

    private int kthGrammar(int A, long B) {
        // Base case: If we are at the first row, the only symbol is 0.
        if (A == 1) {
            return 0;
        }

        // Calculate the parent index of B in the previous row
        long parentIndex = B / 2;

        // Recursively determine the symbol for the parent
        int parentSymbol = kthGrammar(A - 1, parentIndex);

        // If B is even (0-indexed), it matches the parent's symbol; otherwise, it's the complement.
        if (B % 2 == 0) {
            return parentSymbol;
        } else {
            return 1 - parentSymbol;
        }

    }
}


// NQueens


public class Solution {
    public String[][] solveNQueens(int A) {
        List<String[]> result = new ArrayList<>();
        char[][] board = new char[A][A];

        // Initialize the board with empty spaces
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < A; j++) {
                board[i][j] = '.';
            }
        }

        // Call the backtracking helper function
        solveNQueensHelper(0, A, board, result);

        // Convert the list of solutions to an array of string arrays
        return result.toArray(new String[result.size()][]);
    }

    private void solveNQueensHelper(int row, int n, char[][] board, List<String[]> result) {
        if (row == n) {
            result.add(constructSolution(board));
            return;
        }

        for (int col = n - 1; col >= 0; col--) { // Reverse lexicographical order
            if (isSafe(row, col, n, board)) {
                board[row][col] = 'Q';
                solveNQueensHelper(row + 1, n, board, result);
                board[row][col] = '.'; // Backtrack
            }
        }
    }

    private boolean isSafe(int row, int col, int n, char[][] board) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }

    private String[] constructSolution(char[][] board) {
        String[] solution = new String[board.length];
        for (int i = 0; i < board.length; i++) {
            solution[i] = new String(board[i]);
        }
        return solution;
    }

}

//* 14. Generate Subsets

class Solution {
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        backtrack(A, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(ArrayList<Integer> A, int index, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> result) {
        result.add(new ArrayList<>(current)); // Add the current subset to the result list

        for (int i = index; i < A.size(); i++) {
            current.add(A.get(i)); // Include A[i] in the current subset
            backtrack(A, i + 1, current, result); // Move to the next element
            current.remove(current.size() - 1); // Backtrack: Exclude A[i] from the current subset
        }
    }
}

//* 15. Permutations

public class Solution {
    public int[][] permute(int[] A) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(A, new ArrayList<>(), new boolean[A.length], result);

        // Convert the List<List<Integer>> result to int[][]
        int[][] permutations = new int[result.size()][A.length];
        for (int i = 0; i < result.size(); i++) {
            List<Integer> perm = result.get(i);
            for (int j = 0; j < perm.size(); j++) {
                permutations[i][j] = perm.get(j);
            }
        }
        return permutations;
    }

    private void backtrack(int[] A, List<Integer> current, boolean[] used, List<List<Integer>> result) {
        if (current.size() == A.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < A.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            current.add(A[i]);
            backtrack(A, current, used, result);
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}


//* 16. Unique Paths 3

public class Solution {
    private int totalPaths = 0;
    private int totalCellsToVisit = 0;
    private int rows, cols;

    public int solve(int[][] A) {
        rows = A.length;
        cols = A[0].length;
        int startRow = 0, startCol = 0;

        // Identify start position and count total walkable cells
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (A[i][j] == 1) {
                    startRow = i;
                    startCol = j;
                }
                if (A[i][j] != -1) {
                    totalCellsToVisit++;
                }
            }
        }

        // Start backtracking from the start position
        backtrack(A, startRow, startCol, 1);  // start by visiting the start cell

        return totalPaths;
    }

    private void backtrack(int[][] A, int row, int col, int visitedCells) {
        // Base case: if out of bounds or hits an obstacle
        if (row < 0 || col < 0 || row >= rows || col >= cols || A[row][col] == -1) {
            return;
        }

        // If reached the ending square
        if (A[row][col] == 2) {
            if (visitedCells == totalCellsToVisit) {
                totalPaths++;
            }
            return;
        }

        // Temporarily mark the cell as visited
        int temp = A[row][col];
        A[row][col] = -1;

        // Explore all 4 directions
        backtrack(A, row + 1, col, visitedCells + 1);
        backtrack(A, row - 1, col, visitedCells + 1);
        backtrack(A, row, col + 1, visitedCells + 1);
        backtrack(A, row, col - 1, visitedCells + 1);

        // Backtrack: Unmark the cell
        A[row][col] = temp;
    }
}


//* 17. Subsets 2

public class Solution {
    public int[][] subsetsWithDup(int[] A) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(A);  // Sort to handle duplicates
        backtrack(A, 0, new ArrayList<>(), result);

        // Convert List<List<Integer>> to int[][]
        int[][] resultArray = new int[result.size()][];
        for (int i = 0; i < result.size(); i++) {
            List<Integer> subset = result.get(i);
            resultArray[i] = subset.stream().mapToInt(Integer::intValue).toArray();
        }
        return resultArray;
    }

    private void backtrack(int[] A, int start, List<Integer> path, List<List<Integer>> result) {
        // Add the current subset to the result
        result.add(new ArrayList<>(path));

        for (int i = start; i < A.length; i++) {
            // Skip duplicates
            if (i > start && A[i] == A[i - 1]) {
                continue;
            }
            path.add(A[i]);
            backtrack(A, i + 1, path, result);  // Move to the next index
            path.remove(path.size() - 1);  // Remove last element to backtrack
        }
    }
}
