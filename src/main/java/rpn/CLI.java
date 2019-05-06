package rpn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CLI {
    private final Parser parser = new Parser();

    public static final void main(String[] args) {
        String expression = Stream.of(args).collect(Collectors.joining(" "));

        System.out.println("About to evaluate '" + expression + "'");
        long result = new CLI().evaluate(expression);
        System.out.println("> " + result);
    }

    long evaluate(String expression) {
        List<TokenMessage> receivedTokens = new ArrayList<>();
        parser.subscribe(new Subscriber() {
            @Override
            public void onEvent(TokenMessage tokenMessage) {
                receivedTokens.add(tokenMessage);
            }
        });
        parser.parse(expression);
        List<String> tokens = new ArrayList<>();
        for (TokenMessage message : receivedTokens) {
            tokens.add(message.getToken());
        }
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            switch (token) {
                case "+": {
                    int right = stack.pop();
                    int left = stack.pop();

                    stack.push(left + right);
                    break;
                }
                case "*": {
                    int right = stack.pop();
                    int left = stack.pop();

                    stack.push(left * right);
                    break;
                }
                case "-": {
                    int right = stack.pop();
                    int left = stack.pop();

                    stack.push(left - right);
                    break;
                }
                case "/": {
                    int right = stack.pop();
                    int left = stack.pop();

                    stack.push(left / right);
                    break;
                }
                default:
                    int constant = Integer.parseInt(token);
                    stack.push(constant);
                    break;
            }
        }
        return stack.pop();
    }

}
