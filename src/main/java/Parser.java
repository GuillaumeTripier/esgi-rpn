package rpn;

import java.util.Arrays;
import java.util.List;

public class Parser {

    private rpn.Subscriber subscriber;

    List<String> parse(String expression) {
        List<String> tokens = Arrays.asList(expression.split(" "));
        for (String token : tokens) {
            publish(new rpn.TokenMessage(token));
        }
        return tokens;
    }

    private void publish(rpn.TokenMessage tokenMessage) {
        subscriber.onEvent(tokenMessage);
    }

    public void subscribe(rpn.Subscriber subscriber) {
        this.subscriber = subscriber;
    }
}