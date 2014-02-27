package exercises;

public class ReverseString {

    public static String iteration(String str) {
        String reversed = "";

        int i = str.length() - 1;
        while (i >= 0) {
            reversed += str.charAt(i);
            i--;
        }

        return reversed;
    }

    public static String builder(String str) {
        StringBuilder reversed = new StringBuilder(str);
        return reversed.reverse().toString();
    }

}
