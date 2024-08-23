/*
* 1. 1D - Max Sum Contiguous Subarray
* 2. 1D - Continuous Sum Query
* 3. 1D - Rain Water Trapped
* 4. 1D - Add One to Number
* 5. 1D - Flip
* 6. 2D - Spiral Order MAtrix 2
* 7. 2D - Search in row wise and column wise sorted Matrix
* 8. 2D - Sum of all Submatrices
* 9. 2D - Row with maximum number of Ones
* 10.2D - Minimum Swaps
* 11. 3D - First Missing Integer
* 12. 3D - Merge Intervals
* 13. 3D - Merge Sorted Overlapping Intervals
* 14. 3D - Next Permutation
* 15. 3D - Number of Digit one
* */

//1D - Max Sum Contiguous Subarray
public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maxSubArray(final int[] A) {
        int n = A.length;
        int maxEndingHere = A[0];
        int maxSoFar = A[0];
        for (int i = 1; i < n; i++){
            maxEndingHere = Math.max(A[i], maxEndingHere + A[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
}

//* 2. 1D - Continuous Sum Query

public class Solution {
    public int[] solve(int A, int[][] B) {
        int [] pots = new int [A];
        for (int[] donation : B){

            int L = donation[0] - 1;
            int R = donation[1] - 1;
            int P = donation[2];
            pots[L] += P;
            if (R+1 < A){pots[R+1] -= P;}
        }
        for (int i = 1; i < A; i++){
            pots[i] += pots[i-1];
        }

        return pots;
    }
}

//* 3. 1D - Rain Water Trapped
public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int trap(final int[] A) {
        if (A == null || A.length <3){return 0;}
        int left = 0;
        int right = A.length -1;
        int leftMax =0;
        int rightMax = 0;
        int waterTrapped = 0;

        while (left < right){
            int currentLeft = A [left];
            int currentRight = A[right];
            if(currentLeft < currentRight){
                if (currentLeft >= leftMax){leftMax = currentLeft;}
                else {waterTrapped = waterTrapped + leftMax - currentLeft;}
                left++;
            }
            else {
                if (currentRight >=rightMax){rightMax = currentRight;}
                else {waterTrapped = waterTrapped + rightMax - currentRight;}
                right--;
            }
        }return waterTrapped;
    }
}

//* 4. 1D - Add One to Number
public class Solution {
    public int[] plusOne(int[] A) {
        int n = A.length;

        int leadingZeroes = 0;
        while (leadingZeroes < n && A[leadingZeroes] == 0) {
            leadingZeroes++;
        }

        if (leadingZeroes == n) {
            return new int[]{1};
        }

        int[] modifiedArray = new int[n - leadingZeroes];
        System.arraycopy(A, leadingZeroes, modifiedArray, 0, n - leadingZeroes);

        modifiedArray[n - leadingZeroes - 1]++;

        for (int i = n - leadingZeroes - 1; i > 0; i--) {
            if (modifiedArray[i] == 10) {
                modifiedArray[i] = 0;
                modifiedArray[i - 1]++;
            } else {
                break;
            }
        }

        if (modifiedArray[0] == 10) {
            int[] result = new int[modifiedArray.length + 1];
            result[0] = 1;
            return result;
        }

        return modifiedArray;
    }
}
//* 5. 1D - Flip

public class Solution {
    public int[] plusOne(int[] A) {
        int n = A.length;

        int leadingZeroes = 0;
        while (leadingZeroes < n && A[leadingZeroes] == 0) {
            leadingZeroes++;
        }

        if (leadingZeroes == n) {
            return new int[]{1};
        }

        int[] modifiedArray = new int[n - leadingZeroes];
        System.arraycopy(A, leadingZeroes, modifiedArray, 0, n - leadingZeroes);

        modifiedArray[n - leadingZeroes - 1]++;

        for (int i = n - leadingZeroes - 1; i > 0; i--) {
            if (modifiedArray[i] == 10) {
                modifiedArray[i] = 0;
                modifiedArray[i - 1]++;
            } else {
                break;
            }
        }

        if (modifiedArray[0] == 10) {
            int[] result = new int[modifiedArray.length + 1];
            result[0] = 1;
            return result;
        }

        return modifiedArray;
    }
}

//2D - Spiral Order MAtrix 2
public class Solution {
    public int [][] generateMatrix(int A){
        int [][] matrix = new int [A][A];
        int num =1;
        int topRow =0, bottomRow = A-1, leftColumn =0, rightColumn= A-1;
        int t= A*A;
        while (t>=0){
            for (int i = leftColumn; i <= rightColumn; i++){matrix [topRow][i] = num++;} topRow++; t--;
            for (int i = topRow; i <= bottomRow; i++){matrix [i][rightColumn] = num++;} rightColumn--; t--;
            for (int i = rightColumn; i >= leftColumn; i--){matrix [bottomRow][i] = num++;} bottomRow--; t--;
            for (int i = bottomRow; i >= topRow; i--){matrix [i][leftColumn] = num++;} leftColumn++; t--;

        }
        return matrix;
    }
}


//* 7. 2D - Search in row wise and column wise sorted Matrix
public class Solution {
    public int solve(int[][] A, int B) {
        int n = A.length;
        int m = A[0].length;
        int row = 0, col = m - 1;
        int smallestIdentifier = Integer.MAX_VALUE;

        while (row < n && col >= 0) {
            if (A[row][col] == B) {
                int currentIdentifier = (row + 1) * 1009 + (col + 1);
                smallestIdentifier = Math.min(smallestIdentifier, currentIdentifier);
                col--;
            } else if (A[row][col] < B) {
                row++;
            } else {
                col--;
            }
        }

        if (smallestIdentifier == Integer.MAX_VALUE) {
            return -1;
        } else {
            return smallestIdentifier;
        }
    }
}
//* 8. 2D - Sum of all Submatrices
public class Solution {
    public int solve(int[][] A) {
        int n = A.length;
        int sum =0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                sum += A[i][j] * (i +1) * (j+1)* (n-i)* (n-j);
            }
        }
        return sum;
    }
}

//* 9. 2D - Row with maximum number of Ones
public class Solution {
    public int solve(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int maxOnesRowIndex =0;

        int i = 0, j = m-1;
        while (i < n && j >= 0){
            if (A[i][j]==1){maxOnesRowIndex= i; j--;}
            else {i++;}
        }
        return maxOnesRowIndex;
    }
}

//* 10.2D - Minimum Swaps
public class Solution {
    public int solve(int[] A, int B) {
        int n = A.length;
        int count = 0;
        int maxCount = 0;

        for (int i = 0; i < n; i++){
            if (A[i] <= B){count++;}
        }

        for (int i =0; i < count; i++){
            if (A[i] <= B){maxCount++;}
        }

        int swaps = count - maxCount;

        for (int i = count; i < n; i++){
            if (A[i - count] <= B){maxCount--;}
            if (A[i] <= B){maxCount++;}
            swaps = Math.min(swaps, count - maxCount);
        }
        return swaps;
    }
}

//3D - First Missing Integer
public class Solution {
    public int firstMissingPositive(ArrayList<Integer> A) {
        int n = A.size();
        boolean[] found = new boolean[n];

        // Mark the presence of positive integers within the range [1, n]
        for (int num : A) {
            if (num > 0 && num <= n) {
                found[num - 1] = true;
            }
        }

        // Find the index of the first missing positive integer
        int missing = 0;
        while (missing < n && found[missing]) {
            missing++;
        }

        // The missing positive integer is missing + 1
        return missing + 1;
    }
}

//* 12. 3D - Merge Intervals
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<>();
        int i = 0;

        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            result.add(intervals.get(i));
            i++;
        }

        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            i++;
        }
        result.add(newInterval);

        while (i < intervals.size()) {
            result.add(intervals.get(i));
            i++;
        }

        return result;
    }
}
//* 13. 3D - Merge Sorted Overlapping Intervals

public class Solution {
    public Interval[] merge(Interval[] intervals) {

        if (intervals == null || intervals.length <= 1)
            return intervals;


        int n = intervals.length;
        int mergedCount = 0;

        for (int i = 1; i < n; i++) {
            if (intervals[i].start <= intervals[mergedCount].end) {
                intervals[mergedCount].end = Math.max(intervals[mergedCount].end, intervals[i].end);
            } else {
                mergedCount++;
                intervals[mergedCount] = intervals[i];
            }
        }

        return Arrays.copyOf(intervals, mergedCount + 1);
    }
}
//* 14. 3D - Next Permutation
public class Solution {
    public int[] nextPermutation(int[] A) {
        int n = A.length;
        if (n <= 1) return A;

        int k = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (A[i] < A[i + 1]) {
                k = i;
                break;
            }
        }

        if (k == -1) {
            reverse(A, 0, n - 1);
            return A;
        }

        int l = -1;
        for (int i = n - 1; i > k; i--) {
            if (A[i] > A[k]) {
                l = i;
                break;
            }
        }

        swap(A, k, l);

        reverse(A, k + 1, n - 1);

        return A;
    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    private static void reverse(int[] A, int start, int end) {
        while (start < end) {
            swap(A, start, end);
            start++;
            end--;
        }
    }
}

//* 15. 3D - Number of Digit one

public class Solution {
    public int solve(int A) {
        int count = 0;
        for (long i = 1; i <= A; i *= 10) {
            long divider = i * 10;
            count += (A / divider) * i + Math.min(Math.max(A % divider - i + 1, 0), i);
        }
        return count;
    }
}

