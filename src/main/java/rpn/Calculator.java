package rpn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Calculator implements Subscriber {

    private static List<TokenMessage> receivedTokens = new ArrayList<>();
    private static ArrayDeque<Integer> stack = new ArrayDeque<>();

    @Override
    public void onEvent(String receivedToken) {
        TokenMessage tokenMessage = new TokenMessage(receivedToken);
        receivedTokens.add(tokenMessage);

        List<String> tokens = new ArrayList<>();
        for (TokenMessage message : receivedTokens) {
            tokens.add(message.getToken());
        }
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
        System.out.println("> " + stack.pop());
    }
}
