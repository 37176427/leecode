package org.heasy;

/**
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
 *
 * 注意：整数序列中的每一项将表示为一个字符串。
 *
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 第一项是数字 1
 *
 * 描述前一项，这个数是 1 即 “一个 1 ”，记作 11
 *
 * 描述前一项，这个数是 11 即 “两个 1 ” ，记作 21
 *
 * 描述前一项，这个数是 21 即 “一个 2 一个 1 ” ，记作 1211
 *
 * 描述前一项，这个数是 1211 即 “一个 1 一个 2 两个 1 ” ，记作 111221
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-and-say
 * @author wyh
 * @date 2020/8/11 15:50
 **/
public class S38 {

    public String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            s = count(s);
        }
        return s;
    }

    private String count(String s) {
        if (s.isEmpty()) return "";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int count = 0;
            char c = s.charAt(i);
            for (int j = i; j < s.length(); j++) {
                if (c == s.charAt(j)) {
                    i++;
                    count++;
                } else {
                    i--;
                    break;
                }
            }
            result.append(count).append(c);
        }
        return result.toString();
    }
}
