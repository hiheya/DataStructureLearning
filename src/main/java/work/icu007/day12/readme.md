# 数据结构与算法打卡-Day12

## 一、哈希表理论基础

### 1.1. 哈希表的定义

哈希表（Hash table，也叫散列表），是根据关键码值（Key
value）而直接进行访问的数据结构。也就是说，它通过把关键码值映射到表中一个位置来访问记录，以加快查找的速度。这个映射函数叫做散列函数（Hash
Function），存放记录的数组叫做哈希表（或散列表）。
其实直白来说，哈希表就是一个数组，只不过这个数组的下标是通过哈希函数计算出来的。



![image-20240525141138906](https://cdn.jsdelivr.net/gh/hiheya/images@master/img/image-20240525141138906.png)

那么哈希表能解决什么问题呢？
一般来说，哈希表都是用来判断一个元素是否出现在一个集合中的，比如判断一个数是否在一个集合中，判断一个字符串是否在一个集合中等等。
例如要查询某个人名是否在集合中，只需要计算一下哈希值，然后直接在哈希表中查找即可。 如果用枚举的方式，时间复杂度是O(n)，是非常慢的。
但如果用哈希表，时间复杂度是O(1)，是非常快的。我们只需要初始化一个哈希表，然后把所有人名全部放进去，然后就可以直接查询了。
将元素映射到哈希表上就涉及到hash function(哈希函数)，这个函数的设计是一个很重要的问题，不同的hash function会影响到哈希表的性能。

### 1.2. 哈希函数

哈希函数是一种从集合中的任意元素中创建数字索引的一种方法。哈希函数的作用是给定一个键值，然后返回值在表中的地址。哈希函数的设计是一个很重要的问题，不同的哈希函数会影响到哈希表的性能。

哈希函数如下图所示,通过hashCode把名字转化为数值,一般hashCode是通过特定的算法计算出来的，它可以将其他数据格式转化为不同的数值.这个算法是可以自己设计的，但是一般来说，我们不需要自己设计哈希函数，因为Java中已经为我们设计好了哈希函数。

![image-20240525142403964](https://cdn.jsdelivr.net/gh/hiheya/images@master/img/image-20240525142403964.png)

如果hashCode得到的值很大，我们可以通过取模运算，将其映射到一个较小的范围内，这个范围就是哈希表的大小。
那问题很多的小明又要问了，如果两个元素映射到同一个位置怎么办呢？
这就是哈希冲突的问题，我们可以通过链表或者红黑树来解决哈希冲突的问题。哈希冲突也称为哈希碰撞，是指两个不同的键值通过哈希函数得到相同的哈希地址。

### 1.3. 哈希碰撞

如下图小李和小王都映射到了索引下标 1 的位置，这一现象叫做哈希碰撞。



![image-20240525142737094](https://cdn.jsdelivr.net/gh/hiheya/images@master/img/image-20240525142737094.png)

一般来说，哈希碰撞有两种解决方法：

- 开放寻址法

  开放寻址法是一种解决哈希冲突的方法，当发生哈希冲突时，开放寻址法会寻找下一个空的位置，将元素插入到这个位置。开放寻址法的优点是不需要额外的空间，缺点是可能会产生聚集现象，即连续的位置都被占用了，这样会导致查找的效率降低。

  使用开放寻址法一定要保证tableSize大于dataSize，当哈希表满了之后，需要进行扩容操作，否则会导致哈希表无法插入元素。我们需要依靠哈希表中的空位置来解决哈希冲突。

![image-20240525143224861](https://cdn.jsdelivr.net/gh/hiheya/images@master/img/image-20240525143224861.png)


- 链地址法

  链地址法是一种解决哈希冲突的方法，当发生哈希冲突时，链地址法会将元素插入到链表中。链地址法的优点是不会产生聚集现象，缺点是需要额外的空间。

![image-20240525142925090](https://cdn.jsdelivr.net/gh/hiheya/images@master/img/image-20240525142925090.png)

### 1.4. 常见的哈希结构

- HashMap

  HashMap是一个散列表，它存储的内容是键值对(key-value)
  映射。HashMap允许键和值为null，但是键只能有一个为null，值可以有多个为null。HashMap是非线程安全的，如果需要线程安全的HashMap，可以使用ConcurrentHashMap。
- HashSet

  HashSet是一个基于HashMap实现的，它存储的内容是不重复的元素。HashSet允许元素为null，但是只能有一个为null。HashSet是非线程安全的，如果需要线程安全的HashSet，可以使用ConcurrentSkipListSet。
- HashTable

  HashTable是一个散列表，它存储的内容是键值对(key-value)映射。HashTable不允许键和值为null。HashTable是线程安全的，但是效率较低，一般不推荐使用。
- ConcurrentHashMap

  ConcurrentHashMap是一个线程安全的HashMap，它是通过分段锁的方式来保证线程安全的。ConcurrentHashMap允许键和值为null，但是键只能有一个为null，值可以有多个为null。
- ConcurrentSkipListSet

  ConcurrentSkipListSet是一个线程安全的HashSet，它是通过跳表的方式来保证线程安全的。ConcurrentSkipListSet允许元素为null，但是只能有一个为null。
- LinkedHashMap

  LinkedHashMap是一个有序的HashMap，它保持了插入元素的顺序。LinkedHashMap允许键和值为null，但是键只能有一个为null，值可以有多个为null。
- TreeMap

  TreeMap是一个有序的树形结构，它存储的内容是键值对(key-value)映射。TreeMap不允许键为null，但是值可以为null。
- TreeSet

  TreeSet是一个有序的Set，它是通过TreeMap实现的。TreeSet不允许元素为null。

## 二、相关题目

### 2.1 有效的字母异位词

原题链接: [242.有效的字母异位词](https://leetcode-cn.com/problems/valid-anagram/)

> 给定两个字符串 `s` 和 `t` ，编写一个函数来判断 `t` 是否是 `s` 的字母异位词。
>
> **注意：**若 `s` 和 `t` 中每个字符出现的次数都相同，则称 `s` 和 `t` 互为字母异位词。
>
>  
>
> **示例 1:**
>
> ```tex
> 输入: s = "anagram", t = "nagaram"
> 输出: true
> ```
>
> **示例 2:**
>
> ```tex
> 输入: s = "rat", t = "car"
> 输出: false
> ```
>
>  
>
> **提示:**
>
> - `1 <= s.length, t.length <= 5 * 104`
> - `s` 和 `t` 仅包含小写字母
>
>  
>
> **进阶:** 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？

- 题解：

```java
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
```

> 思路：先把字符串s添加到哈希表中，如果字符串t中的字符在哈希表中，则将哈希表中的字符值减1，如果字符值为0，则将字符从哈希表中删除，如果出现了没有添加过的数据就直接返回false。
>
> 
>
>
> ![242.有效的字母异位词](https://cdn.jsdelivr.net/gh/hiheya/images@master/img/242.有效的字母异位词.gif)

### 2.2. 赎金信

原题链接: [383.赎金信](https://leetcode-cn.com/problems/ransom-note/)

> 给你两个字符串：`ransomNote` 和 `magazine` ，判断 `ransomNote` 能不能由 `magazine` 里面的字符构成。
>
> 如果可以，返回 `true` ；否则返回 `false` 。
>
> `magazine` 中的每个字符只能在 `ransomNote` 中使用一次。
>
>  
>
> **示例 1：**
>
> ```tex
> 输入：ransomNote = "a", magazine = "b"
> 输出：false
> ```
>
> **示例 2：**
>
> ```tex
> 输入：ransomNote = "aa", magazine = "ab"
> 输出：false
> ```
>
> **示例 3：**
>
> ```tex
> 输入：ransomNote = "aa", magazine = "aab"
> 输出：true
> ```
>
>  
>
> **提示：**
>
> - `1 <= ransomNote.length, magazine.length <= 10^5`
> - `ransomNote` 和 `magazine` 由小写英文字母组成

- 题解

```java
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
```

> 这题思路和有效的字母异位词一致
