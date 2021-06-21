package org.heasy;

/**
 * 最长回文子串 中心扩散法 遍历每一个下标 分别扩散
 *
 * @author wyh
 * @date 2021/6/21 15:52
 **/
public class S3 {
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        final char[] array = s.toCharArray();
        int start = 0;
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            int l = i, r = i;
            //找相同 全部相同的字符串 不管长度多少都是回文串
            while (l >= 0 && array[l] == array[i]) {
                l--;
            }
            while (r < array.length && array[r] == array[i]) {
                r++;
            }

            //向左右扩散
            while (l >= 0 && r < array.length) {
                if (array[l] == array[r]) {
                    l--;
                    r++;
                } else {
                    break;
                }
            }
            //到这一步 下标为l 和r的两个字符不相等 或超出范围 所以回文串实际下标为l+1 r-1
            if (r - l - 2 > max) {
                max = r - l - 2;
                start = l + 1;
            }

        }
        return s.substring(start, start + max + 1);
    }
}
