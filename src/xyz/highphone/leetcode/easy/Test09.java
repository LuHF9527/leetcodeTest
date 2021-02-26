package xyz.highphone.leetcode.easy;

public class Test09 {
    public static void main(String[] args) {
        int x = 10;
        System.out.println(new Test09().isPalindrome(x));
    }

    public boolean isPalindrome(int x) {
        String xStr = String.valueOf(x);
        if(xStr.length() > 1)
        {
            int i = 0;
            int j = xStr.length() - 1;
            while (i < j)
            {
                if(xStr.charAt(i++) != xStr.charAt(j--))
                {
                    return false;
                }

            }
        }
        return true;
    }
}
