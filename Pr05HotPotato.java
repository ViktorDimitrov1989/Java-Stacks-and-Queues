import java.util.ArrayDeque;
import java.util.Scanner;

public class Pr05HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        ArrayDeque<String> queue = new ArrayDeque<>();
        int n = scanner.nextInt();

        for (String name : input) {
            queue.offer(name);
        }

        int cicle = 1;
        while (queue.size() > 1) {
            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());
            }

            if (isPrime(cicle)) {
                System.out.println("Prime " + queue.peek());
            } else {
                System.out.println("Removed " + queue.poll());
            }
            cicle++;
        }
        System.out.println("Last is " + queue.poll());
    }

    private static boolean isPrime(int cicle) {
        if(cicle <= 1){
            return false;
        }

        for (int j = 2; j <= Math.sqrt(cicle); j++) {
            if (cicle % j == 0) {
                return false;
            }
        }
        return true;
    }
}
