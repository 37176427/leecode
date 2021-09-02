package org.heasy.dp;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 描述 :121. 买卖股票的最佳时机
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意：你不能在买入股票前卖出股票。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * 作者 : wyh
 * 时间: 2020-03-26 21:33
 */
public class S121 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int buy = prices[0];
        int sell = 0;
        for (int i = 1; i < prices.length; i++) {
            if (buy > prices[i]) {
                buy = prices[i];
            }
            sell = Math.max(sell, prices[i] - buy);
        }
        return sell;
    }


    public static int maxProfit2(int[] prices) {
        if (prices.length < 2){
        	return 0;
		}
        //array存的是当前钱数 等价于题目中说的「利润」，即先买入这只股票，后买入这只股票的差价
        int[][] array = new int[prices.length][2];
        //第一天不持股 0
        array[0][0] = 0;
        //第一天持股 为负数
        array[0][1] = -prices[0];

        for (int i = 1;i<prices.length;i++){
        	//今天不持股 = 最大（ 昨天不持股， 昨天持股今天卖出）
        	array[i][0] = Math.max(array[i-1][0], array[i - 1][1] + prices[i]);
        	//今天持股 = 最大（ 昨天持股 ， 昨天不持股今天买入）注意 只允许交易一次，因此手上的现金数就是当天的股价的相反数
        	array[i][1] = Math.max(array[i-1][1], - prices[i]);
		}
        return array[prices.length-1][0];
    }

	public static int maxProfit3(int[] prices) {
		Deque<Integer> deque = new ArrayDeque<>();
		int m = 0;
		for (int i = 0; i < prices.length; i++) {
			if (!deque.isEmpty()) {
				if (deque.peek() > prices[i]) {
					while (!deque.isEmpty() && deque.peek() > prices[i]) {
						deque.pop();
					}
				} else {
					m += prices[i] - deque.peek();
				}
			}
			deque.addFirst(prices[i]);
		}
		return m;
	}

	public static void main(String[] args) {
		int[] array = new int[]{7,1,5,3,6,4};
		System.out.println(maxProfit3(array));
	}

}
