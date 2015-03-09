package stackmachine;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ShuntingYard {

    Map<Character, Operator> operators = new HashMap<>();

    public ShuntingYard() {
        operators.put('+', new Operator('+', 0));
        operators.put('-', new Operator('-', 0));
        operators.put('*', new Operator('*', 1));
        operators.put('/', new Operator('/', 1));
    }

    public Object[] convertToRPN(Object[] tokens) {
        Deque<Object> stack = new LinkedList<>();
        Queue<Object> queue = new LinkedList<>();

        for (Object token : tokens) {
            if (token instanceof Integer) {
                queue.add(token);
            } else if (token.equals('(')) {
                stack.push(token);
            } else if (token.equals(')')) {
                while (!stack.peek().equals('(')) {
                    Object notLeftParenthesis = stack.pop();
                    queue.add(notLeftParenthesis);
                }

                if (stack.size() == 0) {
                    String message = String.format("Mismatched parentheses,: [%s]", Arrays.toString(tokens));
                    throw new IllegalArgumentException(message);
                }

                // pop left parenthesis "("
                stack.pop();
            } else if (operators.containsKey(token)) {
                Operator o1 = operators.get(token);

                // we need to check operator associativity, but currently all supported operators are left-associative
                while (stack.peek() != null
                        && operators.containsKey(stack.peek())
                        && o1.cpmPrecedence(operators.get(stack.peek())) < 1) {
                    queue.add(stack.pop());
                }

                stack.push(o1.functionToken);
            } else {
                String message = String.format("Unknown token given: \"%s\"", token);
                throw new IllegalArgumentException(message);
            }
        }

        // pop the rest operators onto the output queue
        while (operators.containsKey(stack.peek())) {
            queue.add(stack.pop());
        }

        return queue.toArray();
    }

    private class Operator {

        final static String ASSOC_LEFT  = "left";
        final static String ASSOC_RIGHT = "right";

        char   functionToken;
        int    precedence;
        String associativity;

        public Operator(char functionToken, int precedence, String associativity) {
            this.functionToken = functionToken;
            this.precedence = precedence;
            this.associativity = associativity;
        }

        public Operator(char functionToken, int precedence) {
            this.functionToken = functionToken;
            this.precedence = precedence;
            associativity = Operator.ASSOC_LEFT;
        }

        public int cpmPrecedence(Operator operator) {
            if (precedence == operator.precedence) {
                return 0;
            } else if (precedence > operator.precedence) {
                return 1;
            } else {
                return -1;
            }
        }
    }

}
