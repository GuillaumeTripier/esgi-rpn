package rpn;

import java.util.Arrays;
import java.util.List;

public class Parser {

    private Subscriber subscriber;

    List<String> parse(String expression) {
        List<String> tokens = Arrays.asList(expression.split(" "));
        for (String token : tokens) {
            publish(new TokenMessage(token));
        }
        return tokens;
    }

    private void publish(TokenMessage tokenMessage) {
        subscriber.onEvent(tokenMessage);
    }

    public void subscribe(Subscriber subscriber) {
        this.subscriber = subscriber;
    }
}