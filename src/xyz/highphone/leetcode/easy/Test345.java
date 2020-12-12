package xyz.highphone.leetcode.easy;

/**
 * 345. 反转字符串中的元音字母
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 *
 *
 * 示例 1：
 *
 * 输入："hello"
 * 输出："holle"
 * 示例 2：
 *
 * 输入："leetcode"
 * 输出："leotcede"
 *
 *
 * 提示：
 *
 * 元音字母不包含字母 "y" 。
 */
public class Test345 {
    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(new Test345().reverseVowels(s));
    }

    public String reverseVowels(String s) {
        if(s == null || s.length() <= 1)
        {
            return s;
        }
        char[] chars = s.toCharArray();
        for (int i = 0, j = chars.length -1 ; i < j; i++,j--) {
            while(!isVowels(chars[i]) && i < j)
            {
                i++;
            }
            while(!isVowels(chars[j]) && i < j)
            {
                j--;
            }
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
       return String.valueOf(chars);

    }

    public boolean isVowels(char vowels)
    {
        char upperVowels = Character.toUpperCase(vowels);
        if(upperVowels == 'A' || upperVowels == 'E' || upperVowels == 'I' || upperVowels == 'O' || upperVowels == 'U')
            return true;
        return false;

    }
}
