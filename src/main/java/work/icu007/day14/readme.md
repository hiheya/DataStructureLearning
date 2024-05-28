# 数据结构与算法打卡-Day14

## 找到字符串中所有字母异位词

原题链接：[LeetCode 438. 找到字符串中所有字母异位词](https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/)

> 给定两个字符串 `s` 和 `p`，找到 `s` 中所有 `p` 的 **异位词** 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
>
> **异位词** 指由相同字母重排列形成的字符串（包括相同的字符串）。
>
>  
>
> **示例 1:**
>
> ```tex
> 输入: s = "cbaebabacd", p = "abc"
> 输出: [0,6]
> 解释:
> 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
> 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
> ```
>
> **示例 2:**
>
> ```tex
> 输入: s = "abab", p = "ab"
> 输出: [0,1,2]
> 解释:
> 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
> 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
> 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
> ```
>
>  
>
> **提示:**
>
> - `1 <= s.length, p.length <= 3 * 104`
> - `s` 和 `p` 仅包含小写字母

- 题解： 

```java
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
```

> 首先，创建一个结果列表和两个哈希映射。一个哈希映射用于存储需要的字符及其数量，另一个用于存储窗口中的字符及其数量。然后，初始化窗口的左右边界和一个变量来记录窗口中满足条件的字符个数。  
>
> 
>
> 接着，初始化需要的字符及其数量的哈希映射，然后开始滑动窗口。在滑动窗口的过程中，对于将要移入窗口的字符，如果它在需要的字符的哈希映射中，就更新窗口中的字符及其数量的哈希映射，并更新满足条件的字符个数。  
>
> 
>
> 然后，判断是否需要收缩窗口。如果窗口的大小大于或等于需要的字符串的长度，就开始收缩窗口。在收缩窗口的过程中，对于将要移出窗口的字符，如果它在需要的字符的哈希映射中，就更新窗口中的字符及其数量的哈希映射，并更新满足条件的字符个数。  
>
> 
>
> 最后，如果窗口中满足条件的字符个数等于需要的字符的数量，就将窗口的起始索引加入结果列表。当滑动窗口结束后，返回结果列表。  这个解决方案的时间复杂度是O(N)，其中N是字符串的长度。空间复杂度是O(1)，因为哈希映射的大小是固定的。



