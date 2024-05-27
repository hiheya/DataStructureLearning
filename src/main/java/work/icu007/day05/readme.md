# 数据结构与算法打卡-Day05

## 一、链表基础理论

链表是一种通过指针串联在一起的线性结构，每一个节点由两部分组成，一个是数据域一个是指针域（存放指向下一个节点的指针），最后一个节点的指针域指向null（空指针的意思）。

链表的入口节点称为链表的头结点也就是head。

如图所示：

![链表1](https://cdn.jsdelivr.net/gh/hiheya/images@master/img/20200806194529815.png)

### 1.1 链表的类型

接下来说一下链表的几种类型

- 单链表

    单链表是最简单的链表，每个节点只有一个指针域，指向下一个节点。
    
    如上图所示
- 双链表

    双链表每个节点有两个指针域，一个指向下一个节点，一个指向前一个节点。双链表既可以从头到尾遍历，也可以从尾到头遍历。

    如图所示:


![链表2](https://cdn.jsdelivr.net/gh/hiheya/images@master/img/20200806194559317.png)

- 循环链表

    循环链表是一种特殊的单链表，循环链表的尾节点指向头节点，形成一个环。
    
    如下图所示：
    

![链表4](https://cdn.jsdelivr.net/gh/hiheya/images@master/img/20200806194629603.png)
    
    
### 1.2 链表的存储方式

数组在内存中是连续存储的，而链表是不连续存储的. 链表的存储方式是通过指针串联在一起的,所以链表的存储方式是不连续的,而是散乱分布在内存中的某地址上，分配机制取决于操作系统的内存管理
如图所示:



![链表3](https://cdn.jsdelivr.net/gh/hiheya/images@master/img/20200806194613920.png)

这个链表起始节点为2， 终止节点为7， 各个节点分布在内存的不同地址空间上，通过指针串联在一起。

### 1.3 链表的定义

链表的定义如下：

```java
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
```

### 1.4 链表的操作

1. 删除节点

    删除节点的操作是将要删除节点的前一个节点的指针指向要删除节点的下一个节点，然后将要删除节点的指针指向null，这样就删除了这个节点。
    
    删除D节点如图所示：
    

![链表-删除节点](https://cdn.jsdelivr.net/gh/hiheya/images@master/img/20200806195114541-20230310121459257.png)
2. 插入节点

    插入节点的操作是将要插入节点的前一个节点的指针指向要插入节点，然后将要插入节点的指针指向要插入节点的下一个节点，这样就插入了这个节点。
    
    插入F节点如图所示：
    

![链表-添加节点](https://cdn.jsdelivr.net/gh/hiheya/images@master/img/20200806195134331-20230310121503147.png)
3. 性能分析

    链表的插入和删除操作的时间复杂度是O(1)，而数组的插入和删除操作的时间复杂度是O(n)。
    
    链表的查询操作的时间复杂度是O(n)，而数组的查询操作的时间复杂度是O(1)。
    
    所以链表适合插入和删除操作频繁的场景，而数组适合查询操作频繁的场景。
    
    再把链表的特性和数组的特性进行一个对比，如图所示
    

![链表-链表与数据性能对比](https://cdn.jsdelivr.net/gh/hiheya/images@master/img/20200806195200276.png)

## 二、链表的题目

### 2.1 leetcode 203题 移除链表元素

原题链接：[203. 移除链表元素](https://leetcode.cn/problems/remove-linked-list-elements/)

> 给你一个链表的头节点 `head` 和一个整数 `val` ，请你删除链表中所有满足 `Node.val == val` 的节点，并返回 **新的头节点** 。
>
>  
>
> **示例 1：**
>
> ![img](https://cdn.jsdelivr.net/gh/hiheya/images@master/img/removelinked-list.jpg)
>
> ```tex
> 输入：head = [1,2,6,3,4,5,6], val = 6
> 输出：[1,2,3,4,5]
> ```
>
> **示例 2：**
>
> ```tex
> 输入：head = [], val = 1
> 输出：[]
> ```
>
> **示例 3：**
>
> ```tex
> 输入：head = [7,7,7,7], val = 7
> 输出：[]
> ```
>
>  
>
> **提示：**
>
> - 列表中的节点数目在范围 `[0, 10^4]` 内
> - `1 <= Node.val <= 50`
> - `0 <= val <= 50`

- 题解：

```java
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

// 移除链表元素
// 删除链表中等于给定值 val 的所有节点。
// 添加虚拟节点
public ListNode removeElements(ListNode head, int val) {
    // 创建一个虚拟头节点
    ListNode dummy = new ListNode(0);
    // 将虚拟头节点指向头节点
    dummy.next = head;
    // 初始化当前节点为虚拟头节点
    ListNode current = dummy;
    // 当当前节点的下一个节点不为空时，继续循环
    while (current.next != null) {
        // 如果当前节点的下一个节点的值等于val
        if (current.next.val == val) {
            // 将当前节点的下一个节点指向下下个节点
            current.next = current.next.next;
        } else {
            // 否则当前节点向后移动一位
            current = current.next;
        }
    }
    // 返回虚拟头节点的下一个节点
    return dummy.next;
}

// 不添加虚拟节点
public ListNode removeElements(ListNode head, int val) {
    // 先判断头节点
    while(head != null && head.val == val) {
        head = head.next;
    }
    // 如果 头节点为空则直接返回
    if(head == null) {
        return head;
    }
    // 上面while循环已经确定当前 head.val != val
    ListNode preNode = head;
    ListNode currentNode = head.next;
    while(currentNode != null) {
        if (currentNode.val == val) {
            preNode.next = currentNode.next;
        } else {
            preNode = currentNode;
        }
        currentNode = currentNode.next;
    }

    return head;
}
```

> 这里提供了两种方法来解决这个问题。  
>
> 第一种方法是使用虚拟头节点。
>
> 首先，创建一个虚拟头节点，并将其指向原链表的头节点。
>
> 然后，初始化一个当前节点为虚拟头节点。在当前节点的下一个节点不为空的情况下，如果当前节点的下一个节点的值等于给定值，就将当前节点的下一个节点指向下下个节点，否则，当前节点向后移动一位。
>
> 最后，返回虚拟头节点的下一个节点，即删除了所有等于给定值的节点后的链表。  
>
> 
>
> 第二种方法是不使用虚拟头节点。
>
> 首先，判断头节点，如果头节点的值等于给定值，就将头节点指向下一个节点，直到头节点的值不等于给定值。
>
> 然后，初始化两个节点，一个是前一个节点，一个是当前节点。在当前节点不为空的情况下，如果当前节点的值等于给定值，就将前一个节点的下一个节点指向当前节点的下一个节点，否则，前一个节点向后移动一位。
>
> 最后，返回头节点，即删除了所有等于给定值的节点后的链表。
>
> 这两种方法的主要区别在于是否使用虚拟头节点。使用虚拟头节点的方法可以简化代码，不需要单独处理头节点。



