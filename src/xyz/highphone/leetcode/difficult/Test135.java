package xyz.highphone.leetcode.difficult;

/**
 * 135. 分发糖果
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 *
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 *
 * 示例 1:
 *
 * 输入: [1,0,2]
 * 输出: 5
 * 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * 示例 2:
 *
 * 输入: [1,2,2]
 * 输出: 4
 * 解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
 *      第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 */
public class Test135 {
    public static void main(String[] args) {
        int[] ratings = {1, 0 ,2};
        System.out.println(new Test135().candy(ratings));
    }

    //今天平安夜，leetcode好应景啊，给安排了这么一道困难题，又是翻译题解的一天。
    public int candy(int[] ratings) {
        int cnt = 0;
        int len = ratings.length;
        if(len > 0)
        {
            //题目要求每个孩子至少一颗糖，故先初始化一个数组，令其糖果数都是1
            int[] res = new int[len];
            for (int i = 0; i < len; i++) {
                res[i] = 1;
            }
            //先考虑从左到右满足题目条件
            for (int i = 1; i < len ; i++) {
                if(ratings[i] > ratings[i - 1])
                {
                    res[i] = res[i-1] + 1;
                }
            }
            //再考虑从右到左满足条件
            for (int i = len - 2; i >= 0; i--) {
                if(ratings[i] > ratings[i + 1] && res[i] <= res[i+1])
                {
                    res[i] = res[i+1] + 1;
                }
            }
            for (int re : res) {
                cnt += re;
            }
        }
        return cnt;
    }
}
