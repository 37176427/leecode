package org.heasy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * <p>
 * 答案中不可以包含重复的四元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * <p>
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 *
 * @author wyh
 * @date 2020/6/3 16:59
 **/
public class S18 {

    /**
     * 参考了三数之和 主要是如何去重
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length < 4) return list;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] > target) break;
            if (i > 0 && nums[i - 1] == nums[i]) continue;

            for (int j = i + 1; j < nums.length; j++) {
                if (j > i+1 && nums[j - 1] == nums[j]) continue;
                int l = j + 1, r = nums.length - 1;
                while (l < r) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target) {
                        List<Integer> subList = new ArrayList<>();
                        subList.add(nums[i]);
                        subList.add(nums[j]);
                        subList.add(nums[l]);
                        subList.add(nums[r]);
                        list.add(subList);
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    } else if (sum < target) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return list;


    }


    public static void main(String[] args) {
        //[1,-2,-5,-4,-3,3,3,5]  -11
        //[-3,-2,-1,0,0,1,2,3] 0
        //[0,0,0,0] 0
        //[-1,-5,-5,-3,2,5,0,4]  -7
        //[-1,0,1,2,-1,-4]  -1   -4 -1 -1 0 1 2
        int[] s = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> list = fourSum(s, -1);
        System.out.println(list);

    }

}
