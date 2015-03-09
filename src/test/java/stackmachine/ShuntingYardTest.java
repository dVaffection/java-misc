package stackmachine;

import org.junit.Test;

import java.util.Arrays;

public class ShuntingYardTest {

    @Test
    public void convertToRPN() {
        // does not work :(

        Object[] tokens = {3, '+', 4, '*', 2, '/', 1, '-', 5};

        ShuntingYard shuntingYard = new ShuntingYard();
        Object[] actual = shuntingYard.convertToRPN(tokens);

        System.out.println(Arrays.toString(actual));

        RPNCalculator rpnCalculator = new RPNCalculator();
        Object result = rpnCalculator.ops(actual);

        System.out.println(result);
    }
}