package rpn;

public interface Subscriber {
    void onEvent(rpn.TokenMessage tokenMessage);
}