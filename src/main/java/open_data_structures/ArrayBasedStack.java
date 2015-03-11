package open_data_structures;

public class ArrayBasedStack<T> implements Stack<T> {

    private ArrayBasedList<T> list;

    public ArrayBasedStack(int initSize) {
        list = new ArrayBasedList<>(initSize);
    }

    @Override
    public void push(T o) {
        list.add(o);
    }

    @Override
    public T pop() {
        return list.remove(list.getElementsNumber() - 1);
    }
}
