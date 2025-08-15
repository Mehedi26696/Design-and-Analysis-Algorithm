 

// Finding A^K mod m using modular exponentiation

// If k is even, then A^K = (A^(K/2))^2
// If k is odd, then A^K = A * (A^(K-1))
// This approach is efficient and works in O(log K) time complexity


public class ModularArithmetic {

    public static long naiveapproach(long A, long K, long M) {
        long result = 1;
        for (long i = 1; i <=K; i++) {
            result = ((result % M) * (A % M)) % M; // Multiply and take mod at each step
        }
        return result;
    }

    public static long modularExponentiation(long A, long K, long M) {
        if (K == 0) {
            return 1; // A^0 = 1
        }
        if (K == 1) {
            return A % M; // A^1 = A
        }

        long half = modularExponentiation(A, K / 2, M);
        long result = (half * half) % M; // Square the result of the half exponent

        if (K % 2 == 1) {
            result = (result * (A % M)) % M; // If K is odd, multiply by A
        }

        return result;
    }

    // Iterative version of modular exponentiation
    public static long modularExponentiationIterative(long A, long K, long M) {
        long result = 1;
        A = A % M; // Take mod of A initially

        while (K > 0) {
            if ((K & 1) == 1) { // If K is odd
                result = (result * A) % M;
            }
            A = (A * A) % M; // Square A
            K >>= 1; // Divide K by 2
        }

        return result;
    }

    public static void main(String[] args) {
        long A = 5; // Base
        long K = 3; // Exponent
        long M = 13; // Modulus
        // Using naive approach
        long naiveResult = naiveapproach(A, K, M);
        System.out.println("Naive Result: " + naiveResult); // Output: Naive Result: 8
        long result = modularExponentiation(A, K, M);
        System.out.println("Result: " + result); // Output: Result: 8
        long iterativeResult = modularExponentiationIterative(A, K, M);
        System.out.println("Iterative Result: " + iterativeResult); // Output: Iterative
    }
}


// Time Complexity:
// - Naive Approach: O(K) 
// - Modular Exponentiation (Recursive): O(log K)
// - Modular Exponentiation (Iterative): O(log K)
// Space Complexity:
// - Naive Approach: O(1)
// - Modular Exponentiation (Recursive): O(log K) due to recursion stack
// - Modular Exponentiation (Iterative): O(1)