import java.util.Scanner;

public class Main {

    public static void main(String... args) throws TwoVariablesCalcException {
        System.out.println("������� ��������� � ���� ������ ����: ");
        System.out.println("�����: " + calc(new Scanner(System.in).nextLine()));
    }

    public static String calc(String input) throws TwoVariablesCalcException {
        if (!input.replaceAll(" ", "").replaceAll("(\\W)", "").matches("(.*)(\\d)(.*)")) {
            return new RomanNumeralsCalculator().executeExpression(input);
        }
        return new TwoVariablesCalculator().executeExpression(input);
    }


}
