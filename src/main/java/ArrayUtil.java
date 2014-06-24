import java.lang.reflect.Array;
import java.util.ArrayList;

public class ArrayUtil {

    public static <T> T[] findDuplicates(T[] array) {
        ArrayList<T> duplicates = new ArrayList<>();
        ArrayList<T> newArray = new ArrayList<>();

        for (T val : array) {
            if (newArray.contains(val)) {
                duplicates.add(val);
            } else {
                newArray.add(val);
            }
        }

        T typeVar = array[0];
        return duplicates.toArray((T[]) Array.newInstance(typeVar.getClass(), duplicates.size()));
    }

}
