# 数据结构与算法打卡-Day08

## 两两交换链表中的节点

原题链接:[24. 两两交换链表中的节点](https://leetcode-cn.com/problems/swap-nodes-in-pairs/)

>给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
>
> 
>
>**示例 1：**
>
>![img](https://cdn.jsdelivr.net/gh/hiheya/images@master/img/swap_ex1.jpg)
>
>```tex
>输入：head = [1,2,3,4]
>输出：[2,1,4,3]
>```
>
>**示例 2：**
>
>```tex
>输入：head = []
>输出：[]
>```
>
>**示例 3：**
>
>```tex
>输入：head = [1]
>输出：[1]
>```
>
> 
>
>**提示：**
>
>- 链表中节点的数目在范围 `[0, 100]` 内
>- `0 <= Node.val <= 100`

- 题解：

```java
// 两两交换链表中的节点
// 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
public ListNode swapPairs(ListNode head) {
    // 虚拟头节点
    ListNode dumyHead = new ListNode(0);
    dumyHead.next = head;
    ListNode currentNode = dumyHead;
    // 分别存储两个节点及其后面那个节点
    ListNode tempNode;
    ListNode firstNode;
    ListNode secondNode;

    while (currentNode.next != null && currentNode.next.next != null) {
        tempNode = currentNode.next.next.next;
        firstNode = currentNode.next;
        secondNode = currentNode.next.next;
        // 将当前节点next节点指向第二个节点
        currentNode.next = secondNode;
        // 第二个节点的next指向 第一个节点
        secondNode.next = firstNode;
        // 第一个节点next指向 之前存储起来的两个节点后面那个节点
        firstNode.next = tempNode;
        // 注意这里的firstNode已经变成了第二个节点 所以currentNode应该指向firstNode
        currentNode = firstNode;
    }
    return dumyHead.next;
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

> 这个问题的关键在于，我们不能仅仅改变节点内部的值，而是需要实际进行节点交换。
>
> 以下是这个题解的主要步骤：
>
> 1. 创建一个虚拟头节点，并将其下一个节点设置为头节点。
> 2. 创建一个当前节点，指向虚拟头节点。
> 3. 创建三个临时节点，用于存储两个要交换的节点以及它们后面的节点。
> 4. 当当前节点的下一个节点和下下一个节点都不为空时，进行以下操作：
>    - 将临时节点设置为当前节点的下下下一个节点。
>    - 将第一个节点设置为当前节点的下一个节点。
>    - 将第二个节点设置为当前节点的下下一个节点。
>    - 将当前节点的下一个节点设置为第二个节点。
>    - 将第二个节点的下一个节点设置为第一个节点。
>    - 将第一个节点的下一个节点设置为临时节点。
>    - 将当前节点设置为第一个节点（注意，此时的第一个节点已经变成了第二个节点）。
> 5. 最后，返回虚拟头节点的下一个节点，即交换后的链表的头节点。
>
> 这个题解使用了虚拟头节点来简化边界条件的处理，同时通过临时节点来保存和修改节点的连接关系，实现了链表节点的两两交换。
>
> 
>
> 初始时，cur指向虚拟头结点，然后进行如下三步：
>
> ![24.两两交换链表中的节点1](https://cdn.jsdelivr.net/gh/hiheya/images@master/img/24.两两交换链表中的节点1.png)
>
> 操作之后，链表如下：
>
> ![24.两两交换链表中的节点2](https://cdn.jsdelivr.net/gh/hiheya/images@master/img/24.两两交换链表中的节点2.png)
>
> 看这个可能就更直观一些了：
>
> ![24.两两交换链表中的节点3](https://cdn.jsdelivr.net/gh/hiheya/images@master/img/24.两两交换链表中的节点3.png)



![]()