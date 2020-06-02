package org.heasy;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * <p>
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wyh
 * @date 2020/6/2 16:39
 **/
public class S16 {

    static public int threeSumClosest(int[] nums, int target) {

        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {

                int sum = nums[i] + nums[l] + nums[r];

                //当前和与目标值的差 要使其尽量为0
                int c = sum - target;
                if (c == 0) {
                    return target;
                } else if (c < 0) {
                    l++;
                    while (l < r && nums[l - 1] == nums[l]) {
                        l++;
                    }
                } else {
                    r--;
                    while (l < r && nums[r + 1] == nums[r]) {
                        r--;
                    }
                }
                c = Math.abs(c);
                if (c < min){
                    res = sum;
                    min = c;
                }

            }
        }

        return res;

    }


    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2};
        int i = threeSumClosest(nums, 3);
        System.out.println(i);

    }
}
