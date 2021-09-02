package org.heasy.other;

/**
 * @author wyh
 * @date 2021/8/9 17:33
 **/
public class S125 {


    public static boolean isPalindrome(String s) {
        final char[] array = s.toLowerCase().toCharArray();
        char[] arr = new char[array.length];
        int i = 0;
        for (char c : array) {
            if ((c >= 48 && c <= 57) || (c >= 97 && c <= 122)) {
                arr[i++] = c;
            }
        }
        for (int j = 0; j < (i / 2); j++) {
            if (arr[j] != arr[i - 1 - j]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(a));
    }
}
