package rpn;

import java.util.*;

public class CLI {

    public static void main(String[] args) {

        Thread subscribeThread = new Thread(() -> {
            Calculator calculator = new Calculator();
            Bus.subscribe(calculator);
        });

        Thread publishThread = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                Parser.parse(scanner.nextLine());
            }
        });

        subscribeThread.start();
        publishThread.start();
    }

    long evaluate(String expression) {
        List<String> tokens = Arrays.asList(expression.split(" "));
        for (String token : tokens) {
            Parser.parse(token);
        }
        return(10);
    }
}