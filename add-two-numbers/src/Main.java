public class Main {
    public static void main(String[] args){
        ListNode l1=new ListNode(1);
        l1.next=new ListNode(0);
        l1.next.next=new ListNode(9);
        ListNode l2=new ListNode(9);
        l2.next=new ListNode(9);
//        l2.next.next=new ListNode(1);

        ListNode r=(new Solution()).addTwoNumbers(l1, l2);

        System.out.println(r);
    }
}
