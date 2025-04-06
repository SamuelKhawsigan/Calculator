import java.util.Scanner;


public class calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        System.out.println("Java CLI Calculator");
        System.out.println("-------------------");

        while (true) { // Loop for continuous calculations
            try {
                // Input
                System.out.print("Enter first number (or 'q' to quit): ");
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("q")) break;
                double num1 = Double.parseDouble(input);

                System.out.print("Enter operator (+, -, *, /): ");
                char operator = scanner.nextLine().charAt(0);

                System.out.print("Enter second number: ");
                double num2 = Double.parseDouble(scanner.nextLine());

                // Calculation
                double result = calculate(num1, operator, num2);
                System.out.printf("Result: %.2f %c %.2f = %.2f\n", num1, operator, num2, result);

            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
            System.out.println("----------------------------");
        }
        scanner.close();
        System.out.println("Calculator closed.");
    }

    private static double calculate(double num1, char operator, double num2) {
        switch (operator) {
            case '+': return num1 + num2;
            case '-': return num1 - num2;
            case '*': return num1 * num2;
            case '/': 
                if (num2 == 0) throw new ArithmeticException("Cannot divide by zero!");
                return num1 / num2;
            default: throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
