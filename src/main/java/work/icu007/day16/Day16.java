package work.icu007.day16;

import java.util.ArrayList;
import java.util.HashMap;

public class Day16 {
    public static void main(String[] args) {

    }

    public enum Operation {
        ADD("+"),
        MINUS("-"),
        DIVI("/"),
        MULTI("*");

        private final String value;

        Operation(String value) {
            this.value = value;
        }

        public final String getValue() {
            return this.value;
        }

    }

    // 两个数组的交集Ⅱ
    // 给定两个数组，编写一个函数来计算它们的交集。
    // 示例 1:
    // 输入: nums1 = [1,2,2,1], nums2 = [2,2]
    // 输出: [2,2]
    // 示例 2:
    // 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    // 输出: [4,9]
    // 说明：
    // 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
    // 我们可以不考虑输出结果的顺序。
    // 进阶:
    // 如果给定的数组已经排好序呢？你将如何优化你的算法？
    // 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
    // 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
    // 解法一：哈希表
    public int[] intersect(int[] nums1, int[] nums2) {
        // 初始化一个哈希表
        HashMap<Integer, Integer> map = new HashMap<>();
        // 初始化一个列表
        ArrayList<Integer> list = new ArrayList<>();
        // 遍历nums1
        for (int num : nums1) {
            // 将nums1中的元素加入哈希表
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 遍历nums2
        for (int num : nums2) {
            // 如果哈希表中包含nums2中的元素
            if (map.containsKey(num)) {
                // 将nums2中的元素加入列表
                list.add(num);
                // 将哈希表中的元素减一
                map.put(num, map.get(num) - 1);
                // 如果哈希表中的元素为0，则删除该元素
                if (map.get(num) == 0) {
                    map.remove(num);
                }
            }
        }
        // 初始化一个数组
        int[] res = new int[list.size()];
        // 遍历列表
        for (int i = 0; i < list.size(); i++) {
            // 将列表中的元素加入数组
            res[i] = list.get(i);
        }
        // 返回数组
        return res;
    }
}
