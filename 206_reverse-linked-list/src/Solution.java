import java.util.Stack;

class Solution {
    // 迭代法解决
    public ListNode reverseListOfIterator(ListNode head) {
        ListNode temp = null;
        ListNode ans = null;
        while(head!=null){
            // 把下一个暂存起来
            temp = head.next;
            // 修改当前节点的下一个节点为前面暂存的节点
            head.next = ans;
            // 获得修改后的当前节点的值并暂存
            ans = head;
            // 当前节点指向下一个节点
            head = temp; 
        }
        return ans;
    }

    // 递归法
    public ListNode reverseListOfRecursion(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode p = reverseListOfRecursion(head.next);
        /**
         * 1.
         * 若从节点 n{k+1}到 n{m}已经被反转，而我们正处于 n_{k}。
         * n_{1} → ... → n_{k-1} → n_{k} → n_{k+1} ← ... ← n_{m}
         * 我们希望 n_{k+1}的下一个节点指向 n_{k}
         * 所以，n_{k}.next.next = n_{k}n
         *
         * 2.
         * 递归返回的时候，head变为了递归前的节点，而这个节点的next仍为其原始的next节点，
         * 所以，可以使用下面的变换：
         * n_{k}.next.next = n_{k}n
        **/
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = null;
        Solution solution = new Solution();
        ListNode res = solution.reverseListOfRecursion(l1);
        System.out.println(res);
    }
}