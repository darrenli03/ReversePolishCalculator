import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class IndependentReversePolishCalculator {

    public static void main(String[] args) {
        Deque<String> operators = new LinkedList<>();
        Queue<String> output = new LinkedList<>();

        Scanner scanner = new Scanner(System.in);
        String token;
        do {
            token = scanner.next();

            if (token.equals("=")) {
                break;

            } else if (token.equals("(")) {
                operators.push(token);

            } else if (token.equals(")")) {
                while (!operators.peek().equals("(")) {
                    output.add(operators.pop());
                }
                operators.pop();


            } else if (token.equals("^")) {
                operators.push(token);

            } else if (token.equals("+") || token.equals("-")) {
                while (!operators.isEmpty() && (operators.peek().equals("*") || operators.peek().equals("/") || operators.peek().equals("^"))) {
                    output.add(operators.pop());
                }
                operators.push(token);

            } else if (token.equals("*") || token.equals("/")) {
                while (!operators.isEmpty() && operators.peek().equals("^")) {
                    output.add(operators.pop());
                }
                operators.push(token);

            } else {
                output.add(token);
            }

        } while (true);

        while (!operators.isEmpty()) {
            output.add(operators.pop());
        }

        ArrayList<String> tokenArray = new ArrayList<String>();

        System.out.print("postfix/reverse polish notation: ");

        while (!output.isEmpty()) {
            tokenArray.add(output.peek());
            System.out.print(output.remove() + " "); // prints reverse polish result
        }

        System.out.print("\n");

        String[] stringArray = new String[tokenArray.size()];

        for (int i = 0; i < tokenArray.size(); i++) {
            stringArray[i] = tokenArray.get(i);
        }
        System.out.println("calculation result is: " + evalRPN(stringArray));


    }

    public static double evalRPN(String[] tokens) {
        Deque<Double> output = new LinkedList<>();

        for (String token : tokens) {
            if (token.equals("+") || token.equals("/") || token.equals("*") || token.equals("-") || token.equals("^")) {

                double dos = output.pop();
                double uno = output.pop();

                output.push(operate(token, uno, dos));

            } else {
                output.push(Double.parseDouble(token));
            }
        }

        return output.pop();
    }

    public static double operate(String operator, double num1, double num2) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
            case "^":
                return Math.pow(num1, num2);
            default:
                return -1.69;
        }
    }
}
