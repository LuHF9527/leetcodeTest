package xyz.highphone.leetcode.medium;

import xyz.highphone.leetcode.TreeNode;

import java.util.*;

/**
 * 103. 二叉树的锯齿形层序遍历
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层序遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class Test103 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node11 = new TreeNode(4);
        TreeNode node22 = new TreeNode(5);
        node2.left = null;
        node2.right = node22;
        node1.left = node11;
        node1.right = null;
        root.left = node1;
        root.right = node2;
        List<List<Integer>> res = new Test103().zigzagLevelOrder(root);
        for (List<Integer> re : res) {
            System.out.println(re);
        }
    }



    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(null != root)
        {
            Queue<TreeNode> nodeQueue = new LinkedList<>();
            nodeQueue.add(root);
            boolean leftFlag = true;
            while (!nodeQueue.isEmpty())
            {
                List<Integer> re = new ArrayList<>();
                int size = nodeQueue.size();
                while (size > 0)
                {
                    TreeNode poll = nodeQueue.poll();
                    re.add(poll.val);
                    if(null != poll.left)
                    {
                        nodeQueue.add(poll.left);
                    }
                    if(null != poll.right)
                    {
                        nodeQueue.add(poll.right);
                    }
                    size--;
                }
                if(!leftFlag)
                    Collections.reverse(re);
                res.add(re);
                leftFlag = !leftFlag;
            }
        }
        return res;
    }
}

