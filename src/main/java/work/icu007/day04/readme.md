# 数据结构与算法打卡-Day04

## 螺旋矩阵

### 1.leetcode 59题 螺旋矩阵Ⅱ

原题链接 [59. 螺旋矩阵 II](https://leetcode.cn/problems/spiral-matrix-ii/)

> 给你一个正整数 `n` ，生成一个包含 `1` 到 `n2` 所有元素，且元素按顺时针顺序螺旋排列的 `n x n` 正方形矩阵 `matrix` 。
>
>  
>
> **示例 1：**
>
> ![img](https://cdn.jsdelivr.net/gh/hiheya/images@master/img/spiraln.jpg)
>
> ```tex
> 输入：n = 3
> 输出：[[1,2,3],[8,9,4],[7,6,5]]
> ```
>
> **示例 2：**
>
> ```tex
> 输入：n = 1
> 输出：[[1]]
> ```
>
>  
>
> **提示：**
>
> - `1 <= n <= 20`

- 题解： 

```java
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
```

> 这个解法主要是通过模拟螺旋的过程来实现的。具体的步骤如下：  
>
> 1. 初始化一个 n x n 的矩阵，所有元素都为 0。
>
> 2. 初始化四个边界值，分别为左边界（left）、右边界（right）、上边界（top）和下边界（bottom）。初始时，左边界和上边界都为 0，右边界和下边界都为 n - 1。
>
> 3. 初始化一个值 num，用于记录当前需要填入矩阵的数。初始时，num 为 1。
>
> 4. 当左边界小于等于右边界且上边界小于等于下边界时，进行以下操作：
>
>    - 从左到右填充上边界的行，然后上边界下移一位。
>    - 从上到下填充右边界的列，然后右边界左移一位。
>    - 从右到左填充下边界的行，然后下边界上移一位。
>    - 从下到上填充左边界的列，然后左边界右移一位。
>
> 5. 重复步骤 4，直到所有的数都填充完毕。

### 2.leetcode 54题 螺旋矩阵

原题链接 [54. 螺旋矩阵](https://leetcode.cn/problems/spiral-matrix/)

> 给你一个 `m` 行 `n` 列的矩阵 `matrix` ，请按照 **顺时针螺旋顺序** ，返回矩阵中的所有元素。
>
>  
>
> **示例 1：**
>
> ![img](https://cdn.jsdelivr.net/gh/hiheya/images@master/img/spiral1.jpg)
>
> ```tex
> 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
> 输出：[1,2,3,6,9,8,7,4,5]
> ```
>
> **示例 2：**
>
> ![img](https://cdn.jsdelivr.net/gh/hiheya/images@master/img/spiral.jpg)
>
> ```tex
> 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
> 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
> ```
>
>  
>
> **提示：**
>
> - `m == matrix.length`
> - `n == matrix[i].length`
> - `1 <= m, n <= 10`
> - `-100 <= matrix[i][j] <= 100`

- 题解：

```java
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
```

> 这里思路同 [螺旋矩阵Ⅱ](###1.leetcode 59题 螺旋矩阵Ⅱ)

