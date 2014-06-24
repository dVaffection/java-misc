package exercises;

import java.util.*;

public class Sets {

    public <E> Set<E> orderedNoDuplicates(Collection<E> c) {
        return new TreeSet<>(c);
    }

}
