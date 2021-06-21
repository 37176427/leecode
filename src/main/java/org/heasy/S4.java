package org.heasy;

import java.util.HashMap;
import java.util.Map;

/**
 * Z字变换
 *
 * @author wyh
 * @date 2021/6/21 16:13
 **/
public class S4 {

    public String convert(String s, int numRows) {
        if (numRows == 1){
            return s;
        }
        char[][] arr = new char[numRows][s.length()];
        int cur = 0;
        boolean inc = true;
        final char[] chars = s.toCharArray();
        Map<Integer, Integer> map = new HashMap<>(numRows);
        for (int i = 0; i < chars.length; i++) {
            map.merge(cur, 0, (ov, nv) -> ov + 1);
            //找到数组要写的二级索引
            int ai = map.get(cur);
            arr[cur][ai] = chars[i];
            if (inc) {
                cur++;
                if (cur == numRows) {
                    cur -= 2;
                    inc = false;
                }
            } else {
                cur--;
                if (cur < 0) {
                    cur += 2;
                    inc = true;
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int ai = 0;
            while (ai < arr[i].length && arr[i][ai] != '\u0000') {
                builder.append(arr[i][ai]);
                ai++;
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        final S4 s4 = new S4();
        final String convert = s4.convert("AB", 1);
        System.out.println(convert);
    }

}
