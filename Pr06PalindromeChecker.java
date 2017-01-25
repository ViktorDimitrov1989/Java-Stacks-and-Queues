import java.util.ArrayDeque;
import java.util.Scanner;

public class Pr06PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<Character> queue = new ArrayDeque<>();

        for (char ch: input.toCharArray()){
            queue.add(ch);
        }

        while (queue.size() > 1){
            char first = queue.removeFirst();
            char last = queue.removeLast();
            if(first != last) {
                System.out.println("false");
                return;
            }
        }
        System.out.println("true");
    }
}
