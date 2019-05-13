package rpn;

class Parser {

    static void parse(String token) {
        Bus.publish(token);
    }
}