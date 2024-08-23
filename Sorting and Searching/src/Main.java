
/*
*1. Sorting - Elements Removal
* 2. Sorting - Noble Integer
* 3. Sorting - Kth Smallest Element
* 4.Sorting - Arithmetic Progression
* 5. Sorting - Merge Two Sorted Arrays
* 6. Sorting - Inversion COunnt in An Array
* 7. Sorting - Count Sort
* 8. Sorting - Merge Sort
* 9. Sorting - Smallest Number
* 10. Sorting - Sort subarray with left and right index
* 11. Sorting - Minimum Absolut Difference
* 12.Sorting - Max Chunks to make Sorted
* 13. Sorting - Factors Sort
* 14. Sorting - B Closest Points to Origin
* 15. Sorting - Sort 01
* 16. Sorting - Partition Index
* 17. Sorting - Quick Sort
* 18. Sorting - Wave Array
* 19. Sorting - Tens Digit Sorting
* 20. Sorting - Sort By Color
* 21. Sorting -Largest Number
* 22. Binary Searching - Sorted Insert Position
* 23. Binary Searching - Search for a Range
* 24. Binary Searching - Find a peak Element
* 25. Binary Searching - Single Element in Sorted Array
* 26. Binary Searching - Matrix Search
* 27. Binary Searching - Minimum Difference
* 28. Binary Searching - Maximum Height of Staircase
* 29. Binary Searching - Rotated sorted Array Search
* 30. Binary Searching - Ath Magical Number
* 31. Binary Searching - Square root of Integer
* 32. Binary Searching - Add or Not
* 33. Binary Searching - Find Smallest Again
* 34. Binary Searching - Matrix Median
* 35- Binary Searching - Painter's Partition Problem
* 36 - Binary Searching - Aggressive Cows
* 37- Binary Searching - Allocate Books
* 38 - Binary Searching - Special Integer
* 39 - Two Pointer - Pairs with given sum 2
* 40 - Two Pointer - Pairs with given difference
* 42 - Two Pointer - Subarray with given sum
* 43 - Two Pointer - container with most water
* 44- Two Pointer - 3 Sum
* 45 - Two Pointer - Another count rectangles
* 46- Two Pointer - Closest pair from sorted arrays
* 47 - Two Pointer - Max continuous series of 1's
* 48 - Two Pointer - Array 3 Pointers
* */

// Sorting - Elements Removal
public class Solution {
    public int solve(int[] A) {
        int n = A.length;

        Arrays.sort(A);

        int totalCost = 0;

        for (int i = 0; i < n; i++) {
            totalCost += A[i]*(n-i);
        }

        return totalCost;
    }
}
//* 2. Sorting - Noble Integer
public class Solution {
    public int solve(int[] A) {
        int n = A.length;
        Arrays.sort(A);
        for(int i = 0; i< A.length; i++){
            if(A[i] == n - i -1){
                if(i == n-1 || A[i] != A[i+1]){return 1;}
            }
        }
        return -1;
    }
}

//* 3. Sorting - Kth Smallest Element
public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int kthsmallest(final int[] A, int B) {
        Arrays.sort(A);
        return A[B-1];
    }
}

//* 4.Sorting - Arithmetic Progression
public class Solution {
    public int solve(int[] A) {
        int n = A.length;

        Arrays.sort(A);

        int commonDiff = A[1] - A[0];

        for (int i = 2; i < n; i++) {
            if (A[i] - A[i - 1] != commonDiff) {
                return 0;
            }
        }

        return 1;
    }
}
//* 5. Sorting - Merge Two Sorted Arrays
public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] solve(final int[] A, final int[] B) {
        int n1 = A.length;
        int n2 = B.length;
        int[] result = new int[n1 + n2];

        int i = 0, j = 0, k = 0;

        while (i < n1 && j < n2) {
            if (A[i] <= B[j]) {
                result[k++] = A[i++];
            } else {
                result[k++] = B[j++];
            }
        }

        while (i < n1) {
            result[k++] = A[i++];
        }

        while (j < n2) {
            result[k++] = B[j++];
        }

        return result;
    }
}

//* 6. Sorting - Inversion COunnt in An Array
public class Solution {
    private static final int MOD = 1000000007;
    public int solve(int[] A) {
        if (A == null || A.length < 2) {
            return 0;
        }
        int[] aux = new int[A.length];
        return mergeSortAndCount(A, aux, 0, A.length - 1);
    }

    private static int mergeSortAndCount(int[] array, int[] aux, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int middle = (left + right) / 2;
        int leftCount = mergeSortAndCount(array, aux, left, middle);
        int rightCount = mergeSortAndCount(array, aux, middle + 1, right);
        int mergeCount = mergeAndCount(array, aux, left, middle, right);

        return (leftCount + rightCount + mergeCount) % MOD;
    }

    private static int mergeAndCount(int[] array, int[] aux, int left, int middle, int right) {
        for (int i = left; i <= right; i++) {
            aux[i] = array[i];
        }

        int i = left, j = middle + 1, k = left;
        int count = 0;

        while (i <= middle && j <= right) {
            if (aux[i] <= aux[j]) {
                array[k++] = aux[i++];
            } else {
                array[k++] = aux[j++];
                count = (count + (middle - i + 1)) % MOD;
            }
        }

        while (i <= middle) {
            array[k++] = aux[i++];
        }

        while (j <= right) {
            array[k++] = aux[j++];
        }

        return count;
    }
}

//* 7. Sorting - Count Sort
public class Solution {
    public int[] solve(int[] A) {
        if (A == null || A.length == 0) {
            return new int[0];
        }

        int max = 0;
        for (int num : A) {
            if (num > max) {
                max = num;
            }
        }

        int[] count = new int[max + 1];
        for (int num : A) {
            count[num]++;
        }

        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        int[] sortedArray = new int[A.length];
        for (int i = A.length - 1; i >= 0; i--) {
            sortedArray[count[A[i]] - 1] = A[i];
            count[A[i]]--;
        }

        return sortedArray;
    }
}



//* 8. Sorting - Merge Sort
public class Solution {
    public int[] solve(int[] A) {
        if (A == null || A.length < 2) {
            return A;
        }
        int[] aux = new int[A.length];
        mergeSort(A, aux, 0, A.length - 1);
        return A;
    }

    private static void mergeSort(int[] array, int[] aux, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            mergeSort(array, aux, left, middle);
            mergeSort(array, aux, middle + 1, right);

            merge(array, aux, left, middle, right);
        }
    }

    private static void merge(int[] array, int[] aux, int left, int middle, int right) {
        for (int i = left; i <= right; i++) {
            aux[i] = array[i];
        }

        int i = left, j = middle + 1, k = left;

        while (i <= middle && j <= right) {
            if (aux[i] <= aux[j]) {
                array[k] = aux[i];
                i++;
            } else {
                array[k] = aux[j];
                j++;
            }
            k++;
        }

        while (i <= middle) {
            array[k] = aux[i];
            i++;
            k++;
        }

    }
}

//* 9. Sorting - Smallest Number
public class Solution {
    public int[] smallestNumber(int[] A) {
        int[] count = new int[10];

        // Count the occurrences of each digit
        for (int num : A) {
            count[num]++;
        }

        // Create the result array
        int index = 0;
        int[] result = new int[A.length];

        // Build the result array by using counts
        for (int digit = 0; digit < 10; digit++) {
            while (count[digit] > 0) {
                result[index++] = digit;
                count[digit]--;
            }
        }

        return result;
    }
}

//* 10. Sorting - Sort subarray with left and right index
public class Solution {

    public int[] sortSubarray(int[] A, int B, int C) {
        // Extract the subarray
        int[] subarray = Arrays.copyOfRange(A, B, C + 1);

        // Sort the subarray using merge sort
        mergeSort(subarray, 0, subarray.length - 1);

        // Place the sorted subarray back into the original array
        for (int i = B; i <= C; i++) {
            A[i] = subarray[i - B];
        }

        return A;
    }

    // Merge Sort Algorithm
    public  void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // Recursively sort the two halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    // Merge function for merge sort
    public  void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temporary arrays
        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);

        // Merge the temporary arrays back into the original array
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        // Copy the remaining elements of L[], if any
        while (i < n1) {
            arr[k++] = L[i++];
        }

        // Copy the remaining elements of R[], if any
        while (j < n2) {
            arr[k++] = R[j++];
        }
    }
}
//* 11. Sorting - Minimum Absolut Difference
public class Solution {
    public int solve(int[] A) {
                /* Process -
        1. Sort the array
        2. initialise the minimum difference with the Max Value
        3. iterating the array A find the minimum difference
        4. return the minDifference
         */
        Arrays.sort(A);
        int minDiff = Integer.MAX_VALUE;
        for(int i = 1; i < A.length; i++){
            int diff = A[i] - A[i - 1];
            if(diff < minDiff){minDiff = diff;}
        }
        return minDiff;
    }
}

//* 12.Sorting - Max Chunks to make Sorted

public class Solution {
    public int solve(int[] A) {
        int maxChunks = 0;
        int maxSoFar = 0;

        for (int i = 0; i < A.length; i++) {
            maxSoFar = Math.max(maxSoFar, A[i]);
            if (maxSoFar == i) {
                maxChunks++;
            }
        }

        return maxChunks;
    }
}

//Sorting - Factors Sort
public class Solution {
    public int[] solve(int[] A) {
        int[] factorCount = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            factorCount[i] = countFactors(A[i]);
        }

        Integer[] indices = new Integer[A.length];
        for (int i = 0; i < A.length; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (i, j) -> {
            if (factorCount[i] != factorCount[j]) {
                return factorCount[i] - factorCount[j];
            } else {
                return A[i] - A[j];
            }
        });

        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            result[i] = A[indices[i]];
        }

        return result;
    }

    private int countFactors(int n) {
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (i * i == n) {
                    count++;
                } else {
                    count += 2;
                }
            }
        }
        return count;
    }
}

//* 14. Sorting - B Closest Points to Origin
public class Solution {
    public int[][] solve(int[][] A, int B) {
        quickselect(A, 0, A.length - 1, B);

        // Extract the first B points
        int[][] result = new int[B][2];
        for (int i = 0; i < B; i++) {
            result[i] = A[i];
        }

        return result;
    }

    private void quickselect(int[][] A, int left, int right, int B) {
        if (left < right) {
            int pivotIndex = partition(A, left, right);
            if (pivotIndex == B - 1) {
                return;  // We've found the B closest points
            } else if (pivotIndex < B - 1) {
                quickselect(A, pivotIndex + 1, right, B);
            } else {
                quickselect(A, left, pivotIndex - 1, B);
            }
        }
    }

    private int partition(int[][] A, int left, int right) {
        int[] pivot = A[right];
        int pivotDist = distanceSquared(pivot);
        int i = left;

        for (int j = left; j < right; j++) {
            if (distanceSquared(A[j]) <= pivotDist) {
                swap(A, i, j);
                i++;
            }
        }
        swap(A, i, right);
        return i;
    }

    private int distanceSquared(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    private void swap(int[][] A, int i, int j) {
        int[] temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}

//* 15. Sorting - Sort 01
public class Solution {
    public int[] sort01(int[] A) {
        int n = A.length;

        int count0 = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] == 0) {
                count0++;
            }
        }

        for (int i = 0; i < count0; i++) {
            A[i] = 0;
        }
        for (int i = count0; i < n; i++) {
            A[i] = 1;
        }

        return A;
    }
}

//* 16. Sorting - Partition Index

public int partition(int[] A) {
    int pivot = A[A.length - 1];
    int i = -1;
    for (int j = 0; j < A.length - 1; j++) {
        if (A[j] < pivot) {
            i++;
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
    }
    int temp = A[i + 1];
    A[i + 1] = A[A.length - 1];
    A[A.length - 1] = temp;

    return i + 1;
}

//* 17. Sorting - Quick Sort

public class Solution {
    public int[] solve(int[] A) {
        if (A == null || A.length == 0) {
            return A;
        }
        quickSort(A, 0, A.length - 1);
        return A;
    }

    private void quickSort(int[] A, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(A, low, high);
            quickSort(A, low, partitionIndex - 1);
            quickSort(A, partitionIndex + 1, high);
        }
    }

    private int partition(int[] A, int low, int high) {
        int pivot = A[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (A[j] < pivot) {
                i++;
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        int temp = A[i + 1];
        A[i + 1] = A[high];
        A[high] = temp;

        return i + 1;
    }

}

//* 18. Sorting - Wave Array
public class Solution {
    public int[] wave(int[] A) {
        Arrays.sort(A);

        for (int i = 0; i < A.length - 1; i += 2) {
            int temp = A[i];
            A[i] = A[i + 1];
            A[i + 1] = temp;
        }

        return A;
    }
}

//* 19. Sorting - Tens Digit Sorting
public class Solution {
    public int[] solve(int[] A) {
        Integer[] arr = new Integer[A.length];
        for (int i = 0; i < A.length; i++) {
            arr[i] = A[i];
        }

        Arrays.sort(arr, (a, b) -> {
            int tensA = (a / 10) % 10;
            int tensB = (b / 10) % 10;

            if (tensA != tensB) {
                return Integer.compare(tensA, tensB);
            } else {
                return Integer.compare(b, a);
            }
        });

        for (int i = 0; i < A.length; i++) {
            A[i] = arr[i];
        }

        return A;
    }
}

//* 20. Sorting - Sort By Color
public class Solution {
    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public int[] sortColors(int[] A) {
        int l = 0, m = 0, h = A.length - 1;

        while (m <= h) {
            if (A[m] == 0) {
                swap(A, l, m);
                l++;
                m++;
            } else if (A[m] == 1) {
                m++;
            } else {
                swap(A, m, h);
                h--;
            }
        }

        return A;
    }
}


//* 21. Sorting -Largest Number

public class Solution {
    public String largestNumber(int[] A) {
        String[] nums = Arrays.stream(A)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        Arrays.sort(nums, new Comparator<String>() {
            public int compare(String x, String y) {
                return (y + x).compareTo(x + y);
            }
        });

        if (nums[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String num : nums) {
            sb.append(num);
        }

        return sb.toString();
    }
}


//Binary Searching - Sorted Insert Position
public class Solution {
    public int searchInsert(int[] A, int B) {
        int left = 0;
        int right = A.length -1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(A[mid] == B){return mid;}
            else if(A[mid] < B){left = mid + 1;}
            else{right = mid -1;}
        }
        return left;
    }
}

//* 23. Binary Searching - Search for a Range

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] searchRange(final int[] A, int B) {
        int left = findIndex(A, B, true);
        int right = findIndex(A, B, false);
        return new int[]{left, right};
// Result -

    }
    public static int findIndex(int[] A, int B, boolean isLeft){

        int low = 0, high = A.length - 1;
        int bound = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(A[mid] == B){
                bound = mid;
                if(isLeft){high = mid -1;}
                else{low = mid + 1;}
            }
            else if(A[mid] < B){low = mid + 1;}
            else{high = mid - 1;}
        }
        return bound;
    }
}

//* 24. Binary Searching - Find a peak Element

public class Solution {
    public int solve(int[] A) {
        int left = 0;
        int right = A.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(A[mid] < A[mid + 1]){left = mid + 1;}
            else{right = mid;}
        }
        return A[left];
    }
}

//* 25. Binary Searching - Single Element in Sorted Array

public class Solution {
    public int solve(int[] A) {
        int left = 0;
        int right = A.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (mid % 2 == 1) {
                mid--;
            }

            if (A[mid] == A[mid + 1]) {
                left = mid + 2;
            } else {
                right = mid;
            }
        }
        return A[left];
    }
}

//* 26. Binary Searching - Matrix Search
public class Solution {
    public int searchMatrix(int[][] A, int B) {
        int N = A.length;
        int M = A[0].length;

        int low = 0, high = N * M - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midElement = A[mid / M][mid % M];

            if (midElement == B) {
                return 1;
            } else if (midElement < B) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return 0;
    }
}

//* 27. Binary Searching - Minimum Difference
public class Solution {
    public int solve(int A, int B, int[][] C) {
        // Sort each row of the matrix
        for (int i = 0; i < A; i++) {
            Arrays.sort(C[i]);
        }

        int minCost = Integer.MAX_VALUE;

        // Iterate over rows starting from the second row
        for (int i = 1; i < A; i++) {
            int localMinCost = Integer.MAX_VALUE;

            // Check all pairs between the current row and the previous row
            for (int j = 0; j < B; j++) {
                for (int k = 0; k < B; k++) {
                    int diff = Math.abs(C[i][j] - C[i - 1][k]);
                    localMinCost = Math.min(localMinCost, diff);
                }
            }

            // Update the global minimum cost
            minCost = Math.min(minCost, localMinCost);
        }

        return minCost;
    }
}

//* 28. Binary Searching - Maximum Height of Staircase

public class Solution {
    public int solve(int A) {
        if (A == 0) return 0;

        int low = 1, high = (int) Math.sqrt(2 * (long) A);
        int result = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long blocksUsed = (long) mid * (mid + 1) / 2;

            if (blocksUsed <= A) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }
}

// Binary Searching - Rotated sorted Array Search

public class Solution {
    public int search(final int[] A, int B) {
        int left = 0;
        int right = A.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (A[mid] == B) {
                return mid;
            }

            if (A[left] <= A[mid]) {
                if (A[left] <= B && B < A[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (A[mid] < B && B <= A[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}

//* 30. Binary Searching - Ath Magical Number

public class Solution {
    private static final int MOD = 1000000007;

    public int solve(int A, int B, int C) {
        long left = 1, right = (long) A * Math.max(B, C);

        while (left < right) {
            long mid = left + (right - left) / 2;
            if (count(mid, B, C) < A) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return (int)(left % MOD);
    }

    private long count(long x, int B, int C) {
        return (x / B) + (x / C) - (x / lcm(B, C));
    }

    private long lcm(int a, int b) {
        return (long) a * b / gcd(a, b);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

//* 31. Binary Searching - Square root of Integer

public class Solution {
    public int sqrt(int A) {
        if (A == 0 || A == 1) {
            return A;
        }

        int left = 1;
        int right = A;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long midSquared = (long) mid * mid;

            if (midSquared == A) {
                return mid;
            } else if (midSquared < A) {
                left = mid + 1;
                result = mid;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}

//* 32. Binary Searching - Add or Not


public class Solution {
    public int[] solve(int[] A, int B) {
        int n = A.length;
        int[] sortedA = Arrays.copyOf(A, n);
        Arrays.sort(sortedA);

        int maxOccurrences = 0;
        int resultValue = Integer.MAX_VALUE;

        int l = 0;
        long currentOperations = 0;

        for (int r = 0; r < n; r++) {
            // Add operations needed to make all elements between l and r equal to sortedA[r]
            if (r > 0) {
                currentOperations += (long) (sortedA[r] - sortedA[r - 1]) * (r - l);
            }

            // Adjust left pointer while operations exceed B
            while (currentOperations > B) {
                currentOperations -= (sortedA[r] - sortedA[l]);
                l++;
            }

            // Calculate current frequency of sortedA[r]
            int currentFrequency = r - l + 1;

            if (currentFrequency > maxOccurrences) {
                maxOccurrences = currentFrequency;
                resultValue = sortedA[r];
            } else if (currentFrequency == maxOccurrences) {
                resultValue = Math.min(resultValue, sortedA[r]);
            }
        }

        return new int[] { maxOccurrences, resultValue };
    }
}

//* 33. Binary Searching - Find Smallest Again

public class Solution {
    public int solve(int[] A, int B) {
        int n = A.length;

        // Sorting the array to facilitate triplet sum calculations
        Arrays.sort(A);

        // Determine the possible range of triplet sums
        int low = A[0] + A[1] + A[2];
        int high = A[n - 1] + A[n - 2] + A[n - 3];

        // Binary search to find the B-th smallest sum
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (countTripletsLessThanOrEqual(A, mid) < B) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    // Function to count the number of triplets with sum <= x
    private int countTripletsLessThanOrEqual(int[] A, int x) {
        int n = A.length;
        int count = 0;

        // Count triplets using a two-pointer approach
        for (int i = 0; i < n - 2; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = A[i] + A[j] + A[k];
                if (sum <= x) {
                    count += (k - j);
                    j++;
                } else {
                    k--;
                }
            }
        }

        return count;
    }
}

//* 34. Binary Searching - Matrix Median

public class Solution {
    public int findMedian(int[][] A) {
        int N = A.length;
        int M = A[0].length;
        int totalElements = N * M;
        int medianIndex = totalElements / 2;

        // Determine the min and max value in the matrix
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            minVal = Math.min(minVal, A[i][0]);
            maxVal = Math.max(maxVal, A[i][M - 1]);
        }

        // Perform binary search to find the median
        while (minVal < maxVal) {
            int mid = minVal + (maxVal - minVal) / 2;
            if (countLessEqual(A, mid) <= medianIndex) {
                minVal = mid + 1;
            } else {
                maxVal = mid;
            }
        }

        return minVal;
    }

    // Count elements less than or equal to x
    private int countLessEqual(int[][] A, int x) {
        int count = 0;
        for (int[] row : A) {
            count += countInRow(row, x);
        }
        return count;
    }

    // Count elements <= x in a sorted row
    private int countInRow(int[] row, int x) {
        int low = 0, high = row.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (row[mid] <= x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;  // Low is the count of elements <= x
    }
}


// Binary Searching - Painter's Partition Problem



public class Solution {
    private static final int MOD = 10000003;

    public int paint(int A, int B, int[] C) {
        int N = C.length;

        // Edge case: If there are more painters than boards, reduce painters to the number of boards
        if (A > N) {
            A = N;
        }

        // Binary Search initialization
        int low = findMax(C); // max element in C
        int high = findSum(C); // sum of all elements in C

        int result = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canPaint(C, A, B, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        // Calculate result using modular arithmetic
        return (int)((result * (long)B) % MOD);
    }

    // Helper function to check if a given time is feasible
    private boolean canPaint(int[] C, int A, int B, int maxTime) {
        int painterCount = 1;
        int currentSum = 0;

        for (int length : C) {
            if (currentSum + length > maxTime) {
                painterCount++;
                currentSum = length;
                if (painterCount > A) {
                    return false;
                }
            } else {
                currentSum += length;
            }
        }
        return true;
    }

    // Helper function to find maximum element in the array
    private int findMax(int[] C) {
        int max = C[0];
        for (int i = 1; i < C.length; i++) {
            if (C[i] > max) {
                max = C[i];
            }
        }
        return max;
    }

    // Helper function to find sum of all elements in the array
    private int findSum(int[] C) {
        int sum = 0;
        for (int length : C) {
            sum += length;
        }
        return sum;
    }
}

//* 36 - Binary Searching - Aggressive Cows

public class Solution {
    public int solve(int[] A, int B) {
        Arrays.sort(A);
        int low = 1;
        int high = A[A.length - 1] - A[0];
        int result = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canPlaceCows(A, B, mid)) {
                result = mid;
                low = mid + 1; // Try for a larger minimum distance
            } else {
                high = mid - 1; // Try for a smaller minimum distance
            }
        }

        return result;
    }

    private boolean canPlaceCows(int[] A, int B, int minDist) {
        int cowsPlaced = 1;
        int lastPos = A[0];

        for (int i = 1; i < A.length; i++) {
            if (A[i] - lastPos >= minDist) {
                cowsPlaced++;
                lastPos = A[i];
                if (cowsPlaced == B) {
                    return true;
                }
            }
        }

        return false;
    }
}

//* 37- Binary Searching - Allocate Books

public class Solution {
    public int books(int[] A, int B) {
        int n = A.length;

        // If students are more than books, it's impossible to allocate.
        if (B > n) return -1;

        int low = getMax(A);
        int high = getSum(A);
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(A, B, mid)) {
                result = mid;
                high = mid - 1; // Try for a smaller max
            } else {
                low = mid + 1; // Increase the allowed maximum pages
            }
        }

        return result;
    }

    private int getMax(int[] A) {
        int max = Integer.MIN_VALUE;
        for (int num : A) {
            max = Math.max(max, num);
        }
        return max;
    }

    private int getSum(int[] A) {
        int sum = 0;
        for (int num : A) {
            sum += num;
        }
        return sum;
    }

    private boolean isPossible(int[] A, int B, int maxPages) {
        int studentsRequired = 1;
        int currentSum = 0;

        for (int pages : A) {
            if (currentSum + pages > maxPages) {
                studentsRequired++;
                currentSum = pages;
                if (studentsRequired > B) {
                    return false;
                }
            } else {
                currentSum += pages;
            }
        }

        return true;
    }
}


//* 38 - Binary Searching - Special Integer

public class Solution {
    public int solve(int[] A, int B) {
        int n = A.length;
        int low = 1, high = n;
        int answer = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isValid(A, B, mid)) {
                answer = mid;
                low = mid + 1; // Try for a larger K
            } else {
                high = mid - 1; // Try for a smaller K
            }
        }

        return answer;
    }

    private boolean isValid(int[] A, int B, int K) {
        long sum = 0;
        // Calculate the sum of the first K elements
        for (int i = 0; i < K; i++) {
            sum += A[i];
        }

        // If the sum of the first K elements is greater than B, return false
        if (sum > B) return false;

        // Use sliding window to check other subarrays of length K
        for (int i = K; i < A.length; i++) {
            sum += A[i] - A[i - K];
            if (sum > B) return false;
        }

        return true;
    }
}


//Two Pointer - Pairs with given sum 2

public class Solution {
    public int solve(int[] A, int B) {
        int MOD = 1000000007;
        int left = 0, right = A.length - 1;
        long count = 0;

        while (left < right) {
            int sum = A[left] + A[right];

            if (sum == B) {
                if (A[left] == A[right]) {
                    // If both elements are the same, the number of pairs is (nC2) where n = right - left + 1
                    int num = right - left + 1;
                    count += (long)num * (num - 1) / 2;
                    count %= MOD;
                    break;  // As all pairs are counted, we can exit the loop
                } else {
                    // If elements are different, count the occurrences of A[left] and A[right]
                    int leftCount = 1, rightCount = 1;

                    while (left + 1 < right && A[left] == A[left + 1]) {
                        left++;
                        leftCount++;
                    }

                    while (right - 1 > left && A[right] == A[right - 1]) {
                        right--;
                        rightCount++;
                    }

                    count += (long)leftCount * rightCount;
                    count %= MOD;

                    left++;
                    right--;
                }
            } else if (sum < B) {
                left++;
            } else {
                right--;
            }
        }

        return (int)count;
    }
}

//* 40 - Two Pointer - Pairs with given difference
public class Solution {
    public int solve(int[] A, int B) {
        Arrays.sort(A);
        int left = 0, right = 1;
        int count = 0;
      /*
      *   while(){
            if(){}
            else{
                if(){
                    while(){}
                    while(){}
                }else if(){}
                else{}
            }
        }*/
        while(right < A.length){
            if(left == right){right++;}
            else{
                int diff = A[right] - A[left];
                if(diff == B){
                    count++;
                    while(right < A.length && A[right] == A[right - 1]){right++;}
                    while(left < A.length-1 && A[left] == A[left+1]){left++;}
                    right++;
                    left++;
                }
                else if(diff < B){right++;}
                else{left++;}
            }
        }
        return count;
    }
}

//* 42 - Two Pointer - Subarray with given sum

public class Solution {
    public int[] solve(int[] A, int B) {
        int start = 0;
        int currentSum = 0;

        for(int end = 0; end < A.length; end++) {
            currentSum += A[end];

            // Shrink the window as long as the current sum is greater than B
            while(currentSum > B && start <= end) {
                currentSum -= A[start];
                start++;
            }

            // If currentSum matches B, return the subarray
            if(currentSum == B) {
                return Arrays.copyOfRange(A, start, end + 1);
            }
        }

        // If no subarray is found, return [-1]
        return new int[]{-1};
    }
}

//* 43 - Two Pointer - container with most water

public class Solution {
    public int maxArea(int[] A) {
        int left = 0;
        int right = A.length -1;
        int maxArea = 0;
        /*
        * while(){
            if(){}
            else{}
        }*/
        while(left < right){
            int height = Math.min(A[left], A[right]);
            int width = right - left;
            int area = height * width;
            maxArea = Math.max(maxArea, area);
            if(A[left] < A[right]){left++;}
            else{right--;}
        }
        return maxArea;
    }
}


//* 44- Two Pointer - 3 Sum

public class Solution {
    public int threeSumClosest(int[] A, int B) {
        Arrays.sort(A);
        int closestSum = A[0] + A[1] + A[2];
        for(int i = 0; i < A.length - 2; i++){
            int left = i + 1;
            int right = A.length - 1;
            /* while(){
                if(){}
                if(){}
                else if(){}
                else{}
            }*/
            while(left < right){
                int currentSum = A[i] + A[left] + A[right];
                if(Math.abs(B - currentSum) < Math.abs(B - closestSum)){
                    closestSum = currentSum;
                }
                if(currentSum < B){left++;}
                else if(currentSum > B){right--;}
                else{return currentSum;}
            }
        }
        return closestSum;
    }
}

//* 45 - Two Pointer - Another count rectangles

public class Solution {
    public int solve(int[] A, int B) {
        final int MOD = 1000000007;
        int n = A.length;
        int i = 0;
        int j = n -1;
        long count = 0;
        /*while(i <= j){
            if(){}
            else{}
        }*/
        while(i <= j){
            if((long) A[i] * A[j] < B){
                count = (count + (j - i + 1)* 2 -1)% MOD;
                i++;
            }
            else{j--;}
        }
        return (int) count;
    }
}

//* 46- Two Pointer - Closest pair from sorted arrays

public class Solution {
    public int[] solve(int[] A, int[] B, int C) {
        int n = A.length;
        int m = B.length;
        int i = 0;
        int j = m - 1;
        int[] result = new int[2];
        int minDiff = Integer.MAX_VALUE;
        /*  while(){
            if(){}
            else if(){
                if(){}
            }
            if(){}
            else{}
        }*/
        while(i < n && j >= 0){
            int sum = A[i] + B[j];
            int currentDiff = Math.abs(sum - C);
            if(currentDiff < minDiff){
                minDiff = currentDiff;
                result[0] = A[i];
                result[1] = B[j];
            }
            else if(currentDiff == minDiff){
                if(A[i] < result[0] || (A[i] == result[0] && B[j] < result[1])){
                    result[0] = A[i];
                    result[1] = B[j];
                }
            }
            if(sum < C){i++;}
            else{j--;}
        }
        return result;
    }
}

//* 47 - Two Pointer - Max continuous series of 1's

public class Solution {
    public int[] maxone(int[] A, int B) {

        int n = A.length;
        int start = 0, end = 0;
        int zeroCount = 0;
        int maxLen = 0;
        int bestStart = 0;
        /*while(end < n){
            if(){}
            while(){
                if(){}
            }
            if(){}
        }*/
        while(end < n){
            if(A[end] == 0){zeroCount++;}
            while(zeroCount > B){
                if(A[start] == 0){zeroCount--;}
                start++;
            }
            if(end - start + 1 > maxLen){
                maxLen = end - start +1;
                bestStart = start;
            }
            end++;
        }
        int[] result = new int[maxLen];
        for(int i = 0; i < maxLen; i++){
            result[i] = bestStart + i;
        }
        return result;

    }
}

//* 48 - Two Pointer - Array 3 Pointers


public class Solution {

    public int minimize(final int[] A, final int[] B, final int[] C) {
        int i = 0, j = 0, k = 0;
        int minDiff = Integer.MAX_VALUE;
        while(i < A.length && j < B.length && k < C.length){
            int maxVal =Math.max( Math.max(A[i], B[j]), C[k]);
            int minVal = Math.min(Math.min(A[i], B[j]), C[k]);
            minDiff = Math.min(minDiff, maxVal - minVal);
            if(minVal == A[i]){i++;}
            else if(minVal == B[j]){j++;}
            else{k++;}
        }
        return minDiff;
    }

}
