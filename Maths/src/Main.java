/*
* 1. Pair Sum Divisible by M
* 2. Greatest Common Divisor
* 3. A, B, and Modulo
* 4. Mod Sum
* 5. Largest Coprime Divisor
* 6. Divisor Game
* 7. Excel Column Title
* 8. Pascal Triangle
* 9. Excel Column Number
* 10. Find All Primes
* 11. Number of Open Doors
* 12. Prime Sum
* */

//1. Pair Sum Divisible by M
public class Solution {
    public static final int MOD = 1000000007;

    public int solve(int[] A, int B) {
        int n = A.length;
        int[] remainderFrequency = new int[B];

        for (int num : A) {
            int remainder = num % B;
            remainderFrequency[remainder]++;
        }

        long count = 0;

        count += (long) remainderFrequency[0] * (remainderFrequency[0] - 1) / 2;

        for (int i = 1; i <= B / 2 && i < B - i; i++) {
            count += (long) remainderFrequency[i] * remainderFrequency[B - i];
        }

        if (B % 2 == 0) {
            count += (long) remainderFrequency[B / 2] * (remainderFrequency[B / 2] - 1) / 2;
        }

        return (int) (count % MOD);
    }
}

//* 2. Greatest Common Divisor
public class Solution {
    public int gcd(int A, int B) {
        while(B != 0){
            int temp = B;
            B = A % B;
            A = temp;
        }
        return A;
    }

}

//* 3. A, B, and Modulo

public class Solution {
    public int solve(int A, int B) {
        int D = A - B;
        if (D < 0) {
            D = -D;
        }
        return D;
    }
}

//* 4. Mod Sum

public class Solution {
    private static final int MOD = 1000000007;

    public int solve(int[] A) {
        int maxValue = 1001; // Since A[i] <= 1000
        int[] freq = new int[maxValue];

        // Step 1: Populate the frequency array
        for (int num : A) {
            freq[num]++;
        }

        // Step 2: Calculate sum of all A[i] % A[j]
        long result = 0;

        // Iterate over all possible values for A[j]
        for (int j = 1; j < maxValue; j++) {
            if (freq[j] == 0) continue;

            // Calculate sum of remainders when A[i] % j for all A[i]
            long sumOfRemainders = 0;
            for (int k = 1; k < maxValue; k++) {
                if (freq[k] > 0) {
                    sumOfRemainders = (sumOfRemainders + (k % j) * freq[k]) % MOD;
                }
            }

            // Each remainder is valid for all occurrences of `j`
            result = (result + freq[j] * sumOfRemainders) % MOD;
        }

        return (int) result;
    }
}

//* 5. Largest Coprime Divisor
public class Solution {
    public int cpFact(int A, int B) {
        int maxDivisor = 1;

        for (int i = 1; i * i <= A; i++) {
            if (A % i == 0) {
                if (gcd(i, B) == 1) {
                    maxDivisor = Math.max(maxDivisor, i);
                }
                int otherDivisor = A / i;
                if (gcd(otherDivisor, B) == 1) {
                    maxDivisor = Math.max(maxDivisor, otherDivisor);
                }
            }
        }
        return maxDivisor;
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

}

//* 6. Divisor Game

public class Solution {
    public int solve(int A, int B, int C) {
        int L = lcm(B, C);
        int count = A/L;
        return count;
    }
    private int lcm(int a, int b){
        return (a*b)/ gcd(a, b);
    }
    private int gcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a %b;
            a = temp;
        }
        return a;
    }
}

//7. Excel Column Title
public class Solution {
    public String convertToTitle(int A) {
        StringBuilder result = new StringBuilder();

        while (A > 0) {
            A--;
            char currentChar = (char) ('A' + (A % 26));
            result.insert(0, currentChar);
            A /= 26;
        }

        return result.toString();
    }
}

//* 8. Pascal Triangle
public class Solution {
    public int[][] solve(int A) {
        int[][] triangle = new int[A][A];

        for (int i = 0; i < A; i++) {
            triangle[i][0] = 1;
            triangle[i][i] = 1;

            for (int j = 1; j < i; j++) {
                triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];
            }
        }
        return triangle;
    }
}

//* 9. Excel Column Number

public class Solution {
    public int titleToNumber(String A) {
        int result = 0;

        for (char c : A.toCharArray()) {
            int value = c - 'A' + 1;
            result = result * 26 + value;
        }

        return result;
    }
}


// 10. Find All Primes
public class Solution {
    public int[] solve(int A) {
        if (A < 2) return new int[0];

        boolean[] isPrime = new boolean[A + 1];
        for (int i = 2; i <= A; i++) {
            isPrime[i] = true;
        }

        // Sieve of Eratosthenes
        for (int i = 2; i * i <= A; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= A; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Count the number of primes
        int primeCount = 0;
        for (int i = 2; i <= A; i++) {
            if (isPrime[i]) {
                primeCount++;
            }
        }

        // Create an array to store prime numbers
        int[] primeArray = new int[primeCount];
        int index = 0;
        for (int i = 2; i <= A; i++) {
            if (isPrime[i]) {
                primeArray[index++] = i;
            }
        }

        return primeArray;
    }
}

//* 11. Number of Open Doors
public class Solution {
    public int solve(int A) {
        return (int) Math.sqrt(A);
    }
}


//* 12. Prime Sum

public class Solution {
    public int[] primesum(int A) {
        boolean[] isPrime = new boolean[A + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= A; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= A; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        Set<Integer> primes = new HashSet<>();
        for (int i = 2; i <= A; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        for (int i = 2; i <= A / 2; i++) {
            if (primes.contains(i) && primes.contains(A - i)) {
                return new int[]{i, A - i};
            }
        }

        return new int[]{};
    }
}
