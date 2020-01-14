
public class Main {

    public static void main(String[] args){
        int[] nums={2, 7, 11, 15};
        int target=9;
        Solution solution=new Solution();
        int[] r=new int[2];
        r = solution.twoSum(nums, target);

        System.out.println(r);
    }
}
