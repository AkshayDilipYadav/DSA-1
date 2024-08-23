/*
*1. Frequency of Element Query
* 2. Count Distinct Elements
* 3. First Repeating Element
* 4. Subarray with 0 sum
* 5. Count Unique Elements
* 6. Count Subarray Zero Sum
* 7. Common Elements
* 8. Check Pair Sum
* 9. Count Pair Difference
* 10. Subarray Sum Equals K
* 11. Distinct Numbers in Window
* 12. Count Pair Sum
* 13. Longest Subarray Zero Sum
* 14. Subarray with given Sum
* */

//Frequency of Element Query
public class Solution {
    public int[] solve(int[] A, int[] B) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int i =0; i < A.length; i++){
            int num = A[i];
            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
        }
        int[] frequencies = new int[B.length];
        for (int i =0; i < B.length; i++){
            int num = B[i];
            frequencies[i] = freqMap.getOrDefault(num, 0);
        }
        return frequencies;
    }
}

//* 2. Count Distinct Elements

public class Solution {
    public int solve(int[] A) {
        Set<Integer> uniqueElements = new HashSet<>();
        for(int num : A){uniqueElements.add(num);}
        return uniqueElements.size();
    }
}

//* 3. First Repeating Element

public class Solution {
    public int solve(int[] A) {
        HashMap<Integer, Integer> elementIndexMap = new HashMap<>();
        int minIndex = Integer.MAX_VALUE;
        int firstRepeatingElement = -1;

        for(int i = 0; i < A.length; i++){
            int num = A[i];
            if(elementIndexMap.containsKey(num)){
                if(elementIndexMap.get(num) < minIndex){
                    minIndex = elementIndexMap.get(num);
                    firstRepeatingElement = num;
                }
            }
            else{elementIndexMap.put(num, i);}


        }
        return firstRepeatingElement;

    }
}

//* 4. Subarray with 0 sum

public class Solution {
    // Do not write code to include libraries, main() function or accept any input from the console.
    // Initialization code is already written and hidden from you. Do not write code for it again.
    public int solve(int[] A) {
        HashSet<Long> seenSums = new HashSet<>();

        // Initialize cumulative sum and add the initial value of 0 to the set
        long cumulativeSum = 0;
        seenSums.add(cumulativeSum);

        // Traverse the array
        for (int num : A) {
            cumulativeSum += num;

            // Check if this cumulative sum has been seen before or if it's zero
            if (seenSums.contains(cumulativeSum)) {
                return 1; // A subarray with sum zero exists
            }

            // Add the current cumulative sum to the set
            seenSums.add(cumulativeSum);
        }

        return 0; // No subarray with sum zero found

    }
}

//* 5. Count Unique Elements

public class Solution {
    public int solve(int[] A) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Build the frequency map
        for (int num : A) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Count elements with frequency 1
        int count = 0;
        for (int freq : frequencyMap.values()) {
            if (freq == 1) {
                count++;
            }
        }

        return count;
    }
}

//* 6. Count Subarray Zero Sum

public class Solution {
    public int solve(int[] A) {
        Map<Long, Integer> prefixSumCount = new HashMap<>();
        int MOD = 1000000007;
        long currentSum = 0;
        int count = 0;

        // Initialize HashMap with prefix sum 0 having count 1
        prefixSumCount.put(0L, 1);

        // Traverse the array to find zero-sum subarrays
        for (int num : A) {
            currentSum += num;

            // If currentSum has been seen before, it indicates a zero-sum subarray
            if (prefixSumCount.containsKey(currentSum)) {
                count = (count + prefixSumCount.get(currentSum)) % MOD;
            }

            // Update the frequency of currentSum in the HashMap
            prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }
}

//* 7. Common Elements

public class Solution {
    // Do not write code to include libraries, main() function or accept any input from the console.
    // Initialization code is already written and hidden from you. Do not write code for it again.
    public int[] solve(int[] A, int[] B) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        // Build frequency map for array A
        for (int num : A) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Find common elements with correct frequency
        for (int num : B) {
            if (frequencyMap.containsKey(num) && frequencyMap.get(num) > 0) {
                result.add(num);
                frequencyMap.put(num, frequencyMap.get(num) - 1);
            }
        }

        // Convert ArrayList to int array
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }
}

//Check Pair Sum

public class Solution {
    public int solve(int A, int[] B) {
      /* Initialization-
        1.HashSet to store elements of array B, this helps in efficiently quick search
         */
        HashSet<Integer> arrayB = new HashSet<>();
        /* Process -
        1. for(int  num: B){
        if(arrayB HashSet contains the element as (A - num)){return 1;}
        add the B array element to HashSet arrayB
        }
         */
        for(int num : B){
            if(arrayB.contains(A-num)){return 1;}
            arrayB.add(num);
        }

// Result - return 1 or return 0
        return 0;
    }
}

//* 9. Count Pair Difference

public class Solution {
    public int solve(int[] A, int B) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        int mod = 1000000007;

        for (int num : A) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int count = 0;

        for (int num : A) {
            if (frequencyMap.containsKey(num - B)) {
                count = (count + frequencyMap.get(num - B)) % mod;
            }
        }

        return count;
    }
}

//* 10. Subarray Sum Equals K

public class Solution {
    public int solve(int[] A, int B) {
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        int prefixSum = 0;
        int count = 0;

        prefixSumCount.put(0, 1);

        for (int num : A) {
            prefixSum += num;

            if (prefixSumCount.containsKey(prefixSum - B)) {
                count += prefixSumCount.get(prefixSum - B);
            }

            prefixSumCount.put(prefixSum, prefixSumCount.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}

//* 11. Distinct Numbers in Window

public class Solution {
    public int[] dNums(int[] A, int B) {
        int n = A.length;
        if (B > n) {
            return new int[0];
        }

        int[] result = new int[n - B + 1];
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int distinctCount = 0;

        for (int i = 0; i < B; i++) {
            countMap.put(A[i], countMap.getOrDefault(A[i], 0) + 1);
            if (countMap.get(A[i]) == 1) {
                distinctCount++;
            }
        }
        result[0] = distinctCount;

        for (int i = B; i < n; i++) {
            int outgoing = A[i - B];
            if (countMap.get(outgoing) == 1) {
                countMap.remove(outgoing);
                distinctCount--;
            } else {
                countMap.put(outgoing, countMap.get(outgoing) - 1);
            }

            int incoming = A[i];
            countMap.put(incoming, countMap.getOrDefault(incoming, 0) + 1);
            if (countMap.get(incoming) == 1) {
                distinctCount++;
            }

            result[i - B + 1] = distinctCount;
        }

        return result;
    }
}

//* 12. Count Pair Sum

public class Solution {
    private static final int MOD = 1000000007;

    public int solve(int[] A, int B) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        long pairCount = 0;

        for (int num : A) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        for (int num : A) {
            int complement = B - num;

            frequencyMap.put(num, frequencyMap.get(num) - 1);

            if (frequencyMap.containsKey(complement)) {
                pairCount = (pairCount + frequencyMap.get(complement)) % MOD;
            }
        }

        return (int) pairCount;
    }
}



//* 13. Longest Subarray Zero Sum


public class Solution {
    public int solve(int[] A) {
        HashMap<Long, Integer> prefixSumMap = new HashMap<>();
        long prefixSum = 0;
        int maxLength = 0;

        prefixSumMap.put(0L, -1);

        for (int i = 0; i < A.length; i++) {
            prefixSum += A[i];

            if (prefixSumMap.containsKey(prefixSum)) {
                int length = i - prefixSumMap.get(prefixSum);
                maxLength = Math.max(maxLength, length);
            } else {
                prefixSumMap.put(prefixSum, i);
            }
        }

        return maxLength;
    }
}



//* 14. Subarray with given Sum


public class Solution {
    public int[] solve(int[] A, int B) {
        HashMap<Long, Integer> prefixSumMap = new HashMap<>();
        long prefixSum = 0;

        // Initialize with prefix sum 0 at index -1 to handle subarrays starting from index 0
        prefixSumMap.put(0L, -1);

        for (int i = 0; i < A.length; i++) {
            prefixSum += A[i];

            // Check if the (prefixSum - B) exists in the map
            if (prefixSumMap.containsKey(prefixSum - B)) {
                // Calculate the start index of the subarray
                int start = prefixSumMap.get(prefixSum - B) + 1;
                // Calculate the end index of the subarray
                int end = i;

                // Construct the result array
                int[] result = new int[end - start + 1];
                for (int j = start; j <= end; j++) {
                    result[j - start] = A[j];
                }
                return result;
            }

            // Add the current prefix sum to the map if it doesn't already exist
            prefixSumMap.putIfAbsent(prefixSum, i);
        }

        // If no subarray is found, return -1
        return new int[]{-1};
    }
}
