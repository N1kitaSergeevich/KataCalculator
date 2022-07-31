public interface ITwoVariablesCalculator {

    public String executeExpression(String input) throws TwoVariablesCalcException;

    public int[] getIntegerValues(String input) throws TwoVariablesCalcException;

    public Operation getOperation(String inputOperation);

    public int doOperation(int a, int b, Operation operation) throws TwoVariablesCalcException;

}
