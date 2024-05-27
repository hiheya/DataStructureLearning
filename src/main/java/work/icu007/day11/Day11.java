package work.icu007.day11;

import work.icu007.day10.Day10;

import java.util.HashSet;
import java.util.Set;

public class Day11 {
    public static void main(String[] args) {

    }

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

    // 解法二：快慢指针
    public ListNode detectCycle2(ListNode head) {
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
}
