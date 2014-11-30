package exercises;

public class HashFunctions {

    public int truncate(int number) {
        String str = numberToString(number);
        int beginIndex = str.length() - 2;
        int endIndex = str.length();
        String address = str.substring(beginIndex, endIndex);

        return Integer.parseInt(address);
    }

//    public int midSquare(int number) {
//        int address;
//    }
//
//    public int folding(int number) {
//        int address;
//    }
//
//    public int moduloDivision(int number) {
//        int address;
//    }

    private String numberToString(int number) {
        String str = Integer.toString(number);
        while (str.length() < 2) {
            str += "0";
        }

        return str;
    }

}
