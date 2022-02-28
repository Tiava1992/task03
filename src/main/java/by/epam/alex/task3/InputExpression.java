package by.epam.alex.task3;

import java.util.Scanner;

public class InputExpression {

    public String getExpression() {
        System.out.println("Введите выражение");
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        return expression;
    }
}
