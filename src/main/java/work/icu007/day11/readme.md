# 数据结构与算法打卡-Day11

## 环形链表 Ⅱ

原题链接：[142. 环形链表 II](https://leetcode-cn.com/problems/linked-list-cycle-ii/)

> 给定一个链表的头节点  `head` ，返回链表开始入环的第一个节点。 *如果链表无环，则返回 `null`。*
>
> 如果链表中有某个节点，可以通过连续跟踪 `next` 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 `pos` 来表示链表尾连接到链表中的位置（**索引从 0 开始**）。如果 `pos` 是 `-1`，则在该链表中没有环。**注意：`pos` 不作为参数进行传递**，仅仅是为了标识链表的实际情况。
>
> **不允许修改** 链表。
>
> 
>
>  
>
> **示例 1：**
>
> ![img](https://cdn.jsdelivr.net/gh/hiheya/images@master/img/circularlinkedlist.png)
>
> ```tex
> 输入：head = [3,2,0,-4], pos = 1
> 输出：返回索引为 1 的链表节点
> 解释：链表中有一个环，其尾部连接到第二个节点。
> ```
>
> **示例 2：**
>
> ![img](https://cdn.jsdelivr.net/gh/hiheya/images@master/img/circularlinkedlist_test2.png)
>
> ```tex
> 输入：head = [1,2], pos = 0
> 输出：返回索引为 0 的链表节点
> 解释：链表中有一个环，其尾部连接到第一个节点。
> ```
>
> **示例 3：**
>
> ![img](https://cdn.jsdelivr.net/gh/hiheya/images@master/img/circularlinkedlist_test3.png)
>
> ```tex
> 输入：head = [1], pos = -1
> 输出：返回 null
> 解释：链表中没有环。
> ```
>
>  
>
> **提示：**
>
> - 链表中节点的数目范围在范围 `[0, 10^4]` 内
> - `-10^5 <= Node.val <= 10^5`
> - `pos` 的值为 `-1` 或者链表中的一个有效索引
>
>  
>
> **进阶：** 你是否可以使用 `O(1)` 空间解决此题？

- 解法一 哈希表

```java
// 环形链表Ⅱ
// 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
// 说明：不允许修改给定的链表。
// 解法一：哈希表
public ListNode detectCycle(ListNode head) {
    // 初始化哈希表
    Set<ListNode> set = new HashSet<>();
    // 初始化当前节点
    ListNode current = head;
    // 当前节点不为空时，继续循环
    while (current != null) {
        // 如果哈希表中包含当前节点，则返回当前节点
        if (set.contains(current)) {
            return current;
        }
        // 将当前节点加入哈希表
        set.add(current);
        // 当前节点指向下一个节点
        current = current.next;
    }
    // 返回null
    return null;
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

- 解法二 双指针

```java
// 解法二：快慢指针
public ListNode detectCycle(ListNode head) {
    // 初始化快慢指针
    ListNode fast = head;
    ListNode slow = head;
    // 当快指针不为空时，继续循环
    while (fast != null) {
        // 如果快指针的下一个节点为空，则返回null
        if (fast.next == null) {
            return null;
        }
        // 快指针走两步
        fast = fast.next.next;
        // 慢指针走一步
        slow = slow.next;
        // 如果快慢指针相遇，则跳出循环
        if (fast == slow) {
            break;
        }
    }
    // 如果快指针为空，则返回null
    if (fast == null) {
        return null;
    }
    // 将快指针指向头节点
    fast = head;
    // 当快慢指针不相等时，继续循环
    while (fast != slow) {
        // 快慢指针同时走一步
        fast = fast.next;
        slow = slow.next;
    }
    // 返回快指针
    return fast;
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

> 解法二解题思路：
>
> 链表类题目一般是使用双指针法解决的，在这个题目中，快慢指针一共会相遇两次。
>
> **双指针的第一次相遇：**
>
> 1. 设两指针 `fast`，`slow` 指向链表头部 `head`；
> 2. 令 `fast` 每轮走两步，`slow` 每轮走一步
>
> 执行以上两步后，可能会出现两种结果：
>
> **第一种结果**： `fast` 指针走过链表末端，说明链表无环，此时直接返回 `null`。
>
> 如果链表存在环，则双指针一定会相遇。因为每走 1 轮，`fast` 与 `slow` 的间距 +1，`fast` 一定会追上 `slow` 。
>
> **第二种结果：**  当`fast == slow`时， 两指针在环中第一次相遇。下面分析此时 `fast` 与 `slow` 走过的步数关系：
>
> 设链表共有 a+b 个节点，其中 **链表头部到链表入口** 有 a 个节点（不计链表入口节点）， **链表环** 有 b 个节点（这里需要注意，a 和 b 是未知数，例如图解上链表 a=4 , b=5）；设两指针分别走了 f，s 步，则有：
>
> 1. `fast` 走的步数是 `slow` 步数的 2 倍，即 f = 2s；（解析： `fast` 每轮走 2 步）
>
> 2. `fast` 比 `slow` 多走了 n 个环的长度，即 f = s + nb；（ 解析： 双指针都走过 a 步，然后在环内绕圈直到重合，重合时 `fast` 比 `slow` 多走 环的长度整数倍 ）。
>
> 将以上两式相减得到 f = 2nb，s = nb，**即 fast 和 slow 指针分别走了 2n，n 个环的周长。**
>
> 
>
> **接下来该怎么做呢？**
>
> 如果让指针从链表头部一直向前走并统计步数k，那么所有 **走到链表入口节点时的步数** 是：k=a+nb ，即先走 a 步到入口节点，之后每绕 1 圈环（ b 步）都会再次到入口节点。而目前 `slow` 指针走了 nb 步。因此，我们只要想办法让 `slow` 再走 a 步停下来，就可以到环的入口。
>
> 但是我们不知道 a 的值，该怎么办？依然是使用双指针法。考虑构建一个指针，此指针需要有以下性质：此指针和 `slow` 一起向前走 a 步后，两者在入口节点重合。那么从哪里走到入口节点需要 a 步？答案是链表头节点`head`。
>
> 
>
> **双指针第二次相遇：**
>
> 1. 令 `fast` 重新指向链表头部节点。此时 f = 0, s = nb；
> 2. `slow` 和 `fast` 同时每轮向前走一步；
> 3. 当 `fast` 指针走到 f = a 步时， `slow` 指针走到 s = a + nb 步。 **此刻两指针重合，并指向链表环入口**，返回 `slow` 指向的节点即可
>
> 图示：
>
> ![linked-list-cycle-ii2](https://cdn.jsdelivr.net/gh/hiheya/images@master/img/linked-list-cycle-ii2.gif)

