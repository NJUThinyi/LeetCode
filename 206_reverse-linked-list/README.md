# Leetcode [206]
## 题目要求

反转一个单链表。 
示例: 
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL 

进阶: 
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 

## Related Topics

- 链表

## 薄弱环节

- 链表处理时对原始数据的保护（见迭代法——采用一个临时节点保存待处理节点的值，以避免处理过程丢失原数据）
- 递归的理解（见递归法——`head.next.next=head`）

## 题解思路
### Method1	迭代法

```java
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
```

### Method2 递归法

注意：

1. <br/>
          若从节点 n{k+1}到 n{m}已经被反转，而我们正处于 n_{k}。
          		n_{1} → ... → n_{k-1} → n_{k} → n_{k+1} ← ... ← n_{m}
          我们希望 n_{k+1}的下一个节点指向 n_{k}
          所以，n_{k}.next.next = n_{k}n

2. 
   ​      递归返回的时候，head变为了递归前的节点，而这个节点的next仍为其原始的next节点，
   ​       所以，可以使用下面的变换：
   ​       n_{k}.next.next = n_{k}n

3. 

   头结点最后需要指向null，否则链表中会出现循环

```java
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
```