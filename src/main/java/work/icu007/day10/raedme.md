# 数据结构与算法打卡-Day10

## 链表相交

原题链接: [160.链表相交](https://leetcode-cn.com/problems/intersection-of-two-linked-lists/)

> 给你两个单链表的头节点 `headA` 和 `headB` ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 `null` 。
>
> 图示两个链表在节点 `c1` 开始相交**：**
>
> ![img](https://cdn.jsdelivr.net/gh/hiheya/images@master/img/160_statement.png)
>
> **注意**，函数返回结果后，链表必须 **保持其原始结构** 。
>
> **自定义评测：**
>
> **评测系统** 的输入如下（你设计的程序 **不适用** 此输入）：
>
> - `intersectVal` - 相交的起始节点的值。如果不存在相交节点，这一值为 `0`
> - `listA` - 第一个链表
> - `listB` - 第二个链表
> - `skipA` - 在 `listA` 中（从头节点开始）跳到交叉节点的节点数
> - `skipB` - 在 `listB` 中（从头节点开始）跳到交叉节点的节点数
>
> 评测系统将根据这些输入创建链式数据结构，并将两个头节点 `headA` 和 `headB` 传递给你的程序。如果程序能够正确返回相交节点，那么你的解决方案将被 **视作正确答案** 。
>
>  
>
> **示例 1：**
>
> ![img](https://cdn.jsdelivr.net/gh/hiheya/images@master/img/160_example_1_1.png)
>
> ```tex
> 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
> 输出：Intersected at '8'
> 解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
> 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,6,1,8,4,5]。
> 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
> — 请注意相交节点的值不为 1，因为在链表 A 和链表 B 之中值为 1 的节点 (A 中第二个节点和 B 中第三个节点) 是不同的节点。换句话说，它们在内存中指向两个不同的位置，而链表 A 和链表 B 中值为 8 的节点 (A 中第三个节点，B 中第四个节点) 在内存中指向相同的位置。
> ```
>
>  
>
> **示例 2：**
>
> ![img](https://assets.leetcode.com/uploads/2021/03/05/160_example_2.png)
>
> ```tex
> 输入：intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
> 输出：Intersected at '2'
> 解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
> 从各自的表头开始算起，链表 A 为 [1,9,1,2,4]，链表 B 为 [3,2,4]。
> 在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
> ```
>
> **示例 3：**
>
> ![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/160_example_3.png)
>
> ```tex
> 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
> 输出：null
> 解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
> 由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
> 这两个链表不相交，因此返回 null 。
> ```
>
>  
>
> **提示：**
>
> - `listA` 中节点数目为 `m`
> - `listB` 中节点数目为 `n`
> - `1 <= m, n <= 3 * 10^4`
> - `1 <= Node.val <= 10^5`
> - `0 <= skipA <= m`
> - `0 <= skipB <= n`
> - 如果 `listA` 和 `listB` 没有交点，`intersectVal` 为 `0`
> - 如果 `listA` 和 `listB` 有交点，`intersectVal == listA[skipA] == listB[skipB]`

- 题解：

解法一、

```java
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    // 如果有一个链表为空，则直接返回null
    if (headA == null || headB == null) {
        return null;
    }
    // 初始化两个指针
    ListNode pA = headA;
    ListNode pB = headB;
    // 初始化两个变量
    int countA = 0;
    int countB = 0;
    // 遍历链表A
    while (pA != null) {
        countA++;
        pA = pA.next;
    }
    // 遍历链表B
    while (pB != null) {
        countB++;
        pB = pB.next;
    }
    // 重新初始化两个指针
    pA = headA;
    pB = headB;
    // 计算两个链表的长度差
    int diff = Math.abs(countA - countB);
    // 如果链表A的长度大于链表B的长度
    if (countA > countB) {
        // 遍历链表A
        for (int i = 0; i < diff; i++) {
            pA = pA.next;
        }
    } else {
        // 遍历链表B
        for (int i = 0; i < diff; i++) {
            pB = pB.next;
        }
    }
    // 当两个指针不相等时，继续循环
    while (pA != pB) {
        pA = pA.next;
        pB = pB.next;
    }
    // 返回pA或pB
    return pA;
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

解法二、

```java
// 链表相交
// 编写一个程序，找到两个单链表相交的起始节点。
// 如下面的两个链表：
// A:          a1 → a2
//                    ↘
//                      c1 → c2 → c3
//                    ↗
// B:     b1 → b2 → b3
// 在节点 c1 开始相交。
// 注意：
// 如果两个链表没有交点，返回 null。
// 在返回结果后，两个链表仍须保持原有的结构。
// 可假定整个链表结构中没有循环。
// 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    // 如果有一个链表为空，则直接返回null
    if (headA == null || headB == null) {
        return null;
    }
    // 初始化两个指针
    ListNode pA = headA;
    ListNode pB = headB;
    // 当两个指针不相等时，继续循环
    while (pA != pB) {
        // 如果pA为空，则将pA指向headB
        pA = pA == null ? headB : pA.next;
        // 如果pB为空，则将pB指向headA
        pB = pB == null ? headA : pB.next;
    }
    // 返回pA或pB
    return pA;
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
> 设「第一个公共节点」为 `node` ，「链表 `headA`」的节点数量为 a ，「链表 `headB`」的节点数量为 b ，「两链表的公共尾部」的节点数量为 ccc ，则有：
>
> - 头节点 `headA` 到 `node` 前，共有 a−c 个节点；
> - 头节点 `headB` 到 `node` 前，共有 b−c 个节点；
>
> ![Picture1.png](https://cdn.jsdelivr.net/gh/hiheya/images@master/img/1615224578-EBRtwv-Picture1.png)
>
>
> 考虑构建两个节点指针 `A` , `B` 分别指向两链表头节点 `headA` , `headB` ，做如下操作：
>
> 指针 `A` 先遍历完链表 `headA` ，再开始遍历链表 `headB` ，当走到 `node` 时，共走步数为：
> `a + (b - c)`
>
> 指针 `B` 先遍历完链表 `headB` ，再开始遍历链表 `headA` ，当走到 `node` 时，共走步数为：
> `b + (a - c)`
>
> 如下式所示，此时指针 `A` , `B` 重合，并有两种情况：
>
> `a + (b - c) = b + (a - c)`
>
> 若两链表 **有** 公共尾部 (即 c > 0 ) ：指针 `A` , `B` 同时指向「第一个公共节点」`node` 。
> 若两链表 无 公共尾部 (即 c = 0 ) ：指针 `A` , `B` 同时指向 null 。
> 因此返回 `A` 即可。
>
> > 如下图所示，为 a = 5 , b = 3 , c = 2 示例的算法执行过程。
>
> 
>
> ![intersection-of-two-linked-lists-lcci](https://cdn.jsdelivr.net/gh/hiheya/images@master/img/intersection-of-two-linked-lists-lcci.gif)

