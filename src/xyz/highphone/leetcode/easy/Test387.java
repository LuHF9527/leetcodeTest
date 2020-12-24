package xyz.highphone.leetcode.easy;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 387. 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 *
 *
 * 示例：
 *
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 *
 *
 * 提示：你可以假定该字符串只包含小写字母。
 *
 *
 */
public class Test387 {
    public static void main(String[] args) {

        String s = "loveleetcode";
        System.out.println(new Test387().firstUniqChar(s));
    }

    public int firstUniqChar(String s) {
        int res = -1;
        if(null != s && s.length() > 0)
        {
            int len = s.length();
            char[] chars = s.toCharArray();
            int[] cnt =new int[26];
            for (int i = 0; i < len; i++) {
               cnt[chars[i] - 'a'] ++;
            }
            for (int i = 0; i < len; i++) {
                if(cnt[chars[i] - 'a'] == 1)
                    return i;
            }
        }
        return res;
    }
}
