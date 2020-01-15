### Related Topics

- 链表

```java
//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
//输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学




//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultList;
        int temp=0;
        temp=l1.val
    }
}
//leetcode submit region end(Prohibit modification and deletion)
```



### 个人所得

1. 如何保持在计算过程保持对新添加的节点的引用

   - 通过一个名为tempList的`ListNode`类指针指向结果的下一个节点，在计算过程中，不断更新这个指针节点

     ```java
     ListNode resultList=new ListNode(0);
     ListNode tempList = resultList;
     
     tempList.next=new ListNode(sum%10);	//注意，这里不能写成tempList=new ListNode()，否则，会导致tempList指向新的地址空间，改变了其指向位置，就无法保持在结果List中的引用关系
     tempList=tempList.next;
     ```

2. 特殊情况的考虑
   - 当输入List在遍历过程变为null时（即其中一个List较短），其对应位为数学意义上的0，应该采用`int a=(l1==null)?0:l1.val`以及`l1=(l1==null)?null:l1.next;`对其进行判断处理