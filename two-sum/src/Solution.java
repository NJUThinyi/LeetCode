import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result={0,0};
        int size=nums.length;
        int count=0;

        //  暴力解法
        OUT:
        for(int i=0;i<size;i++){
            for(int j=i+1;j<size;j++){
                if(nums[i]+nums[j]==target){
                    result[0]=i;
                    result[1]=j;
                    break OUT;
                }
            }
        }

        //  网上解法
        // 建立k-v ，一一对应的哈希表
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            if(hash.containsKey(nums[i])){  //  这个数即为对应于target-原数组中的数的那个数
                result[1] = i;
                result[0] = hash.get(nums[i]);
                return result;
            }
            // hash表中不包含数组中的这个数，将数据存入 key为补数 ，value为下标
            hash.put(target-nums[i],i);
        }
        return result;
    }
}