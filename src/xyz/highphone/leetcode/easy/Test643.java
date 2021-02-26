package xyz.highphone.leetcode.easy;

import java.time.temporal.Temporal;

/**
 * 643. 子数组最大平均数 I
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 *
 *
 *
 * 示例：
 *
 * 输入：[1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 *
 *
 * 提示：
 *
 * 1 <= k <= n <= 30,000。
 * 所给数据范围 [-10,000，10,000]。
 */
public class Test643 {

    public static void main(String[] args) {
        int[] nums = {9,7,3,5,6,2,0,8,1,9};
        int k = 1;
        System.out.println(new Test643().findMaxAverage(nums,k));

    }

    public double findMaxAverage(int[] nums, int k) {
        int len = nums.length;
        double sum = 0;
        for(int i = 0; i < k; i++)
        {
            sum += nums[i];
        }
        double temp = sum;
        for(int x = 1, y = k; y < len; x++, y++)
        {
            temp = temp - nums[x - 1] + nums[y];
            if(temp > sum)
            {
                sum = temp;
            }
        }
        return sum / k;
    }
}
