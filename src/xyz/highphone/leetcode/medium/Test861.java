package xyz.highphone.leetcode.medium;

/**
 * 861. 翻转矩阵后的得分
 * 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
 *
 * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 *
 * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
 *
 * 返回尽可能高的分数。
 *
 *
 *
 * 示例：
 *
 * 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
 * 输出：39
 * 解释：
 * 转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
 * 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 20
 * 1 <= A[0].length <= 20
 * A[i][j] 是 0 或 1
 */
public class Test861 {

    public static void main(String[] args) {
        int[][] A = {{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        System.out.println(new Test861().matrixScore(A));
    }

    public int matrixScore(int[][] A) {
        int result = 0;
        assert null != A;
        int m = A.length;
        int n = A[0].length;
        //二维数组每个子数组第一个数字必须是1才能使数字最大，第一遍循环使0开头的子数组翻转
        for (int i = 0; i < m; i++) {
            if(A[i][0] == 0)
            {
                for (int j = 0; j < n; j++) {
                   A[i][j] = A[i][j] == 0 ? 1 : 0;
                }
            }
        }

        //行翻转后，考虑列翻转，尽量保证每一列的1都是比0多的（大于等于）。思路是，第一列已保证全是1，不用动，其他列中的0只要超过一半，那这一列就需要翻转
        for(int j = 1; j < n; j ++){
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                if(A[i][j] == 0)
                {
                    cnt ++;
                }
            }
            if(cnt > m/2)
            {
                for (int i = 0; i < m; i++) {
                    A[i][j] = A[i][j] == 0 ? 1 : 0;
                }
            }
        }
        //转为2进制输出结果
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result += A[i][j] == 1 ? 1 << (n - j -1): 0;
            }
        }
        return result;
    }


}
