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
        if(fullString.length == 3){
            op1 = Integer.parseInt(fullString[0]);
            System.out.println("bob");
            op2 = Integer.parseInt(fullString[1]);
            c = fullString[fullString.length - 1].charAt(0);
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
                    System.out.println("Error");
            }
        } else if(fullString.length > 3) {
            for (int i = 0; i < fullString.length - 3; i += 1) {
                op1 = result;
                op2 = Integer.parseInt(fullString[i + 1]);
                c = fullString[fullString.length - 1 - i].charAt(0);
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
