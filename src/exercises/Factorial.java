package exercises;

public class Factorial {

    public static int calc(int n) {
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

}
