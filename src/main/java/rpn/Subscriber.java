package rpn;

public interface Subscriber {
    void onEvent(TokenMessage tokenMessage);
}