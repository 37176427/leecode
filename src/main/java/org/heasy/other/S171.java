package org.heasy.other;

/**
 * @author wyh
 * @date 2021/8/24 19:29
 **/
public class S171 {

    public static int titleToNumber(String columnTitle) {
        final char[] chars = columnTitle.toCharArray();
        int s = 0;
        for (char c : chars){
            int a = c - 'A' + 1;
            s = s * 26 + a;
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("FXSHRXW"));
    }
}
