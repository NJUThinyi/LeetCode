//给定一个二叉树，返回它的 前序 遍历。
//
// 示例:
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,2,3]
//
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树
// 👍 326 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    static List<Integer> res = new LinkedList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        return preorderTraversalForIteration(root);
    }

    // 递归解法
    public List<Integer> preorderTraversalForRecursion(TreeNode root){
        // 注意根节点可能为空的情况
        if(root!=null){
            res.add(root.val);
            if(root.left!=null){
                preorderTraversalForRecursion(root.left);
            }
            if(root.right!=null){
                preorderTraversalForRecursion(root.right);
            }
        }
        return res;
    }

    // 迭代解法
    public static List<Integer> preorderTraversalForIteration(TreeNode root){
        TreeNode temp = root;
        Stack<TreeNode> treeNodes = new Stack<>();
        while(temp!=null || !treeNodes.isEmpty()){
            res.add(temp.val);
            if(temp.right!=null){
                treeNodes.push(temp.right);
            }
            if(temp.left!=null){
                temp = temp.left;
            }else{
                if(!treeNodes.isEmpty()){
                    temp = treeNodes.pop();
                }else{
                    break;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
