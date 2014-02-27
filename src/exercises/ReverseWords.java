package exercises;

public class ReverseWords {

    public static String iteration(String str) {
        String[] words = str.split(" ");
        String reversed = "";

        for (int i = words.length - 1; i >= 0; i--) {
            reversed += words[i];
            if (i != 0) {
                reversed += " ";
            }
        }

        return reversed;
    }

}
