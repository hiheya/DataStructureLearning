# 数据结构与算法打卡-Day09

## 删除链表的倒数第N个节点

原题链接：[19.删除链表的倒数第N个节点](https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/)

> 给你一个链表，删除链表的倒数第 `n` 个结点，并且返回链表的头结点。
>
>  
>
> **示例 1：**
>
> ![img](https://cdn.jsdelivr.net/gh/hiheya/images@master/img/remove_ex1.jpg)
>
> ```tex
> 输入：head = [1,2,3,4,5], n = 2
> 输出：[1,2,3,5]
> ```
>
> **示例 2：**
>
> ```tex
> 输入：head = [1], n = 1
> 输出：[]
> ```
>
> **示例 3：**
>
> ```tex
> 输入：head = [1,2], n = 1
> 输出：[1]
> ```
>
>  
>
> **提示：**
>
> - 链表中结点的数目为 `sz`
> - `1 <= sz <= 30`
> - `0 <= Node.val <= 100`
> - `1 <= n <= sz`
>
>  

- 题解：

```java
// 删除链表的倒数第 N 个结点
// 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
public ListNode removeNthFromEnd(ListNode head, int n) {
    // 虚拟头节点
    ListNode dummyNode = new ListNode(0,head);
    // 快慢指针
    ListNode fastNode = dummyNode;
    ListNode slowNode = dummyNode;
    // 注意边界问题；快指针先走n + 1步，因为初始化时 fastNode = dummyNode，所以这里是 i <= n；如果是 fastNode = head, 则 i < n;
    for(int i = 0; i <= n; i++) {
        fastNode = fastNode.next;
    }
    // 快慢指针同时走，直到快指针走到最后一个节点
    while (fastNode != null) {
        fastNode = fastNode.next;
        slowNode = slowNode.next;
    }
    // 走完后 快指针走到最后一个节点，慢指针走到需要被删除节点的前一个节点。
    // 删除节点
    slowNode.next = slowNode.next.next;
    return dummyNode.next;
}
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
```

> 思路：
>
> 如果要删除倒数第n个节点，让fast移动n步，然后让fast和slow同时移动，直到fast指向链表末尾。删掉slow所指向的节点就可以了。
>
> 分为如下几步：
> 
> - 定义fast指针和slow指针，初始值为虚拟头结点，如图：![19.删除链表的倒数第N个节点](https://cdn.jsdelivr.net/gh/hiheya/images@master/img/19.删除链表的倒数第N个节点.png)
>
> - fast首先走n + 1步 ，为什么是n+1呢，因为只有这样同时移动的时候slow才能指向删除节点的上一个节点（方便做删除操作），如图： ![19.删除链表的倒数第N个节点1](https://cdn.jsdelivr.net/gh/hiheya/images@master/img/19.删除链表的倒数第N个节点1.png)
> - fast和slow同时移动，直到fast指向末尾，如图： ![19.删除链表的倒数第N个节点2](https://cdn.jsdelivr.net/gh/hiheya/images@master/img/19.删除链表的倒数第N个节点2.png)
> - 删除slow指向的下一个节点，如图： ![19.删除链表的倒数第N个节点3](https://cdn.jsdelivr.net/gh/hiheya/images@master/img/19.删除链表的倒数第N个节点3.png)
