package org.heasy.other;

/**
 * @author wyh
 * @date 2021/8/23 19:37
 **/
public class S168 {

    public static String convertToTitle(int columnNumber) {
        int a = 'A';
        int sum = 26;
        StringBuilder builder = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            final int i = columnNumber % sum;
            final char c = (char) (i + a);
            builder.append(c);
            columnNumber = columnNumber / sum;
        }


        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(52));
    }
}
