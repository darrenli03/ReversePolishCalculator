import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class IndependentReversePolishCalculatorV2 {
    public static void main(String[] args) {
        Deque<String> operators = new LinkedList<>();
        Queue<String> output = new LinkedList<>();
        ArrayList<String> formattedInput = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        StringTokenizer st = new StringTokenizer(userInput, "()^+-*/=", true);

        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (!token.equals("=")) {
                formattedInput.add(token);
            }
        }
        System.out.println(formattedInput.toString());

        for (String newToken : formattedInput) {

            if (newToken.equals("(")) {
                operators.push(newToken);

            } else if (newToken.equals(")")) {
                //fixed this condition from v1
                while (!operators.isEmpty() && !operators.peek().equals("(")) {
                    output.add(operators.pop());
                }
                operators.pop();


            } else if (newToken.equals("^")) {
                operators.push(newToken);

            } else if (newToken.equals("+") || newToken.equals("-")) {
                while (!operators.isEmpty() && (operators.peek().equals("*") || operators.peek().equals("/") || operators.peek().equals("^") || operators.peek().equals("+") || operators.peek().equals("-"))) {
                    output.add(operators.pop());
                }
                operators.push(newToken);

            } else if (newToken.equals("*") || newToken.equals("/")) {
                while (!operators.isEmpty() && (operators.peek().equals("^") || operators.peek().equals("*") || operators.peek().equals("/"))) {
                    output.add(operators.pop());
                }
                operators.push(newToken);

            } else {
                output.add(newToken);
            }

        }

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
