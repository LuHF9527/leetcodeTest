package xyz.highphone.leetcode.easy;

/**
 * 125. 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 */
public class Test125 {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(new Test125().isPalindrome(s));
    }

    public boolean isPalindrome(String s) {
        if(null == s) return false;
        if("".equals(s)) return true;
        char[] chars = s.toCharArray();
        for(int i = 0, j = chars.length -1; i < j;)
        {
            while(!isNumOrCharacter(chars[i]) && i < j) i++;
            while(!isNumOrCharacter(chars[j]) && i < j) j--;
            if(Character.toUpperCase(chars[i]) == Character.toUpperCase(chars[j]))
            {
                i++;
                j--;
            }
            else
            {
                return false;
            }
        }
        return true;
    }

    public boolean isNumOrCharacter(char c)
    {
        if((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9'))
            return true;
        return false;
    }
}
