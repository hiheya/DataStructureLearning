# 数据结构与算法打卡-Day06

## 设计链表

原题链接: [707. 设计链表](https://leetcode-cn.com/problems/design-linked-list/)

> 你可以选择使用单链表或者双链表，设计并实现自己的链表。
>
> 单链表中的节点应该具备两个属性：`val` 和 `next` 。`val` 是当前节点的值，`next` 是指向下一个节点的指针/引用。
>
> 如果是双向链表，则还需要属性 `prev` 以指示链表中的上一个节点。假设链表中的所有节点下标从 **0** 开始。
>
> 实现 `MyLinkedList` 类：
>
> - `MyLinkedList()` 初始化 `MyLinkedList` 对象。
> - `int get(int index)` 获取链表中下标为 `index` 的节点的值。如果下标无效，则返回 `-1` 。
> - `void addAtHead(int val)` 将一个值为 `val` 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。
> - `void addAtTail(int val)` 将一个值为 `val` 的节点追加到链表中作为链表的最后一个元素。
> - `void addAtIndex(int index, int val)` 将一个值为 `val` 的节点插入到链表中下标为 `index` 的节点之前。如果 `index` 等于链表的长度，那么该节点会被追加到链表的末尾。如果 `index` 比长度更大，该节点将 **不会插入** 到链表中。
> - `void deleteAtIndex(int index)` 如果下标有效，则删除链表中下标为 `index` 的节点。
>
>  
>
> **示例：**
>
> ```tex
> 输入
> ["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
> [[], [1], [3], [1, 2], [1], [1], [1]]
> 输出
> [null, null, null, null, 2, null, 3]
> 
> 解释
> MyLinkedList myLinkedList = new MyLinkedList();
> myLinkedList.addAtHead(1);
> myLinkedList.addAtTail(3);
> myLinkedList.addAtIndex(1, 2);    // 链表变为 1->2->3
> myLinkedList.get(1);              // 返回 2
> myLinkedList.deleteAtIndex(1);    // 现在，链表变为 1->3
> myLinkedList.get(1);              // 返回 3
> ```
>
>  
>
> **提示：**
>
> - `0 <= index, val <= 1000`
> - 请不要使用内置的 LinkedList 库。
> - 调用 `get`、`addAtHead`、`addAtTail`、`addAtIndex` 和 `deleteAtIndex` 的次数不超过 `2000` 。

- 题解：

```java
// 设计链表
// 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
// 在链表类中实现这些功能：
// get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
// addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
// addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
// addAtIndex(index, val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。
// deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
class MyLinkedList {
    // 链表长度
    int size;

    // 虚拟头节点
    ListNode node;

    public MyLinkedList() {

        size = 0;
        node = new ListNode(0);

    }
    
    public int get(int index) {
        // 下标无效直接返回 -1
        if(index < 0 || index >= size) {
            return -1;
        }
        ListNode current = node;
        // 一直往下遍历，直到找到下标为index的节点
        for(int i = 0; i < index + 1; i++) {
            current = current.next;
        }
        return current.val;
    }
    
    public void addAtHead(int val) {
        // 直接调用addAtIndex方法
        addAtIndex(0, val);
    }
    
    public void addAtTail(int val) {
        // 同上
        addAtIndex(size, val);
    }
    
    public void addAtIndex(int index, int val) {
        // 如果 index比长度更大，该节点不会插入到链表中
        if(index > size) {
            return;
        }
        if(index < 0) {
            index = 0;
        }
        ListNode preNode = node;
        // 注意是要插入到 index 下标节点之前，所以这里只需要遍历找到 index前一个节点
        for(int i = 0; i < index; i++) {
            preNode = preNode.next;
        }
        // 先将需要添加的节点next指向 preNode节点next，再让preNode的next节点指向需要添加的节点
        ListNode addNode = new ListNode(val);
        addNode.next = preNode.next;
        preNode.next = addNode;
        // 添加成功后size + 1
        size++;
    }
    
    public void deleteAtIndex(int index) {
        // 下标无效直接返回
        if(index < 0 || index >= size) {
            return;
        }
        // 删除的动作就是 需要删除的节点 前置节点next直接指向需要删除节点的next；
        ListNode preNode = node;
        for(int i = 0; i < index; i++) {
            preNode = preNode.next;
        }
        preNode.next = preNode.next.next;
        // 删除成功后 size - 1
        size--;
    }

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
```

