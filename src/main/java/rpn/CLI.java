package rpn;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CLI {
    public static final void main(String[] args) {
        String expression = Stream.of(args).collect(Collectors.joining(" "));

        System.out.println("About to evaluate '" + expression + "'");
        long result = evaluate(expression);
        System.out.println("> " + result);
    }

    /*static long evaluate(String expression) {
        return 0;
    }*/
    static long evaluate(String entree){//ArrayDeque
        String[] fullString = entree.split(" ");
        int result = 0;
        int op1;
        int op2;
        char c;
        result = Integer.parseInt(fullString[0]);
        if(fullString.length > 2) {
            for (int i = 0; i < fullString.length - 2; i += 2) {
                op1 = result;
                op2 = Integer.parseInt(fullString[i + 1]);
                c = fullString[i + 2].charAt(0);
                switch (c) {
                    case '+':
                        result = op1 + op2;
                        break;
                    case '-':
                        result = op1 - op2;
                        break;
                    case '*':
                        result = op1 * op2;
                        break;
                    case '/':
                        result = op1 / op2;
                        break;
                    default:
                        i += fullString.length;
                        System.out.println("Error");
                }
            }
        }
        return result;
    }
}
