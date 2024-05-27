package work.icu007.day03;

import java.util.HashMap;
import java.util.Map;

public class Day03 {
    public static void main(String[] args) {

    }

    // 长度最小的子数组
    // 给定一个含有 n 个正整数的数组和一个正整数 target 。找出该数组中满足其和 ≥ target 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0 。
    public int minSubArrayLen(int target, int[] nums) {
        // 初始化左右指针和当前和
        int left = 0;
        int right = 0;
        int sum = 0;
        // 初始化最小长度为整数最大值
        int minLen = Integer.MAX_VALUE;
        // 当右指针没有遍历完数组时，继续循环
        while (right < nums.length) {
            // 将右指针指向的元素加到当前和中
            sum += nums[right];
            // 当当前和大于等于目标值时，尝试缩小窗口以找到最小长度
            while (sum >= target) {
                // 更新最小长度
                minLen = Math.min(minLen, right - left + 1);
                // 将左指针指向的元素从当前和中减去
                sum -= nums[left];
                // 左指针向右移动一位
                left++;
            }
            // 右指针始终向右移动一位
            right++;
        }
        // 如果最小长度仍为初始值，说明不存在满足条件的子数组，返回0，否则返回最小长度
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }


    // 水果成篮
    // 在一排树中，第 i 棵树产生 tree[i] 型的水果。你可以从你选择的任何树开始，然后重复执行以下步骤：
    // 有两个篮子，每个篮子可以携带任何数量的水果，但你希望每个篮子最多只携带一种类型的水果。
    // 可以选择从任意一棵树开始收集水果,从每棵树上恰好摘一个水果,采摘的水果应当符合篮子中的水果类型.每采摘一次就向右移动到下一颗树继续采摘
    // 把这棵树上的水果放进你的篮子里。如果你做不到，就停下来。
    // 给你一个整数数组tree, 返回可以收集的水果的最大数目。
    public int totalFruit(int[] fruits) {
        // 左右指针
        int left = 0;
        int right = 0;
        // 篮子
        Map<Integer, Integer> basket = new HashMap<>();
        // 最大水果数
        int maxFruits = 0;
        // 当右指针没有遍历完数组，继续循环
        while (right < fruits.length) {
            // 这里就相当于把水果放进篮子的过程，key为水果类型 确保其唯一性，value 为该类型水果的数量。相同类型的水果进来 数量+1；
            basket.put(fruits[right], basket.getOrDefault(fruits[right], 0) + 1);
            // 当篮子中的水果种类大于2时，尝试缩小窗口以找到最大水果数；
            while (basket.size() > 2) {
                // 将左指针指向的水果从篮子中拿出去，一次拿一个
                basket.put(fruits[left], basket.get(fruits[left]) - 1);
                // 如果篮子里面已经没有左指针指向的水果类型了，就将这个类型的水果从篮子里面移除
                if (basket.get(fruits[left]) == 0) {
                    basket.remove(fruits[left]);
                }
                // 左指针右移，寻找下一个最大水果数
                left++;
            }
            // 每次循环完都更新一次最大水果数
            maxFruits = Math.max(maxFruits, right - left + 1);
            // 右指针始终向右移
            right++;
        }
        return maxFruits;
    }

    // 最小覆盖字串
    // 给你一个字符串S、一个字符串T，请在字符串S里面找出：包含T所有字母的最小子串。
    // 如果S中不存这样的子串，则返回空字符串 ""。
    public String minWindow(String s, String t) {
        // 如果s的长度小于t的长度，那么s中不可能存在包含t的子串，直接返回空字符串
        if (s.length() < t.length()) {
            return "";
        }
        // 创建一个哈希表，用于存储字符串t中的字符及其出现的次数
        Map<Character, Integer> mapT = new HashMap<>();
        for (char c : t.toCharArray()) {
            mapT.put(c, mapT.getOrDefault(c, 0) + 1);
        }
        // 创建一个哈希表，用于存储当前窗口中的字符及其出现的次数
        Map<Character, Integer> mapS = new HashMap<>();
        // 初始化左右指针，matchCount（匹配计数），start（最小覆盖子串的起始位置）和minLen（最小覆盖子串的长度）
        int left = 0, right = 0;
        int matchCount = 0;
        int start = 0, minLen = s.length() + 1;
        // 当右指针没有遍历完字符串s时，继续循环
        while (right < s.length()) {
            char c = s.charAt(right);
            // 如果字符c在字符串t中，将其加入到mapS中，并更新matchCount
            if (mapT.containsKey(c)) {
                mapS.put(c, mapS.getOrDefault(c, 0) + 1);
                if (mapS.get(c).equals(mapT.get(c))) {
                    matchCount++;
                }
            }
            // 右指针向右移动一位
            right++;
            // 当窗口中的字符满足了字符串t中的所有字符及其出现次数时，尝试缩小窗口
            while (matchCount == mapT.size()) {
                // 如果当前窗口的长度小于minLen，更新start和minLen
                if (right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }
                // 尝试将左指针指向的字符移出窗口，并更新matchCount
                char leftChar = s.charAt(left);
                if (mapT.containsKey(leftChar)) {
                    mapS.put(leftChar, mapS.get(leftChar) - 1);
                    if (mapS.get(leftChar) < mapT.get(leftChar)) {
                        matchCount--;
                    }
                }
                // 左指针向右移动一位
                left++;
            }
        }
        // 如果minLen仍为初始值，说明不存在满足条件的子串，返回空字符串，否则返回最小覆盖子串
        return minLen == s.length() + 1 ? "" : s.substring(start, start + minLen);
    }
}
