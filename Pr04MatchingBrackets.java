import java.util.ArrayDeque;
import java.util.Scanner;

public class Pr04MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '('){
                stack.push(i);
            }
            else if (input.charAt(i) == ')'){
                int startIndex = stack.pop();
                int endIndex = i;
                System.out.println(input.substring(startIndex,endIndex + 1));
            }
        }
    }
}
