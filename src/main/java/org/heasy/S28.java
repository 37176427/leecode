package org.heasy;

/**
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * @author wyh
 * @date 2020/6/30 16:47
 **/
public class S28 {

    /**
     * kmp算法
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        if ("".equals(haystack) || "".equals(needle)) {
            return 0;
        }
        int n = needle.length();
        int m = haystack.length();
        int[] prefix = new int[n];
        char[] tChars = haystack.toCharArray();
        char[] pChars = needle.toCharArray();
        //构造前缀表
        prefixTable(pChars, prefix, n);

        int i = 0, j = 0;
        while (i < m) {
            if (tChars[i] == pChars[j]) {
                i++;
                j++;
                //如果最后一位也匹配了 代表找到子串
                if (j == n) {
                    return i - j;
                }
            } else {
                //通过前缀表 找到模式串移动后的位置j
                j = prefix[j];
                //如果移动后的j 在第一位 代表全部不相等 令i、j都增长 j变为0 i变为下一位 从text的i位置 模式串的0匹配
                if (j == -1) {
                    i++;
                    j++;
                }
            }
        }
        return -1;
    }

    private void prefixTable(char[] pattern, int[] prefix, int n) {
        //第一位先设置为0 单个字符的最长前后缀没有作用
        prefix[0] = 0;
        //当前最长长度
        int len = 0;
        //从第一位开始
        int i = 1;
        while (i < n) {
            //如果模式串当前字符和长度下标对应字符相等 代表当前字符串最长前缀比上一个串多1
            //例 aba -> abab len=1 (aba最长前后缀是1) pattern[i]='b' pattern[len]='b' 相等
            //则len=2(abab最长前后缀是2)
            if (pattern[i] == pattern[len]) {
                len++;
                prefix[i] = len;
                i++;
            } else {
                if (len > 0) {
                    len = prefix[len - 1];
                } else {
                    prefix[i] = len;
                    i++;
                }
            }
        }
        //将前缀表后移一位 第一位补充-1 抛弃最后一位(最后一位代表整个模式串 其前后缀长度使用不到)
        for (int k = n - 1; k > 0; k--) {
            prefix[k] = prefix[k - 1];
        }
        prefix[0] = -1;
    }
}
