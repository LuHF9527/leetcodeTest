package xyz.highphone.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 *205. 同构字符串
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 *
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 示例 1:
 *
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 示例 3:
 *
 * 输入: s = "paper", t = "title"
 * 输出: true
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 */
public class Test205 {

    public static void main(String[] args) {
        String s = "egg";
        String t = "add";
        System.out.println(new Test205().isIsomorphic(s, t));
    }

    public boolean isIsomorphic(String s, String t) {
        if(s != null && t != null && s.length() == t.length())
        {
            int len = s.length();
            Map<Character, Character> sMap = new HashMap<>();
            Map<Character, Character> tMap = new HashMap<>();
            for (int i = 0; i < len; i++) {
                char sChar = s.charAt(i);
                char tChar = t.charAt(i);
                if((sMap.containsKey(sChar) && sMap.get(sChar) != tChar )  || (tMap.containsKey(tChar) && tMap.get(tChar) != sChar ))
                {
                    return false;
                }
                else
                {
                    sMap.put(sChar, tChar);
                    tMap.put(tChar, sChar);
                }
            }
            return true;
        }

        return false;
    }
}
