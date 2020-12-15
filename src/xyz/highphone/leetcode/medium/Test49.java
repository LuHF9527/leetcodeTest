package xyz.highphone.leetcode.medium;

import java.util.*;

/**
 * 49. 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */
public class Test49 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new Test49().groupAnagrams(strs));

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groupString = new ArrayList<>();
        if(strs != null && strs.length > 0)
        {
            Map<String, List<String>> strMap = new HashMap<>();
            for (int i = 0; i < strs.length; i++) {
                char[] str = strs[i].toCharArray();
                Arrays.sort(str);
                String strKey = String.valueOf(str);
                List<String> stringList = strMap.containsKey(strKey) ? strMap.get(strKey) : new ArrayList<>();
                stringList.add(strs[i]);
                strMap.put(strKey, stringList);
            }
            groupString = new ArrayList<>(strMap.values());

        }
        return groupString;
    }

}
