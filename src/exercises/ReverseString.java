package exercises;

public class ReverseString {

    public static String iterative(String str) {
        String reversed = "";

        int i = str.length() - 1;
        while (i >= 0) {
            reversed += str.charAt(i);
            i--;
        }

        return reversed;
    }

    public static String recursive(String str) {
        String reversed = "";

        int i = str.length() - 1;
        reversed = recursive(str, i, reversed);

        return reversed;
    }

    private static String recursive(String str, int i, String reversed) {
        if (i >= 0) {
            reversed += str.charAt(i);
            i--;

            String ret = recursive(str, i, reversed);
            return ret;
        }

        reversed += "";

        return reversed;
    }

    public static String builder(String str) {
        StringBuilder reversed = new StringBuilder(str);
        return reversed.reverse().toString();
    }

}
