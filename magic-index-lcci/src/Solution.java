//魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找
//出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。
//
// 示例1:
//
//  输入：nums = [0, 2, 3, 4, 5]
// 输出：0
// 说明: 0下标的元素为0
//
//
// 示例2:
//
//  输入：nums = [1, 1, 1]
// 输出：1
//
//
// 说明:
//
//
// nums长度在[1, 1000000]之间
// 此题为原书中的 Follow-up，即数组中可能包含重复元素的版本
//
// Related Topics 数组 二分查找
// 👍 59 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMagicIndex(int[] nums) {
        return 0;
    }

    /**
     * 方法一：暴力解法 -- 线性扫描
     * 思路：首先将结果默认置为-1，因为要返回索引最小值，那么当遇到索引值和对应数组值相等时
     *      即可返回；如果遍历之后没有遇到魔术索引，则返回res的-1值。
     * @param nums
     * @return
     */
    public int method1(int[] nums){
        int res = -1;
        for(int i=0;i<nums.length;i++){
            if(res<0){
                if(i==nums[i]){
                    res=i;
                    break;
                }
            }else{
                break;
            }
        }
        return res;
    }

    /**
     * 方法二：基于二分法的 分治剪枝
     * @param nums
     * @return
     */
    public int method2(int[] nums){
        // TODO: 2020/7/31 完成二分法 分治剪枝 
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
