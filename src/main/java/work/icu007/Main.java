package work.icu007;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String expression = "3 + 5 * ( 2 - 8 )";
        String[] tokens = expression.split(" ");
        List<String> strings = infixToPostfix(tokens);
        System.out.println(strings);
    }

    private static List<String> infixToPostfix(String[] tokens) {
        List<String> output = new ArrayList<>();
        Stack<String> operatorStack = new Stack<>();

        Map<String, Integer> precedence = new HashMap<>();
        precedence.put("+", 1);
        precedence.put("-", 1);
        precedence.put("*", 2);
        precedence.put("/", 2);
        precedence.put("(", 0);

        for (String token : tokens) {
            if (!isOperator(token)) {
                output.add(token);
            } else {
                if (token.equals("(")) {
                    operatorStack.push(token);
                } else if (token.equals(")")) {
                    while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
                        output.add(operatorStack.pop());
                    }
                    if (!operatorStack.isEmpty() && operatorStack.peek().equals("(")) {
                        operatorStack.pop(); // Pop the "("
                    }
                } else {
                    while (!operatorStack.isEmpty() && precedence.get(operatorStack.peek()) >= precedence.get(token)) {
                        output.add(operatorStack.pop());
                    }
                    operatorStack.push(token);
                }
            }
        }

        // Pop all the operators left in the stack
        while (!operatorStack.isEmpty()) {
            output.add(operatorStack.pop());
        }

        return output;
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*")
                || token.equals("/") || token.equals("(") || token.equals(")");
    }
}

