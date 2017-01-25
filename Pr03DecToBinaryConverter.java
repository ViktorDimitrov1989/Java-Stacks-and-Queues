import java.util.ArrayDeque;
import java.util.Scanner;

public class Pr03DecToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long num = Long.parseLong(scanner.nextLine());
        if(num == 0){
            System.out.println(0);
            return;
        }

        ArrayDeque<Long> stack = new ArrayDeque<>();
        long rem = 0;
        while (num != 0){
            rem = num % 2;
            stack.push(rem);
            num /= 2;
        }

        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }
}
