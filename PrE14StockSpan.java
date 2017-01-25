import java.util.Scanner;
import java.util.Stack;

public class PrE14StockSpan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int stocks[] = new int[n];
        for (int i = 0; i < n; i++) {
            stocks[i] = scanner.nextInt();
        }
        stocks = ssp(stocks);
        for (int stock: stocks){
            System.out.println(stock);
        }
    }
    public static int[] ssp(int[]stocks){
        int[]span = new int[stocks.length];

        //The stack stores last day with a stock greater than this day
        Stack<Integer>days = new Stack<Integer>();

        days.push(0);
        span[0] = 1;
        for(int i = 1 ; i < stocks.length ; i++){

            while(!days.isEmpty() && stocks[days.peek()]<=stocks[i]){
                days.pop();
            }

            if(!days.isEmpty())
                span[i] = i - days.peek();
            else
                span[i] = 1;
            days.push(i);

        }

        return span;

    }
}
