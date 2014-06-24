package exercises;

public class Asterisks {

    /**
     * *
     * ***
     * *****
     * ***
     * *
     */
    public static void main(String... str) {
        int starsNumber = 1;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < starsNumber; j++) {
                System.out.print('*');
            }
            System.out.print("\n");

            if (i < 2) {
                starsNumber += 2;
            } else {
                starsNumber -= 2;
            }
        }
    }

}
