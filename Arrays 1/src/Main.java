/*
* 1. Count Factors
* 2. IsPrime
* 3.Find Perfect Numbers
* 4.Count of Primes
* 5. Good Pair
* 6. Reverse in a range
* 7. Array Rotation
* 8. Max Min of an Array
* 9. Linear Search Multiple Occurences
* 10. Time to Equality
* 11. Count of Elements
* 12. Second Largest
*13.Prefix Sum - Range Sum Query
* 14.Prefix Sum - Even Numbers in A range
* 15. Prefix Sum - Equilibrium of an Array
* 16.Prefix Sum - inplace Prefix Sum
* 17. Subarrays - Closest MinMax
* 18.Subarrays - Subarray in Given Range
* 19.Subarrays - Generate all Subarrays
* 20.Subarrays - Special Subsequences "AG"
* 21.Subarrays - Count Subarrays
* 22.Subarrays - Best Time to buy and sell Stocks
* 23.Subarrays - Pick from Both Sides
* 24. Subarrays - Leaders in an Array
* 25. Sliding Window- Maximum Subarray Easy
* 26. Sliding Window - Sum of all Subarrays
* 27. Sliding Window - Subarray with given sum and length
* 28.Sliding Window - Good Subarrays Easy
* 29.Sliding Window - Counting Subarrays Easy
* 30.Sliding Window - Maximum Swaps
* 31.Sliding Window - Subarray with least Average
* 32. 2D Matrix - Column Sum
* 33. 2D Matrix - Main Diagonal Sum
* 34. 2D Matrix - Anti Diagonals
* 35. 2D Matrix - Matrix Transpose
* 36. 2D Matrix - Rotate Matrix
* 37. 2D Matrix - Row Sum
*38. 2D Matrix - Minor Diagonal Sum
* 39. 2D Matrix - Matrix Scalar Product
* 40. 2D Matrix - Add the Matrices
* */

//1.Count Factors
public class Solution {
    public int solve(int N) {
        int ans = 0;
        for (int i = 1; i*i <=N;i++){
            if(N%i==0){
                if (i == N/i){ans ++;}
                else {ans = ans +2;}
            }
        }return ans;
    }
}

//2.IsPrime
public class Solution {
    public int solve(int A) {

        if (A <=1){return 0;}
        int sqrtA = (int)Math.sqrt(A);
        for (int i = 2; i <= sqrtA; i++) {
            if (A%i==0){return 0;}
        }
        return 1;
    }
}

//3.Find Perfect Numbers
public class Solution {
    public int solve(int N) {
        if (N <= 1) {
            return 0; // N is not a perfect number
        }
        int ans = 1;
        for (int i = 2; i * i <= N; i++) {
            if (N % i == 0) {
                ans =ans + i + N/i;

            }
        }
        if (ans == N) {
            return 1;
        } else {
            return 0;
        }
    }
}
//4.Count of Primes

public class Solution {
    public int solve(int A) {
        int count = 0;

        for (int i = 2; i <= A; i++) {
            if (isPrime(i)) {
                count++;
            }
        }

        return count;
    }
    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}

//5. Good Pair
public class Solution {
    public int solve(int[] A, int B) {
        Arrays.sort(A);
        int l = 0;
        int r = A.length -1;

        while(l < r){
            int sum = A[l] + A[r];
            if(sum == B){return 1;}
            if(sum < B){l++;}
            if(sum > B){r--;}
        }
        return 0;
    }
}


// 6. Reverse in a range
public class Solution {
    public int[] solve(int[] A, int B, int C) {
        while (B < C) {
            int temp = A[B];
            A[B] = A[C];
            A[C] = temp;
            B++;
            C--;
        }
        return A;
    }

}

// 7. Array Rotation
public class Solution {
    public int[] solve(int[] A, int B) {
        int N = A.length;
        B = B % N;
        int[] result = new int[N];
        for(int i = 0; i < N; i++){
            int newIndex = (i+ B)%N;
            result[newIndex] = A[i];
        }
        return result;
    }
}

//8. Max Min of an Array

public class Solution {
    public int solve(int[] A) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            int num = A[i];
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return min + max;
    }
}

// 9. Linear Search Multiple Occurences
public class Solution {
    public int solve(int[] A, int B) {
        int count = 0;

        for (int i=0;i<A.length; i++) {
            int num = A[i];
            if (num == B) {
                count++;
            }
        }

        return count;
    }
}

// 10. Time to Equality
public class Solution {
    public int solve(int[] A) {
        int n = A.length;

        int max = A[0];
        for (int i = 1; i < n; i++) {
            if (A[i] > max) {
                max = A[i];
            }
        }

        int totalTime = 0;
        for (int i =0; i< A.length; i++) {
            int num = A[i];
            totalTime += max - num;
        }

        return totalTime;
    }
}

// 11. Count of Elements
public class Solution {
    public int solve(int[] A) {
        int max = Integer.MIN_VALUE;
        int count =0;

        for (int i = 0; i < A.length; i++){
            if (A[i]> max){
                max = Math.max(max, A[i]);

            }
        }

        for (int i = 0; i < A.length; i++){
            if (A[i] < max){count++;}
        }

        return count;
    }
}


//12. Second Largest

public class Solution {
    public int solve(int[] A) {
        if (A.length < 2){return -1;}
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int n = A.length;
        for (int i = 0; i < n; i++){
            int num = A[i];
            if (num > largest){
                secondLargest = largest;
                largest = num;
            }
            else if (num> secondLargest && num != largest){secondLargest = num;}

        }
        return (secondLargest == Integer.MIN_VALUE) ? -1 : secondLargest;
    }
}


//Prefix Sum - Range Sum Query
public class Solution {
    public long[] rangeSum(int[] A, int[][] B) {
        int n = A.length;
        int m = B.length;
        long[] cumulativeSum = new long[n];
        cumulativeSum[0] = A[0];

        for (int i = 1; i < n; i++) {
            cumulativeSum[i] = cumulativeSum[i - 1] + A[i];
        }

        long[] querySums = new long[m];

        for (int i = 0; i < m; i++) {
            int L = B[i][0];
            int R = B[i][1];

            long sum = cumulativeSum[R];
            if (L > 0) {
                sum -= cumulativeSum[L - 1];
            }
            querySums[i] = sum;
        }

        return querySums;
    }
}
//14.Prefix Sum - Even Numbers in A range
public class Solution {
    public int[] solve(int[] A, int[][] B) {
        int N = A.length;
        int Q = B.length;

        int[] evenCountPrefix = new int[N + 1];
        for (int i = 0; i < N; i++) {
            evenCountPrefix[i + 1] = evenCountPrefix[i] + (A[i] % 2 == 0 ? 1 : 0);
        }

        int[] result = new int[Q];
        for (int i = 0; i < Q; i++) {
            int L = B[i][0];
            int R = B[i][1];
            result[i] = evenCountPrefix[R + 1] - evenCountPrefix[L];
        }

        return result;
    }
}

// 15. Prefix Sum - Equilibrium of an Array
public class Solution {
    public int solve(int[] A) {
        int totalSum = 0;
        for (int num : A) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < A.length; i++) {
            if (leftSum == totalSum - leftSum - A[i]) {
                return i;
            }
            leftSum += A[i];
        }

        return -1;
    }
}

// 16.Prefix Sum - inplace Prefix Sum

public class Solution {
    public int[] solve(int[] A) {
        int n = A.length;

        for (int i = 1; i < n ; i++) {
            A[i] = A[i] + A[i - 1];
        }

        return A;
    }
}

//Subarrays - Closest MinMax
public class Solution {
    public int solve(int[] A) {
        int n = A.length;
        if (n == 0) return 0;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i : A) {
            if (i < min) min = i;
            if (i > max) max = i;
        }

        int minIndex = -1;
        int maxIndex = -1;
        int minLength = n;

        for (int i = 0; i < n; i++) {
            if (A[i] == min) minIndex = i;
            if (A[i] == max) maxIndex = i;

            if (minIndex != -1 && maxIndex != -1) {
                int currentLength = Math.abs(minIndex - maxIndex) + 1;
                minLength = Math.min(minLength, currentLength);
            }
        }

        return minLength;
    }
}

//18.Subarrays - Subarray in Given Range
public class Solution {
    public int[] solve(int[] A, int B, int C) {
        int subarrayLength = C-B+1;
        int [] subarray = new int [subarrayLength];
        for (int i = 0; i <  subarrayLength; i++){
            subarray[i] = A[B+i];
        }
        return subarray;
    }
}

// 19.Subarrays - Generate all Subarrays
public class Solution {
    public int[][] solve(int[] A) {

        int n = A.length;
        ArrayList<int[]> subarraysList = new ArrayList<>();

        for (int start = 0; start < n; start++) {
            for (int end = start; end < n; end++) {
                int[] subarray = new int[end - start + 1];
                for (int k = start; k <= end; k++) {
                    subarray[k - start] = A[k];
                }
                subarraysList.add(subarray);
            }
        }

        int[][] result = new int[subarraysList.size()][];
        for (int i = 0; i < subarraysList.size(); i++) {
            result[i] = subarraysList.get(i);
        }

        return result;
    }
}

// 20.Subarrays - Special Subsequences "AG"
public class Solution {
    public int solve(String A) {
        final int MOD = 1000000007;
        int countA = 0;
        int result = 0;


        char [] charArray = A.toCharArray();

        for (int i =0; i < charArray.length; i++) {
            char c= charArray[i];
            if (c == 'A') {
                countA++;
            } else if (c == 'G') {
                result = (result + countA) % MOD;
            }
        }

        return result;
    }
}

// 21.Subarrays - Count Subarrays
public class Solution {
    public int solve(int[] A) {
        final int MOD = 1000000007;
        int n = A.length;
        int[] lastSeen = new int[1000001];
        for (int i = 0; i < lastSeen.length; i++) {
            lastSeen[i] = -1;
        }

        int left = 0;
        long count = 0;

        for (int right = 0; right < n; right++) {
            if (lastSeen[A[right]] >= left) {
                left = lastSeen[A[right]] + 1;
            }
            lastSeen[A[right]] = right;
            count = (count + (right - left + 1)) % MOD;
        }

        return (int) count;
    }
}

// 22.Subarrays - Best Time to buy and sell Stocks
public class Solution {

    public int maxProfit(final int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : A) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }

        return maxProfit;
    }
}

// 23.Subarrays - Pick from Both Sides
public class Solution {
    public int solve(int[] A, int B) {
        int n = A.length;

        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i <= B; i++) {
            int sum = 0;

            for (int j = 0; j < i; j++) {
                sum += A[j];
            }

            for (int j = n - 1; j >= n - (B - i); j--) {
                sum += A[j];
            }

            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}

//24. Subarrays - Leaders in an Array

public class Solution {
    public int[] solve(int[] a) {
        int n = a.length;
        int[] tempLeaders = new int[n];
        int count = 0;
        int maxRight = a[n - 1];
        tempLeaders[count++] = maxRight;

        for (int i = n - 2; i >= 0; i--) {
            if (a[i] > maxRight) {
                maxRight = a[i];
                tempLeaders[count++] = maxRight;
            }
        }

        int[] leaders = new int[count];
        for (int i = 0; i < count; i++) {
            leaders[i] = tempLeaders[count - 1 - i];
        }

        return leaders;
    }
}

//Sliding Window- Maximum Subarray Easy
public class Solution {
    public int maxSubarray(int A, int B, int[] C) {
        int maxSum =0, currentSum =0;
        int left =0;
        for (int right = 0; right < A; right++){
            currentSum += C[right];
            while (currentSum > B){
                currentSum -= C[left++];

            }
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}
//* 26. Sliding Window - Sum of all Subarrays
public class Solution {
    public long subarraySum(int[] A) {
        long sum = 0;
        int N = A.length;

        for (int i = 0; i < N; i++){
            long contribution = (long) A[i] * (i+1) * (N-i);
            sum += contribution;
        }

        return sum;

    }
}

//* 27. Sliding Window - Subarray with given sum and length
public class Solution {
    public int solve(int[] A, int B, int C) {
        int N = A.length;
        if (B > N) return 0;
        int windowSum = 0;
        for (int i = 0; i < B; i++) {
            windowSum += A[i];
        }

        if (windowSum == C) return 1;

        for (int i = B; i < N; i++) {
            windowSum += A[i] - A[i - B];
            if (windowSum == C) return 1;
        }

        return 0;}
}

//* 28.Sliding Window - Good Subarrays Easy
public class Solution {
    public int solve(int[] A, int B) {
        int n = A.length;
        int count = 0;

        for (int start = 0; start < n; start++) {
            int sum = 0;
            for (int end = start; end < n; end++) {
                sum += A[end];
                int length = end - start + 1;
                if (length % 2 == 0) {
                    if (sum < B) {
                        count++;
                    }
                } else {
                    if (sum > B) {
                        count++;
                    }
                }
            }
        }

        return count;}
}

//* 29.Sliding Window - Counting Subarrays Easy
public class Solution {
    public int solve(int[] A, int B) {
        int n = A.length;
        int count = 0;
        int currentSum = 0;
        int start = 0;

        for (int end = 0; end < n; end++) {
            currentSum += A[end];

            while (currentSum >= B && start <= end) {
                currentSum -= A[start++];
            }

            count += (end - start + 1);
        }

        return count;
    }
}
//* 30.Sliding Window - Maximum Swaps
public class Solution {
    public int solve(int[] A, int B) {
        int n = A.length;
        int countLessEqualB = 0;

        for (int num : A) {
            if (num <= B) {
                countLessEqualB++;
            }
        }

        if (countLessEqualB == 0) {
            return 0;
        }

        int maxCount = 0;
        int currentCount = 0;

        for (int i = 0; i < countLessEqualB; i++) {
            if (A[i] <= B) {
                currentCount++;
            }
        }

        maxCount = currentCount;

        for (int i = countLessEqualB; i < n; i++) {
            if (A[i] <= B) {
                currentCount++;
            }
            if (A[i - countLessEqualB] <= B) {
                currentCount--;
            }
            maxCount = Math.max(maxCount, currentCount);
        }

        return countLessEqualB - maxCount;
    }
}

//* 31.Sliding Window - Subarray with least Average

public class Solution {
    public int solve(int[] A, int B) {
        int n = A.length;

        int currentSum = 0;
        for (int i = 0; i < B; i++) {
            currentSum += A[i];
        }

        int minSum = currentSum;
        int minIndex = 0;

        for (int i = B; i < n; i++) {
            currentSum += A[i] - A[i - B];

            if (currentSum < minSum) {
                minSum = currentSum;
                minIndex = i - B + 1;
            }
        }

        return minIndex;
    }
}

//2D Matrix - Column Sum
public class Solution {
    public int[] solve(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0){
            return new int [0];
        }
        int n = A.length;
        int m = A[0].length;

        int [] columnSums = new int [m];
        for (int j = 0; j < m; j++){
            for (int i = 0; i < n; i++){
                columnSums[j] += A[i][j];
            }
        }
        return columnSums;
    }
}

//* 33. 2D Matrix - Main Diagonal Sum
public class Solution {

    public int solve(final int[][] A) {
        int sum = 0;
        int n = A.length;
        for (int i  = 0; i < n; i++){
            sum += A[i][i];
        }
        return sum;
    }
}

//* 34. 2D Matrix - Anti Diagonals
public class Solution {
    public int[][] diagonal(int[][] A) {
        int n = A.length;
        int [][] result = new int [2* n-1][n];
        for (int d = 0; d < n; d++){
            int r = 0; int c = d;
            int index =0;
            while(c >= 0){
                result[d][index] = A[r][c];
                r++;
                c--;
                index++;
            }
        }
        for (int d  = n; d < 2* n -1; d++){
            int r = d - n +1;
            int c = n-1;
            int index =0;
            while (r < n){
                result[d][index] = A[r][c];
                r++;
                c--;
                index++;
            }
        }
        return result;

    }

}
//* 35. 2D Matrix - Matrix Transpose
public class Solution {
    public int[][] solve(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;

        int[][] transpose = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpose[j][i] = A[i][j];
            }
        }

        return transpose;
    }
}

//* 36. 2D Matrix - Rotate Matrix
public class Solution {
    public void solve(int[][] A) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = A[i][j];
                A[i][j] = A[i][n - 1 - j];
                A[i][n - 1 - j] = temp;
            }
        }
    }
}
//* 37. 2D Matrix - Row Sum
public class Solution {
    public int[] solve(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;
        int[] result = new int[rows];

        for (int i = 0; i < rows; i++) {
            int sum = 0;
            for (int j = 0; j < cols; j++) {
                sum += A[i][j];
            }
            result[i] = sum;
        }

        return result;
    }
}

//*38. 2D Matrix - Minor Diagonal Sum
public class Solution {

    public int solve(final int[][] A) {
        int n = A.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += A[i][n - i - 1];
        }

        return sum;
    }
}
//* 39. 2D Matrix - Matrix Scalar Product
public class Solution {
    public int[][] solve(int[][] A, int B) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = A[i][j] * B;
            }
        }

        return result;
    }
}
//* 40. 2D Matrix - Add the Matrices

public class Solution {
    public int[][] solve(int[][] A, int[][] B) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }

        return result;
    }
}