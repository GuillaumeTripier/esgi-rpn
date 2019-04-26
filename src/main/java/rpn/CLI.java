package rpn;

import java.util.ArrayDeque;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CLI {
    public static final void main(String[] args) {
        String expression = Stream.of(args).collect(Collectors.joining(" "));

        System.out.println("About to evaluate '" + expression + "'");
        long result = evaluate(expression);
        System.out.println("> " + result);
    }

    static long evaluate(String expression){//ArrayDeque
        String[] tokens = expression.split(" ");
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int right;
        int left;
        for (String token : tokens){
            switch (token) {
                case "+":
                    right = stack.pop();
                    left = stack.pop();
                    stack.push(left + right);
                    break;
                case "-":
                    right = stack.pop();
                    left = stack.pop();
                    stack.push(left - right);
                    break;
                case "*":
                    right = stack.pop();
                    left = stack.pop();
                    stack.push(left * right);
                    break;
                case "/":
                    right = stack.pop();
                    left = stack.pop();
                    stack.push(left / right);
                    break;
                default:
                    int constant = Integer.parseInt(token);
                    stack.push(constant);
                    break;
            }
        }
        return stack.pop();
    }
}
