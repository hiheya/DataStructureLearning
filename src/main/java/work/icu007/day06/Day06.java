package work.icu007.day06;

public class Day06 {
    public static void main(String[] args) {

    }

    // 设计链表
    // 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
    // 在链表类中实现这些功能：
    // get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
    // addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
    // addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
    // addAtIndex(index, val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。
    // deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
    class MyLinkedList {
        // 定义链表长度
        int size;
        // 定义虚拟头节点
        ListNode dummy;

        public MyLinkedList() {
            size = 0;
            dummy = new ListNode(0);
        }

        // 获取链表中第 index 个节点的值。如果索引无效，则返回-1。
        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }
            ListNode current = dummy;
            for (int i = 0; i < index + 1; i++) {
                current = current.next;
            }
            return current.val;
        }

        // 在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        // 将值为 val 的节点追加到链表的最后一个元素。
        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        // 在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。
        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }
            if (index < 0) {
                index = 0;
            }
            size++;
            ListNode pred = dummy;
            for (int i = 0; i < index; i++) {
                pred = pred.next;
            }
            ListNode toAdd = new ListNode(val);
            toAdd.next = pred.next;
            pred.next = toAdd;
        }

        // 如果索引 index 有效，则删除链表中的第 index 个节点。
        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            size--;
            ListNode pred = dummy;
            for (int i = 0; i < index; i++) {
                pred = pred.next;
            }
            pred.next = pred.next.next;
        }

        // 定义链表节点
        class ListNode {
            int val;
            ListNode next;

            public ListNode(int val) {
                this.val = val;
            }
        }
    }
}
