package exercises;

public class Fibonacci {

    /**
     * Fn = Fn-1 + Fn-2
     */
    public int iterative(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be a positive integer value");
        }

        int F = 0, F1 = 1, F2 = 1;

        switch (n) {
            case 0:
                F = 0;
                break;
            case 1:
            case 2:
                F = 1;
                break;
            default:
                int i = 3;
                while (i <= n) {
                    F = F1 + F2;

                    F2 = F1;
                    F1 = F;

                    i++;
                }
        }

        return F;
    }

    /**
     * Fn = Fn-1 + Fn-2
     */
    public int recursive(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be a positive integer value");
        }

        int F = 0, F1 = 1, F2 = 1;

        switch (n) {
            case 0:
                F = 0;
                break;
            case 1:
            case 2:
                F = 1;
                break;
            default:
                F = recursive(3, n, F, F1, F2);
        }

        return F;
    }

    private int recursive(int i, int n, int F, int F1, int F2) {
        F = F1 + F2;

        if (i < n) {
            i++;
            F2 = F1;
            F1 = F;
            return recursive(i, n, F, F1, F2);
        }

        return F;
    }

}
