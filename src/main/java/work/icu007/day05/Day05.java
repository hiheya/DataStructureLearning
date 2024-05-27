package work.icu007.day05;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day05 {
    public static void main(String[] args) {

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // 移除链表元素
    // 删除链表中等于给定值 val 的所有节点。
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

}
