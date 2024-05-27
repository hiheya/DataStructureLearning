package work.icu007.day08;

public class Day08 {
    public static void main(String[] args) {

    }

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
}
