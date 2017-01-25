import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Stack;

public class PrE11InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String infix = scanner.nextLine();
        System.out.printf("%.2f%n", round(postFixToint(infixToPostfix(infix)), 2));
    }

    static String infixToPostfix(String infix) {
        final String ops = "-+/*^";
        StringBuilder sb = new StringBuilder();
        Stack<Integer> s = new Stack<>();

        for (String token : infix.split("\\s")) {
            if (token.isEmpty())
                continue;
            char c = token.charAt(0);
            int idx = ops.indexOf(c);

            // check for operator
            if (idx != -1) {
                if (s.isEmpty())
                    s.push(idx);

                else {
                    while (!s.isEmpty()) {
                        int prec2 = s.peek() / 2;
                        int prec1 = idx / 2;
                        if (prec2 > prec1 || (prec2 == prec1 && c != '^'))
                            sb.append(ops.charAt(s.pop())).append(' ');
                        else break;
                    }
                    s.push(idx);
                }
            } else if (c == '(') {
                s.push(-2); // -2 stands for '('
            } else if (c == ')') {
                // until '(' on stack, pop operators.
                while (s.peek() != -2)
                    sb.append(ops.charAt(s.pop())).append(' ');
                s.pop();
            } else {
                sb.append(token).append(' ');
            }
        }
        while (!s.isEmpty())
            sb.append(ops.charAt(s.pop())).append(' ');
        return sb.toString();
    }

    static double postFixToint(String str){
        ArrayDeque<Double> queue = new ArrayDeque<>();
        final String ops = "-+/*";//^

        for (String token: str.split("\\s")){
            char c = token.charAt(0);
            int operatorIndex = ops.indexOf(c);
            if(token.equals(" ")){
                continue;
            }
            if(operatorIndex == -1){
                queue.add(Double.parseDouble(token));
            }
            else{
                double tmp = queue.removeLast();
                if(c == '*'){
                    double retVal = queue.removeLast() * tmp;
                    queue.addLast(retVal);
                }
                if(c == '-'){
                    double retVal = queue.removeLast() - tmp;
                    queue.addLast(retVal);
                }
                if(c == '+'){
                    double retVal = queue.removeLast() + tmp;
                    queue.addLast(retVal);
                }
                if(c == '/'){
                    double secTmp = queue.removeLast();
                    double retVal = secTmp / tmp;
                    queue.addLast(retVal);
                }
            }
        }
        return queue.pop();
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}


