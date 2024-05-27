package work.icu007.day10;

import work.icu007.day09.Day09;

public class Day10 {
    public static void main(String[] args) {

    }

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
    // 解法一：双指针法
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
    // 解法二：遍历法
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
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
}
