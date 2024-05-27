package work.icu007.day13;

import java.util.*;

public class Day13 {
    public static void main(String[] args) {
        Day13 day13 = new Day13();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        day13.groupAnagrams(strs);
    }
    // 字母异位词分组
    // 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
    // 示例:
    // 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
    // 输出:
    // [ ["ate","eat","tea"], ["nat","tan"], ["bat"] ]
    // 说明：
    // 所有输入均为小写字母。
    // 不考虑答案输出的顺序。
    // 解法一：哈希表
    public List<List<String>> groupAnagrams(String[] strs) {
        // 初始化哈希表
        Map<String, List<String>> map = new HashMap<>();
        // 遍历字符串数组
        for (String str : strs) {
            // 将字符串转换为字符数组
            char[] array = str.toCharArray();
            // 对字符数组进行排序
            Arrays.sort(array);
            // 将字符数组转换为字符串
            String key = new String(array);
            // 如果哈希表中不包含key，则将key加入哈希表
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            // 将字符串加入哈希表
            map.get(key).add(str);
        }
        // 返回哈希表的值
        Collection<List<String>> values = map.values();
        System.out.println(values);
        return new ArrayList<>(map.values());
    }
}
