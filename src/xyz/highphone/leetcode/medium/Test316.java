package xyz.highphone.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.ResourceBundle;

/**
 * 316. 去除重复字母
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 *
 * 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "bcabc"
 * 输出："abc"
 * 示例 2：
 *
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 */
public class Test316 {
    public static void main(String[] args) {
        String s = "cbacdcbc";
        System.out.println(new Test316().removeDuplicateLetters(s));
    }

    public String removeDuplicateLetters(String s) {
        StringBuilder res = new StringBuilder();
        if(s != null && s.length() > 0)
        {
            int[] lastIndex = new int[26];
            char[] chars = s.toCharArray();
            int len = s.length();
            for (int i = 0; i < len; i++) {
                lastIndex[chars[i] - 'a'] = i;
            }
            boolean[] exists = new boolean[26];
            Deque<Character> stack = new ArrayDeque<>();

            for (int i = 0; i < len; i++) {
                if(exists[chars[i] - 'a'])
                {
                    continue;
                }
                while(!stack.isEmpty() && stack.peekLast() > chars[i] && lastIndex[stack.peekLast() -'a'] > i)
                {
                    Character top = stack.removeLast();
                    exists[top - 'a'] = false;
                }
                stack.addLast(chars[i]);
                exists[chars[i] - 'a'] = true;
            }
            for (Character character : stack) {
                res.append(character);
            }
        }

        return res.toString();
    }
}
