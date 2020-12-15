package xyz.highphone.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 738. 单调递增的数字
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 *
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 *
 * 示例 1:
 *
 * 输入: N = 10
 * 输出: 9
 * 示例 2:
 *
 * 输入: N = 1234
 * 输出: 1234
 * 示例 3:
 *
 * 输入: N = 332
 * 输出: 299
 * 说明: N 是在 [0, 10^9] 范围内的一个整数。
 */
public class Test738 {

    public static void main(String[] args) {
        int N = 332;
        System.out.println(new Test738().monotoneIncreasingDigits(N));

    }

    public int monotoneIncreasingDigits(int N) {
        int res = 0;
        if(N > 0)
        {
            List<Integer> arraylist = new ArrayList<>();
            while ( N > 0)
            {
                arraylist.add(N % 10);
                N = N /10;
            }
            int size = arraylist.size();
            int to9flag = -1;
            for (int i = 0; i < size -1; i++) {
                if(arraylist.get(i) < arraylist.get(i + 1))
                {
                    arraylist.set(i + 1, arraylist.get(i+1) - 1);
                    to9flag = i;
                }

            }
            for (int i = 0; i < size; i++) {
                if(to9flag != -1 && i <= to9flag)
                {
                    res += Math.pow(10, i) * 9;
                }
                else
                {
                    res += Math.pow(10, i) * arraylist.get(i);
                }
            }


        }

        return res;
    }
}
