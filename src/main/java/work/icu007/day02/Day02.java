package work.icu007.day02;

public class Day02 {
    public static void main(String[] args) {
        Day02 day02 = new Day02();
        // 移除元素
        int[] nums = new int[]{3, 2, 2, 3};
        int val = 3;
        System.out.println(day02.removeElement(nums, val));
        // 移除元素
        nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        val = 2;
        System.out.println(day02.removeElement(nums, val));
    }

    // 移除元素 https://leetcode-cn.com/problems/remove-element/
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

    // 删除排序数组中的重复项
    // 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度
    public int removeDuplicates(int[] nums) {
        int slowIndex = 0;
        for (int fastIndex = 1; fastIndex < nums.length; fastIndex++) {
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

    // 比较含退格的字符串
    // 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等
    public boolean backspaceCompare(String S, String T) {
        // 使用StringBuilder来模拟栈
        StringBuilder sStack = new StringBuilder();
        StringBuilder tStack = new StringBuilder();
        // 遍历字符串S
        for (int i = 0; i < S.length(); i++) {
            // 如果当前字符不是退格符
            if (S.charAt(i) != '#') {
                // 将当前字符入栈
                sStack.append(S.charAt(i));
            } else {
                // 如果当前字符是退格符，且栈不为空，则将栈顶元素出栈
                if (sStack.length() > 0) {
                    sStack.deleteCharAt(sStack.length() - 1);
                }
            }
        }
        // 遍历字符串T
        for (int i = 0; i < T.length(); i++) {
            // 如果当前字符不是退格符
            if (T.charAt(i) != '#') {
                // 将当前字符入栈
                tStack.append(T.charAt(i));
            } else {
                // 如果当前字符是退格符，且栈不为空，则将栈顶元素出栈
                if (tStack.length() > 0) {
                    tStack.deleteCharAt(tStack.length() - 1);
                }
            }
        }
        // 比较两个栈是否相等
        return sStack.toString().equals(tStack.toString());
    }

    // 有序数组的平方
    // 给你一个按 非递减顺序 排序的整数数组 nums，返回每个数字的平方组成的新数组，要求也按 非递减顺序 排序
public int[] sortedSquares(int[] nums) {
        // 初始化一个新的数组，用来存放平方后的元素
        int[] result = new int[nums.length];
        // 初始化两个指针，分别指向数组的开始和结尾
        int left = 0;
        int right = nums.length - 1;
        // 初始化一个指针，指向新数组的结尾
        int index = nums.length - 1;
        // 当左指针小于等于右指针时，继续循环
        while (left <= right) {
            // 如果左指针指向的元素的平方大于右指针指向的元素的平方
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                // 将左指针指向的元素的平方放入新数组的末尾
                result[index] = nums[left] * nums[left];
                // 左指针向右移动一位
                left++;
            } else {
                // 将右指针指向的元素的平方放入新数组的末尾
                result[index] = nums[right] * nums[right];
                // 右指针向左移动一位
                right--;
            }
            // 新数组的指针向左移动一位
            index--;
        }
        // 返回新数组
        return result;
    }
}
