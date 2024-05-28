# 数据结构与算法打卡-Day15

## 两个数组的交集

原题链接：[349. 两个数组的交集](https://leetcode-cn.com/problems/intersection-of-two-arrays/)

> 给定两个数组 `nums1` 和 `nums2` ，返回 *它们的* 
>
> *交集*
>
>  。输出结果中的每个元素一定是 **唯一** 的。我们可以 **不考虑输出结果的顺序** 。
>
> 
>
>  
>
> **示例 1：**
>
> ```tex
> 输入：nums1 = [1,2,2,1], nums2 = [2,2]
> 输出：[2]
> ```
>
> **示例 2：**
>
> ```tex
> 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
> 输出：[9,4]
> 解释：[4,9] 也是可通过的
> ```
>
>  
>
> **提示：**
>
> - `1 <= nums1.length, nums2.length <= 1000`
> - `0 <= nums1[i], nums2[i] <= 1000`

- 题解：

```java
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
```

> 思路：
>
> 使用了哈希映射来存储第一个数组中的元素及其出现的次数，然后遍历第二个数组，如果元素在哈希映射中存在，就将其添加到结果的哈希映射中。最后，将结果的哈希映射的键转换为数组并返回。
