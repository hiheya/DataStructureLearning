package work.icu007.day12;

import java.util.*;

public class Day12 {
    public static void main(String[] args) {

    }
    // 有效的字母异位词
    // 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
    // 示例 1:
    // 输入: s = "anagram", t = "nagaram"
    // 输出: true
    // 示例 2:
    // 输入: s = "rat", t = "car"
    // 输出: false
    // 说明:
    // 你可以假设字符串只包含小写字母。
    // 进阶:
    // 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
    // 解法一：哈希表
    public boolean isAnagram(String s, String t) {
        // 如果两个字符串长度不相等，则直接返回false
        if (s.length() != t.length()) {
            return false;
        }
        // 初始化一个长度为26的数组
        int[] counter = new int[26];
        // 遍历字符串s
        for (int i = 0; i < s.length(); i++) {
            // 将字符串s中的字符转换为数字
            counter[s.charAt(i) - 'a']++;
            // 将字符串t中的字符转换为数字
            counter[t.charAt(i) - 'a']--;
        }
        // 遍历数组
        for (int count : counter) {
            // 如果数组中有不为0的数，则返回false
            if (count != 0) {
                return false;
            }
        }
        // 返回true
        return true;
    }
    // 解法二：排序
    public boolean isAnagram2(String s, String t) {
        // 如果两个字符串长度不相等，则直接返回false
        if (s.length() != t.length()) {
            return false;
        }
        // 将字符串s转换为字符数组
        char[] str1 = s.toCharArray();
        // 将字符串t转换为字符数组
        char[] str2 = t.toCharArray();
        // 对字符数组进行排序
        Arrays.sort(str1);
        Arrays.sort(str2);
        // 比较两个字符数组是否相等
        return Arrays.equals(str1, str2);
    }
    // 解法三：哈希表
    public boolean isAnagram3(String s, String t) {
        // 如果两个字符串长度不相等，则直接返回false
        if (s.length() != t.length()) {
            return false;
        }
        // 初始化哈希表
        Map<Character,Integer> map = new HashMap<>();
        // 遍历字符串s
        for (char c : s.toCharArray()) {
            // 将字符加入哈希表
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // 遍历字符串t
        while (map.size() > 0) {
            for (char c : t.toCharArray()) {
                // 如果哈希表中不包含字符c，则返回false
                if (!map.containsKey(c)) {
                    return false;
                }
                // 如果哈希表中包含字符c，则将字符c的值减1
                map.put(c, map.get(c) - 1);
                // 如果字符c的值为0，则将字符c从哈希表中删除
                if (map.get(c) == 0) {
                    map.remove(c);
                }
            }
        }
        // 返回true
        return true;
    }

    // 赎金信
    // 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，
    // 判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。
    // 如果可以构成，返回 true ；否则返回 false。
    // 示例 1：
    // 输入：ransomNote = "a", magazine = "b"
    // 输出：false
    // 示例 2：
    // 输入：ransomNote = "aa", magazine = "ab"
    // 输出：false
    // 示例 3：
    // 输入：ransomNote = "aa", magazine = "aab"
    // 输出：true
    // 提示：
    // 你可以假设两个字符串均只含有小写字母。
    // 解法一：哈希表
    public boolean canConstruct(String ransomNote, String magazine) {
        // 初始化哈希表
        Map<Character,Integer> map = new HashMap<>();
        // 遍历杂志字符串
        for (char c : magazine.toCharArray()) {
            // 将字符加入哈希表
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // 遍历赎金信字符串
        for (char c : ransomNote.toCharArray()) {
            // 如果哈希表中不包含字符c，则返回false
            if (!map.containsKey(c)) {
                return false;
            }
            // 如果哈希表中包含字符c，则将字符c的值减1
            map.put(c, map.get(c) - 1);
            // 如果字符c的值为0，则将字符c从哈希表中删除
            if (map.get(c) == 0) {
                map.remove(c);
            }
        }
        // 返回true
        return true;
    }
}
