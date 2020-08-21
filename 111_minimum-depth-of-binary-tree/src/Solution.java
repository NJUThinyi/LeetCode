//给定一个二叉树，找出其最小深度。
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例:
//
// 给定二叉树 [3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回它的最小深度 2.
// Related Topics 树 深度优先搜索 广度优先搜索
// 👍 346 👎 0

public class Solution {
    int min=Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        if(root.left!=null){
            traverse(root.left, 2);
        }
        if(root.right!=null){
            traverse(root.right, 2);
        }
        return min;
    }

    void traverse(TreeNode t, int level){
        if(t.left==null&&t.right==null){
            min = Math.min(min, level);
            return;
        }
        if(t.left!=null){
            traverse(t.left, ++level);
        }
        if(t.right!=null){
            traverse(t.right, ++level);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(-9);
        TreeNode t1 = new TreeNode(-3);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(0);
        TreeNode t6 = new TreeNode(-6);
        TreeNode t7 = new TreeNode(-5);
        root.left = t1;
        root.right = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t4.left = t7;

        System.out.println(solution.minDepth(root));
    }
}
