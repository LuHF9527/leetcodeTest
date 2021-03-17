package xyz.highphone.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 *
 *
 * 示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 *
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 *
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *
 *
 * 提示：
 *
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 */
public class Test17 {
    private List<String> res;
    public static void main(String[] args) {
        String digits = "234";
        Test17 test = new Test17();
        test.letterCombinations(digits);
        for (String re : test.res) {
            System.out.println(re);
        }

    }

    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if(null != digits && !"".equals(digits))
        {
            findLetterCombinations(digits,0, "");
        }
        return res;
    }

    public void findLetterCombinations(String digits, int index, String s)
    {
        if(index == digits.length())
        {
            res.add(s);
            return;
        }
        char thisCh = digits.charAt(index);
        char[] letters = getLettersByChar(thisCh).toCharArray();
        for (int i = 0; i < letters.length; i++) {
            findLetterCombinations(digits, index + 1, s + letters[i]);
        }
        return;
    }

    public String getLettersByChar(char ch)
    {
        String letters = "";
        switch (ch){
            case '2':
                letters = "abc";
                break;
            case '3':
                letters = "def";
                break;
            case '4':
                letters = "ghi";
                break;
            case '5':
                letters = "jkl";
                break;
            case '6':
                letters = "mno";
                break;
            case '7':
                letters = "pqrs";
                break;
            case '8':
                letters = "tuv";
                break;
            case '9':
                letters = "wxyz";
                break;
            default:
                break;
        }
        return letters;
    }


}
