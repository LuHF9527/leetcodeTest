package xyz.highphone.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 6
 * 输出:
 * [
 *      [1],            1   0   0   0   0   0           1
 *     [1,1],           1   1   0   0   0   0           2
 *    [1,2,1],          1   2   1   0   0   0           3
 *   [1,3,3,1],         1   3   3   1   0   0           4
 *  [1,4,6,4,1]         1   4   6   4   1   0           5
 *[1,5,10,10,5,1]       1   5   10  10  5   1           6
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test118 {

    public static void main(String[] args) {
        List<List<Integer>> pascalsTriangle = new Test118().generate(5);
        for (int i = 0; i < pascalsTriangle.size(); i++) {
            for (Integer integer : pascalsTriangle.get(i)) {
                System.out.print(integer + "\t");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalsTriangle = new ArrayList<>();
        if(numRows > 0)
        {
            for(int i = 0; i < numRows; i ++)
            {
                List<Integer> items = new ArrayList<>();
                if(i == 0)
                {
                    items.add(1);
                    pascalsTriangle.add(items);
                    continue;
                }
                for(int j = 0; j < i + 1; j ++)
                {
                    if(j == 0 || j == i)
                    {
                        items.add(1);
                        if(j == i)
                        {
                            pascalsTriangle.add(items);
                        }
                    }
                    else
                    {
                        items.add(pascalsTriangle.get(i-1).get(j-1) + pascalsTriangle.get(i-1).get(j));
                    }
                }
            }
        }
        return pascalsTriangle;
    }
}
