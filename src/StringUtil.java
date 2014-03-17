import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

    public static String pad(String input, int length) {
        return pad(input, length, " ", PadType.RIGHT);
    }

    public static String pad(String input, int length, String padStr) {
        return pad(input, length, padStr, PadType.RIGHT);
    }

    public static String pad(String input, int length, String padStr, PadType padType) {
        if (padStr.length() == 0) {
            throw new IllegalArgumentException("Padding string cannot be empty");
        }

        String output = input;
        String padPaddedStr = "";

        if (length > input.length()) {
            int lengthDiff = length - input.length();

            if (padStr.length() == lengthDiff) {
                padPaddedStr = padStr;
            } else if (padStr.length() > lengthDiff) {
                padPaddedStr = padStr.substring(0, lengthDiff);
            } else {
                // this is an integer multiplier
                int multiplier = lengthDiff / padStr.length();
                for (int i = 0; i < multiplier; i++) {
                    padPaddedStr += padStr;
                }

                // now if we still short on length
                // (quite possible cause we took just an integer part from the previous operation),
                // let's pad to the needed length
                if (padPaddedStr.length() < lengthDiff) {
                    int residue = lengthDiff - padStr.length();
                    padPaddedStr += padStr.substring(0, residue);
                }
            }

            if (PadType.LEFT == padType) {
                output = padPaddedStr + output;
            } else {
                output += padPaddedStr;
            }
        }

        return output;
    }

    public static String repeat(String str, int multiplier) {
        String output = "";

        if (multiplier < 0) {
            throw new IllegalArgumentException("Second argument has to be greater than or equal to 0");
        }

        if (multiplier > 0) {
            for (int i = 0; i < multiplier; i++) {
                output += str;
            }
        }

        return output;
    }

    public static int wordsCount(String str) {
        String[] words = str.split(" ");
        return words.length;
    }

    public static int pos(String haystack, String needle) throws Exception {
        if (needle.length() == 0) {
            throw new IllegalArgumentException("Empty needle given");
        }

        for (int i = 0; i < haystack.length(); i++) {
            String cmp = haystack.substring(i, needle.length() + i);
            if (cmp.equals(needle)) {
                return i;
            }
        }

        throw new Exception("The needle was not found in the haystack");
    }

    public static int rpos(String haystack, String needle) throws Exception {
        StringBuilder haystackBuilder = new StringBuilder(haystack);
        haystack = haystackBuilder.reverse().toString();

        StringBuilder needleBuilder = new StringBuilder(needle);
        needle = needleBuilder.reverse().toString();

        int pos = pos(haystack, needle);
        pos = haystack.length() - needle.length() - pos;
        return pos;
    }

    public static Integer[] allIndexOf(String str, String instance) {
        return allIndexOf(str, instance, 0);
    }

    public static Integer[] allIndexOf(String str, String instance, int fromIndex) {
        ArrayList<Integer> result = new ArrayList<>();

        int index;
        while (true) {
            index = str.indexOf(instance, fromIndex);

            if (-1 == index) {
                break;
            } else {
                result.add(index);
                fromIndex += index + instance.length();
            }
        }

        return result.toArray(new Integer[result.size()]);
    }

    public static String strtr(String str, HashMap<String, String> map) {
        Set<String> keys = map.keySet();

        int beginIndex = 0;
        int endIndex = 1;
        while (true) {
            if (endIndex >= str.length()) {
                beginIndex++;
                endIndex = beginIndex + 1;
            }

            if (beginIndex >= str.length()) {
                break;
            }

            String cmp = str.substring(beginIndex, endIndex);
            boolean found = false;
            for (String key : keys) {
                if (key.equals(cmp)) {
                    found = true;

                    String value = map.get(key);
                    str = str.replace(key, value);

                    beginIndex += cmp.length();
                    endIndex += cmp.length();
                    break;
                }
            }

            if (!found) {
                endIndex++;
            }
        }

        return str;
    }

    /**
     * hashtags starts with '#'
     */
    public static String[] findHashTags(String str) {
        ArrayList<String> matches = new ArrayList<>();

        Pattern pattern = Pattern.compile("#[a-z0-9_\\-]*", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {
            int start = matcher.start() + 1; // exclude first char (#)
            int end = matcher.end();

            String match = str.substring(start, end);
            matches.add(match);
        }

        return Arrays.copyOf(matches.toArray(), matches.size(), String[].class);
    }

    /**
     * mentioned starts with '@'
     */
    public static String[] findMentioned(String str) {
        ArrayList<String> matches = new ArrayList<>();

        Pattern pattern = Pattern.compile("@[a-z0-9_\\-]*", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {
            int start = matcher.start() + 1; // exclude first char (#)
            int end = matcher.end();

            String match = str.substring(start, end);
            matches.add(match);

            System.out.println(start);
            System.out.println(end);
        }

        return Arrays.copyOf(matches.toArray(), matches.size(), String[].class);
    }

    enum PadType {
        LEFT,
        RIGHT,
    }

}
