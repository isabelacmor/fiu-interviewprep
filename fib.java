import java.util.Arrays;

public class fib {
    public static int[] memoized = new int[100];

    public static void main(String[] args) {
        int result1 = recursive(7);
        System.out.println("Recursive solution");
        System.out.println(result1);

        int result2 = memo(7);
        System.out.println("Memoized solution");
        System.out.println(result2);

        int result3 = dp(7);
        System.out.println("Dynamic programming solution");
        System.out.println(result3);
    }

    public static int recursive(int x) {
        // T(n) = T(n-1) + T(n-2) + 1 = 2n = O(2^n)
        if (x == 0) return 0;
        if (x == 1) return 1;
        return recursive(x - 1) + recursive(x - 2);
    }

    public static int memo(int x) {
        // T(n) = O(n)
        memoized[0] = 0;
        memoized[1] = 1;
        memoized[2] = 1;
        return memoSolve(x);       
    }

    public static int memoSolve(int x) {
        if (x <= 0) return memoized[0];

        int f = memoized[x];
        if (f == 0) {
            // Number hasn't been calculated yet (Java arrays get initialized with 0's)
            // so calculate it and store the result for future use
            f = memoSolve(x - 1) + memoSolve(x - 2);
            memoized[x] = f;
        }

        return f;
    }

    public static int dp(int x) {
        // T(n) = O(n)
        int[] fib = new int[x+1];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= x; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        return fib[x];
    }
}