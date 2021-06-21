package org.heasy;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 *
 * @author wyh
 * @date 2021/6/21 17:24
 **/
public class S9 {


    public static boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }
        if (x < 0) {
            return false;
        }
        int tmp = x;

        int log10 = Double.valueOf(Math.log10(tmp)).intValue();
        if (log10 <= 0) {
            return true;
        }
        while (tmp != 0) {
            int pow = Double.valueOf(Math.pow(10, log10)).intValue();
            int a = tmp / pow;
            int b = tmp % 10;
            if (a != b) {
                return false;
            }
            tmp = tmp - pow * a;
            tmp = tmp / 10;
            log10 -= 2;
        }

        return true;
    }

    public static void main(String[] args) {
//        System.out.println(isPalindrome(1000021));
        Map<String,String> map = new HashMap<>(8);
        for (int i = 1;i < 8;i++){
            map.put(String.valueOf(i),String.valueOf(i));
            System.out.println(map.size());
        }
    }
}
