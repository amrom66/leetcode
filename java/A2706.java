import java.util.Arrays;

public class A2706 {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int carry = prices[0] + prices[1];
        if(carry > money) return money;
        return money-carry;
    }
}
