package xyz.highphone.leetcode.easy;

import xyz.highphone.leetcode.TreeNode;

/**
 * 101. 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 *
 * 进阶：
 *
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 */
public class Test101 {
    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {

        return check(root, root);
    }

    private boolean check(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        if(p != null && q != null)
            return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
        return false;
    }
}
