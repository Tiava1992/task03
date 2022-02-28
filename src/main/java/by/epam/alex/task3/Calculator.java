package by.epam.alex.task3;

import java.util.Stack;

public class Calculator {

        public static int priority (char token){
            if(token=='*'|| token=='/'){
                return 3;
            } else if( token=='+'|| token=='-'){
                return 2;
            } else if(token=='('){
                return 1;
            } else if(token==')'){
                return -1;
            } else  {
                return 0;
            }
        }

        // разбиваем выражение, +-*.)( - мы скидываем в стэк, паралельно изымая их по приоритету
        // и закидывая в строку; числа в строку
        public static String expression (String expr){
            String current=" ";
            Stack<Character> stack=new Stack<>();


            for(int i=0; i<expr.length(); i++){
                int  position=priority(expr.charAt(i));
                if(position==0){
                    current+=expr.charAt(i);
                }
                else if(position==1){
                    stack.push(expr.charAt(i));
                }
                else if(position>1){
                    current+=" ";
                    while (!stack.empty()){
                        //проверяем приоритет верхнего в стэке знака, если он выше нового
                        if(priority(stack.peek())>=position) {
                            // то мы в строку переносим значение из стэка, паралельно удалив его со стэка
                            current += stack.pop();
                        }
                        else break;
                    }
                    //а в стэк кладем значение с меньшим приоритетом
                    stack.push(expr.charAt(i));
                }
                if(position==-1){
                    current+=" ";
                    //пока приоритете нашего верхнего стэка не равен открывающейся скобки
                    while (priority(stack.peek()) !=1)
                        //закидываем все знаки в строку удаляя их со стэка
                        current+=stack.pop();
                    // и удаляем со стэка открывающуюся скобку
                    stack.pop();
                }
            }
            // и в конце просто скидываем все оставшиеся знаки со стэка в строку
            while (!stack.empty()){
                current+=stack.pop();
            }
            return current;
        }



        public static double rpn(String rpnString){
            Stack<Double> stack=new Stack<>();

            for(int i=0; i<rpnString.length(); i++) {
                if (rpnString.charAt(i) == ' ') {
                    continue;
                }
                if (priority(rpnString.charAt(i)) == 0) {
                    StringBuilder sb=new StringBuilder();
                    do {
                        sb.append(rpnString.charAt(i));
                        i++;
                        if (i == rpnString.length()) {
                            break;
                        }
                    }
                    while ((rpnString.charAt(i) != ' ' && priority(rpnString.charAt(i)) == 0));
                    stack.push(Double.parseDouble(sb.toString()));
                    }


                if(priority(rpnString.charAt(i))>1){
                    double a=stack.pop();
                    double b=stack.pop();
                    if(rpnString.charAt(i) == '+'){
                        stack.push(b+a);
                    }
                    else if(rpnString.charAt(i)=='-'){
                        stack.push(b-a);
                    }
                    else if(rpnString.charAt(i)=='*'){
                        stack.push(b*a);
                    }
                    else if(rpnString.charAt(i)=='/'){
                        stack.push(b/a);
                    }
                }
            }
            return stack.pop();
        }
    }
