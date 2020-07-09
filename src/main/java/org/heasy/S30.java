package org.heasy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 * 示例 1：
 *
 * 输入：
 *   s = "barfoothefoobarman",
 *   words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 *
 * 输入：
 *   s = "wordgoodgoodgoodbestword",
 *   words = ["word","good","best","word"]
 * 输出：[]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
 * @author wyh
 * @date 2020/7/9 11:53
 * 执行用时：
 * 910 ms
 * , 在所有 Java 提交中击败了
 * 6.87%
 * 的用户
 * 内存消耗：
 * 40.9 MB
 * , 在所有 Java 提交中击败了
 * 12.50%
 * 的用户
 **/
public class S30 {

    public static List<Integer> findSubstring(String s, String[] words) {
        int length = 0;
        for (String word : words){
            length += word.length();
        }
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() < length || s.length() == 0 || length == 0){
            return list;
        }
        for (int i=0;i<=s.length() - length;i++){
            String macthStr= s.substring(i, i + length);
            boolean match = match(macthStr, words);
            if (match){
                list.add(i);
            }
        }
        return list;
    }

    private static boolean match(String str,String[] words){
        String tmp = str;
        List<String> list = new ArrayList<>(Arrays.asList(words));
        while (tmp.length()>0){
            boolean has = false;
            for(int i=0;i<list.size();i++){
                if (tmp.startsWith(list.get(i))){
                    tmp = tmp.replaceFirst(list.get(i),"");
                    list.remove(i);
                    has = true;
                }
            }
            if (!has){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        //"ababaab"
        //["ab","ba","ba"]
        String s = "foobarthe";
        String[] words = {"bar","foo","the"};
        System.out.println(match(s,words));
//        System.out.println(findSubstring(s,words));
    }
}
