package careercup;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class StringExercises {

    public static boolean areAllCharactersUnique(String input) {
        char[] inputChars = input.toCharArray();

        Set<Character> inputCharsSet = new HashSet<>();
        for (char inputChar : inputChars) {
            inputCharsSet.add(inputChar);
        }

        return inputChars.length == inputCharsSet.size();
    }

    public static String reverseString(String input) {
        String output = "";
        char[] chars = input.toCharArray();

        for (int i = chars.length - 1; i >= 0; i--) {
            output += chars[i];
        }

        return output;
    }

    public static String removeDuplicateCharacters(String input) {
        char[] inputChars = input.toCharArray();

        Set<Character> inputCharsSet = new TreeSet<>();
        for (char inputChar : inputChars) {
            inputCharsSet.add(inputChar);
        }

        String outputString = "";
        Object[] outputChars = inputCharsSet.toArray();
        for (int i = 0; i < outputChars.length; i++) {
            outputString += (char) outputChars[i];
        }

        return outputString;
    }

    public static boolean areAnagrams(String first, String second) {

        char[] firstChars = first.toCharArray();
        char[] secondChars = second.toCharArray();

        Arrays.sort(firstChars);
        Arrays.sort(secondChars);

        boolean is = true;
        for (int i = 0; i < firstChars.length; i++) {
            if (firstChars[i] != secondChars[i]) {
                is = false;
                break;
            }
        }

        return is;
    }

    public static int[][] zerofillMatrixRowAndColumnOnZero(int[][] matrix) {
        class Zerofill {

            void row(int[][] matrix, int index) {
                for (int i = 0; i < matrix[index].length; i++) {
                    matrix[index][i] = 0;
                }
            }

            void column(int[][] matrix, int index) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][index] = 0;
                }
            }
        }

        int[][] copy = copyMatrix(matrix);
        Zerofill zerofill = new Zerofill();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    zerofill.row(copy, i);
                    zerofill.column(copy, j);
                }
            }
        }

        return copy;
    }

    private static int[][] copyMatrix(int[][] original) {
        int[][] copy = new int[original.length][original[0].length];

        for (int i = 0; i < original.length; i++) {
            for (int j = 0; j < original[i].length; j++) {
                copy[i][j] = original[i][j];
            }
        }

        return copy;
    }

    private static void dumpMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println("");
        }
    }

}
