public class TwoVariablesCalculator implements ITwoVariablesCalculator {

    public String executeExpression(String input) throws TwoVariablesCalcException {
        int[] values = getIntegerValues(input);
        return Integer.toString(doOperation(values[0], values[1], getOperation(input)));
    }

    public int[] getIntegerValues(String input) throws TwoVariablesCalcException {
        String[] values = input.replace(" ", "").split("(\\W)");
        // Обработка исключения
        if(!values[0].matches("\\d") | !values[1].matches("\\d")) {
            throw new TwoVariablesCalcException("Используются две системы счисления одновременно");
        } else if (values.length > 2) {
            throw new TwoVariablesCalcException("Математический формат операции не удовлетворяет заданию");
        }
        //
        return new int[]{Integer.parseInt(values[0]), Integer.parseInt(values[1])};
    }

    public Operation getOperation(String inputOperation) {
        return switch (inputOperation.replaceAll("(\\w)", "").replaceAll(" ", "")) {
            case "+" -> Operation.PLUS;
            case "-" -> Operation.MINUS;
            case "*" -> Operation.MULTIPLY;
            case "/" -> Operation.DIVIDE;
            default -> throw new IllegalStateException("Unexpected value");
        };
    }

    public int doOperation(int a, int b, Operation operation) throws TwoVariablesCalcException {
        // Обработка исключения
        if (a > 10 | a < 1 | b > 10 | b < 1) {
            throw new TwoVariablesCalcException("Введенное значение выше 10 или меньше 1");
        }
        //
        return switch (operation) {
            case PLUS -> a + b;
            case MINUS -> a - b;
            case DIVIDE -> a / b;
            case MULTIPLY -> a * b;
        };
    }

}

