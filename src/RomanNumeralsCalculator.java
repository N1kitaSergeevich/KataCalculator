public class RomanNumeralsCalculator extends TwoVariablesCalculator {

    @Override
    public String executeExpression(String input) throws TwoVariablesCalcException {
        return RomanNumeral.getNameByArabicNumber(Integer.parseInt(super.executeExpression(input)));
    }

    @Override
    public int[] getIntegerValues(String input) throws TwoVariablesCalcException {
        String[] inputValues = input.replace(" ", "").split("(\\W)");
        // ��������� ����������
        if (inputValues[0].matches("(\\d)") | inputValues[1].matches("\\d")) {
            throw new TwoVariablesCalcException("������������ ��� ������� ��������� ������������");
        } else if (inputValues.length > 2) {
            throw new TwoVariablesCalcException("�������������� ������ �������� �� ������������� �������");
        }
        //
        return new int[]{RomanNumeral.getArabicNumberByName(inputValues[0]), RomanNumeral.getArabicNumberByName(inputValues[1])};
    }

    @Override
    public int doOperation(int a, int b, Operation operation) throws TwoVariablesCalcException {
        int result = super.doOperation(a, b, operation);
        // ��������� ����������
        if (result < 0) {
            throw new TwoVariablesCalcException("� ������� ������� ��� ������������� �����");
        }
        //
        return result;
    }

}
