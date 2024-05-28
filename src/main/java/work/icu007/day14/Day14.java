package work.icu007.day14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Day14 {
    public static void main(String[] args) {

    }

    // 找到字符串中所有字母异位词
    // 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
    // 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
    // 说明：
    // 字母异位词指字母相同，但排列不同的字符串。
    // 不考虑答案输出的顺序。
    // 示例 1:
    // 输入:
    // s: "cbaebabacd" p: "abc"
    // 输出:
    // [0, 6]
    // 解释:
    // 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
    // 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
    // 示例 2:
    // 输入:
    // s: "abab" p: "ab"
    // 输出:
    // [0, 1, 2]
    // 解释:
    // 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
    // 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
    // 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
    // 解法一：滑动窗口
    public List<Integer> findAnagrams(String s, String p) {
        // 用于存储结果的列表
        ArrayList<Integer> ans = new ArrayList<>();

        // 需要的字符及其数量
        HashMap<Character, Integer> needMap = new HashMap<>();
        // 窗口中的字符及其数量
        HashMap<Character, Integer> windowMap = new HashMap<>();

        // 窗口的左右边界
        int left = 0;
        int right = 0;
        // 记录窗口中满足need条件的字符个数
        int valid = 0;

        // 初始化needMap
        for (char c : p.toCharArray()) {
            needMap.put(c, needMap.getOrDefault(c, 0) + 1);
        }

        // 开始滑动窗口
        while (right < s.length()) {
            // c是将移入窗口的字符
            char c = s.charAt(right);
            // 右移窗口
            right++;
            // 进行窗口内数据的一系列更新
            if (needMap.containsKey(c)) {
                windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
                if (needMap.get(c).equals(windowMap.get(c))) {
                    valid++;
                }
            }

            // 判断左侧窗口是否要收缩
            while (right - left >= p.length()) {
                // 当窗口符合条件时，把起始索引加入res
                if (valid == needMap.size()) {
                    ans.add(left);
                }
                // d是将移出窗口的字符
                char d = s.charAt(left);
                // 左移窗口
                left++;
                // 进行窗口内数据的一系列更新
                if (needMap.containsKey(d)) {
                    if (windowMap.get(d).equals(needMap.get(d))) {
                        valid--;
                    }
                    windowMap.put(d, windowMap.get(d) - 1);
                }
            }
        }
        // 返回结果
        return ans;
    }
}
