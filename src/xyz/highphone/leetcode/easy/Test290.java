package xyz.highphone.leetcode.easy;

import com.sun.deploy.util.StringUtils;
import sun.awt.SunHints;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 290. 单词规律
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 *
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 *
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 *
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 *
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
 */
public class Test290 {
    public static void main(String[] args) {
        String pattern = "abba";
        String str = "dog dog dog dog";
        System.out.println(new Test290().wordPattern(pattern, str));
    }


    public boolean wordPattern(String pattern, String s) {
        boolean res = false;
        if(pattern != null && s != null)
        {
            char[] patterns = pattern.toCharArray();
            String[] strs = s.split(" ");
            if(patterns.length == strs.length && patterns.length > 0)
            {
                HashMap<String, String> checkStrMap = new HashMap<>();
                HashMap<String, String> checkPatternMap = new HashMap<>();
                checkStrMap.put(String.valueOf(patterns[0]), strs[0]);
                checkPatternMap.put(strs[0], String.valueOf(patterns[0]));

                for (int i = 1; i < patterns.length; i++) {
                    if(check(checkStrMap, String.valueOf(patterns[i]), strs[i]) || check(checkPatternMap, strs[i], String.valueOf(patterns[i])))
                    {
                        return  false;
                    }
                    else {
                        checkStrMap.put(String.valueOf(patterns[i]), strs[i]);
                        checkPatternMap.put(strs[i], String.valueOf(patterns[i]));
                    }
                }
                res =true;
            }
        }
        return res;
    }

    public boolean check(HashMap<String, String> map, String key, String value)
    {
        if(map.get(key) != null && !map.get(key).equals(value))
            return true;
        return false;
    }


}
