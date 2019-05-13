package rpn;

import java.util.ArrayList;
import java.util.List;

class Bus {

    private static List<Subscriber> subscribers = new ArrayList<>();

    public static void publish(String token) {
        //if (subscribers != null && subscribers.size() > 0) {
        for (Subscriber subscriber : subscribers) {
            subscriber.onEvent(token);
        }
        //}
    }

    public static void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }
}