package stackmachine;


/**
 * Reverse polish notation (postfix notation) calculator
 */
public class RPNCalculator {

    private final StackMachine stackmachine = new StackMachine();

    public Object ops(Object[] ops) {
        for (Object op : ops) {
            if (op instanceof Integer) {
                stackmachine.push(op);
            } else {
                if (op.equals('+')) {
                    stackmachine.push((Integer) stackmachine.pop() + (Integer) stackmachine.pop());
                } else if (op.equals('-')) {
                    Integer number = (Integer) stackmachine.pop();
                    stackmachine.push((Integer) stackmachine.pop() - number);
                } else if (op.equals('*')) {
                    stackmachine.push((Integer) stackmachine.pop() * (Integer) stackmachine.pop());
                } else if (op.equals('/')) {
                    Integer number = (Integer) stackmachine.pop();
                    stackmachine.push((Integer) stackmachine.pop() / number);
                } else {
                    String message = String.format("Unknown operation given: \"%s\"", op);
                    throw new IllegalArgumentException(message);
                }
            }
        }

        return stackmachine.pop();
    }

}
