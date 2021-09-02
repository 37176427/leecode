package org.heasy.other;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wyh
 * @date 2021/8/30 19:15
 **/
public class S204 {

    public static int countPrimes(int n) {
        int r = 0;
        int[] array = new int[n];
        Arrays.fill(array, 1);
        for (int i = 2; i < n; i++) {
            if (array[i] == 1) {
                r++;
                for (long j = (long) i * i; j < n; j += i) {
                    array[(int) j] = 0;
                }
            }
        }
        return r;
    }

    public static void main(String[] args) {
        final long l = System.currentTimeMillis();
        System.out.println(countPrimes(5000000));
        final long e = System.currentTimeMillis();
        System.out.println(e - l);
    }
}
