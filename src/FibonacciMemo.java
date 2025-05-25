import java.util.HashMap;

public class FibonacciMemo {
    static HashMap<Integer, Integer> memo = new HashMap<>();

    public static int fibonacciMemoized(int n) {
        if (n <= 1) {
            return n;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int result = fibonacciMemoized(n - 1) + fibonacciMemoized(n - 2);
        memo.put(n, result);
        return result;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("--- Fibonacci using Memoization ---");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacciMemoized(i) + " ");
        }
        System.out.println();

        System.out.println("\n--- Fibonacci using Pure Recursion ---");
        for (int i = 0; i < n; i++) {
            System.out.print(FibonacciRecursive.fibonacciRecursive(i) + " ");
        }
        System.out.println();

//        int largeN = 47;
//        System.out.println("\n--- Comparison (n=" + largeN + ") ---");
//        memo.clear();
//        System.out.println("Fibonacci(" + largeN + ") (Memoized): " + fibonacciMemoized(largeN));
//        System.out.println("Fibonacci(" + largeN + ") (Recursive): " + FibonacciRecursive.fibonacciRecursive(largeN));
    }
}

class FibonacciRecursive {
    public static int fibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
}