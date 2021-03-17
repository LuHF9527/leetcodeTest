package xyz.highphone.leetcode.easy;

import xyz.highphone.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */
public class Test257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null)
            return res;
        if(root.left == null && root.right == null)
        {
            res.add(String.valueOf(root.val));
            return res;
        }

        List<String> leftPaths = binaryTreePaths(root.left);
        for (int i = 0; i < leftPaths.size(); i++) {
            res.add(String.valueOf(root.val) + "->" + leftPaths.get(i));
        }

        List<String> rightPaths = binaryTreePaths(root.right);
        for (int i = 0; i < rightPaths.size(); i++) {
            res.add(String.valueOf(root.val) + "->" + rightPaths.get(i));
        }
        return res;
    }
}
