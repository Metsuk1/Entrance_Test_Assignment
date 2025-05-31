package tests;

import entity.Evaluator;
import java.util.Scanner;

public class EvaluatorTest {
    public static void starter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("**********************************************");
        System.out.println("Arithmetic Expression Evaluator Test");
        System.out.println("**********************************************");

        System.out.print("Enter the expression: ");
        String input = scanner.nextLine();

        try {
            double result = Evaluator.evaluate(input);
            System.out.println("Result: " + (result % 1 == 0 ? (int) result : result));
        } catch (Exception e) {
            System.out.println("Calculation error: " + e.getMessage());
        }
    }
}
