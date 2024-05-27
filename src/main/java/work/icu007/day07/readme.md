# 数据结构与算法打卡-Day07

## 反转链表

原题链接: [206. 反转链表](https://leetcode-cn.com/problems/reverse-linked-list/)

> 给你单链表的头节点 `head` ，请你反转链表，并返回反转后的链表。
>
>  
>
> **示例 1：**
>
> ![img](https://cdn.jsdelivr.net/gh/hiheya/images@master/img/rev1ex1.jpg)
>
> ```tex
> 输入：head = [1,2,3,4,5]
> 输出：[5,4,3,2,1]
> ```
>
> **示例 2：**
>
> ![img](https://cdn.jsdelivr.net/gh/hiheya/images@master/img/rev1ex2.jpg)
>
> ```tex
> 输入：head = [1,2]
> 输出：[2,1]
> ```
>
> **示例 3：**
>
> ```tex
> 输入：head = []
> 输出：[]
> ```
>
>  
>
> **提示：**
>
> - 链表中节点的数目范围是 `[0, 5000]`
> - `-5000 <= Node.val <= 5000`

- 题解：

```java
// 反转链表
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public ListNode reverseList(ListNode head) {
    // 初始化前一个节点为null
    ListNode prev = null;
    // 初始化当前节点为头节点
    ListNode current = head;
    // 当当前节点不为空时，继续循环
    while (current != null) {
        // 保存当前节点的下一个节点
        ListNode nextTemp = current.next;
        // 将当前节点的下一个节点指向前一个节点
        current.next = prev;
        // 前一个节点指向当前节点
        prev = current;
        // 当前节点指向下一个节点
        current = nextTemp;
    }
    // 返回前一个节点
    return prev;
}
```



> 首先初始化两个指针，一个指向前一个节点，一个指向当前节点。然后，它在一个循环中不断地将当前节点的下一个节点指向前一个节点，然后将前一个节点和当前节点向后移动，直到遍历完所有的节点。
