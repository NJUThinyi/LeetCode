//给定一个二叉树，原地将它展开为一个单链表。
//
//
//
// 例如，给定二叉树
//
//     1
//   / \
//  2   5
// / \   \
//3   4   6
//
// 将其展开为：
//
// 1
// \
//  2
//   \
//    3
//     \
//      4
//       \
//        5
//         \
//          6
// Related Topics 树 深度优先搜索
// 👍 468 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    boolean isValid = false;
    public void flatten(TreeNode root) {
        method1(root);
        // TODO: 2020/8/4 添加前序遍历的两种方法 
    }

    // 方法一：我的方法（与官方题解中的第三种方法思路一样，不过个别地方【判断是否满足题意时】实现过于复杂）
    public void method1(TreeNode root){
        if(root!=null){
            isValid(root);
            while(!isValid){
                if(root.left!=null){
                    TreeNode temp=getRightestForLeftNode(root.left);
                    temp.right=root.right;
                    root.right=root.left;
                }
                root.left=null;
                root=root.right;
                isValid(root);
            }
        }
    }

    public void isValid(TreeNode node){
        if(node.left!=null){
            isValid = false;
        }else if(node.right!=null){
            node = node.right;
            isValid(node);
        }else{
            isValid = true;
        }
    }

    public TreeNode getRightestForLeftNode(TreeNode left){
        while(left.right!=null){
            left=left.right;
        }
        return left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
