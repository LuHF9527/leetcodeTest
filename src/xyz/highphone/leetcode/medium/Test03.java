package xyz.highphone.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 *
 * 输入: s = ""
 * 输出: 0
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 5 * 10^4
 * s 由英文字母、数字、符号和空格组成
 */
public class Test03 {

    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(new Test03().lengthOfLongestSubstring(str));
    }

    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        if(s != null && s.length() > 0)
        {
            char[] strs = s.toCharArray();
            int[] charArray = new int[256];
            int i = 0;
            int j = -1;
           while (i < strs.length)
           {
                if(j + 1 < strs.length && charArray[strs[j + 1]] == 0 )
                {
                    charArray[strs[++j]]++;
                }
                else
                {
                    charArray[strs[i++]]--;
                }
                res = Math.max(res, j - i + 1);
           }
        }

        return res;
    }
}
