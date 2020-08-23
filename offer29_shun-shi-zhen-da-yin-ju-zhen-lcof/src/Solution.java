//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
//
//
//
// 示例 1：
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
//
//
// 示例 2：
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
//
//
//
//
// 限制：
//
//
// 0 <= matrix.length <= 100
// 0 <= matrix[i].length <= 100
//
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/
// Related Topics 数组
// 👍 126 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        int rowNum = matrix.length;
        int colNum = 0;
        if(rowNum!=0){
            colNum = matrix[0].length;
        }
        int pRow1 = 0;
        int pCol1 = 0;
        int pRow2 = rowNum-1;
        int pCol2 = colNum -1;
        int cnt = 0;
        int[] result;
        if(matrix==null||rowNum==0||colNum==0){
            return new int[0];
        }else{
            result = new int[rowNum*colNum];
        }
        while(cnt<rowNum*colNum){
            for(int i=pCol1;i<=pCol2;i++){
                result[cnt] = matrix[pRow1][i];
                cnt++;
            }
            pRow1++;
            for(int i=pRow1;i<=pRow2;i++){
                result[cnt] = matrix[i][pCol2];
                cnt++;
            }
            if(cnt == rowNum*colNum){
                break;
            }
            pCol2--;
            for(int i=pCol2;i>=pCol1;i--){
                result[cnt] = matrix[pRow2][i];
                cnt++;
            }
            if(cnt == rowNum*colNum){
                break;
            }
            pRow2--;
            for(int i=pRow2;i>=pRow1;i--){
                result[cnt] = matrix[i][pCol1];
                cnt++;
            }
            if(cnt == rowNum*colNum){
                break;
            }
            pCol1++;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {};
        System.out.println(Arrays.toString(solution.spiralOrder(matrix)));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
