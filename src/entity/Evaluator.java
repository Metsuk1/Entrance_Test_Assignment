package entity;

public class Evaluator {
    private static String input;
    private static int pos;

    public static double evaluate(String expr) {
        input = expr.replaceAll("\\s+", ""); // удаляем пробелы
        pos = 0;
        double result = parseExpression();
        if (pos < input.length()) {
            throw new RuntimeException("Unexpected symbol: " + input.charAt(pos));
        }
        return result;
    }

    private static double parseExpression() {
        double result = parseTerm();
        while (pos < input.length()) {
            char op = input.charAt(pos);
            if (op == '+' || op == '-') {
                pos++;
                double term = parseTerm();
                result = (op == '+') ? result + term : result - term;
            } else {
                break;
            }
        }
        return result;
    }

    private static double parseTerm() {
        double result = parseFactor();
        while (pos < input.length()) {
            char op = input.charAt(pos);
            if (op == '*' || op == '/') {
                pos++;
                double factor = parseFactor();
                if (op == '*') {
                    result *= factor;
                } else {
                    if (factor == 0) {
                        throw new ArithmeticException("Division by zero");
                    }
                    result /= factor;
                }
            } else {
                break;
            }
        }
        return result;
    }

    private static double parseFactor() {
        if (pos >= input.length()) {
            throw new RuntimeException("A number or bracket was expected");
        }

        char ch = input.charAt(pos);

        // Унарный минус
        if (ch == '-') {
            pos++;
            return -parseFactor();
        }

        // Скобки
        if (ch == '(') {
            pos++;
            double value = parseExpression();
            if (pos >= input.length() || input.charAt(pos) != ')') {
                throw new RuntimeException("Missing closing parenthesis");
            }
            pos++;
            return value;
        }

        // Число
        StringBuilder number = new StringBuilder();
        while (pos < input.length() &&
                (Character.isDigit(input.charAt(pos)) || input.charAt(pos) == '.')) {
            number.append(input.charAt(pos++));
        }

        if (number.length() == 0) {
            throw new RuntimeException("Number expected");
        }

        return Double.parseDouble(number.toString());
    }
}
