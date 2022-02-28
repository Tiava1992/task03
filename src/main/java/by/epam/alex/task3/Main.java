package by.epam.alex.task3;

public class Main {
    public static void main(String[] args) {
        Calculator calc=new Calculator();
        InputExpression inputExpression= new InputExpression();
        ViewResult vr=new ViewResult();

       vr.result(calc.rpn(calc.expression(inputExpression.getExpression())));
       //System.out.println(Calculator.expression("2*(3-2)+(1+2)*10"));
         //   System.out.println(Calculator.rpn(Calculator.expression("2*(3-2)+(1+2)*10")));
    }

}
