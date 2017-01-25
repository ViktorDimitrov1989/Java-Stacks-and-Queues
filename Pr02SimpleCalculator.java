import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class Pr02SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");

        ArrayDeque<String> stack = new ArrayDeque<>();
        Collections.addAll(stack,input);

        while (stack.size() > 1){
            int first = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int sec = Integer.parseInt(stack.pop());

            int res = 0;
            if(operator.equals("+")){
                res = first + sec;
                stack.push(res + "");
            }
            else{
                res = first - sec;
                stack.push(String.valueOf(res));
            }
        }
        System.out.println(stack.pop());
    }
}
