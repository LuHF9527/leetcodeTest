package xyz.highphone.leetcode.easy;

/**
 * 389. 找不同
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 *
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t 中被添加的字母。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * 示例 2：
 *
 * 输入：s = "", t = "y"
 * 输出："y"
 * 示例 3：
 *
 * 输入：s = "a", t = "aa"
 * 输出："a"
 * 示例 4：
 *
 * 输入：s = "ae", t = "aea"
 * 输出："a"
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 1000
 * t.length == s.length + 1
 * s 和 t 只包含小写字母
 */
public class Test389 {
    public static void main(String[] args) {
        String s = "abdsahsda";
        String t = "abdsahsdar";

        System.out.println(new Test389().findTheDifference(s, t));
    }

    public char findTheDifference(String s, String t) {
        assert s != null && t != null;
        /*int [] charCnt = new int[26];
        for(char ch : s.toCharArray())
        {
            charCnt[ch - 'a'] ++;
        }
        for(char ch : t.toCharArray())
        {
            charCnt[ch - 'a'] ++;
        }
        for (int i = 0; i < charCnt.length; i++) {
            if(charCnt[i] % 2 != 0)
            {
                return (char)(i + 'a');
            }
        }
        return 0;*///no char found
        //别人的思路，有被秀到^-^。    ·
        int res = 0;
        for(char ch : (s + t).toCharArray())
        {
            res ^= ch;
        }
        return Character.valueOf((char) res);
    }
}
