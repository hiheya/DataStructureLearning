package work.icu007.day04;

import java.util.ArrayList;
import java.util.List;

public class Day04 {
    public static void main(String[] args) {
        // 螺旋矩阵 Ⅱ
        int n = 3;
        Day04 day04 = new Day04();
        int[][] matrix = day04.generateMatrix(n);
        // 最终结果
        System.out.println("最后数组:");
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    // 螺旋矩阵 Ⅱ
    // 给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵。
    public int[][] generateMatrix(int n) {

        // 初始化矩阵
        int[][] matrix = new int[n][n];
        // 初始化边界
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        // 初始化当前值
        int num = 1;
        // 当左边界小于等于右边界且上边界小于等于下边界时，继续循环
        while (left <= right && top <= bottom) {
            // 从左到右
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;
                System.out.println("matrix["+ top + "][" + i + "]= " + matrix[top][i]);
            }
            // 从上到下
            for (int i = top + 1; i <= bottom; i++) {
                matrix[i][right] = num++;
                System.out.println("matrix["+ i + "][" + right + "]= " + matrix[i][right]);
            }
            // 从右到左
            for (int i = right - 1; i >= left; i--) {
                matrix[bottom][i] = num++;
                System.out.println("matrix["+ bottom + "][" + i + "]= " + matrix[bottom][i]);
            }
            // 从下到上
            // 这里 i > top 是因为上面已经填充了第一行，所以不用重复填充
            for (int i = bottom - 1; i > top; i--) {
                matrix[i][left] = num++;
                System.out.println("matrix["+ i + "][" + left + "]= " + matrix[i][left]);
            }
            // 缩小边界
            left++;
            right--;
            top++;
            bottom--;
        }
        return matrix;
    }

    // 螺旋矩阵
    // 给你一个 m 行 n 列的矩阵 matrix ，请按照顺时针螺旋顺序，返回矩阵中的所有元素。
    public List<Integer> spiralOrder(int[][] matrix) {
        // 初始化结果集
        List<Integer> result = new ArrayList<>();
        // 初始化边界
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        // 当左边界小于等于右边界且上边界小于等于下边界时，继续循环
        while (left <= right && top <= bottom) {
            // 从左到右
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            // 从上到下
            for (int i = top + 1; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            // 从右到左
            // 注意这里的边界处理，因为上面已经遍历了第top行，所以这里要判断 top < bottom
            for (int i = right - 1; i >= left && top < bottom; i--) {
                result.add(matrix[bottom][i]);
            }
            // 从下到上
            // 同理，因为上面已经遍历了第right列，所以这里要判断 left < right
            for (int i = bottom - 1; i > top && left < right; i--) {
                result.add(matrix[i][left]);
            }
            // 缩小边界
            left++;
            right--;
            top++;
            bottom--;
        }
        return result;
    }
}
