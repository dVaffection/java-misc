package exercises;

import java.util.*;

public class Sets {

    public <E> Collection<E> orderedNoDuplicates(Collection<E> c) {
        Collection<E> result = new TreeSet<>(c);
        return result;
    }

}
