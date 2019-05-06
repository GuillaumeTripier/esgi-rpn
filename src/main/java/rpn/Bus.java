package rpn;

import java.util.ArrayList;
import java.util.List;

public class Bus {
    private rpn.Subscriber subscriber;
    private List<Subscriber> subscribers = new ArrayList<>();

    private void publish(rpn.TokenMessage tokenMessage) {
        //subscribers.onEvent(tokenMessage);
    }

    public void subscribe(rpn.Subscriber subscriber) {
        this.subscribers.add(subscriber);
    }
}
