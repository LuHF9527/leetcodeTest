package xyz.highphone.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 217. 存在重复元素
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 */
public class Test247 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(new Test247().containsDuplicate(nums));
    }

    public boolean containsDuplicate(int[] nums) {
        if(nums != null && nums.length > 1)
        {
            Arrays.sort(nums);
            Map<Integer, Integer> duplicate = new HashMap<>();
            for (int i = 0; i < nums.length -1; i++) {
                if(nums[i] == nums[i+1])
                    return true;
            }
//            Map<Integer, Integer> duplicate = new HashMap<>();
//            for (int i = 0; i < nums.length; i++) {
//                int cntI = duplicate.get(nums[i]) != null ? duplicate.get(nums[i]) + 1 : 1;
//                duplicate.put(nums[i],cntI);
//            }
//            for(Integer cnt : duplicate.values())
//            {
//                if(cnt > 1)
//                    return true;
//            }
        }
        return false;
    }
}
