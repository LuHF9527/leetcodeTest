package xyz.highphone.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class Test77 {

    public static void main(String[] args) {
        int n = 4, k = 2;
        System.out.println(new Test77().combine(n, k));
    }

    private List<List<Integer>> res;

    private void findCombinations(int n, int k, int start, List<Integer> subRes)
    {
        if(k == subRes.size())
        {
            //在java中，万物皆对象，所以要new一个新的arraylist去添加到res中，而不是在原subRes对象上操作
            res.add(new ArrayList<>(subRes));
            return;
        }
        //总共有k个数字，已找到的数字已经在subRes中，则剩下的位置还有k-subRes.size()个
        //将n == 4， k == 2, subRes.size()==0代入计算可知，i取值范围是[start, n - ((k - subRes.size()) + 1
        // 所有i的取值范围是[start, n - ()
        for(int i = start; i <= n - (k - subRes.size()) + 1; i ++)
        {
            subRes.add(i);
            findCombinations(n, k , i + 1, subRes);
            subRes.remove(subRes.size() - 1);
        }
        return;
    }

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        if(n <=0 || k <=0 || k > n) return res;
        List<Integer> subRes = new ArrayList<>();
        findCombinations(n, k,1, subRes);
        return res;
    }
}
