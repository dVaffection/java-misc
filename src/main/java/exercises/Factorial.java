package exercises;

public class Factorial {

    public static int iterative(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be greater than or equal to 0");
        }

        int factorial = 1;

        if (n > 1) {
            for (int i = 1; i <= n; i++) {
                factorial *= i;
            }
        }

        return factorial;
    }

    public static int recursive(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be greater than or equal to 0");
        }

        if (n == 0) {
            return 1;
        }

        return n * recursive(n - 1);
    }

}
