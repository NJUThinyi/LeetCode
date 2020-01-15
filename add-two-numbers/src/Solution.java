class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultList=new ListNode(0);
        ListNode tempList = resultList;
        int carry=0;
        while(!(l1==null&&l2==null)){
            int a=(l1==null)?0:l1.val;
            int b=(l2==null)?0:l2.val;
            int sum=carry+a+b;
            tempList.next=new ListNode(sum%10);
            tempList=tempList.next;
            l1=(l1==null)?null:l1.next;
            l2=(l2==null)?null:l2.next;
            carry=sum/10;
        }
        if(carry!=0){
            tempList.next=new ListNode(carry);
        }
        return resultList.next;
    }
}