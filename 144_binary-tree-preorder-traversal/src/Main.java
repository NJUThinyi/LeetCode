import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left = new TreeNode(5);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(6);

        List<Integer> res = s.preorderTraversal(root);
        System.out.println(res);
    }
}
