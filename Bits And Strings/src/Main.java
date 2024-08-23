/*
* 1. Decimal to Binary
* 2. Add Binary Strings
* 3.Unset i-th bit
* 4. Check bit
* 5.Number of 1 Bits
* 6.Set Bit
* 7.Toggle i-th bit
* 8.Unset x bits from right
* 9. Finding Good Days
* 10. Find nth Magic Number
* 11.Help from Sam
* 12.Single Number
* 13.Single Number 2
* 14. Single Number 3
* 15. Maximum AND Pair
* 16. Strange Equality
* 17 SUbarray OR
* 18. Min XOR value
* 19.Sum of XOR of all Pairs
* 20.Find Two Missing Numbers
* 21.Strings - Toggle Case
* 22. Strings - Simple Reverse
* 23. Strings - Reverse the string
* 24. Strings - Longest Palindromic Substring
* 25-Strings -String Operations
* 26 - Strings - Longest Common Prefix
* 27.Strings - Isalnum()
*28. Strings - Count Occurences
* 29.Strings - Amazing Subarrays
* */

//1. Decimal to Binary

public static String decimalToBinary(int decimal) {
    if (decimal == 0) {
        return "0";
    }

    StringBuilder binary = new StringBuilder();

    while (decimal > 0) {
        int remainder = decimal % 2;
        binary.insert(0, remainder);
        decimal /= 2;
    }

    return binary.toString();
}
//* 2. Add Binary Strings

public class Solution {
    public String addBinary(String A, String B) {
        StringBuilder result = new StringBuilder();

        int carry = 0;
        int i = A.length() - 1;
        int j = B.length() - 1;

        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += A.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += B.charAt(j--) - '0';
            }

            result.insert(0, sum % 2);
            carry = sum / 2;
        }

        if (carry > 0) {
            result.insert(0, carry);
        }

        return result.toString();
    }
}


//.Unset i-th bit
public class Solution {
    public int solve(int A, int B) {

        if (((A >> B)&1) == 1){
            A ^= (1 << B);
        }
        return A;
    }
}

//* 4. Check bit
public class Solution {
    public int solve(int A, int B) {
        int mask = 1 << B;
        if ((A & mask)!=0){return 1;
        }
        else {return 0;}
    }
}

//* 5.Number of 1 Bits
public class Solution {
    public int numSetBits(int A) {
        // Brian Kernighan's Algorithm
        int count = 0;
        while (A>0){
            A &= (A-1);
            count++;
        }
        return count;
    }
}

//* 6.Set Bit
public class Solution {
    public int solve(int A, int B) {
        int maskA = 1<< A;
        int maskB = 1<<B;
        int result = maskA | maskB;
        return result;
    }
}

//* 7.Toggle i-th bit
public class Solution {
    public int solve(int A, int B) {
        return A ^ (1 << B);
    }
}

//* 8.Unset x bits from right
public class Solution {
    public long solve(long A, int B) {
        return (A >>B) << B;
    }
}

//* 9. Finding Good Days
public class Solution {
    public int solve(int A) {
        int count = 0;
        while (A > 0){
            A &= (A -1);
            count++;
        }
        return count;
    }
}

//* 10. Find nth Magic Number
public class Solution {
    public int solve(int A) {
        int pow = 1, answer = 0;
        while (A != 0)
        {
            pow = pow*5;

            if ((int)(A & 1) == 1)
                answer += pow;

            A >>= 1;
        }
        return answer;
    }
}

//* 11.Help from Sam

public class Solution {
    public int solve(int A) {
        int count =0;

        /*Brian Kernighan's Algorithm*/

        while (A > 0){
            A &= (A-1);
            count++;
        }
        return count;
    }
}


//12.Single Number
public class Solution {
    public int singleNumber(final int[] A) {
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            int num = A[i];
            result ^= num;
        }
        return result;
    }
}
//* 13.Single Number 2
public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int singleNumber(final int[] A) {
        int ans = 0;
        int n = A.length;
        for (int b = 0; b < 32; b++) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                int num = A[i];
                if (((num >> b) & 1) == 1) {
                    count++;
                }
            }
            if (count % 3 == 1) {
                ans |= (1 << b);
            }
        }
        return ans;
    }
}
//* 14. Single Number 3
public class Solution {
    public int[] solve(int[] A) {
        int XOR =0;
        for (int num : A){XOR ^= num;}
        int rightmostSetBit = XOR & -XOR;

        int num1 = 0, num2 = 0;
        for (int num : A){
            if ((num & rightmostSetBit) == 0){
                num1 ^= num;
            }
            else {num2 ^= num;}
        }
        return new int [] {Math.min(num1, num2), Math.max(num1, num2)};
    }
}

//* 15. Maximum AND Pair
public class Solution {
    public int solve(int[] A) {
        int result = 0;

        for (int bit = 30; bit >= 0; bit--) {
            int temp = result | (1 << bit);
            int count = 0;

            for (int num : A) {
                if ((num & temp) == temp) {
                    count++;
                }
                if (count >= 2) break;
            }

            if (count >= 2) {
                result = temp;
            }
        }

        return result;
    }
}

//* 16. Strange Equality
public class Solution {
    public int solve(int A) {
        int highestBit = 1;
        while (highestBit <= A) {
            highestBit <<= 1;
        }
        int X = highestBit - 1 - A;


        int Y = highestBit;

        return X ^ Y;

    }
}


//* 17 SUbarray OR
public class Solution {
    private static final int MOD = 1000000007;

    public int solve(int[] A) {
        int n = A.length;
        long result = 0;

        // We consider each bit position from 0 to 29
        for (int bit = 0; bit < 30; bit++) {
            long count = 0; // Number of subarrays where the current bit is set
            long total = 0; // Total contribution of this bit

            for (int i = 0; i < n; i++) {
                if ((A[i] & (1 << bit)) != 0) {
                    count = i + 1; // if the current bit is set, count all subarrays ending at i
                }
                total += count; // add the count to the total
            }

            result += (total * (1 << bit)) % MOD;
            result %= MOD;
        }

        return (int) result;
    }
}


//* 18. Min XOR value
public class Solution {
    public int findMinXor(int[] A) {
        // Step 1: Sort the array
        Arrays.sort(A);

        int min_xor = Integer.MAX_VALUE;

        // Step 2: Compute XOR for consecutive elements
        for (int i = 0; i < A.length - 1; i++) {
            int xor_value = A[i] ^ A[i + 1];
            min_xor = Math.min(min_xor, xor_value);
        }

        // Step 3: Return the minimum XOR value found
        return min_xor;
    }
}

//* 19.Sum of XOR of all Pairs
public class Solution {
    private static final int MOD = 1000000007;

    public int solve(int[] A) {
        int n = A.length;
        long result = 0;

        // Consider each bit position from 0 to 29
        for (int i = 0; i < 30; i++) {
            long count1 = 0;

            // Count how many numbers have the ith bit set
            for (int j = 0; j < n; j++) {
                if ((A[j] & (1 << i)) != 0) {
                    count1++;
                }
            }

            long count0 = n - count1;
            long contribution = count1 * count0 * (1L << i);

            // Add contribution to result and take modulo
            result = (result + contribution) % MOD;
        }

        return (int) result;
    }
}

//* 20.Find Two Missing Numbers

public class Solution {
    public int[] solve(int[] A) {
        int N = A.length;

        long totalSum = (long)(N + 2) * (N + 3) / 2;
        long totalSumSquares = (long)(N + 2) * (N + 3) * (2L * (N + 2) + 1) / 6;

        long sumA = 0;
        long sumSquaresA = 0;

        for (int i = 0; i < N; i++) {
            sumA += A[i];
            sumSquaresA += (long) A[i] * A[i];
        }

        long S = totalSum - sumA; // S = x + y
        long P = totalSumSquares - sumSquaresA; // P = x^2 + y^2

        long xy = (S * S - P) / 2;

        // Solving the quadratic equation t^2 - S * t + xy = 0
        long discriminant = S * S - 4 * xy;
        long sqrtDiscriminant = (long) Math.sqrt(discriminant);

        int x = (int) ((S + sqrtDiscriminant) / 2);
        int y = (int) ((S - sqrtDiscriminant) / 2);

        int[] result = new int[2];
        result[0] = Math.min(x, y);
        result[1] = Math.max(x, y);
        return result;
    }
}


//.Strings - Toggle Case
public class Solution {
    public String solve(String A) {

        char[] charArray = A.toCharArray();
        for(int i = 0; i < charArray.length; i++){
            char ch = charArray[i];
            if(Character.isLowerCase(ch)){
                charArray[i] = Character.toUpperCase(ch);
            }
            else if(Character.isUpperCase(ch)){
                charArray[i] = Character.toLowerCase(ch);
            }
        }
        return new String(charArray);
    }
}

//* 22. Strings - Simple Reverse
public class Solution {
    public String solve(String A) {
        char[] charArray = A.toCharArray();
        int left = 0;
        int right = charArray.length -1;
        while(left < right){
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;

        }
        return new String(charArray);
    }
}


//* 23. Strings - Reverse the string
public class Solution {
    public String solve(String A) {
        int length = A.length();
        String result = "";
        int i = length -1;

        while(i >= 0){
            while(i >= 0 && A.charAt(i) == ' '){
                i--;
            }
            if(i < 0){
                break;
            }
            int end = i;
            while(i >= 0 && A.charAt(i) != ' '){
                i--;
            }
            if(!result.isEmpty()){
                result +=" ";
            }
            result += A.substring(i+1, end +1);
        }
        return result;
    }

}
//* 24. Strings - Longest Palindromic Substring
public class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0){return "";}
        int n = s.length();
        char[] transformed = new char[2*n+1];
        int[] P =new int[2*n+1];
        for(int i =0; i<n; i++){
            transformed[2*i] = '#';
            transformed[2*i+1] = s.charAt(i);
        }
        transformed[2*n] = '#';

        int center = 0, right = 0;
        int maxLen =0, start = 0;

        for(int i =0; i < transformed.length; i++){
            int j = 2* center -i;
            if(i<right){P[i] = Math.min(right -i, P[j]);}

            while(i+ P[i]+1 < transformed.length && i - P[i] -1 >= 0 && transformed[i+ P[i]+1] == transformed[i - P[i]-1]){
                P[i]++;
            }

            if(i + P[i] > right){
                center = i;
                right = i + P[i];
            }

            if(P[i] > maxLen){
                maxLen = P[i];
                start = (i - P[i])/2;
            }
        }
        return s.substring(start, start+ maxLen);
    }
}
//* 25-Strings -String Operations

public class Solution {
    public String solve(String A) {
        A = A + A;

        A = A.replaceAll("[A-Z]", "");

        A = A.replaceAll("[aeiouAEIOU]", "#");

        return A;
    }
}
//* 26 - Strings - Longest Common Prefix
public class Solution {
    public String longestCommonPrefix(String[] strings) {
        int n = strings.length;
        StringBuilder commonPrefix = new StringBuilder();

        for (int i = 0; i < strings[0].length(); i++) {
            char currentChar = strings[0].charAt(i);

            for (int j = 1; j < n; j++) {
                if (i >= strings[j].length() || strings[j].charAt(i) != currentChar) {
                    return commonPrefix.toString();
                }
            }

            commonPrefix.append(currentChar);
        }

        return commonPrefix.toString();
    }
}

//* 27.Strings - Isalnum()
public class Solution {
    public int solve(char[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        for (char ch : A) {
            if (!Character.isLetterOrDigit(ch)) {
                return 0;
            }
        }

        return 1;
    }
}

//*28. Strings - Count Occurences

public class Solution {
    public int solve(String A) {
        int count = 0;


        for (int i = 0; i <= A.length() - 3; i++) {

            if (A.substring(i, i + 3).equals("bob")) {
                count++;
            }
        }

        return count;
    }
}

//* 29.Strings - Amazing Subarrays

public class Solution {
    private static final int MOD = 10003;

    public int solve(String S) {
        int count = 0;
        int n = S.length();

        for (int i = 0; i < n; i++) {
            char ch = S.charAt(i);

            if (isVowel(ch)) {
                count = (count + (n - i)) % MOD;
            }
        }

        return count;
    }

    private static boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) != -1;
    }
}
