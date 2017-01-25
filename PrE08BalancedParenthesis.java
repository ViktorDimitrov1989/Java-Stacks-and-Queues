import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class PrE08BalancedParenthesis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if(ch == '('
                    || ch == '{'
                    || ch == '['
                    || ch == ' ' && i  < (input.length() - 1) / 2){
                stack.push(ch);
            }
            else{
                if(stack.isEmpty()){
                    System.out.println("NO");
                    return;
                }
                char elementToCompare = stack.removeFirst();
                if(ch == ')'){
                    if(elementToCompare != '('){
                        System.out.println("NO");
                        return;
                    }
                }
                else if(ch == '}'){
                    if(elementToCompare != '{'){
                        System.out.println("NO");
                        return;
                    }
                }
                else if(ch == ']'){
                    if(elementToCompare != '['){
                        System.out.println("NO");
                        return;
                    }
                }
                else if(Character.isWhitespace(ch)){
                    if(!Character.isWhitespace(ch)){
                        System.out.println("NO");
                        return;
                    }
                }
            }
        }
        System.out.println("YES");

    }

}
