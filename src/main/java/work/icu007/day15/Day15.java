package work.icu007.day15;

import java.util.HashMap;

public class Day15 {
    public static void main(String[] args) {

    }

    // 两个数组的交集
    public int[] intersection(int[] nums1, int[] nums2) {
        // 创建一个哈希映射来存储第一个数组中的元素及其出现的次数
        HashMap<Integer, Integer> map = new HashMap<>();
        // 创建一个哈希映射来存储结果
        HashMap<Integer, Integer> ansMap = new HashMap<>();
        // 遍历第一个数组
        for (int i : nums1) {
            // 将元素及其出现的次数添加到哈希映射中
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        // 遍历第二个数组
        for (int i : nums2) {
            // 如果元素在哈希映射中存在，就将其添加到结果的哈希映射中
            if (map.containsKey(i)) {
                ansMap.put(i, 0);
            }
        }
        // 创建一个数组来存储结果
        int[] ans = new int[ansMap.size()];
        int index = 0;
        // 将结果的哈希映射的键转换为数组
        for (int i : ansMap.keySet()) {
            ans[index++] = i;
        }
        // 返回结果
        return ans;
    }
}
