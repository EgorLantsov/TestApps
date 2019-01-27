import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

interface Operation {
    double calc(double op1, double op2);
}

public class Calculator {
    final static Pattern numberPatt = Pattern.compile("(\\(*-?\\(*\\d+\\)*)(.*)");
    static LinkedList<Calculator> operationsList = new LinkedList<>();
    static LinkedList<Double> numberList = new LinkedList<>();

    private int prior;
    private Operation operation;

    public Calculator(int p, Operation o) {
        prior = p;
        operation = o;
    }

    double calc(double o1, double o2) { return operation.calc(o1,o2); }

    static void calculate(Calculator c) {
        while(operationsList.peek() != c)
            numberList.addFirst(operationsList.poll().calc(numberList.poll(), numberList.poll()));
    }

    static double evaluate(String expr){
        expr = expr.replaceAll(" ","");
        boolean inBrackets = false;
        try {
            for(;;) {

                Matcher m = numberPatt.matcher(expr);
                if(!m.matches())
                    throw new Exception("Not a number");
                if(m.group(1).contains("(")){
                    inBrackets = true;
                    numberList.addFirst(Double.parseDouble(m.group(1).replace("(", "")));
                } else if(m.group(1).contains(")")){
                    inBrackets = false;
                    numberList.addFirst(Double.parseDouble(m.group(1).replace(")", "")));
                } else {
                    numberList.addFirst(Double.parseDouble(m.group(1)));
                }

                expr = m.group(2);

                if(expr.length() == 0)
                    break;

                Calculator c = null;
                switch(expr.charAt(0)) {
                    case '*':  c = new Calculator(inBrackets? 0:1, (op1, op2) -> op2*op1);  break;
                    case '/':  c = new Calculator(inBrackets? 0:1, (op1, op2) -> op2/op1);  break;
                    case '+':  c = new Calculator(inBrackets? 0:2, (op1, op2) -> op2+op1);  break;
                    case '-':  c = new Calculator(inBrackets? 0:2, (op1, op2) -> op2-op1);  break;
                    default:
                        throw new Exception("Not operation");
                }
                operationsList.add(c);
                operationsList.sort((o1, o2) -> o1.prior < o2.prior?-1:1);
                calculate(c);
                expr = expr.substring(1);
            }
            calculate(null);
        } catch(Exception e) {
            System.out.println("Wrong expression");
        }
        return numberList.poll();
    }

    public static void main(String[] args) {
        System.out.println(Calculator.evaluate("(73 - 23) * (8 + 12)"));
    }
}