package work.icu007.day01;

public class Day01 {
    public static void main(String[] args) {

    }

    // 二分查找 给定一个n个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
    public int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // 搜索查找插入位置 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    // 在排序数组中查找元素的第一个和最后一个位置.给定一个按照升序排列的整数数组 nums，和一个目标值 target。 如果 target 在数组中出现，则返回它的第一个和最后一个位置，否则返回[-1, -1]。
    public int[] searchRange(int[] nums, int target) {
        int left = searchLeftIndex(nums, target);
        int right = searchRightIndex(nums, target);

        // 情况一 target 在数组范围的右边或者左边
        if (left == -2 || right == -2) return new int[]{-1, -1};
        // 情况三 target 在数组范围中，且数组中存在target
        if (right - left > 1) return new int[]{left + 1, right - 1};
        // 情况二 target 在数组范围中，且数组中不存在target
        return new int[]{-1, -1};
    }

    // 如果rightIndex没有被赋值,说明target在数组范围的左边 如: [1, 2, 3, 4, 5] target = 0
    public int searchRightIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int rightIndex = -2;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 右边界就是第一个大于target的数 所以当nums[mid] == target时,我们要继续向右查找
            // 当nums[mid] > target时,说明target在数组的左边,我们要继续向左查找
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                // 当nums[mid] < target时,说明target在数组的右边,我们要继续向右查找同时记录右边界
                // 当nums[mid] == target时,我们要找的右边界就在mid的右边
                left = mid + 1;
                rightIndex = left;
            }
        }
        return rightIndex;
    }

    // 如果leftIndex没有被赋值,说明target在数组的右边 如: [1, 2, 3, 4, 5] target = 6
    public int searchLeftIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int leftIndex = -2;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 左边界就是第一个大于等于target的数 所以当nums[mid] > target时,我们要继续向左查找
            if (nums[mid] >= target) {
                // 当nums[mid] == target时,我们要找的左边界就在mid的左边
                right = mid - 1;
                leftIndex = right;
            } else {
                // 当nums[mid] < target时,说明target在数组的右边,我们要继续向右查找
                left = mid + 1;

            }
        }
        return leftIndex;
    }

    // 给你一个非负整数 x ，计算并返回 x 的平方根。由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
    public int mySqrt(int x) {
        // 初始化左边界为1，右边界为x
        int left = 1;
        int right = x;
        // 初始化结果为-1
        int ans = -1;
        // 如果x为0或1，直接返回x
        if (x == 0 || x == 1) {
            return x;
        }
        // 当左边界小于等于右边界时，执行循环
        while (left <= right) {
            // 计算中间值
            int mid = (left + right) / 2;
            // 如果中间值的平方大于x，说明答案在中间值的左侧，将右边界设置为mid - 1，并更新结果为右边界
            if (mid > x / mid) {
                right = mid - 1;
                ans = right;
            } else {
                // 如果中间值的平方小于等于x，说明答案在中间值的右侧，将左边界设置为mid + 1
                // 如果mid + 1的平方大于x，说明mid为最接近x的整数平方根
                if ((mid + 1) > x / (mid + 1)) {
                    return mid;
                }
                left = mid + 1;
            }
        }
        // 返回结果
        return ans;
    }

    // 有效的完全平方数 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
    public boolean isPerfectSquare(int num) {
        // 如果num为0或1，直接返回true，因为0和1都是完全平方数
        if (num == 0 || num == 1) {
            return true;
        }

        // 初始化左边界为1，右边界为num
        long left = 1;
        long right = num;
        // 当左边界小于等于右边界时，执行循环
        while (left <= right) {
            // 计算中间值
            long mid = (left + right) / 2;
            // 计算中间值的平方
            long square = mid * mid;
            // 如果中间值的平方等于num，说明num是一个完全平方数，返回true
            if (square == num) {
                return true;
            } else if (square < num) {
                // 如果中间值的平方小于num，说明答案在中间值的右侧，将左边界设置为mid + 1
                left = mid + 1;
            } else {
                // 如果中间值的平方大于num，说明答案在中间值的左侧，将右边界设置为mid - 1
                right = mid - 1;
            }
        }
        // 如果循环结束还没有找到一个数的平方等于num，说明num不是一个完全平方数，返回false
        return false;
    }
}
