# 数据结构与算法打卡-Day02

## 移除元素

### 1. leetcode 27题 移除元素

原题链接：[27. 移除元素](https://leetcode.cn/problems/remove-element/)

> 给你一个数组 `nums` 和一个值 `val`，你需要 **[原地](https://baike.baidu.com/item/原地算法)** 移除所有数值等于 `val` 的元素，并返回移除后数组的新长度。
>
> 不要使用额外的数组空间，你必须仅使用 `O(1)` 额外空间并 **[原地](https://baike.baidu.com/item/原地算法)修改输入数组**。
>
> 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
>
>  
>
> **说明:**
>
> 为什么返回数值是整数，但输出的答案是数组呢?
>
> 请注意，输入数组是以**「引用」**方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
>
> 你可以想象内部操作如下:
>
> ```tex
> // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
> int len = removeElement(nums, val);
> 
> // 在函数里修改输入数组对于调用者是可见的。
> // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
> for (int i = 0; i < len; i++) {
>     print(nums[i]);
> }
> ```
>
>  
>
> **示例 1：**
>
> ```tex
> 输入：nums = [3,2,2,3], val = 3
> 输出：2, nums = [2,2]
> 解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
> ```
>
> **示例 2：**
>
> ```tex
> 输入：nums = [0,1,2,2,3,0,4,2], val = 2
> 输出：5, nums = [0,1,3,0,4]
> 解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。
> ```
>
>  
>
> **提示：**
>
> - `0 <= nums.length <= 100`
> - `0 <= nums[i] <= 50`
> - `0 <= val <= 100`

题解：

```java
// 移除元素
// 给你一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，并返回移除后数组的新长度。
public int removeElement(int[] nums, int val) {
    // 双指针
    // 初始化慢指针
    int slowIndex = 0;
    // 使用快指针遍历数组
    for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
        // 如果快指针指向的元素不等于val
        if (nums[fastIndex] != val) {
            // 将快指针指向的元素复制到慢指针的位置
            nums[slowIndex] = nums[fastIndex];
            // 将慢指针向前移动一位
            slowIndex++;
        }
        // 找到与val值相等元素后 fastIndex往右移动，slowIndex不动，直到找到不等于val的元素
    }
    // 返回新的数组长度，即慢指针的位置
    return slowIndex;
    // 暴力解法
    /*int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == val) {
                for (int j = i + 1; j < length; j++) {
                    nums[j - 1] = nums[j];
                }
                i--;        // 当前元素被移除后，后面的元素都向前移动了一位，所以需要将i减一，以便在下一次循环中检查原本i+1位置的元素
                length--;   // 数组长度减一
            }
        }
        return length;*/
}
```

> 双指针思路：
>
> 一个快指针和一个慢指针。快指针用于遍历数组，慢指针用于指向下一个可能被替换的位置。当快指针指向的元素不等于val时，我们就将快指针指向的元素复制到慢指针的位置，然后将慢指针向前移动一位。这样，当快指针遍历完数组后，慢指针的位置就是新的数组长度。
>
> 
>
> 暴力解法：
>
> 遍历数组，当遇到等于val的元素时，就将其后面的所有元素向前移动一位，然后将数组长度减一。这样，当遍历完数组后，数组的长度就是新的数组长度。

### 2. leetcode 26题：删除有序数组中的重复项

原题链接：[26. 删除有序数组中的重复项](https://leetcode.cn/problems/remove-duplicates-from-sorted-array/)

> 给你一个 **非严格递增排列** 的数组 `nums` ，请你**[原地](http://baike.baidu.com/item/原地算法)** 删除重复出现的元素，使每个元素 **只出现一次** ，返回删除后数组的新长度。元素的 **相对顺序** 应该保持 **一致** 。然后返回 `nums` 中唯一元素的个数。
>
> 考虑 `nums` 的唯一元素的数量为 `k` ，你需要做以下事情确保你的题解可以被通过：
>
> - 更改数组 `nums` ，使 `nums` 的前 `k` 个元素包含唯一元素，并按照它们最初在 `nums` 中出现的顺序排列。`nums` 的其余元素与 `nums` 的大小不重要。
> - 返回 `k` 。
>
> **判题标准:**
>
> 系统会用下面的代码来测试你的题解:
>
> ```tex
> int[] nums = [...]; // 输入数组
> int[] expectedNums = [...]; // 长度正确的期望答案
> 
> int k = removeDuplicates(nums); // 调用
> 
> assert k == expectedNums.length;
> for (int i = 0; i < k; i++) {
>     assert nums[i] == expectedNums[i];
> }
> ```
>
> 如果所有断言都通过，那么您的题解将被 **通过**。
>
>  
>
> **示例 1：**
>
> ```tex
> 输入：nums = [1,1,2]
> 输出：2, nums = [1,2,_]
> 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
> ```
>
> **示例 2：**
>
> ```tex
> 输入：nums = [0,0,1,1,1,2,2,3,3,4]
> 输出：5, nums = [0,1,2,3,4]
> 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
> ```
>
>  
>
> **提示：**
>
> - `1 <= nums.length <= 3 * 10^4`
> - `-10^4 <= nums[i] <= 10^4`
> - `nums` 已按 **非严格递增** 排列

题解： 

```java
// 删除排序数组中的重复项 
// 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度
public int removeDuplicates(int[] nums) {
    int slowIndex = 0;
    for(int fastIndex = 1; fastIndex < nums.length; fastIndex++) {
        // 如果快指针指向的元素不等于慢指针指向的元素 则将快指针指向的元素复制到慢指针的下一位
        if (nums[fastIndex] != nums[slowIndex]) {
            // 慢指针向右移动一位
            slowIndex++;
            // 将快指针指向的元素复制到慢指针的下一位
            nums[slowIndex] = nums[fastIndex];
        }
    }
    // 返回新的数组长度，即慢指针的位置+1
    return slowIndex + 1;
}
```

> 我们使用两个指针，一个慢指针slowIndex和一个快指针fastIndex。快指针用于遍历数组，慢指针用于指向下一个可能被替换的位置。当快指针指向的元素不等于慢指针指向的元素时，我们就将快指针指向的元素复制到慢指针的下一位，然后将慢指针向前移动一位。这样，当快指针遍历完数组后，慢指针的位置+1就是新的数组长度。
>
> ⭐**注意最后需要返回的是数组长度，所以需要返回慢指针的位置 + 1**

### 1.3 leetcode 283题：移动零

原题链接： [283. 移动零](https://leetcode.cn/problems/move-zeroes/)

> 给定一个数组 `nums`，编写一个函数将所有 `0` 移动到数组的末尾，同时保持非零元素的相对顺序。
>
> **请注意** ，必须在不复制数组的情况下原地对数组进行操作。
>
>  
>
> **示例 1:**
>
> ```tex
> 输入: nums = [0,1,0,3,12]
> 输出: [1,3,12,0,0]
> ```
>
> **示例 2:**
>
> ```tex
> 输入: nums = [0]
> 输出: [0]
> ```
>
>  
>
> **提示**:
>
> - `1 <= nums.length <= 10^4`
> - `-2^31 <= nums[i] <= 2^31 - 1`

题解

```java
// 移动零
// 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序
public void moveZeroes(int[] nums) {
    // 初始化两个指针，slowIndex和fastIndex，都指向数组的开始
    int slowIndex = 0;
    int fastIndex = 0;

    // 当fastIndex（快指针）没有遍历完数组时，继续循环
    while (fastIndex < nums.length) {
        // 如果fastIndex指向的元素不为0
        if (nums[fastIndex] != 0) {
            // 交换slowIndex和fastIndex指向的元素
            int temp = nums[slowIndex];
            nums[slowIndex] = nums[fastIndex];
            nums[fastIndex] = temp;
            // slowIndex（慢指针）向右移动一位
            slowIndex++;
        }
        // fastIndex（快指针）始终向右移动一位
        fastIndex++;
    }
}
```

> 使用两个指针，一个快指针（fasttIndex）和一个慢指针（slowIndex）。快指针用于遍历数组，慢指针用于指向下一个可能被替换的位置。当快指针指向的元素不等于0时，我们就将快指针指向的元素复制到慢指针的位置，然后将慢指针向前移动一位。这样，当快指针遍历完数组后，所有的非零元素都已经被移动到了数组的前部，而零则被移动到了数组的末尾。

### 1.4 leetcode 844题：比较含退格的字符串

原题链接：[844. 比较含退格的字符串](https://leetcode.cn/problems/backspace-string-compare/)

> 给定 `s` 和 `t` 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 `true` 。`#` 代表退格字符。
>
> **注意：**如果对空文本输入退格字符，文本继续为空。
>
>  
>
> **示例 1：**
>
> ```tex
> 输入：s = "ab#c", t = "ad#c"
> 输出：true
> 解释：s 和 t 都会变成 "ac"。
> ```
>
> **示例 2：**
>
> ```tex
> 输入：s = "ab##", t = "c#d#"
> 输出：true
> 解释：s 和 t 都会变成 ""。
> ```
>
> **示例 3：**
>
> ```tex
> 输入：s = "a#c", t = "b"
> 输出：false
> 解释：s 会变成 "c"，但 t 仍然是 "b"。
> ```
>
>  
>
> **提示：**
>
> - `1 <= s.length, t.length <= 200`
> - `s` 和 `t` 只含有小写字母以及字符 `'#'`

题解：

```java
public boolean backspaceCompare(String s, String t) {
    String sString = restoreString(s);
    String tString = restoreString(t);
    // 还原字符串后直接比较
    return sString.equals(tString);
}

public String restoreString(String s) {
    // 使用StringBuilder来模拟栈
    StringBuilder stack = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
        // 如果当前字符不是退格符，入栈
        if (s.charAt(i) != '#') {
            stack.append(s.charAt(i));
        } else {
            // 如果当前字符是退格符且栈不为空，则栈顶元素出栈
            if(stack.length() > 0) {
                stack.deleteCharAt(stack.length() - 1);
            }
        }
    }
    return stack.toString();
}
```

> 这里使用的是 StringBuilder来模拟栈，如果不为 ‘#’ 则直接入栈;为‘#’时**判断一下栈是否为空**，不为空的话把栈顶元素弹出

### 1.5 leetcode 977题 有序数组的平方

原题链接： [977. 有序数组的平方](https://leetcode.cn/problems/squares-of-a-sorted-array/)

> 给你一个按 **非递减顺序** 排序的整数数组 `nums`，返回 **每个数字的平方** 组成的新数组，要求也按 **非递减顺序** 排序。
>
> 
>
>  
>
> **示例 1：**
>
> ```tex
> 输入：nums = [-4,-1,0,3,10]
> 输出：[0,1,9,16,100]
> 解释：平方后，数组变为 [16,1,0,9,100]
> 排序后，数组变为 [0,1,9,16,100]
> ```
>
> **示例 2：**
>
> ```tex
> 输入：nums = [-7,-3,2,3,11]
> 输出：[4,9,9,49,121]
> ```
>
>  
>
> **提示：**
>
> - `1 <= nums.length <= 10^4`
> - `-10^4 <= nums[i] <= 10^4`
> - `nums` 已按 **非递减顺序** 排序

题解：

```java
public int[] sortedSquares(int[] nums) {
    // 初始化一个新的数组，用来存放平方后的元素
    int[] result = new int[nums.length];
    // 初始化两个指针，分别指向数组的开始和结尾
    int left = 0;
    int right = nums.length - 1;
    // 初始化一个指针，指向新数组的结尾
    int index = nums.length - 1;
    // 用来存放平方后的结果
    int leftSqure = 0;
    int rightSqure = 0;

    while (left <= right) {
        // 如果左指针指向的元素的平方大于右指针指向的元素的平方
        leftSqure = nums[left] * nums[left];
        rightSqure = nums[right] * nums[right];
        if (leftSqure > rightSqure) {
            // 将左指针指向的元素的平方放入新数组的末尾， 左指针右移
            result[index] = leftSqure;
            left++;
        } else {
            // 将右指针指向的元素的平方放入新数组的末尾， 右指针左移
            result[index] = rightSqure;
            right--;
        }
        // 新数组指针左移一位 存放下一个元素
        index--;
    }
    return result;
}
```

> 使用两个指针，一个左指针left和一个右指针right。左指针从数组的开始位置开始，右指针从数组的结束位置开始。我们比较左指针和右指针指向的元素的平方，将较大的那个放入新数组的末尾，然后将对应的指针向中间移动。这样，当左指针和右指针相遇时，我们就得到了一个按非递减顺序排序的平方数组。