package org.heasy.dp;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author wyh
 * @date 2021/8/2 19:00
 **/
public class S122 {
    public static int maxProfit3(int[] prices) {
        Deque<Integer> deque = new ArrayDeque<>();
        int m = 0;
        for (int i = 0; i < prices.length; i++) {
            if (deque.isEmpty()){
                deque.addFirst(prices[i]);
            }else {
                if (deque.peek() > prices[i]){
                    while (!deque.isEmpty() && deque.peek() > prices[i]){
                        deque.pop();
                    }
                }else {
                    m += prices[i] - deque.peek();
                }
            }
        }
        return m;
    }
}
