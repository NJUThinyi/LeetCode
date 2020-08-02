# Leetcode 144
## 题目要求
给定一个二叉树，返回它的 前序 遍历。

示例:
输入: [1,null,2,3]
```
   1
    \
     2
    /
   3
```
输出: [1,2,3]

 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
## Related Topics 
- 栈
- 树
## 薄弱环节
- 栈的使用场景

    像本题中的迭代解法，在进行前序遍历的时候，因为需要获得子节点及其所在分支的值，就必定会把其右节点及其分支遗失，但后续还需要遍历右节点，所以需要将右节点部分存起来，并且要能够**后进先出**，这时候就需要借助栈这个数据结构
## 题解思路
### Method1 递归法（较为简单）

- 对于每一个节点
  - 首先获取该节点的值；
  - 接着，判定是否有左节点，如果有，则进入左节点继续深度遍历；
  - 如果没有，则判定是否有右节点，如果有，则进入右节点继续深度遍历；
  - 如果左右节点都为null， 则说明该节点已无子节点，该层递归结束，返回。

```java
List<Integer> res = new LinkedList<>();

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
```

### Method2 迭代法（借用栈结构对数据临时存储）

==迭代法需要利用好栈结构**后进先出**的特点==

- 首先，声明一个栈用于存右节点结构；
- 接着，把当前节点是否为null(`temp!=null`)以及栈是否为空(`!treeNodes.isEmpty()`)作为循环条件；
- 进入循环结构后，首先，将当前节点的值存储；
- 之后，判定当前节点是否有右节点，有的话，则将其右节点push入栈；
- 接着，判定当前节点是否有左节点，如果有，则把当前节点的左节点赋给当前节点；如果没有，则从栈中pop出栈顶节点（如果有的话）并赋给当前节点。

```java
List<Integer> res = new LinkedList<>();

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
```

